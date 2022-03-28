package yuki.spring.web.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yuki.spring.web.common.BoardDAO;
@Controller
public class GetBoardListController{
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView GetBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리");
		// 1. 사용자 입력 정보 추출 : 검색 기능은 나중에 구현
		// 2. 데이터베이스 연동 처리
		// 3. 응답 화면 구성
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보저당
		mav.setViewName("getBoardList.jsp"); // View 정보저장
		return mav;
	}

}
