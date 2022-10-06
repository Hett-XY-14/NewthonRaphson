/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newtonraphson.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import newtonraphson.Controller;

/**
 *
 * @author Hoeco
 */
public class UserInterface extends JFrame{
    public JPanel mainWindow;
    public JPanel header;
    public JPanel body;
    public JPanel inputSection;
    public JPanel buttonsSection;
    
    public JLabel title;
    public ClockPanel clock;                                                                                                                                                ;
    
    public JLabel instruction;
    public JTextField[] equationCoefficientsInput;
    public JButton submitEquation;
    public JButton back;
    
    public UserInterface(String title, int degree) {
        
        initialize(title, degree);
    }
    
    public void initialize(String title, int degree) {
        initializeHeader(title);
        initializeBody(degree);
        initializeMainWindow();
        this.add(mainWindow);
        this.setVisible(true);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initializeMainWindow() {
        mainWindow = new JPanel(new BorderLayout());
        mainWindow.add(header, BorderLayout.NORTH);
        mainWindow.add(body, BorderLayout.CENTER);
    }
    
    public void initializeBody(int degree) {
        body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.PAGE_AXIS));
        
        inputSection = new JPanel();
        buttonsSection = new JPanel(new FlowLayout());
        instruction = new JLabel("Inserta tu ecuación:");
        equationCoefficientsInput = new JTextField[degree + 1];
        submitEquation = new JButton("Submit");
        back = new JButton("Back");
        
        body.add(instruction);
        generateInputSection(degree);
        body.add(inputSection);
        body.add(buttonsSection);
        
    }
    public void initializeHeader(String title) {
        header = new JPanel(new FlowLayout());
        this.title = new JLabel(title);
        this.clock = new ClockPanel();
        header.add(this.title);
        header.add(this.clock);
    }
    
    private void generateInputSection(int degree) {
        // adding the JTextFields to the inputSection panel
        for(int i=0; i<degree+1; i++) {
            equationCoefficientsInput[i] = new JTextField();
            inputSection.add(equationCoefficientsInput[i]);
            equationCoefficientsInput[i].setColumns(3);
            inputSection.add(new JLabel("x^" + (degree-i)));
        }
        // adding the Sumbit and Back buttons to the buttonsSection panel
        buttonsSection.add(submitEquation);
        buttonsSection.add(back);
    }
    
    public int[] getEquationCoefficients() {
        int[] equationCoefficients = new int[equationCoefficientsInput.length];
        for (int i=0; i<equationCoefficientsInput.length; i+=1) {
            equationCoefficients[i] = Integer.parseInt(equationCoefficientsInput[i].getText());
            System.out.println(Integer.parseInt(equationCoefficientsInput[i].getText()));
        }
        return equationCoefficients;
    }

    public void setActionListener(ActionListener listener) {
        submitEquation.addActionListener(listener);
        back.addActionListener(listener);
    }
}
