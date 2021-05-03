package br.leg.camara.dadosabertos.converter;

import br.leg.camara.dadosabertos.dto.DespesaDTO;
import br.leg.camara.dadosabertos.model.Despesa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DespesaDTOConverter {
    @Autowired
    private ModelMapper modelMapper;

    public DespesaDTO toDTO(Despesa despesa) {
        return modelMapper.map(despesa, DespesaDTO.class);
    }

    public List<DespesaDTO> toListDTO(List<Despesa> despesas) {
        List<DespesaDTO> despesasDTO = new ArrayList<>();

        // Agrupa as despesas por mês num
        Map<String, List<Despesa>> despesasAgrupadas = despesas
                .stream()
                .collect(Collectors.groupingBy(Despesa::getMes));
        // Percorre o mapa
        despesasAgrupadas.forEach((mes, despesaList) -> {
            DespesaDTO despesaDTO = new DespesaDTO();
            // Soma os valores de todas as despesas (reduce) usando lambda
            Double total = despesaList
                    .stream()
                    .reduce(0D, (parcial, despesa) -> parcial + despesa.getValorLiquido(), Double::sum);
            despesaDTO.setMes(mes);
            despesaDTO.setTotal(total);
            despesasDTO.add(despesaDTO);
        });
        return despesasDTO;
    }

    public List<DespesaDTO> toCollectionDTO(List<Despesa> despesas) {
        return despesas
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
