package ufrn.br.aulamvcintroducao.service;

import org.springframework.stereotype.Service;
import ufrn.br.aulamvcintroducao.domain.Pessoa;
import ufrn.br.aulamvcintroducao.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> getPessoaByIdade(int idade){
        List<Pessoa> pessoas = pessoaRepository.findByIdade(idade);
        return pessoas;
    }

    public void addNewPessoa(Pessoa p){
        pessoaRepository.saveAndFlush(p);
    }

    public Optional<Pessoa> getById(Long id){
        return pessoaRepository.findById(id);
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
