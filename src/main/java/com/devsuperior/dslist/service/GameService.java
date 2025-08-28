package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameResumeDTO;
import com.devsuperior.dslist.exceptions.NotFoundException;
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
    public ResponseEntity<List<GameResumeDTO>> findAll() {
        try {
            return ResponseEntity.ok(
                    gameRepository.findAll().stream()
                            .map(GameResumeDTO::new)
                            .toList()
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<List<GameResumeDTO>> findByList(Long listId) {
        try {
            return ResponseEntity.ok(
                    gameRepository.searchByList(listId).stream()
                            .map(GameResumeDTO::new)
                            .toList()
            );
        } catch (Exception e) {
            throw new NotFoundException("List not found with id: " + listId);
        }

    }

    @Transactional
    public ResponseEntity<GameDTO> findById(Long id) {
        return gameRepository.findById(id)
                .map(game -> ResponseEntity.ok(new GameDTO(game)))
                .orElseThrow(() -> new NotFoundException("Game not found with id: " + id));
    }
}
