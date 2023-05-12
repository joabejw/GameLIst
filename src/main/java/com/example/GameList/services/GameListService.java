package com.example.GameList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.GameList.dto.GameListDTO;
import com.example.GameList.entities.GameList;
import com.example.GameList.projections.GameMinProjection;
import com.example.GameList.repositories.GameListRepository;
import com.example.GameList.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private  GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> list =  gameListRepository.findAll();
		//tranforma uma list de GameList para lista de GameListDTO
		List<GameListDTO> listdto = list.stream().map(x -> new GameListDTO(x)).toList();
		return listdto;
	}
	
	@Transactional(readOnly = true)
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list =  gameRepository.searchByList(listId);
		GameMinProjection obj =  list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
