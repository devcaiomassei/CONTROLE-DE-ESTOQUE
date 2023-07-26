package br.comvarejonline.projetoinicial.repositories;

import br.comvarejonline.projetoinicial.entities.MovimentacaoEstoque;
import br.comvarejonline.projetoinicial.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {

  List<MovimentacaoEstoque> findByProduto(Produto produto);
}
