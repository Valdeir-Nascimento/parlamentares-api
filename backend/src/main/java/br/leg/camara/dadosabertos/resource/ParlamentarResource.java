package br.leg.camara.dadosabertos.resource;

import br.leg.camara.dadosabertos.converter.DespesaDTOConverter;
import br.leg.camara.dadosabertos.converter.DetalharDespesasDTOConverter;
import br.leg.camara.dadosabertos.converter.ParlamentarDTOConverter;
import br.leg.camara.dadosabertos.dto.DespesaDTO;
import br.leg.camara.dadosabertos.dto.DetalharDespesasDTO;
import br.leg.camara.dadosabertos.dto.ParlamentarDTO;
import br.leg.camara.dadosabertos.dto.PerfilParlamentarDTO;
import br.leg.camara.dadosabertos.model.Despesa;
import br.leg.camara.dadosabertos.model.Parlamentar;
import br.leg.camara.dadosabertos.service.DespesaService;
import br.leg.camara.dadosabertos.service.ParlamentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parlamentares")
public class ParlamentarResource {
    @Autowired
    private ParlamentarService parlamentarService;
    @Autowired
    private ParlamentarDTOConverter parlamentarDTOConverter;
    @Autowired
    private DespesaDTOConverter despesaDTOConverter;
    @Autowired
    private DespesaService despesaService;
    @Autowired
    private DetalharDespesasDTOConverter detalharDepesasDTOConverter;

    @GetMapping
    public List<ParlamentarDTO> listar(@PageableDefault(page = 0, size = 5) Pageable paginacao) {
        Page<Parlamentar> parlamentares = parlamentarService.listarParlamentares(paginacao);
        return parlamentarDTOConverter.toListDTO(parlamentares.getContent());
    }

    @GetMapping("/{id}")
    public PerfilParlamentarDTO buscar(@PathVariable Long id, @PageableDefault(page = 0, size = 2) Pageable paginacao) {
        List<Despesa> despesas = despesaService.obterDespesasUltimosMeses(id, paginacao);
        List<DespesaDTO> despesaList = despesaDTOConverter.toListDTO(despesas);
        PerfilParlamentarDTO perfilParlamentar = new PerfilParlamentarDTO();
        for (Despesa despesa: despesas) {
            perfilParlamentar.setNome(despesa.getParlamentar().getNome());
            perfilParlamentar.setDataNascimento(despesa.getParlamentar().getDataNascimento());
            perfilParlamentar.setPartido(despesa.getParlamentar().getPartido());
            perfilParlamentar.setSexo(despesa.getParlamentar().getSexo());
            perfilParlamentar.setFoto(despesa.getParlamentar().getFoto());
            perfilParlamentar.setDespesas(despesaList);
        }
        return perfilParlamentar;
    }

    @GetMapping("/{id}/despesas")
    public List<DetalharDespesasDTO> detalharDespesa(@PathVariable Long id) {
        List<DetalharDespesasDTO> despesas = detalharDepesasDTOConverter.toListDTO(despesaService.obterDetalhesDespesa(id));
        return despesas;
    }

}
