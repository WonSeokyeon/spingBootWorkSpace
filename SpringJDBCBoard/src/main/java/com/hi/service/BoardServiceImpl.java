package com.hi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hi.domain.Board;
import com.hi.dto.BoardDTO;
import com.hi.repository.BoardRepo;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepo boardRepo;

	@Override
	public boolean insert(BoardDTO boardDTO) throws Exception {
		if(boardDTO== null  || boardDTO.getTitle()== null || boardDTO.getWriter()==null) {
			return false;
			
		}
		Board board= new Board();
		board.setTitle(boardDTO.getTitle());
		board.setWriter(boardDTO.getWriter());
		board.setContent(boardDTO.getContent());
		return boardRepo.insert(board);
		
	}

	@Override
	public BoardDTO select(BoardDTO boardDTO) throws Exception {
		if(boardDTO.getBoardNo() <= 0) {
			return null;
			
		}
		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo());
		
		Board board1 = boardRepo.select(board);
		boardDTO.setBoardNo(board1.getBoardNo());
		boardDTO.setTitle(board1.getTitle());
		boardDTO.setContent(board1.getContent());
		boardDTO.setRegDate(board1.getRegDate());
		boardDTO.setWriter(board1.getWriter());
		return boardDTO;
	}

	@Override
	public boolean update(BoardDTO boardDTO) throws Exception {
		if(boardDTO.getBoardNo()<=0) {
			return false;
		}
		Board board= new Board();
		board.setBoardNo(boardDTO.getBoardNo());
		board.setTitle(boardDTO.getTitle());
		board.setWriter(boardDTO.getWriter());
		board.setContent(boardDTO.getContent());
		return boardRepo.update(board);
	}

	@Override
	public boolean delete(BoardDTO boardDTO) throws Exception {
		if(boardDTO.getBoardNo()<=0) {
			return false;
		}
		Board board = new Board();
		board.setBoardNo(boardDTO.getBoardNo());
		
		return boardRepo.delete(board);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		List<Board> list = boardRepo.list();
		if(list.size()<=0) {
			return null;
		}List<BoardDTO> list2 = new ArrayList<>();
		for (Board board : list) {
			BoardDTO boardDTO1 = new BoardDTO();
			boardDTO1.setBoardNo(board.getBoardNo());
			boardDTO1.setContent(board.getContent());
			boardDTO1.setTitle(board.getTitle());
			boardDTO1.setRegDate(board.getRegDate());
			boardDTO1.setWriter(board.getWriter());
			list2.add(boardDTO1);
			
			
		}
		
		return list2;
	}

}
