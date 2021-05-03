package br.leg.camara.dadosabertos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class DetalharDespesasDTO {
    private String tipoDespesa;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dataDespesa;
    private String tipoDocumento;
    private Double valorLiquido;
}
