package ifrn.pi.ProjetoPBD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifrn.pi.ProjetoPBD.modelos.Funcionario;
import ifrn.pi.ProjetoPBD.repositories.CadastroRepository;

@Controller
public class CadastroController {

    @Autowired
    private CadastroRepository cr;

    // Exibe a página de cadastro (GET)
    @GetMapping("/mercado/cadastro")
    public String cadastroPage() {
        return "Pag-Cadastro_Login/Cadastro"; // Redireciona para a página de cadastro
    }

    // Processa o formulário de cadastro (POST)
    @PostMapping("/mercado/cadastro")
    public String cadastro(Funcionario funcionario) {
        cr.save(funcionario); // Salva os dados do funcionário no banco de dados
        return "redirect:/mercado/login"; // Redireciona para a página de login
    }
}