package br.bandtec.com.projetojpa03.repositorios;

import br.bandtec.com.projetojpa03.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
