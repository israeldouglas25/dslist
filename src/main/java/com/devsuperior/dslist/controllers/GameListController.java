package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameResumeDTO;
import com.devsuperior.dslist.dtos.GameListDTO;
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
        return ResponseEntity.ok(gameListService.findAll().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameListService.findById(id).getBody());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameResumeDTO>> findByList(@PathVariable Long listId) {
        return ResponseEntity.ok(gameService.findByList(listId).getBody());
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getFromIndex(), body.getToIndex());
    }

}
