package ifrn.pi.ProjetoPBD.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Página de detalhes do produto
    @GetMapping("/produto/{id}")
    public ModelAndView produto(@PathVariable("id") Long id) {
        Optional<Estoque> produto = estoquerepository.findById(id);
        ModelAndView mv = new ModelAndView("Home/produto"); // Página de detalhes
        if (produto.isPresent()) {
            mv.addObject("produto", produto.get()); // Passa o produto específico para o template
        } else {
            mv.addObject("erro", "Produto não encontrado");
        }
        return mv;
    }
}
