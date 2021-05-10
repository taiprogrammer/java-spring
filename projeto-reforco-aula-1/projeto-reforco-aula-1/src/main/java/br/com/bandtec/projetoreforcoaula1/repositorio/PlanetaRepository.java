package br.com.bandtec.projetoreforcoaula1.repositorio;

import br.com.bandtec.projetoreforcoaula1.entidade.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
}
