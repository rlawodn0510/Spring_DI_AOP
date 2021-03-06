package yuki.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yuki.spring.web.common.BoardDAO;
@Controller
public class InsertBoardController {
	@RequestMapping(value = "/insetBoard.do")
	public String InsertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");
		// 1. 사용자 입력 정보 추출
		// 2. 데이터베이스 연동 처리
		boardDAO.insertBoard(vo);
		// 3. 화면 네비게이션
		return "getBoardList.do";
	}

}
