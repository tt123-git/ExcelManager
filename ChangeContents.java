package com.example;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
//import javax.swing.JButton;
//import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.example.AbstractClasses.Category;
import com.example.AbstractClasses.Days;
import com.example.AbstractClasses.Month;
import com.example.AbstractClasses.Place;
import com.example.SelectExcelClasses.SelectExcelChange;

//import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;

public class ChangeContents extends SelectExcelChange implements Month, Category, Days, Place{

  /*public String sheetName = "sigyou辰海";//これらの変数をGUIからの入力や効率の良い方法で変更できるようにする。
  public int rowNum = 1;
  public int colmNum = 12;
  public String data = "";*/
  JPanel panel = new JPanel();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();
  JPanel panel5 = new JPanel();
  JPanel panel6 = new JPanel();


  JLabel label = new JLabel("数量変更");
  JLabel label1 = new JLabel("変更する月");
  JLabel label2 = new JLabel("変更する日");
  JLabel label3 = new JLabel("変更する品目");
  JLabel label4 = new JLabel("変更する場所");

  JButton button;
  JButton button1;
  

  ChangeContents(){
    super();
    panel.setBounds(200,20,350,50);
    panel1.setBounds(0,200,150,50);
    panel2.setBounds(200,200,150,50);
    panel3.setBounds(0,200,350,50);
    panel4.setBounds(200,200,350,50);
    panel5.setBounds(150,350,150,50);
    panel6.setBounds(450,350,150,50);

    label.setFont(new Font(null, Font.BOLD,25));
    label.setBounds(0,50,200,50);
    label1.setFont(new Font(null, Font.PLAIN,15));
    label1.setBounds(100,50,100,25);
    label2.setFont(new Font(null, Font.PLAIN,15));
    label2.setBounds(100,50,100,25);
    label3.setFont(new Font(null, Font.PLAIN,15));
    label3.setBounds(100,50,200,25);
    label4.setFont(new Font(null, Font.PLAIN,15));
    label4.setBounds(100,50,200,25);

    button = new JButton("ホームに戻る");
    button.setBounds(0,0,200,25);

    button1 = new JButton("決定");
    button1.setBounds(0,0,200,25);

    button.addActionListener(this);
    button1.addActionListener(this);
    

    this.add(panel);
    this.add(panel1);
    this.add(panel2);
    this.add(panel3);
    this.add(panel4);
    this.add(panel5);
    this.add(panel6);
    
    
    panel.add(label);
    panel1.add(label1);
    month();
    panel2.add(label2);
    days();
    panel3.add(label3);
    category();
    panel4.add(label4);
    place();
    panel5.add(button);
    panel6.add(button1);
    
  }

  public void month(){

    JComboBox monthBox = new JComboBox(monthList);//このメソッド内でComboBoxを作って実装したい。
    panel1.setBounds(0,175,350,30);
    panel1.add(monthBox);

  }

  public void days(){

    JComboBox daysBox = new JComboBox(daysList);//このメソッド内でComboBoxを作って実装したい。
    panel2.setBounds(350,175,350,30);
    panel2.add(daysBox);
  }

  public void category(){
    JComboBox categoryBox = new JComboBox(categoryList);
    panel3.setBounds(0,250,350,30);
    panel3.add(categoryBox);
  }

  public void place(){

    JComboBox placeBox = new JComboBox(placeList);
    panel4.setBounds(350,250,350,30);
    panel4.add(placeBox);
  }

  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == button){
      this.dispose();//Delete this window
      new MainMenu();
    }
    else if(e.getSource() == button1){
      System.out.println("決定");//決定を押すとexcelの変更したい情報がsetterで変更されるクラスを呼ぶ。確認ウィンドウも作る
    }
    else if(e.getSource() == selectButton){
      JFileChooser fileChooser = new JFileChooser();

      int response = fileChooser.showOpenDialog(null);//select file open

      if(response == JFileChooser.APPROVE_OPTION){
        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());//Get absolute path
        String pathStr = file + "";
        textField.setText(pathStr);

      }
      System.out.println("選択");
    }
    
  
  } 

  
}

