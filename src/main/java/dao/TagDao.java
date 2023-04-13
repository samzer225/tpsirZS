package dao;


import system.Tag;

public class TagDao extends AbstractJpaDao<Long, Tag> {
	
	public TagDao() {
		this.setClazz(Tag.class);
	}

}
