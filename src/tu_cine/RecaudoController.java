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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jesús Lozano
 */
public class RecaudoController implements Initializable {
    static int recaudoc = 0;
    static int recaudocc =0;
    @FXML 
    Label recaudo_tick, recaudo_combo;
    public void back(ActionEvent e) throws IOException {
        Parent ticket_page_parent = FXMLLoader.load(getClass().getResource("FXMLHome_page.fxml"));
        Scene tickets_scene = new Scene(ticket_page_parent);
        Stage ap_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        ap_stage.hide(); //optional
        ap_stage.setScene(tickets_scene);
        ap_stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TicketsController.tiquetes.mostrar();
        recaudo_tick.setText("$"+String.valueOf(recaudoc));
        recaudo_combo.setText("$"+String.valueOf(recaudocc));
    }    
    
}
