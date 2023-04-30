package system;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idTag;
    private String libelle;
    private String des;
    private Set<Ticket> tickets = new HashSet<>();

    protected Tag(){}

    public Tag(String libelle, String des){
        this.libelle =libelle;
        this.des = des;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return idTag;
    }
    public void setId(Long id) {
        this.idTag = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@JsonManagedReference(value = "tag-ticket")
    @OneToMany(mappedBy = "tag", cascade = CascadeType.PERSIST)
    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
