/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.invoicesgenerator;

import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author bruce
 */
public class filemodifier {

    // TODO: Read from excel file
    // TODO: write to pdf
    // For Generating pdf file
    PdfWriter pdf_file;
    private String file_name;
    
    //For reading Excel 
    private String Excel_file_name;
    FileInputStream fis;
    HSSFWorkbook wb ;
    HSSFSheet sheet;
    FormulaEvaluator formulaevaulator;

    public void fileGenerate() {
        // TODO: change the name of the file generated
        file_name = "Inovice.pdf";
        try {
            pdf_file = new PdfWriter(file_name);
            System.out.println(file_name + " has been generated");
        } catch (FileNotFoundException fe) {
            System.err.println("Invoices are not able to be generated");
        }
    }

    public void readFile() {
        
        Excel_file_name = "datasource.xlsx";
        
        try{
           fis = new FileInputStream(Excel_file_name);
           System.out.println("Reading " + Excel_file_name + ".....");
           
           sheet = wb.getSheetAt(0);
           formulaevaulator = wb.getCreationHelper().createFormulaEvaluator();
           
           for (Row row :sheet){
               for(Cell cell:row){
                   switch(formulaevaulator.evaluateInCell(cell).getCellType()){
                       case Cell.CELL_TYPE_NUMERIC:
                           System.out.print(cell.getNumericCellValue()+"\t\t");
                           break;
                       case Cell.CELL_TYPE_STRING:
                           System.out.print(cell.getStringCellValue()+"\t\t");
                           break;
           }
           }
               System.out.println();
           }
           
        }catch(Exception E){
            System.err.println("File can not be found");
        }
                
    }

}
