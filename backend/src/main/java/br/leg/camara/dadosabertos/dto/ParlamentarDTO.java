package br.leg.camara.dadosabertos.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParlamentarDTO {
    private Long id;
    private String nome;
    private String partido;
    private String uf;
    private int visualizacoes;
}
