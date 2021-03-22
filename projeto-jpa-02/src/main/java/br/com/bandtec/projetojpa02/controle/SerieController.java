package br.com.bandtec.projetojpa02.controle;

import br.com.bandtec.projetojpa02.dominio.Serie;
import br.com.bandtec.projetojpa02.repositorio.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieRepository repository;

    @GetMapping
    public ResponseEntity getSeries(){
        List<Serie> series = repository.findAll();

        if (series.isEmpty()) {
            return status(204).build();
        } else {
            return status(200).body(series);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSerie(@PathVariable int id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return status(200).build();
        } else {
            return status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity postSerie(@RequestBody Serie novaSerie){
        //supondo que o ano tem que estar entre 1920 e 2021
        if (novaSerie.getAnoCriacao() <= 1920 || novaSerie.getAnoCriacao() == 2021){
            return status(400).body("Ano de criação deve " +
                    "estar entre 1920 e 2021");
        }else {
            repository.save(novaSerie);
            return status(201).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getSerie(@PathVariable int id) {
        return of(repository.findById(id));
    }
}
