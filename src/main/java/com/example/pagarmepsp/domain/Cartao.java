package com.example.pagarmepsp.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "nome_portador")
    private String nomePortador;

    @Column(name = "data_validade")
    private LocalDate dataValidade;

    @Column(name = "cvv")
    private String cvv;

    public Cartao() {
    }

    public Cartao(String numero, String nomePortador, LocalDate dataValidade, String cvv) {
        this.numero = getUltimosQuatroDigitos(numero);
        this.nomePortador = nomePortador;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    private String getUltimosQuatroDigitos(String numeroCartao) {
        var qtdCaracteres = numeroCartao.length();

        return numeroCartao.substring(qtdCaracteres - 4, qtdCaracteres);
    }

    public String getNumero() {
        return numero;
    }
}
