package com.example.mapper_oracle;

import java.util.List;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;

public interface BoardMapper {
	 public List<BoardVO> list(Criteria cri);
	 
	 public BoardVO read(int bno);
	 
	 public void isnert(BoardVO vo);
	 
	 public void update(BoardVO vo);
	 
	 public void delete(int bno);
	 
	 public int totalCount(Criteria cri);
	}
