package br.leg.camara.dadosabertos.service;

import br.leg.camara.dadosabertos.model.Parlamentar;
import br.leg.camara.dadosabertos.repository.ParlamentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ParlamentarService {
    @Autowired
    private ParlamentarRepository parlamentarRepository;

    public Page<Parlamentar> listarParlamentares(Pageable paginacao) {
        return parlamentarRepository.listarParlamentares(paginacao);
    }

}

