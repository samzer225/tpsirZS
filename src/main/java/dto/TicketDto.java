package dto;

import java.util.Date;
import java.util.Set;

public class TicketDto {
    private Long idTicket;
    private String sujet;
    private String description;
    private Date dateCreationTicket;
    private String statut;
    private Long tagId;
    private Long userId;
    private Set<Long> userSTIds;
    private Set<Long> commentaireIds;

    public TicketDto(Long idTicket, String sujet, String description, Date dateCreationTicket, String statut, Long tagId, Long userId, Set<Long> userSTIds, Set<Long> commentaireIds) {
        this.idTicket = idTicket;
        this.sujet = sujet;
        this.description = description;
        this.dateCreationTicket = dateCreationTicket;
        this.statut = statut;
        this.tagId = tagId;
        this.userId = userId;
        this.userSTIds = userSTIds;
        this.commentaireIds = commentaireIds;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
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

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getUserSTIds() {
        return userSTIds;
    }

    public void setUserSTIds(Set<Long> userSTIds) {
        this.userSTIds = userSTIds;
    }

    public Set<Long> getCommentaireIds() {
        return commentaireIds;
    }

    public void setCommentaireIds(Set<Long> commentaireIds) {
        this.commentaireIds = commentaireIds;
    }
}
