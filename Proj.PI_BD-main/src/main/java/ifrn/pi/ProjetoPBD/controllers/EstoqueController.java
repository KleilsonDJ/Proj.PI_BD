package ifrn.pi.ProjetoPBD.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.ProjetoPBD.modelos.Estoque;
import ifrn.pi.ProjetoPBD.repositories.EstoqueRepository;

@Controller
@RequestMapping("/Estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoquerepository;

    @GetMapping("/form")
    public String form() {
        return "Estoque/Gerenciador_do_Estoque";
    }

    @PostMapping
    public String adicionarProduto(Estoque estoque) {
        estoquerepository.save(estoque); 
        return "redirect:/Estoque";
    }

    @GetMapping
    public ModelAndView listar() {
        List<Estoque> listagenDOEstoque = estoquerepository.findAll();
        ModelAndView mv = new ModelAndView("Estoque/Gerenciador_do_Estoque");
        mv.addObject("listagenDOEstoque", listagenDOEstoque);
        return mv;
    }

    @GetMapping("/{id}/removerP")
    public String apagardoEstoque(@PathVariable Long id){
        Optional<Estoque> opt = estoquerepository.findById(id);
        if(opt.isPresent()){
            Estoque estoque = opt.get();
            estoquerepository.delete(estoque);
        }
        return "redirect:/Estoque";
    }

    // Método para exibir os detalhes do produto
    @GetMapping("/{id}")
    public ModelAndView produto(@PathVariable Long id) {
        Optional<Estoque> produto = estoquerepository.findById(id);
        ModelAndView mv = new ModelAndView("Estoque/Gerenciador_do_Estoque");
        if (produto.isPresent()) {
            mv.addObject("produto", produto.get()); // Passa o produto selecionado para a view
        } else {
            mv.addObject("erro", "Produto não encontrado");
        }
        return mv;
    }
}
