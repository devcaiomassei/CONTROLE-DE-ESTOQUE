package br.comvarejonline.projetoinicial.repositories;

import br.comvarejonline.projetoinicial.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
