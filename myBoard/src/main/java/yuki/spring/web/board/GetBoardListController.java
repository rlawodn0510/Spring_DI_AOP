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
		System.out.println("�� ��� �˻� ó��");
		// 1. ����� �Է� ���� ���� : �˻� ����� ���߿� ����
		// 2. �����ͺ��̽� ���� ó��
		// 3. ���� ȭ�� ����
		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model ��������
		mav.setViewName("getBoardList.jsp"); // View ��������
		return mav;
	}

}
