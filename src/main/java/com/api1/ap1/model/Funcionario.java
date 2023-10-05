package com.api1.ap1.model;

import lombok.*;


@Data
@AllArgsConstructor
public class Funcionario {
    private String cpf;
    private String nome;
    private int idade;
}
