/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import com.jfoenix.controls.*;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JESÚS LOZANO
 */
public class AddpeliculaController implements Initializable {

    @FXML
    private JFXTextField nombrepeltxt, clastxt, generotxt, directortxt;
    @FXML
    private JFXTextArea sinoptxt;
    @FXML
    private JFXComboBox<String> tipopel, pos;
    @FXML
    public static Label head;
    @FXML
    private JFXDatePicker fechaestrenotxt;
    @FXML
    JFXTimePicker hora_funcion;

    static Lista funciones = new Lista();

    public void agregar(ActionEvent e) {

        if (pos.getSelectionModel().getSelectedItem().equals("1")) {
            FXMLCarteleraController.peliculas.set(0, new Pelicula(nombrepeltxt.getText(), clastxt.getText(), generotxt.getText(), sinoptxt.getText(), tipopel.getSelectionModel().getSelectedItem(), directortxt.getText(), fechaestrenotxt.getValue().toString()));
            System.out.println(FXMLCarteleraController.peliculas.get(0));

        } else if (pos.getSelectionModel().getSelectedItem().equals("2")) {
            FXMLCarteleraController.peliculas.set(1, new Pelicula(nombrepeltxt.getText(), clastxt.getText(), generotxt.getText(), sinoptxt.getText(), tipopel.getSelectionModel().getSelectedItem(), directortxt.getText(), fechaestrenotxt.getValue().toString()));
            System.out.println(FXMLCarteleraController.peliculas.get(1));

        } else if (pos.getSelectionModel().getSelectedItem().equals("3")) {
            FXMLCarteleraController.peliculas.set(2, new Pelicula(nombrepeltxt.getText(), clastxt.getText(), generotxt.getText(), sinoptxt.getText(), tipopel.getSelectionModel().getSelectedItem(), directortxt.getText(), fechaestrenotxt.getValue().toString()));
            System.out.println(FXMLCarteleraController.peliculas.get(2));

        }

    }

    public void back(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCartelera.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void addFuncion() {
        funciones.insertarf(hora_funcion.getValue().toString());
        //System.out.println(hora_funcion.getValue().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipopel.getItems().add("2D");
        tipopel.getItems().add("3D");
        tipopel.getItems().add("3D-2D");
        pos.getItems().add("1");
        pos.getItems().add("2");
        pos.getItems().add("3");
    }

}
