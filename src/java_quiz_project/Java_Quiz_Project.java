/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_quiz_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author user
 */
public class Java_Quiz_Project extends JFrame implements ActionListener{
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x=1 , y=1, now=0;
    int m[]=new int[10];
    
    Java_Quiz_Project(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg=new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i]= new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30, 40, 450, 20);
        radioButtons[0].setBounds(50, 80, 450, 20);
        radioButtons[1].setBounds(50, 100, 200, 20);
        radioButtons[2].setBounds(50, 140, 200, 20);
        radioButtons[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }
    
    void setData(){
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Q1 : India won its first Olympic hockey gold in?");
            radioButtons[0].setText("1928");
            radioButtons[1].setText("1932");
            radioButtons[2].setText("1936");
            radioButtons[3].setText("1948");      
        }
        if(current==1){
            label.setText("Q2 : What is the name of the person that controls a football match?");
            radioButtons[0].setText("An umpire");
            radioButtons[1].setText("A referee");
            radioButtons[2].setText("A goalkeeper");
            radioButtons[3].setText("A spectator");      
        }
        if(current==2){
            label.setText("Q3 : You should save your computer from?");
            radioButtons[0].setText("Viruses");
            radioButtons[1].setText("Time bombs");
            radioButtons[2].setText("Worms");
            radioButtons[3].setText("All of the above");      
        }
        if(current==3){
            label.setText("Q4 : The TV is too loud. Can you turn it _____ a bit?");
            radioButtons[0].setText("off");
            radioButtons[1].setText("down");
            radioButtons[2].setText("out");
            radioButtons[3].setText("up");      
        }
        if(current==4){
            label.setText("Q5 : What program runs first after computer is booted and loading GUI?");
            radioButtons[0].setText("Desktop Manager");
            radioButtons[1].setText("Windows Explorer");
            radioButtons[2].setText("Authentication");
            radioButtons[3].setText("File Manager");      
        }
        if(current==5){
            label.setText("Q6 : Which scientist discovered the radioactive element radium?");
            radioButtons[0].setText("Isaac Newton");
            radioButtons[1].setText("Albert Einstein");
            radioButtons[2].setText("Marie Curie");
            radioButtons[3].setText("Benjamin Franklin");      
        }
        if(current==6){
            label.setText("Q7 : Who invented Gunpowder?");
            radioButtons[0].setText("Roger Bacon");
            radioButtons[1].setText("G. Ferdinand Von Zeppelin");
            radioButtons[2].setText("Sir Frank Whittle");
            radioButtons[3].setText("Leo H Baekeland");      
        }
        if(current==7){
            label.setText("Q8 : The memory which allocates space for DOS and application is called");
            radioButtons[0].setText("Expanded memory");
            radioButtons[1].setText("Cache memory");
            radioButtons[2].setText("Virtual memory");
            radioButtons[3].setText("Conventional memory");      
        }
        if(current==8){
            label.setText("Q9 : Where was the yo-yo invented?");
            radioButtons[0].setText("France");
            radioButtons[1].setText("United States");
            radioButtons[2].setText("England");
            radioButtons[3].setText("Philippines");      
        }
        if(current==9){
            label.setText("Q10 : In which Indian state did the game of Polo originate?");
            radioButtons[0].setText("Meghalaya");
            radioButtons[1].setText("Rajasthan");
            radioButtons[2].setText("Manipur");
            radioButtons[3].setText("West Bengal");      
        }
        label.setBounds(30, 40, 450, 20);
        for(int i=0,j=0; i<=90; i+=30,j++){
            radioButtons[j].setBounds(50, 80+i, 200, 20);
        }
        
        
    }
    
    boolean checkAns(){
        if(current==0){
            return (radioButtons[0].isSelected());
        }
        if(current==1){
            return (radioButtons[1].isSelected());
        }
        if(current==2){
            return (radioButtons[3].isSelected());
        }
        if(current==3){
            return (radioButtons[1].isSelected());
        }
        if(current==4){
            return (radioButtons[2].isSelected());
        }
        if(current==5){
            return (radioButtons[2].isSelected());
        }
        if(current==6){
            return (radioButtons[0].isSelected());
        }
        if(current==7){
            return (radioButtons[3].isSelected());
        }
        if(current==8){
            return (radioButtons[3].isSelected());
        }
        if(current==9){
            return (radioButtons[2].isSelected());
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        new Java_Quiz_Project("Quiz App");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnNext){
            if(checkAns())
                count=count+1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        if(ae.getActionCommand().equals("Result")){
            if(checkAns())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers are "+count);
            System.exit(0);
        }
    }
    
}
