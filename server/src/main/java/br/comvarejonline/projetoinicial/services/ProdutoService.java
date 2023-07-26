package br.comvarejonline.projetoinicial.services;

import br.comvarejonline.projetoinicial.convertes.ProdutorConverter;
import br.comvarejonline.projetoinicial.dto.ProdutoDto;
import br.comvarejonline.projetoinicial.entities.MovimentacaoEstoque;
import br.comvarejonline.projetoinicial.entities.Produto;
import br.comvarejonline.projetoinicial.models.TipoMovimentacao;
import br.comvarejonline.projetoinicial.repositories.MovimentacaoEstoqueRepository;
import br.comvarejonline.projetoinicial.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

  @Transactional // garante atomicidade das operações (inserirá ambos ou nada)
  public ProdutoDto inserirProduto(ProdutoDto produtoDto) {

    Produto produto = ProdutorConverter.converteParaProduto(produtoDto);
    produto = produtoRepository.save(produto);

    List<MovimentacaoEstoque> movimentacoes = movimentacaoEstoqueRepository.findByProduto(produto);

    if (produto.getSaldoInicial() > 0 && movimentacoes.isEmpty()) { //regra de saldo inicial e movimentacoes de produto
      MovimentacaoEstoque movimentacaoEstoque = new MovimentacaoEstoque();
      movimentacaoEstoque.setTipo(TipoMovimentacao.SALDO_INICIAL);
      movimentacaoEstoque.setProduto(produto);
      movimentacaoEstoque.setQuantidade(produto.getSaldoInicial());
      movimentacaoEstoqueRepository.save(movimentacaoEstoque);
    }
    return ProdutorConverter.converteParaProdutoDto(produto);
  }

  public List<ProdutoDto> buscaTodos() {
    return produtoRepository.findAll().stream()
            .map(ProdutorConverter::converteParaProdutoDto)
            .collect(Collectors.toList());
  }

  public void movimentarEstoque(MovimentacaoEstoque movimentacaoEstoque) {

    List<MovimentacaoEstoque> movimentacoesAnteriores = movimentacaoEstoqueRepository
            .findByProduto(movimentacaoEstoque.getProduto());

    if (movimentacaoEstoque.getTipo().equals(TipoMovimentacao.SALDO_INICIAL) && !movimentacoesAnteriores.isEmpty()) {
      throw new IllegalArgumentException("Produto ja possui lançamentos anteriores, por isso não é possivel lancar saldo inicial");
    }


    movimentacaoEstoqueRepository.save(movimentacaoEstoque);
  }
}
