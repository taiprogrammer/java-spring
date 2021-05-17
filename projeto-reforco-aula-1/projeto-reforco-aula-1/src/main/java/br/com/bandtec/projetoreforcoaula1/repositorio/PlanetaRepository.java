package br.com.bandtec.projetoreforcoaula1.repositorio;

import br.com.bandtec.projetoreforcoaula1.entidade.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {

    List<Planeta> findByDistanciaSolKmGreaterThan(Integer distancia);

    @Query("select p from Planeta p where p.distanciaSolKm > 500000")
    List<Planeta> pesquisarMaisDistantes();

}
