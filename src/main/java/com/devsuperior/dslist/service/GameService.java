package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public ResponseEntity<List<GameDTO>> findAll() {
        return ResponseEntity.ok(
            gameRepository.findAll().stream()
                .map(GameDTO::new)
                .toList()
        );
    }
}
