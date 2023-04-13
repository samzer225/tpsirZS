package dao;

import system.User;

public class UserDao extends AbstractJpaDao<Long, User> {
	
	public UserDao() {
		this.setClazz(User.class);
	}

}
