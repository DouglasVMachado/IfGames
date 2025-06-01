package dev.games.IfGames.Repository;

import dev.games.IfGames.Entity.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
