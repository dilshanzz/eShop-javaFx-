package dto;

public class CustomerDto {
    private String Contact;
    private String name;
    private  String email;

    public CustomerDto() {
    }

    public CustomerDto(String contact, String email, String name) {
       this.Contact = contact;
        this.email = email;
        this.name = name;

    }

    public CustomerDto(String email, String name) {
        this.name=name;
        this.email=email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
