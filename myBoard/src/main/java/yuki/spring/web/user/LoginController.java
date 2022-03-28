package yuki.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yuki.spring.web.user.impl.UserDAO;
@Controller
public class LoginController {

	@RequestMapping(value = "/login.do")
	public String Login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó��");
		// 1. ����� �Է� ���� ����
		// 2. �����ͺ��̽� ���� ó��
		// 3. ȭ�� �׺���̼�
		if (userDAO.getUser(vo) != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
