package com.example.solva_bank.Dto;
import com.example.solva_bank.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal limitUSD;
    private BigDecimal transaction;
    private LocalDateTime dateTime;
    private Boolean limitExceeded;

}
