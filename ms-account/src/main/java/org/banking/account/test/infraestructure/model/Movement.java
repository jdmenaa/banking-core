package org.banking.account.test.infraestructure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
@Getter
@Setter
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_movement", nullable = false)
    private LocalDateTime dateMovement;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "value_movement", nullable = false)
    @DecimalMin(value = "-1000000.00", message = "El valor del movimiento no puede ser menor a -1000000.00")
    @DecimalMax(value = "1000000.00", message = "El valor del movimiento no puede ser mayor a 1000000.00")
    private Double valueMovement;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

}
