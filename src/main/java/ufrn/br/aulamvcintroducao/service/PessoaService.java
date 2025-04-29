package ufrn.br.aulamvcintroducao.service;

import org.springframework.stereotype.Service;
import ufrn.br.aulamvcintroducao.domain.Pessoa;
import ufrn.br.aulamvcintroducao.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void addNewPessoa(Pessoa p ){
        pessoaRepository.save(p);
    }

    public Pessoa getById(Long id){
        return pessoaRepository.getById(id);
    }

    public void deletePessoa(Long id){
        pessoaRepository.deleteById(id);
    }

    public void updatePessoa(Pessoa p){
        pessoaRepository.save(p);
    }

    public List<Pessoa> listAll(){
        return  pessoaRepository.findAll();
    }

}
