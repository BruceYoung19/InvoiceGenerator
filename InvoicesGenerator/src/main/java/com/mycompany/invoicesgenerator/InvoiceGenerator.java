/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.invoicesgenerator;

import java.io.IOException;

/**
 *
 * @author bruce
 */
public class InvoiceGenerator {
    public static void main(String args[]) throws IOException   
    {       
       filemodifier pdf_gen = new filemodifier();
       pdf_gen.readFile();
       pdf_gen.fileGenerate();
    }  
}
