package com.example.GameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.GameList.dto.GameListDTO;
import com.example.GameList.entities.GameList;
import com.example.GameList.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list =  gameListRepository.findAll();
		//tranforma uma list de GameList para lista de GameListDTO
		List<GameListDTO> listdto = list.stream().map(x -> new GameListDTO(x)).toList();
		return listdto;
	}
}
