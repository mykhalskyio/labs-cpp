/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lab2_1.cpp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MainFXMLController implements Initializable {

    @FXML
    public Label label1;
    private Counter counter;
    private Thread thread;
    public int temp;

    /**
     * Initializes the controller class.
     */
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        counter = new Counter();
        counter.x = 5;
        counter.eps = Math.pow(10, -5);
        counter.label = label1;
    }    

    @FXML
    private void checkboxClicked(ActionEvent event) {
        temp++;
        
        if (temp == 1) {
            counter.stop = false;
            thread = new Thread(counter);
            thread.start();
        }
        if (temp == 2) {
            Counter c = new Counter();
            c.x = 5;
            c.eps = Math.pow(10, -5);
            c.label = label1;
            c.stop = true; 
            temp = 0;
        }
    }
}
