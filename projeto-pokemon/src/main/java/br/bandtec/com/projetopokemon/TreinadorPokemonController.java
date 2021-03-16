package br.bandtec.com.projetopokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinadores")
public class TreinadorPokemonController {
    @Autowired
    private TreinadorPokemonRepository repository;

    @GetMapping
    public List<TreinadorPokemon> getTreinador() {
        return repository.findAll();
    }

    @PostMapping
    public String postTreinador(@RequestBody TreinadorPokemon novoTreinador) {
        repository.save(novoTreinador);
        return "Treinador cadastrado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String deleteTreinador(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Excluído com sucesso!";
        } else {
            return "Este treinador nunca foi cadastrado!";
        }
    }

    @GetMapping("/{id}")
    public TreinadorPokemon getTreinador(@PathVariable int id) {
        Optional<TreinadorPokemon> optionalTreinadorPokemon = repository.findById(id);
        if (optionalTreinadorPokemon.isPresent()) {
            return optionalTreinadorPokemon.get();
        } else {
            return null;
        }
    }

    @PutMapping("{id}")
    public String putTreinador(@PathVariable int id,
                               @RequestBody TreinadorPokemon treinadorAtualizado) {
        if (repository.existsById(id)) {
            treinadorAtualizado.setId(id);
            repository.save(treinadorAtualizado);
            return "Dados do treinador atualizados com sucesso";
        } else {
            return "Treinador não encontrado no nosso sistema :(";
        }
    }
}
