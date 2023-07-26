package br.comvarejonline.projetoinicial.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String nome;
  @Column(unique = true) // unique = true garante que não haverá código de barras idênticos.
  private String codigoDeBarra;
  @Column
  private Long quantidadeMinima;
  @Column(updatable = false) //updatable = false garante que saldo inicial nunca será atualizado.
  private Long saldoInicial;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCodigoDeBarra() {
    return codigoDeBarra;
  }

  public void setCodigoDeBarra(String codigoDeBarra) {
    this.codigoDeBarra = codigoDeBarra;
  }

  public Long getQuantidadeMinima() {
    return quantidadeMinima;
  }

  public void setQuantidadeMinima(Long quantidadeMinima) {
    this.quantidadeMinima = quantidadeMinima;
  }

  public Long getSaldoInicial() {
    return saldoInicial;
  }

  public void setSaldoInicial(Long saldoInicial) {
    this.saldoInicial = saldoInicial;
  }
}
