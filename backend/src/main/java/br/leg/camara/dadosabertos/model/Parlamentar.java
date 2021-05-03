package br.leg.camara.dadosabertos.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Parlamentar {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String partido;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private int visualizacoes;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column(nullable = false)
    private String sexo;
    @Column(nullable = false)
    private String foto;
    @OneToMany(mappedBy = "parlamentar", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

}
