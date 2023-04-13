package dao;

import system.UserSupportTech;

public class UserSupportTechDao extends AbstractJpaDao<Long, UserSupportTech>{
	
	public UserSupportTechDao() {
		this.setClazz(UserSupportTech.class);
	}

}
