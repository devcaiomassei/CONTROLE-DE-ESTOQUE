package br.comvarejonline.projetoinicial.convertes;

import br.comvarejonline.projetoinicial.dto.ProdutoDto;
import br.comvarejonline.projetoinicial.entities.Produto;

public class ProdutorConverter {


  public static ProdutoDto converteParaProdutoDto(Produto produto) {
    ProdutoDto produtoDto = new ProdutoDto();

    produtoDto.setId(produto.getId());
    produtoDto.setCodigoDeBarra(produto.getCodigoDeBarra());
    produtoDto.setQuantidadeMinima(produto.getQuantidadeMinima());
    produtoDto.setNome(produto.getNome());
    produtoDto.setSaldoInicial(produto.getSaldoInicial());

    return produtoDto;
  }

  public static Produto converteParaProduto(ProdutoDto produtoDto) {
    Produto produto = new Produto();

    produto.setId(produtoDto.getId());
    produto.setCodigoDeBarra(produtoDto.getCodigoDeBarra());
    produto.setQuantidadeMinima(produtoDto.getQuantidadeMinima());
    produto.setNome(produtoDto.getNome());
    produto.setSaldoInicial(produtoDto.getSaldoInicial());

    return produto;
  }
}
