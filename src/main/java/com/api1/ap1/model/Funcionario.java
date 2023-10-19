package com.api1.ap1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //indicando que uma tabela será criada no banco de dados a partir da classe
@Table(name="funcionarios") //indicando o nome da tabela
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    private String cpf;
    private String nome;
    private int idade;
}
