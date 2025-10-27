package com.Fintrack.Fintrack.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.internal.TransactionManagement;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "transactions")
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {


    @ManyToOne // one user can have many transaction
    @JoinColumn(name = "users_id", nullable = false)
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TransactionId;

    @Column(nullable = false)
    private  BigDecimal amount;

    @Enumerated(EnumType.STRING)
@NotNull(message = "income type is required")
    private TransactionType type; // income or expense


    private String category; //shopping,food,etc


    private String description; //optional for notes of transaction

    @Column(nullable = false)
    private LocalDateTime date;

    @PrePersist
    protected void onCreate(){
          if (date == null){
              date = LocalDateTime.now();
          }
    }



}
