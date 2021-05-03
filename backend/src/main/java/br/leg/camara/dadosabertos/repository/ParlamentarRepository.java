package br.leg.camara.dadosabertos.repository;
import br.leg.camara.dadosabertos.model.Parlamentar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParlamentarRepository extends JpaRepository<Parlamentar, Long> {

    @Query("select p from Parlamentar p order by p.nome asc")
    Page<Parlamentar> listarParlamentares(Pageable paginacao);


}
