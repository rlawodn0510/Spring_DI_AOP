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
		System.out.println("�� �� ���� ó��");
		// 1. �˻��� �Խñ� ��ȣ ����
		// 2. �����ͺ��̽� ���� ó��
		// 3. ���� ȭ�� ����
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;

	}

}
