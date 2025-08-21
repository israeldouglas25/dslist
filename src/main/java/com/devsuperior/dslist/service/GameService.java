package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public ResponseEntity<List<GameDTO>> findAll() {
        return ResponseEntity.ok(
                gameRepository.findAll().stream()
                        .map(GameDTO::new)
                        .toList()
        );
    }

    @Transactional
    public ResponseEntity<List<GameDTO>> findByList(Long listId) {
        return ResponseEntity.ok(
                gameRepository.searchByList(listId).stream()
                        .map(GameDTO::new)
                        .toList()
        );
    }

    @Transactional
    public ResponseEntity<GameDTO> findById(Long id) {
        return gameRepository.findById(id)
                .map(game -> ResponseEntity.ok(new GameDTO(game)))
                .orElse(ResponseEntity.notFound().build());
    }
}
