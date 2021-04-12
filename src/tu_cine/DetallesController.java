/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JESÚS LOZANO
 */
public class DetallesController implements Initializable {

    @FXML
    private Label titulo_label, estreno_label, clasificacion_label, sinopsis_label, director_label, genero_label;
    @FXML
    ImageView poster;
    static int pos;
    Image pelicula1 = new Image(getClass().getResource("Imagenes/peliculas/avengers.jpg").toExternalForm());
    Image pelicula2 = new Image(getClass().getResource("Imagenes/peliculas/deadpool.jpg").toExternalForm());
    Image pelicula3 = new Image(getClass().getResource("Imagenes/peliculas/antman.jpg").toExternalForm());

    public void back(ActionEvent e) throws IOException {
        Parent ticket_page_parent = FXMLLoader.load(getClass().getResource("FXMLCartelera.fxml"));
        Scene tickets_scene = new Scene(ticket_page_parent);
        Stage ap_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        ap_stage.hide(); //optional
        ap_stage.setScene(tickets_scene);
        ap_stage.show();
    }
   
    public void setDetalles(int index){
        if(index==0){
            poster.setImage(pelicula1);
        }else if(index == 1){
            poster.setImage(pelicula2);
        } else if(index == 2){
            poster.setImage(pelicula3);
        }
        titulo_label.setText(FXMLCarteleraController.peliculas.get(index).getNombre());
        estreno_label.setText(FXMLCarteleraController.peliculas.get(index).getFechaEstreno());
        clasificacion_label.setText(FXMLCarteleraController.peliculas.get(index).getClasificacion());
        sinopsis_label.setText(FXMLCarteleraController.peliculas.get(index).getSinopsis());
        director_label.setText(FXMLCarteleraController.peliculas.get(index).getDirector());
        genero_label.setText(FXMLCarteleraController.peliculas.get(index).getGenero());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDetalles(pos);
    }

}
