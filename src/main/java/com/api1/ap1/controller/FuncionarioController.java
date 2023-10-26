package com.api1.ap1.controller;

import com.api1.ap1.model.Funcionario;
import com.api1.ap1.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
        return new ResponseEntity<>(funcionarioService.addFuncionario(funcionario), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Funcionario>> listar(){
        return new ResponseEntity<>(funcionarioService.listarFuncionarios(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<Object> buscarPorCpf(@PathVariable String cpf){
        Optional<Funcionario> funcionario = funcionarioService.buscarPorCpf(cpf);
        if (funcionario.isPresent())
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Funcionário não encontrado",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<String> deletarFuncionario(@PathVariable String cpf){
        funcionarioService.deletar(cpf);
        return new ResponseEntity<>("Funcionário deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/atualizar/{cpf}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable String cpf,
                                                  @Nullable @RequestParam String nome,
                                                  @Nullable @RequestParam Integer idade){
        return new ResponseEntity<>(funcionarioService.atualizar(cpf, nome, idade), HttpStatus.CREATED);

    }

}
