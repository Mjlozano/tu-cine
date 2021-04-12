/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import com.jfoenix.controls.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JESÚS LOZANO
 */
public class FXMLCarteleraController implements Initializable {

    public static ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    @FXML
    public Label pelicula_label1, clasificacion_label1, genero_label1, pelicula_label3, clasificacion_label3, genero_label3;
    @FXML
    public Label pelicula_label2, clasificacion_label2, genero_label2;

    DetallesController det = new DetallesController();

    public void addMovie(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Addpelicula.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void back(ActionEvent e) throws IOException {
        Parent ticket_page_parent = FXMLLoader.load(getClass().getResource("FXMLHome_page.fxml"));
        Scene tickets_scene = new Scene(ticket_page_parent);
        Stage ap_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        ap_stage.hide(); //optional
        ap_stage.setScene(tickets_scene);
        ap_stage.show();
    }

    public void verMas(ActionEvent e, int index) throws IOException {
        Parent ticket_page_parent = FXMLLoader.load(getClass().getResource("Detalles.fxml"));
        Scene tickets_scene = new Scene(ticket_page_parent);
        Stage ap_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        ap_stage.hide(); //optional
        ap_stage.setScene(tickets_scene);
        ap_stage.show();
        DetallesController.pos = index;
    }

    public void verMas1(ActionEvent e) throws IOException {
        verMas(e, 0);
    }

    public void verMas2(ActionEvent e) throws IOException {
        verMas(e, 1);
    }

    public void verMas3(ActionEvent e) throws IOException {
        verMas(e, 2);
    }

    public void setMovie1() {
        pelicula_label1.setText(peliculas.get(0).getNombre());
        genero_label1.setText(peliculas.get(0).getGenero());
        clasificacion_label1.setText(peliculas.get(0).getClasificacion());
    }

    public void setMovie2() {
        pelicula_label2.setText(peliculas.get(1).getNombre());
        genero_label2.setText(peliculas.get(1).getGenero());
        clasificacion_label2.setText(peliculas.get(1).getClasificacion());
    }

    public void setMovie3() {
        pelicula_label3.setText(peliculas.get(2).getNombre());
        genero_label3.setText(peliculas.get(2).getGenero());
        clasificacion_label3.setText(peliculas.get(2).getClasificacion());
    }
    public void modificar(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Addpelicula.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
        AddpeliculaController.head.setText("Modificar Pelicula");
    }
    public void eliminar(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Eliminar.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setMovie1();
        setMovie2();
        setMovie3();

    }

}
