package ifrn.pi.ProjetoPBD.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.ProjetoPBD.modelos.Estoque;
import ifrn.pi.ProjetoPBD.repositories.EstoqueRepository;

@Controller
public class HomeController {

    @Autowired
    private EstoqueRepository estoquerepository;

    // Página inicial com listagem de produtos
    @GetMapping("/home")
    public ModelAndView home() {
        List<Estoque> listagenDOEstoque = estoquerepository.findAll();
        ModelAndView mv = new ModelAndView("Home/home"); // Página home
        mv.addObject("listagenDOEstoque", listagenDOEstoque); // Passa a lista para o template
        return mv;
    }
}
