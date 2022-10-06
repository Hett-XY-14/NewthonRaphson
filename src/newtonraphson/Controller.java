/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newtonraphson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;
import newtonraphson.ui.UserInterface;

/**
 *
 * @author Hoeco
 */
public class Controller implements ActionListener{
    public UserInterface userInterface;
    int[] equationCoefficients;
    NewtonRaphsonMethod newtonRaphson;
    double error;
    static double startPoint = 1.0;
    
    public Controller(int degree) {
        userInterface = new UserInterface("Newton Raphson", degree);
        userInterface.setActionListener(this);
    }
    
    public Controller() {
        int degree = Integer.parseInt(JOptionPane.showInputDialog("Cuál es el máximo grado de la ecuación de la que se busca obtener sus raíces? : "));
        error = Double.parseDouble(JOptionPane.showInputDialog("Cuál es el error tolerado? (ej. 0.001): "));
        userInterface = new UserInterface("Newton Raphson", degree);
        userInterface.setActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        if (arg0.getActionCommand().equals("Submit")) {
            handleSubmission();
        }
        if (arg0.getActionCommand().equals("Back")) {
            handleAppRestart();
        }
    }
    
    public void handleSubmission() {
        getEquationCoefficients();
        newtonRaphson = new NewtonRaphsonMethod(this.equationCoefficients, this.startPoint, this.error);
        double root = newtonRaphson.findRoot();
        userInterface.generateResultsSection(root);
    }
    
    public void handleAppRestart() {
        userInterface.dispose();
        int degree = Integer.parseInt(JOptionPane.showInputDialog("Cuál es el máximo grado de la ecuación de la que se busca obtener sus raíces? : "));
        error = Double.parseDouble(JOptionPane.showInputDialog("Cuál es el error tolerado? (ej. 0.001): "));
        userInterface = new UserInterface("Newton Raphson", degree);
        userInterface.setActionListener(this);
    }
    
    public void getEquationCoefficients() {
        equationCoefficients = userInterface.getEquationCoefficients();        
    }
}
