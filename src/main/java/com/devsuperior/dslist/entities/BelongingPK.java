package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BelongingPK {

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @EqualsAndHashCode.Include
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;


}
