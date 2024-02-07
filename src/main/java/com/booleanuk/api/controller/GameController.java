package com.booleanuk.api.controller;

import com.booleanuk.api.model.Game;
import com.booleanuk.api.model.payloads.PostGame;
import com.booleanuk.api.repository.GameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("games")
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Game> getAll() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Game getById(@PathVariable("id") Integer id) {
        return this.repository.findById(id).orElseThrow();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Game create(@RequestBody Game game) {
        if(game.getTitle() == null || game.getGenre() == null || game.getReleaseYear() == 0)
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title, genre, and release year are required");
        
        return this.repository.save(game);
    }

    @PutMapping("{id}")
    public Game update(@PathVariable("id") Integer id, @RequestBody Game game) {
        if(game.getTitle() == null && game.getGenre() == null && game.getReleaseYear() == 0 && game.getPublisher() == null && game.getIsEarlyAccess() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one field must be provided for update");

        Game existingGame = this.repository.findById(id).orElseThrow();
        if (game.getTitle() != null) {
            existingGame.setTitle(game.getTitle());
        }
        if (game.getGenre() != null) {
            existingGame.setGenre(game.getGenre());
        }
        if (game.getPublisher() != null) {
            existingGame.setPublisher(game.getPublisher());
        }
        if (game.getReleaseYear() != 0) {
            existingGame.setReleaseYear(game.getReleaseYear());
        }
        if (game.getIsEarlyAccess() != null) {
            existingGame.setIsEarlyAccess(game.getIsEarlyAccess());
        }
        return this.repository.save(existingGame);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.repository.deleteById(id);
    }
}