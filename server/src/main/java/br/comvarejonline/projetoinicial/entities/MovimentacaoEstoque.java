package br.comvarejonline.projetoinicial.entities;

import br.comvarejonline.projetoinicial.models.TipoMovimentacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MovimentacaoEstoque {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  @Enumerated(EnumType.STRING)
  private TipoMovimentacao tipo;

  @Column
  private Long quantidade;

  @ManyToOne
  private Produto produto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TipoMovimentacao getTipo() {
    return tipo;
  }

  public void setTipo(TipoMovimentacao tipo) {
    this.tipo = tipo;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }
}
