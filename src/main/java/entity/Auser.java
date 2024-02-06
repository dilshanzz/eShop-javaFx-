package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auser {
    @Id
    private  String mail;
    private String name;
    private String password;

    public Auser() {
    }

    public Auser(String mail, String name, String password) {
        this.mail = mail;
        this.name = name;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
