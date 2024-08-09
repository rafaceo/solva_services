package com.example.solva_user.dto;
import com.example.solva_user.category.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class UserDto {
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private BigDecimal limitUSD;
    private BigDecimal transaction;
}
