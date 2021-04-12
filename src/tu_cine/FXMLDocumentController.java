/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import com.jfoenix.controls.*;
import java.io.*;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import static tu_cine.FXMLCarteleraController.peliculas;

/**
 *
 * @author JESÚS LOZANO
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField txtnombre, txtapellidos, txtemail, txtdocumento, txtusuarioID;
    @FXML
    private JFXPasswordField txtpassw, txtcontrase;
    @FXML
    private JFXComboBox<String> tdoc, tusuario;
    @FXML
    private JFXDatePicker bornDatetxt;

    
    @FXML
    private void logIn(ActionEvent e) throws IOException {
        if(tusuario.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("administrador")){
            if (findUser() && findPassw()){
        openWindow(e, "FXMLHome_page.fxml");
        }else{
            JOptionPane.showMessageDialog(null,"Usuario o Contraseña inconrrectos" );
            System.out.println("Usuario o Contraseña inconrrectos");
        }
        }else{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Tickets.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        }
    
        
    }

    @FXML
    private void registrar(ActionEvent ev) throws IOException {
        File f = null;
        FileWriter w;
        BufferedWriter bw;
        try {
            f = new File("InfoUsuarios.txt");
            w = new FileWriter(f, true);
            bw = new BufferedWriter(w);
            bw.write(txtnombre.getText() + " | " + txtapellidos.getText() + " | " + txtemail.getText() + " | " + tdoc.getSelectionModel().getSelectedItem()+ " | " +txtdocumento.getText()+ " | " +bornDatetxt.getValue().toString());
            bw.newLine();
            bw.write("--------------------------------------------------------------------------------------------------------");
            bw.newLine();
            bw.close();
            SendMail(creaNombreUsuario());
            idUsuarios();
            passwords();
            cleanRegistro();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error! " + e);
        }
    }

    @FXML
    public void openWindow(ActionEvent e, String file) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource(file));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void cleanRegistro() {
        txtnombre.setText("");
        txtapellidos.setText("");
        txtemail.setText("");
        txtdocumento.setText("");
        txtpassw.setText("");
    }

    private String creaNombreUsuario() {
        String usuario;
        String[] mail = txtemail.getText().split("@");
        usuario = mail[0];
        return usuario;
    }

    private void idUsuarios() {
        File f = null;
        FileWriter w;
        BufferedWriter bw;
        try {
            f = new File("IDusuarios.txt");
            w = new FileWriter(f, true);
            bw = new BufferedWriter(w);
            bw.write(creaNombreUsuario());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error! " + e);
        }
    }

    private void passwords() {
        File f = null;
        FileWriter w;
        BufferedWriter bw;
        try {
            f = new File("contraseñas.txt");
            w = new FileWriter(f, true);
            bw = new BufferedWriter(w);
            bw.write(txtpassw.getText());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha habido un error! " + e);
        }
    }
    
    private boolean findUser() {
        boolean exist= false;
        try {
            final BufferedReader reader = new BufferedReader(new FileReader("IDusuarios.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.indexOf(txtusuarioID.getText()) != -1) {
                    exist = true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exist;
    }
    
    private boolean findPassw(){
        boolean existe= false;
        try {
            final BufferedReader reader = new BufferedReader(new FileReader("contraseñas.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.indexOf(txtcontrase.getText()) != -1) {
                    existe = true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return existe;
    }
    
    public void SendMail(String nuser) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("tucine18@gmail.com", "tucine2018");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("tucine18@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(txtemail.getText()));
            message.setSubject("Bienvenido a TU CINE!");
            message.setText("Desde TU CINE te damos la bienvenida, gracias por utilizar nuestros servicios\nTu nombre de usuario es: "+nuser);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tdoc.getItems().add("Cedula de Ciudadania");
        tdoc.getItems().add("Tarjeta de Identidad");
        tusuario.getItems().add("Administrador");
        tusuario.getItems().add("Usuario");
        
        
        peliculas.add(0,new Pelicula("None","None","None","None","None","None","None"));
        peliculas.add(1,new Pelicula("None","None","None","None","None","None","None"));
        peliculas.add(2,new Pelicula("None","None","None","None","None","None","None"));
        TicketsController.llenarMatriz();
    }    
    
}
