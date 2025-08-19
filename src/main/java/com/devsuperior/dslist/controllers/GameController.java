package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll().getBody());
    }
}
