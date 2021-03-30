package br.justgeek.com.apiboleto.repositorio;

import br.justgeek.com.apiboleto.dominio.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
}
