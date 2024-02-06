package dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserTm {
    private String name;
    private String mail;
    private String password;
    JFXButton btn;

    public UserTm() {
    }

    public UserTm(String mail,String name,String password ,JFXButton btn) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.btn = btn;
    }

    public UserTm(String name, String mail, String password) {
        this.mail = mail;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
    }
}
