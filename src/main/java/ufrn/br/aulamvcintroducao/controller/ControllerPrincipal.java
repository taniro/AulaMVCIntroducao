package ufrn.br.aulamvcintroducao.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ufrn.br.aulamvcintroducao.domain.Pessoa;
import ufrn.br.aulamvcintroducao.service.PessoaService;

import java.util.Optional;


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
    public String doProcessCadastro(@ModelAttribute @Valid Pessoa pessoa, Errors errors){

        if (errors.hasErrors()){
            return "cadastro";
        }else {
            pessoaService.addNewPessoa(pessoa);
            return "redirect:/";
        }
    }

    @PostMapping("/doProcessEdit/{id}")
    public String doProcessEdit(@ModelAttribute Pessoa pessoa){
        pessoaService.updatePessoa(pessoa);
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String doDeletePessoa(@PathVariable Long id){
        pessoaService.deletePessoa(id);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String getEditarPage(@PathVariable Long id, Model model){
        Optional<Pessoa> p = pessoaService.getById(id);
        if (p.isPresent()){
            model.addAttribute("pessoa", p.get());
            return "editar";
        }else{
            return "redirect:/";
        }

    }

    @GetMapping("/pessoasPorIdade")
    public String getPessoasPorIdadePage(Model model){

        var pessoas = pessoaService.getPessoaByIdade(40);
        model.addAttribute("pessoas", pessoas);

        return "pessoas";
    }

}
