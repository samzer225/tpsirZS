package dto;

import java.util.Set;

public class TagDto {
    private Long id;
    private String libelle;
    private String des;
    private Set<Long> ticketIds;

    public TagDto(Long id, String libelle, String des, Set<Long> ticketIds) {
        this.id = id;
        this.libelle = libelle;
        this.des = des;
        this.ticketIds = ticketIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(Set<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}

