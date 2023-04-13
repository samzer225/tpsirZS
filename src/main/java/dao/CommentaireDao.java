package dao;

import system.Commentaire;

public class CommentaireDao extends AbstractJpaDao<Long, Commentaire> {

	public CommentaireDao() {
		this.setClazz(Commentaire.class);
	}
}
