package com.example.exercicio1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "\"user\"")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 25, message = "Nome deve ter entre 3 e 100 caracteres.")
    private String name;

    @Min(value = 18, message = "Minimo 18 anos")
    private int age;

    @Pattern(regexp = "[A-Z]{2}\\d{5}", message = "Obrigatorio no formato XX99999")
    private String vatNumber;

    @Email(message = "Email invalido")
    private String email;

}
