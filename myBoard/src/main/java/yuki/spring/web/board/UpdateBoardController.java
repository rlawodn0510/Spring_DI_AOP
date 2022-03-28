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
		// 1. ����� �Է� ���� ����
		System.out.println("�� ���� ��� ó��");
		// 2. �����ͺ��̽� ���� ó��
		boardDAO.updateBoard(vo);
		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}

}