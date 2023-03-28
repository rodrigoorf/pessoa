package com.rodrigo.pessoa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoas")
public class Pessoa {
    @Id
    @Column
    private Long id;
    @Column
    @NotBlank(message = "Campo não pode ser vazio")
    private String nome;
    @Column
    @NotBlank(message = "Campo não pode ser vazio")
    private int idade;
}
