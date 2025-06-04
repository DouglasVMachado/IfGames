package dev.games.IfGames.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_Category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<GamesModel> games;

}
