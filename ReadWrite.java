package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWrite {

  //public static String sheetName = "sigyou辰海";//これらの変数をGUIからの入力や効率の良い方法で変更できるようにする。
  //public static int rowNum = 1;
  //public static int colmNum = 12;
  //public String data = "";

  public static void main(String[] args){
    ReadWrite obj = new ReadWrite();
    String str = obj.readExcel("sigyou辰海", 12, 0);
    System.out.println(str);

    obj.writeExcel("sigyou辰海", 1, 1, "Hello");//Need to separete parameter w read and write
  } 

  public String readExcel(String sheetName, int rowNum, int colmNum){

    String data = "";

    try {
      FileInputStream file = new FileInputStream("C:\\Users\\Tatsumi\\OneDrive\\ドキュメント\\sigyou辰海.xlsx");
      Workbook wb = WorkbookFactory.create(file);
      Sheet sheet = wb.getSheet(sheetName);
      Row row = sheet.getRow(rowNum);//get row
      Cell cell = row.getCell(colmNum);//get column?

     if(cell.getCellType()==CellType.STRING){//日付けはstringとintが混ざっててうまくprint出来てない。

      data = cell.getStringCellValue(); 
     } 
     else if(cell.getCellType()==CellType.NUMERIC){

      data = String.valueOf(cell.getNumericCellValue());
     } 
      //data = cell.getStringCellValue();

    } catch (Exception e) {
      System.out.println("Read Exception");
      e.printStackTrace();
    }

    return data;
  }

  public void writeExcel(String sheetName, int rowNum, int colmNum, String DATA){

    try {
      FileInputStream file = new FileInputStream("C:\\Users\\Tatsumi\\OneDrive\\ドキュメント\\sigyou辰海.xlsx");
      Workbook wb = WorkbookFactory.create(file);
      Sheet sheet = wb.getSheet(sheetName);
      Row row = sheet.createRow(rowNum);//get row
      Cell cell = row.createCell(colmNum);//get column?
      cell.setCellValue(DATA);
      FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Tatsumi\\OneDrive\\ドキュメント\\sigyou辰海.xlsx");
      wb.write(fileOut);


    } catch (Exception e) {
      System.out.println("Read Exception");
      e.printStackTrace();
    }
  }
  
}
