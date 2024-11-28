package ifrn.pi.ProjetoPBD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ifrn.pi.ProjetoPBD.modelos.Funcionario;
import ifrn.pi.ProjetoPBD.repositories.CadastroRepository;

@Controller
public class LoginController {

    @Autowired
    private CadastroRepository cr;

    @GetMapping("/mercado/login")
    public String loginPage() {
        return "Pag-Cadastro_Login/Login";
    }

    @PostMapping("/mercado/login")
    public String login(@RequestParam String email, @RequestParam String senha, Model model) {
        Funcionario funcionario = cr.findByEmail(email);

        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return "redirect:/cadastro";
        } else {
            model.addAttribute("erro", "Email ou senha incorretos!");
            return "Login";
        }
    }
}