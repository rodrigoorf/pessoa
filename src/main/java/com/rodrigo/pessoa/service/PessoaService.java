package com.rodrigo.pessoa.service;

import com.rodrigo.pessoa.entity.Pessoa;
import com.rodrigo.pessoa.exception.PessoaNotFoundException;
import com.rodrigo.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa createPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Page<Pessoa> getPessoas(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    public Optional<Pessoa> getPessoaById(Long id) throws PessoaNotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return pessoa;
        } else {
            throw new PessoaNotFoundException("Nenhuma pessoa foi encontrada.");
        }
    }

    public Pessoa updatePessoa(Long id, Pessoa newPessoa) throws PessoaNotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            Pessoa existingPessoa = pessoa.get();
            existingPessoa.setNome(newPessoa.getNome());
            existingPessoa.setIdade(newPessoa.getIdade());
            return pessoaRepository.save(existingPessoa);
        } else {
            throw new PessoaNotFoundException("Nenhuma pessoa foi encontrada.");
        }
    }

    public void deletePessoa(Long id) throws PessoaNotFoundException {
        getPessoaById(id);
        pessoaRepository.deleteById(id);
    }
}
