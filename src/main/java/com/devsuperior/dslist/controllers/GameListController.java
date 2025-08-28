package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.dtos.GameResumeDTO;
import com.devsuperior.dslist.dtos.ReplacementDTO;
import com.devsuperior.dslist.service.GameListService;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return gameListService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameResumeDTO>> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getFromIndex(), body.getToIndex());
    }

}
