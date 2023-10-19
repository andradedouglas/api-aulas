package com.api1.ap1.service;

import com.api1.ap1.model.Funcionario;
import com.api1.ap1.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired //injeção de dependência
    FuncionarioRepository funcionarioRepository;

    public Funcionario addFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario); //insert no banco
    }
    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }
    public Optional<Funcionario> buscarPorCpf(String cpf){
        return funcionarioRepository.findById(cpf);

    }
}
