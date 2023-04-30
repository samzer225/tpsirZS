package dto;


public class UserSupportTechDto {
    private Long idUser;
    private String name;
    private String pseudo;
    private String email;
    private String job;

    public UserSupportTechDto() {}
    public UserSupportTechDto(Long idUser, String name, String pseudo, String email, String job) {
        this.idUser = idUser;
        this.name = name;
        this.pseudo = pseudo;
        this.email = email;
        this.job = job;
    }

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
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }
}

