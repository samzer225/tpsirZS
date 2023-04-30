package dto;

import java.util.Date;

public class CommentaireDto {
	
	private Long idCommentaire;
	private String com;
	private Date dateCommentaire;
	private Long idTicket;
	private Long idUser;
	
	public CommentaireDto() {}
	
	public CommentaireDto(Long idCommentaire, String com, Date dateCommentaire, Long idTicket, Long idUser) {
		this.idCommentaire = idCommentaire;
		this.com = com;
		this.dateCommentaire = dateCommentaire;
		this.idTicket = idTicket;
		this.idUser = idUser;
	}

	public Long getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public Date getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(Long idTicket) {
		this.idTicket = idTicket;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

}

