package yuki.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yuki.spring.web.common.BoardDAO;
@Controller
public class GetBoardController {
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView GetBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 보기 처리");
		// 1. 검색할 게시글 번호 추출
		// 2. 데이터베이스 연동 처리
		// 3. 응답 화면 구현
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;

	}

}
