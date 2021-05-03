package br.leg.camara.dadosabertos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PerfilParlamentarDTO {
    private String nome;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
    private String sexo;
    private String partido;
    private String foto;
    private List<DespesaDTO> despesas;
}
