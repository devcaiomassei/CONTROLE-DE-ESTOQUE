package br.comvarejonline.projetoinicial.dto;

public class ProdutoDto {
  private Long id;
  private String nome;
  private String codigoDeBarra;
  private Long quantidadeMinima;
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
