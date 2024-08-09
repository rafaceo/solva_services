package com.example.solva_bank.entity;
import com.example.solva_bank.category.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Table(name = "bank_entity")
@Entity
@Getter
@Setter
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)

    @Column(name = "category")
    private Category category;

    @Column(name = "limitusd")
    private BigDecimal limitUSD;

    @Column(name = "transaction")
    private BigDecimal transaction;

    @Column(name = "datetime")
    private LocalDateTime dateTime;

    @Column(name = "limitexceeded")
    private Boolean limitExceeded;

}
