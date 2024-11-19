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

@Controller // Define que esta classe é um controlador do Spring
@RequestMapping("/Estoque") // Define o caminho base para os mapeamentos deste controlador
public class EstoqueController {

    @Autowired // Injeta automaticamente uma instância de EstoqueRepository
    private EstoqueRepository estoquerepository;

    /**
     * Método que exibe o formulário para gerenciar o estoque.
     * @return O nome da página do formulário.
     */
    @GetMapping("/form")
    public String form() {
        return "Estoque/Gerenciador_do_Estoque"; // Nome da página HTML que contém o formulário
    }
    
    /**
     * Método que adiciona um produto ao banco de dados.
     * @param estoque Objeto que contém os dados do produto a ser salvo.
     * @return Redireciona para a listagem dos produtos após salvar.
     */
    @PostMapping
    public String adicionarProduto(Estoque estoque) {
        System.out.println(estoque); // Exibe os dados do produto no console (apenas para depuração)
        estoquerepository.save(estoque); // Salva o objeto no banco de dados
        return "redirect:/Estoque"; // Redireciona para a página principal da listagem de produtos
    }
    
    /**
     * Método que lista todos os produtos cadastrados no banco de dados.
     * @return Um ModelAndView com a página de listagem e os produtos cadastrados.
     */
    @GetMapping
    public ModelAndView listar() {
        List<Estoque> listagenDOEstoque = estoquerepository.findAll(); // Recupera todos os produtos do banco de dados
        ModelAndView mv = new ModelAndView("Estoque/Gerenciador_do_Estoque"); // Configura a página de listagem
        mv.addObject("listagenDOEstoque", listagenDOEstoque); // Adiciona a lista de produtos ao modelo
        return mv; // Retorna a página configurada com os dados
    }
    
    @GetMapping("/{id}/removerP")
    public String apagardoEstoque(@PathVariable Long id){
    	Optional<Estoque> opt = estoquerepository.findById(id);
    	
    	if(!opt.isEmpty()){
    		Estoque estoque = opt.get();
    		estoquerepository.delete(estoque);
    	}
    	return"redirect:/Estoque";
    }
}
