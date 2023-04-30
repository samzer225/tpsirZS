package system;

//import javax.annotation.processing.Generated;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idUser;
	protected String name;
	protected String pseudo;
	protected String email;
	protected Set<Ticket> listTickets = new HashSet<>();
	private Set<Commentaire> listCom = new HashSet<>();

	/**
	 * Constructor
	 */
	public User(){
		super();
	}

	public User(String name,String pseudo, String email){
		this.name = name;
		this.pseudo = pseudo;
		this.email= email;
	}

	/**
	 * Getter and Setter
	 */
	@Id
	@GeneratedValue
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
	
	/**
	 * getTickets
	 * @return
	 */
	@JsonManagedReference(value = "user-ticket")	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	public Set<Ticket> getListTickets() {
		return listTickets;
	}

	public void setListTickets(Set<Ticket> listTickets) {
		this.listTickets = listTickets;
	}

	@JsonManagedReference(value = "comment-user")
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	public Set<Commentaire> getListCom() {
		return listCom;
	}

	public void setListCom(Set<Commentaire> listCom) {
		this.listCom = listCom;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	

}
