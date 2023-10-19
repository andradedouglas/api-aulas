package com.api1.ap1.controller;

import com.api1.ap1.model.Funcionario;
import com.api1.ap1.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario funcionario){
        Funcionario funcionarioCriado = funcionarioService.addFuncionario(funcionario);
        return new ResponseEntity<>(funcionarioCriado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listar(){
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable String cpf){
        Optional<Funcionario> funcionario = funcionarioService.buscarPorCpf(cpf);
        if (funcionario.isPresent())
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Funcionário não encontrado",HttpStatus.NOT_FOUND);
    }

}
