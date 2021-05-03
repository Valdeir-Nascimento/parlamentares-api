package br.leg.camara.dadosabertos.service;

import br.leg.camara.dadosabertos.model.Despesa;
import br.leg.camara.dadosabertos.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> obterDespesasUltimosMeses(Long parlamentarId, Pageable paginacao) {
        return despesaRepository.obterDespesasUltimosMeses(parlamentarId, paginacao);
    }

    public List<Despesa> obterDetalhesDespesa(Long id) {
        return despesaRepository.obterDetalhesDespesas(id);
    }





}
