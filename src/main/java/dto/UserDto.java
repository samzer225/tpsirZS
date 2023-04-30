package dto;

import java.util.HashSet;
import java.util.Set;

import system.Ticket;
import system.Commentaire;

public class UserDto {
	
	private Long idUser;
	private String name;
	private String pseudo;
	private String email;
	private Set<Ticket> listTickets = new HashSet<>();
	private Set<Commentaire> listCom = new HashSet<>();
	
	/**
	 * Constructor
	 */
	public UserDto() {
		super();
	}
	
	public UserDto(String name, String pseudo, String email) {
		this.name = name;
		this.pseudo = pseudo;
		this.email = email;
	}

	/**
	 * Getter and Setter
	 */
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Ticket> getListTickets() {
		return listTickets;
	}

	public void setListTickets(Set<Ticket> listTickets) {
		this.listTickets = listTickets;
	}

	public Set<Commentaire> getListCom() {
		return listCom;
	}

	public void setListCom(Set<Commentaire> listCom) {
		this.listCom = listCom;
	}

}
