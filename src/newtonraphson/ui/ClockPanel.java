/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newtonraphson.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author 
 */
public class ClockPanel extends JPanel implements ActionListener{
    JLabel timeLabel;
    SimpleDateFormat timeFormat;
    Calendar calendar;
    String time;
    Timer tick;
    
    
    public ClockPanel() {
        timeFormat = new SimpleDateFormat(" HH : mm : ss ");
        this.timeLabel = new JLabel();
       
        this.timeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        this.timeLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        this.timeLabel.setForeground(Color.WHITE);
        this.setOpaque(false);
        this.add(timeLabel);
        //this.setBackground(Color.black);
        
        this.tick = new Timer(1000, this);
        tick.start();
        
    }

    public void setLetterColor(Color color) {
        this.timeLabel.setForeground(color);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
    }
}
