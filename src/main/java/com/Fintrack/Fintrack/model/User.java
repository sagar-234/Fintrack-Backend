package com.Fintrack.Fintrack.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required")// validation at runtime
    private String username;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is required")// validation at runtime
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    private String role;

    private LocalDateTime createdAt ;

    private LocalDateTime updatedAt ;


    }

}
