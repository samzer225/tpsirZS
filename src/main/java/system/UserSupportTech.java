package system;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Set;


@Entity
public class UserSupportTech  extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String job;

    /**
     * Constructor
     */
    public UserSupportTech(){}

    public UserSupportTech(String name, String job){
        this.job = job;
        this.setName(name);
    }


    /**
     * Getter and Setter
     * @return
     */
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @JsonManagedReference
    @Override
    @ManyToMany
    public Set<Ticket> getListTickets() {
        return super.getListTickets();
    }

    @Override
    public void setListTickets(Set<Ticket> listTickets) {
        super.setListTickets(listTickets);
    }

}
