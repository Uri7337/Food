
package com.mycompany.food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodFrame extends JFrame {
    private JTextField[] textFields;
    private JButton button1, button2;
    private String[][] food;
    private int x = 4;
    
    public String[][] getFood(){
        
        return this.food;
    }
            
     public void setFood(String[][] s){
         this.food= s;
    }
    
    public String Data(int x,int y){
        String[][] si = getFood();
        String s = si[x][y];
        return s;
    }

    
    
    public FoodFrame(String[][] food) {
        // Set frame properties
        this.food = food;
        setTitle("Food");
        setSize(650, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create text fields
        //asi vztvorit textfields o velikosti 12
        textFields = new JTextField[13];
        textFields[1] = new JTextField("Polévka:", 6);
        textFields[7] = new JTextField(food[x][0], 50);
        textFields[2] = new JTextField("1", 6);
        textFields[8] = new JTextField(food[x][1], 50);
        textFields[3] = new JTextField("2", 6);
        textFields[9] = new JTextField(food[x][2], 50);
        textFields[4] = new JTextField("3", 6);
        textFields[10] = new JTextField(food[x][3], 50);
        textFields[5] = new JTextField("4", 6);
        textFields[11] = new JTextField(food[x][4], 50);
        textFields[6] = new JTextField("Salát:", 6);
        textFields[12] = new JTextField(food[x][5], 50);
        
        // Set text fields to read-only
        for(int i=1;i<=12;i++){
            textFields[i].setEditable(false);
        }
        // Create buttons
        button1 = new JButton("-");
        button2 = new JButton("+");

        // Add ActionListener to button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x=(x+4)%5;
                int y=0;
                for(int i=7;i<=12;i++){
                    textFields[i].setText(food[x][y]);
                    y++;
                }
                
                
            }
        });

        // Add ActionListener to button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                x=(x+1)%5;
                
                int y=0;
                for(int i=7;i<=12;i++){
                    textFields[i].setText(food[x][y]);
                    y++;
                }
            }
        });

        // Create panel and set layout
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Add components to panel
        for(int i=1;i<=12;i++){
            panel.add(textFields[i]);            
        }
        panel.add(button1);
        panel.add(button2);

        // Add panel to frame
        add(panel);
    }
}