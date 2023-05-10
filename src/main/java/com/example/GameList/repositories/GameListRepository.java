package com.example.GameList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.GameList.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
