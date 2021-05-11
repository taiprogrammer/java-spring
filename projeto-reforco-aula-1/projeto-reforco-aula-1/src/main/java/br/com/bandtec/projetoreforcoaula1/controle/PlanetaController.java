package br.com.bandtec.projetoreforcoaula1.controle;

import br.com.bandtec.projetoreforcoaula1.entidade.Planeta;
import br.com.bandtec.projetoreforcoaula1.repositorio.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;

    @GetMapping
    public ResponseEntity getPlaneta() {
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getPlanetaId(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.status(200).body(repository.findById(id));
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlanetaId(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        else {
            return ResponseEntity.status(204).body("Planeta inexistente");
        }
    }

    @PostMapping
    public ResponseEntity postPlaneta(@RequestBody @Valid Planeta novoPlaneta) {
        repository.save(novoPlaneta);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity putPlanetaId(@PathVariable int id,
                                       @RequestBody @Valid Planeta planetaAtualizado) {
        if (repository.existsById(id)) {
            planetaAtualizado.setId(id);
            repository.save(planetaAtualizado);
            return ResponseEntity.status(201).build();
        }
        else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/mais-distantes")
    public ResponseEntity getPlanetasMaisDistantes() {
        List<Planeta> planetas = repository.findByDistanciaSolKmGreaterThan(500_000);
        if (planetas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        else {
            return ResponseEntity.status(200).body(planetas);
        }
    }
}
