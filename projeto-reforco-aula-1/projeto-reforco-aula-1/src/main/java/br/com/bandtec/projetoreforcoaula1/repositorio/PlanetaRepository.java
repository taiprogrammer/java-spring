package br.com.bandtec.projetoreforcoaula1.repositorio;

import br.com.bandtec.projetoreforcoaula1.entidade.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {

    List<Planeta> findByDistanciaSolKmGreaterThan(Integer distancia);

}
