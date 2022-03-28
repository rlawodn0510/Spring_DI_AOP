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
		System.out.println("�� ���� ó��");
		// 1. ����� �Է� ���� ����
		// 2. �����ͺ��̽� ���� ó��
		boardDAO.deleteBoard(vo);
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";

	}

}
