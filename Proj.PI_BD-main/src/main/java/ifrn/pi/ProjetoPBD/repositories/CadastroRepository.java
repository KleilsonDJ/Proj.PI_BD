package ifrn.pi.ProjetoPBD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.ProjetoPBD.modelos.Funcionario;

public interface CadastroRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByEmail(String email);
}