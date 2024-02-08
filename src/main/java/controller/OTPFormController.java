
package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.mail.Session;

public class OTPFormController {

    @FXML
    private JFXTextField txtOtp;

    String otp;
    private static final String OTP_CHARACTERS = "0123456789";

    public void initialize(){
        sendEmail();
    }

    public static String generateOTP(int length) {

        StringBuilder otp = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(OTP_CHARACTERS.length());
            otp.append(OTP_CHARACTERS.charAt(index));
        }

        return otp.toString();
    }
    public  void sendEmail() {
        String mail = UserRoleContext.getEmail();
         otp = generateOTP(6);
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(10);
        // Setup mail properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");



        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(" dilshanduminducr@gmail.com", "zlxvuedfbvpfvmmx"); // Replace with your email credentials
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dilshanduminducr@gmail.com ")); // Replace with your email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("E-shop System OTP");
            message.setText(otp+"\n dont share it with anyone. OTP will expire in 10 minutes");

            Transport.send(message);
            System.out.println("Email sent to: " +mail);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void confirmBtnOnAction(ActionEvent actionEvent) {
        if(otp.equals(txtOtp.getText())){
            try {
                Stage stage = (Stage) txtOtp.getScene().getWindow();

                Parent root =  FXMLLoader.load(getClass().getResource("/view/ResetPasswordForm.fxml"));
                Scene scene = new Scene(root);
                if (scene != null) {

                    scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                    stage.setScene(scene);
                    stage.setTitle("User Dashboard");
                    stage.show();
                } else {
                    System.err.println("Error: Scene is null");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}