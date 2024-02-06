package dto.tm;

import com.jfoenix.controls.JFXButton;


public class AuserTm {
    private  String mail;
    private String name;
    private String password;
    private JFXButton btn;

    public AuserTm() {
    }

    public AuserTm(String mail, String name, String password,JFXButton btn) {
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.btn = btn;
    }

    public JFXButton getBtn() {
        return btn;
    }

    public void setBtn(JFXButton btn) {
        this.btn = btn;
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
