package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(
                gameListRepository.findAll().stream()
                        .map(GameListDTO::new)
                        .toList()
        );
    }

    @Transactional
    public ResponseEntity<GameListDTO> findById(Long id) {
        return gameListRepository.findById(id)
                .map(gameList -> ResponseEntity.ok(new GameListDTO(gameList)))
                .orElse(ResponseEntity.notFound().build());
    }
}
