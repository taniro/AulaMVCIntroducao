package ufrn.br.aulamvcintroducao.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ufrn.br.aulamvcintroducao.domain.Pessoa;
import ufrn.br.aulamvcintroducao.service.PessoaService;


@Controller
public class ControllerPrincipal {

    PessoaService pessoaService;

    public ControllerPrincipal(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){

       model.addAttribute("arrayListPessoas", pessoaService.listAll());

       return "index";
    }



    @GetMapping("/cadastro.html")
    public String getCadastroPage(Model model){
        Pessoa pessoa = new Pessoa();
        model.addAttribute("pessoa", pessoa);
        return "cadastro";
    }

    @PostMapping("/doProcessCadastro")
    public String doProcessCadastro(@ModelAttribute Pessoa pessoa){
        pessoaService.addNewPessoa(pessoa);
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String doDeletePessoa(@PathVariable Long id){
        pessoaService.deletePessoa(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String getEditarPage(@PathVariable Long id, Model model){
        Pessoa p = pessoaService.getById(id);
        model.addAttribute("pessoa", p);
        return "editar";
    }

}
