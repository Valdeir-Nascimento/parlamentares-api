package br.leg.camara.dadosabertos.converter;

import br.leg.camara.dadosabertos.dto.ParlamentarDTO;
import br.leg.camara.dadosabertos.model.Parlamentar;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParlamentarDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ParlamentarDTO toDTO(Parlamentar parlamentar) {
        return modelMapper.map(parlamentar, ParlamentarDTO.class);
    }

    public List<ParlamentarDTO> toListDTO(List<Parlamentar> parlamentares) {
        return parlamentares
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
