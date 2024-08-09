package com.example.solva_user.entity;
import com.example.solva_user.category.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Data
@Table(name ="user_service")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "limitusd")
    private BigDecimal limitUSD;

    @Column(name = "transaction")
    private BigDecimal transaction;

}
