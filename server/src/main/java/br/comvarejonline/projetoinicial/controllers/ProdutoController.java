package br.comvarejonline.projetoinicial.controllers;

import br.comvarejonline.projetoinicial.dto.ProdutoDto;
import br.comvarejonline.projetoinicial.entities.MovimentacaoEstoque;
import br.comvarejonline.projetoinicial.entities.Produto;
import br.comvarejonline.projetoinicial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;

  @PostMapping(path = "/produtos")
  public ResponseEntity<?> inserirProduto(@RequestBody ProdutoDto produtoDto) {

    //REGRA O Saldo inicial não poderá ser inferior a quantidade mínima
    if (produtoDto.getSaldoInicial() < produtoDto.getQuantidadeMinima()) {
      return ResponseEntity.status(BAD_REQUEST).body("Saldo inicial não pode ser menor que quantidade minima.");
    }

    ProdutoDto dto = produtoService.inserirProduto(produtoDto);

    return ResponseEntity.status(CREATED).body(dto);
  }

  @PostMapping(path = "/estoques")
  public ResponseEntity<?> movimentarEstoque(@RequestBody MovimentacaoEstoque movimentacaoEstoque) {


    produtoService.movimentarEstoque(movimentacaoEstoque);

    return ResponseEntity.status(CREATED).build();
  }


  @GetMapping(path = "/produtos")
  public ResponseEntity<?> buscaTodos() {
    return ResponseEntity.status(OK).body(produtoService.buscaTodos());
  }
}
