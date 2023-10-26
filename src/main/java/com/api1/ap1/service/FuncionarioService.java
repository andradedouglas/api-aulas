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
    private FuncionarioRepository funcionarioRepository;

    public Funcionario addFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario); //insert no banco
    }
    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }
    public Optional<Funcionario> buscarPorCpf(String cpf){
        return funcionarioRepository.findById(cpf);
    }

    public void deletar(String cpf){
        Optional<Funcionario> funcionarioEncontrado = this.buscarPorCpf(cpf);
        if (funcionarioEncontrado.isEmpty())
            throw new RuntimeException("Funcionário não encontrado");
        else
            funcionarioRepository.deleteById(cpf);
    }

    public Funcionario atualizar(String cpf, String nome, Integer idade){
        if (nome == null && idade == null)
            throw new RuntimeException("Nenhum dado para atualizar");
        Optional<Funcionario> funcionarioEncontrado = this.buscarPorCpf(cpf);
        if (funcionarioEncontrado.isEmpty())
            throw new RuntimeException("Funcionário não encontrado");
        else {
            Funcionario funcionario = funcionarioEncontrado.get();

            if (nome != null) funcionario.setNome(nome);
            if (idade != null) funcionario.setIdade(idade);
            return funcionarioRepository.save(funcionario);
        }
    }
}
