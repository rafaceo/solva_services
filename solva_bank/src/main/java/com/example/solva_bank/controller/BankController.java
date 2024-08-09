package com.example.solva_bank.controller;
import com.example.solva_bank.Dto.BankDto;
import com.example.solva_bank.category.Category;
import com.example.solva_bank.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    //устаналивает пользователя
    @PostMapping("/set")
    public BankDto createBankEntity(@RequestParam Category category,
                                    @RequestParam BigDecimal limit,
                                    @RequestParam BigDecimal transaction) {
        return bankService.createBankDto(category, limit, transaction);
    }

    //возвращает пользователя
    @GetMapping("/{id}")
    public BankDto getBankEntity(@PathVariable Long id) {
        return bankService.getBankDto(id);
    }
}
