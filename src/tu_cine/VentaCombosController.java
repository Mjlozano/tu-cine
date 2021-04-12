/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tu_cine;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jesusl
 */
public class VentaCombosController implements Initializable {
    

    
    public void back(ActionEvent e) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLHome_page.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    public void comprar1(ActionEvent e){
        RecaudoController.recaudocc =RecaudoController.recaudocc+27500;
    }
    public void comprar2(ActionEvent e){
       RecaudoController.recaudocc =RecaudoController.recaudocc+29500;
    }
    public void comprar3(ActionEvent e){
       RecaudoController.recaudocc =RecaudoController.recaudocc+19500;
    }
    public void comprar4(ActionEvent e){
       RecaudoController.recaudocc =RecaudoController.recaudocc+15000;
    }
    public void comprar5(ActionEvent e){
       RecaudoController.recaudocc =RecaudoController.recaudocc+16500;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
