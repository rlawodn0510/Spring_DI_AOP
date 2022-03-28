/*
package yuki.spring.web.board.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yuki.spring.web.board.BoardService;
import yuki.spring.web.board.BoardVO;
import yuki.spring.web.common.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSpring boardDAO;

	public void insertBoard(BoardVO vo) {
		
		boardDAO.insertBoard(vo);
		// log.printLogging();
	}

	public void updateBoard(BoardVO vo) {
		// log.printLogging();
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		// log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		// log.printLogging();
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		// log.printLogging();
		return boardDAO.getBoardList(vo);
	}

}
*/