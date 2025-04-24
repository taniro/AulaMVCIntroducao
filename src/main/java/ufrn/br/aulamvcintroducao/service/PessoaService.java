package ufrn.br.aulamvcintroducao.service;

import org.springframework.stereotype.Service;
import ufrn.br.aulamvcintroducao.domain.Pessoa;

import java.util.ArrayList;

@Service
public class PessoaService {

    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public PessoaService() {
    }

    public void addNewPessoa(Pessoa p ){
        pessoas.add(p);
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
