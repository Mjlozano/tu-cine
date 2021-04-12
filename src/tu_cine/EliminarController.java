/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.stage.Stage;
import static tu_cine.FXMLCarteleraController.peliculas;

public class EliminarController implements Initializable {

    @FXML
    JFXComboBox peliss;
    public void eliminar(ActionEvent e){
        peliculas.set(peliss.getSelectionModel().getSelectedIndex(), new Pelicula("None","None","None","None","None","None","None"));
    }
    
    public void back(ActionEvent e) throws IOException {
        Parent ticket_page_parent = FXMLLoader.load(getClass().getResource("FXMLCartelera.fxml"));
        Scene tickets_scene = new Scene(ticket_page_parent);
        Stage ap_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        ap_stage.hide(); //optional
        ap_stage.setScene(tickets_scene);
        ap_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        peliss.getItems().add(peliculas.get(0).getNombre());
        peliss.getItems().add(peliculas.get(1).getNombre());
        peliss.getItems().add(peliculas.get(2).getNombre());
        
    }

}
