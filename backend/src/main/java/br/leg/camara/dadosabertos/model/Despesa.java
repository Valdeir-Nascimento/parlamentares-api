package br.leg.camara.dadosabertos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Despesa {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipoDespesa;
    @Column(nullable = false)
    private String tipoDocumento;
    @Column(nullable = false)
    private Date dataDespesa;
    @Column(nullable = false)
    private Double valorLiquido;
    private String mes;
    @ManyToOne
    @JoinColumn(name = "parlamentar_id", nullable = false)
    private Parlamentar parlamentar;

}

