package system;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ticket implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long idTicket;
	private String sujet;
    private String description;
    private Date dateCreationTicket;
    private String statut;
    private Tag tag;
    private User user;
	private Set<UserSupportTech> userST = new HashSet<>();
	private Set<Commentaire> commentaire = new HashSet<>();
	
    /**
     * Constructor
     */
    protected Ticket() {}

    public Ticket( String sujet,String description, String statut) {
    	this.sujet = sujet;
        this.description = description;
        this.statut = statut;
        this.dateCreationTicket = new Date();
    }

    /**
     *  Getter and Setter
     */
    @Id
    @GeneratedValue
    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Date getDateCreationTicket() {
        return dateCreationTicket;
    }

    public void setDateCreationTicket(Date dateCreationTicket) {
        this.dateCreationTicket = dateCreationTicket;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @JsonBackReference(value = "tag-ticket")
    @ManyToOne
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @JsonBackReference(value = "user-ticket")
    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @JsonBackReference(value = "userST-ticket")
    @ManyToMany
    public Set<UserSupportTech> getUserST() {
        return userST;
    }

    public void setUserST(Set<UserSupportTech> userST) {
        this.userST = userST;
    }

    @JsonBackReference(value = "comment-ticket")
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.PERSIST)
    public Set<Commentaire> getCommentaire() {
        return commentaire;
    }

    
    public void setCommentaire(Set<Commentaire> commentaire) {
        this.commentaire = commentaire;
    }

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
