package ifrn.pi.ProjetoPBD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ifrn.pi.ProjetoPBD.modelos.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
