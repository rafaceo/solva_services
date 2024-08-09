package com.example.solva_bank.mapper;
import com.example.solva_bank.Dto.BankDto;
import com.example.solva_bank.entity.BankEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toBankDto(BankEntity bankEntity);
    BankEntity toBankEntity(BankDto bankDto);

}
