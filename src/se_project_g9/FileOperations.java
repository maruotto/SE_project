/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author luigi
 */
public class FileOperations {
    
    public static void writeIn(File filename,HashMap<String,UDOperation> map) throws IOException{
        
        try(ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
                
            writer.writeObject(map);
                
                
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
                
    }
    
    public static HashMap<String,UDOperation> loadFrom(File filename) throws FileNotFoundException{
          
        HashMap<String,UDOperation> m = null;
       
        try(ObjectInputStream reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            
            m = (HashMap<String,UDOperation>) reader.readObject();
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
            
        
        return m;
        
        
    }
        
        
        
        
        
        
        
        
        
        
      
        
        
           
    
    
    
    
    
    
    
}
