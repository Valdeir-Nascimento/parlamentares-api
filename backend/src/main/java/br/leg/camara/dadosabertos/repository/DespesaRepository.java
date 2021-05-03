package br.leg.camara.dadosabertos.repository;

import br.leg.camara.dadosabertos.model.Despesa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query("select d from Despesa d where d.parlamentar.id = :id order by d.dataDespesa desc ")
    List<Despesa> obterDetalhesDespesas(@Param("id") Long id);

    @Query("select d from Despesa d where d.parlamentar.id = :id group by d.mes order by d.dataDespesa desc")
    List<Despesa> obterDespesasUltimosMeses(@Param("id") Long id, Pageable paginacao);

}

