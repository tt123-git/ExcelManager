package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.example.SelectExcelClasses.SelectExcelChange;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Frame implements ActionListener{
  
  JButton button;
  JButton button1;
  JButton button2;
  JButton button3;

  MainMenu(){
    JPanel leftPanel = new JPanel();

    leftPanel.setBackground(new Color(49,158,246));
    leftPanel.setBounds(0,0,200,500);

    button = new JButton("内容確認");
    button1 = new JButton("内容変更");
    button2 = new JButton("単価変更");
    button3 = new JButton("内容削除");

    button.setBounds(0,0,200,50);
    button1.setBounds(0,50,200,50);
    button2.setBounds(0,100,200,50);
    button3.setBounds(0,150,200,50);

    button.setBackground(new Color(51,228,255));
    button1.setBackground(new Color(51,228,255));
    button2.setBackground(new Color(51,228,255));
    button3.setBackground(new Color(51,228,255));

    button.addActionListener(this);
    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);


    //button.setBackground(Color.RED);
    //button1.setBackground(Color.BLACK);

    leftPanel.add(button);
    leftPanel.add(button1);
    leftPanel.add(button2);
    leftPanel.add(button3);

    super.baseFrame();
    leftPanel.setLayout(null);
    this.add(leftPanel);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button){
      System.out.println("内容確認");
    }
    else if(e.getSource() == button1){
      this.dispose();//Delete this window
      //new SelectExcelChange();
      new ChangeContents();
    }
    else if(e.getSource() == button2){
      System.out.println("単価変更");
    }
    else if(e.getSource() == button3){
      System.out.println("内容削除");
    }
  }

  
}
