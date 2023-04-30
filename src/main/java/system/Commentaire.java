package system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Commentaire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idCommentaire;
	private String com;
	private Date dateCommentaire;
	private Ticket ticket;
	private User user;
	
	// Protected pour obliger l'utilisateur a mettre un commentaire
	protected Commentaire() {}
	
	public Commentaire (String com) {
		this.com = com;
		this.dateCommentaire= new Date();
	}
	
	@Id
	@GeneratedValue
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

	@JsonBackReference(value = "comment-ticket")
	@ManyToOne
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@JsonBackReference(value = "comment-user")
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
