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
		System.out.println("로그인 처리");
		// 1. 사용자 입력 정보 추출
		// 2. 데이터베이스 연동 처리
		// 3. 화면 네비게이션
		if (userDAO.getUser(vo) != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
}
