/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_1.cpp;

import java.math.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author User
 */

public class Counter implements Runnable {
    public double x;
    public double eps;
    public Label label;

    public boolean stop;

    @Override
    public void run()
    {
        Platform.runLater(new Runnable() {
            @Override
            public void run()
            {
                double S = 0;
                int n = 0;
                double a = 1;
                S = a;
                while(Math.abs(a) > eps)
                {
                    if(stop)
                    {
                        label.setText(String.valueOf(S));
                        return;
                    }
                    n++;
                    double R = Math.pow((x - 1.0), n) / (n * Math.pow(x, n));
                    a *= R;
                    S += a;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Counter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    label.setText(String.valueOf(S));
                }
            }
        });
    }
}