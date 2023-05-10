package com.example.GameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.GameList.dto.GameDTO;
import com.example.GameList.dto.GameMinDTO;
import com.example.GameList.entities.Game;
import com.example.GameList.projections.GameMinProjection;
import com.example.GameList.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private  GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> list =  gameRepository.findAll();
		//tranforma uma list de games para lista de gamesDTO
		List<GameMinDTO> listdto = list.stream().map(x -> new GameMinDTO(x)).toList();
		return listdto;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> list =  gameRepository.searchByList(listId);
		//tranforma uma list de games para lista de gamesDTO	
		return list.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
