package com.example.GameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GameList.dto.GameMinDTO;
import com.example.GameList.entities.Game;
import com.example.GameList.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private  GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> list =  gameRepository.findAll();
		//tranforma uma list de games para lista de gamesDTO
		List<GameMinDTO> listdto = list.stream().map(x -> new GameMinDTO(x)).toList();
		return listdto;
	}
}
