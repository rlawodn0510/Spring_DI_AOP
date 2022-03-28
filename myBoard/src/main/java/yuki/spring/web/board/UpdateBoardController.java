package yuki.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yuki.spring.web.common.BoardDAO;
@Controller
public class UpdateBoardController {
	@RequestMapping(value = "/updateBoard.do")
	public String UpdateBoard(BoardVO vo, BoardDAO boardDAO) {
		// 1. 사용자 입력 정보 추출
		System.out.println("글 수정 기능 처리");
		// 2. 데이터베이스 연동 처리
		boardDAO.updateBoard(vo);
		// 3. 화면 네비게이션
		return "getBoardList.do";
	}

}
