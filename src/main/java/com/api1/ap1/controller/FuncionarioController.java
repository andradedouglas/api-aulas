package com.api1.ap1.controller;

import com.api1.ap1.model.Funcionario;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    /*
Cada path existente representa um ENDPOINT da API.
Cada ENDPOINT é um método da classe Controller que chama outro da classe Service.
     */
    List<Funcionario> funcionarios =
            new ArrayList<>(List.of(new Funcionario("12345678900", "Fulano", 20)));


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Funcionario funcionario){
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        return new ResponseEntity<>(funcionarios, HttpStatus.CREATED);
    }
    @GetMapping("/instrucoes")
    public ResponseEntity<String> getInstrucoes(){
        return new ResponseEntity<>("Um funcionário tem nome(String), cpf" +
                "(String) e idade(int).", HttpStatus.OK);
    }

    @GetMapping("/exemplo")
    public ResponseEntity<Funcionario> getExemplo(){
        Funcionario funcionario = new Funcionario("12345678900", "Fulano", 20);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

}
