package com.example.GameList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GameList.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
