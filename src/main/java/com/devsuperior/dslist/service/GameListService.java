package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.exceptions.NotFoundException;
import com.devsuperior.dslist.repository.GameListRepository;
import com.devsuperior.dslist.repository.GameRepository;
import com.devsuperior.dslist.utils.GameDTOProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public ResponseEntity<List<GameListDTO>> findAll() {
        try {
            return ResponseEntity.ok(
                    gameListRepository.findAll().stream()
                            .map(GameListDTO::new)
                            .toList()
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<GameListDTO> findById(Long id) {
        return gameListRepository.findById(id)
                .map(gameList -> ResponseEntity.ok(new GameListDTO(gameList)))
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Transactional
    public void move(Long listId, int fromIndex, int toIndex) {

        try {
            List<GameDTOProjection> list = gameRepository.searchByList(listId);

            GameDTOProjection game = list.remove(fromIndex);
            list.add(toIndex, game);

            for (int i = 0; i < list.size(); i++) {
                gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
