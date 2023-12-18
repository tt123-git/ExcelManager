package com.example;

import javax.swing.JFrame;

import com.example.MainMenu;

public class Frame extends JFrame{//This class for make new GUI class for window
//Need to add window name each classes
  
  public void baseFrame(){

    this.setSize(750, 500);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setTitle("Excel Manager");
    this.setLayout(null);
  }  
}
