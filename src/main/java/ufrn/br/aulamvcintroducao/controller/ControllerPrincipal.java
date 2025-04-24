package ufrn.br.aulamvcintroducao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String doCrescer(Model model){

       model.addAttribute("arrayListPessoas", pessoaService.getPessoas());

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

}
