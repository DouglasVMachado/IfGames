package dev.games.IfGames.Repository;

import dev.games.IfGames.Entity.GamesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<GamesModel, Long> {
}
