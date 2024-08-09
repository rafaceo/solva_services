package com.example.solva_bank.services;
import com.example.solva_bank.Dto.BankDto;
import com.example.solva_bank.category.Category;
import com.example.solva_bank.entity.BankEntity;
import com.example.solva_bank.mapper.BankMapper;
import com.example.solva_bank.openfeign.UserFeignClient;
import com.example.solva_bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Slf4j
public class BankService {

    private final BankRepository bankRepository;
    private final BankMapper bankMapper;
    private final UserFeignClient userFeignClient;

    public BankDto createBankDto(Category category, BigDecimal limit, BigDecimal transaction ) {
        BankDto bankDto = new BankDto();
        bankDto.setCategory(category);
        bankDto.setLimitUSD(limit);
        bankDto.setTransaction(transaction);
        return bankMapper.toBankDto(bankRepository.save(bankMapper.toBankEntity(bankDto)));
    }

    public BankDto getBankDto(Long id) {
        BankEntity bankEntity = bankRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BankEntity not found"));

        BankDto bankDto = bankMapper.toBankDto(bankEntity);
        bankDto.setDateTime(LocalDateTime.now());
        if(bankDto.getCategory() == null) {
            bankDto.setCategory(userFeignClient.getUserById(bankDto.getId()).getCategory());
        }
        if (bankDto.getLimitUSD() == null){
            bankDto.setLimitUSD(userFeignClient.getUserById(bankDto.getId()).getLimitUSD());
        }
        if(bankDto.getTransaction() == null){
            bankDto.setTransaction(userFeignClient.getUserById(bankDto.getId()).getTransaction());
        }

        // установка значения limitUSD по умолчанию, если оно не задано
        if (bankDto.getLimitUSD() == null) {
            bankDto.setLimitUSD(new BigDecimal("1000"));
        }
        if (bankDto.getTransaction() == null){
            bankDto.setTransaction(new BigDecimal("0"));
        }

        bankDto.setLimitExceeded(calculateLimitExceeded(bankDto));
        return bankDto;

    }

    // расчёт превышения лимита
    private Boolean calculateLimitExceeded(BankDto bankDto) {
        BigDecimal difference = bankDto.getLimitUSD().subtract(bankDto.getTransaction());

        return difference.compareTo(BigDecimal.ZERO) < 0;
    }
}
