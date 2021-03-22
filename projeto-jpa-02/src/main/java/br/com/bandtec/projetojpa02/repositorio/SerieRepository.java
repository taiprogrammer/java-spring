package br.com.bandtec.projetojpa02.repositorio;

import br.com.bandtec.projetojpa02.dominio.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
