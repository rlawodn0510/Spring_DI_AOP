package yuki.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LogoutController{

	@RequestMapping(value = "/logout.do")
	public String Logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		// 1. �������� ����� ���� ��ü�� ����
		session.invalidate();
		// 2. ���� ���� �� ���� ȭ������ �̵�
		return "login.jsp";

	}

}
