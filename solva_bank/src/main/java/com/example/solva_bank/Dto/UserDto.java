package com.example.solva_bank.Dto;
import com.example.solva_bank.category.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class UserDto {

    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal limitUSD;
    private BigDecimal transaction;

}
