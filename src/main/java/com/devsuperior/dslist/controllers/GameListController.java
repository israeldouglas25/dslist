package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(gameListService.findAll().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameListService.findById(id).getBody());
    }
}
