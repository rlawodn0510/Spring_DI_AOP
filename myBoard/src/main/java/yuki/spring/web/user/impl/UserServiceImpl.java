package yuki.spring.web.user.impl;

import yuki.spring.web.user.UserService;
import yuki.spring.web.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	UserDAO user = new UserDAO(); 
	@Autowired
	public void setUserDAO() {
		this.userDAO = user;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
