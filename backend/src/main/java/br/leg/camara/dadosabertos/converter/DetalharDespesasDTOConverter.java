package br.leg.camara.dadosabertos.converter;

import br.leg.camara.dadosabertos.dto.DetalharDespesasDTO;
import br.leg.camara.dadosabertos.dto.ParlamentarDTO;
import br.leg.camara.dadosabertos.model.Despesa;
import br.leg.camara.dadosabertos.model.Parlamentar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DetalharDespesasDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public DetalharDespesasDTO toDTO(Despesa despesa) {
        return modelMapper.map(despesa, DetalharDespesasDTO.class);
    }

    public List<DetalharDespesasDTO> toListDTO(List<Despesa> despesas) {
        return despesas
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
