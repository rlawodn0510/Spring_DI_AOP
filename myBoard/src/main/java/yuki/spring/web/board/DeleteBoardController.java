package yuki.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import yuki.spring.web.common.BoardDAO;
@org.springframework.stereotype.Controller
public class DeleteBoardController {

	@RequestMapping(value = "/daleteBoard.do")
	public String DeleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		// 1. 사용자 입력 정보 추출
		// 2. 데이터베이스 연동 처리
		boardDAO.deleteBoard(vo);
		// 3. 화면 네비게이션
		return "getBoardList.do";

	}

}
