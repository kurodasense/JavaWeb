package easymall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import easymall.dao.CartDao;
import easymall.dao.UserDao;
import easymall.po.Cart;
import easymall.po.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);
		
	}

	@Override
	public Boolean checkUsername(String username) {
		// TODO 自动生成的方法存根
		User us = userDao.checkUsername(username);
		if(us != null) return true;
		else return false;
	}

	@Override
	public int regist(User user) {
		// TODO 自动生成的方法存根
		int n = userDao.regist(user);
		return n;
	}
	
	
}
