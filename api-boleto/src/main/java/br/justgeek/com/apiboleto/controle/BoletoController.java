package br.justgeek.com.apiboleto.controle;

import br.justgeek.com.apiboleto.dominio.Boleto;
import br.justgeek.com.apiboleto.repositorio.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletos")
public class BoletoController {
    @Autowired
    private BoletoRepository repository;
}
