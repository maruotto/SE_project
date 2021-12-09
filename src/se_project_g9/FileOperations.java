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
import java.io.PrintWriter;
import java.util.Scanner;
import se_project_g9.exceptions.InputNumberException;

/**
 *
 * @author luigi
 */
public class FileOperations {

    public static void writeIn(File filename, UDAllOp map) throws IOException {

        try ( PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (String key : map.keySet()) {
                writer.print(key + " : " + map.get(key).toString() + '\n');
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        /*try(ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))){
                
            writer.writeObject(map);
                
                
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }*/
    }

    public static void loadFrom(File filename, Operation ope) throws FileNotFoundException {

        String key;

        try ( Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitted = line.split(" : ");
                key = splitted[0];
                try {
                    ope.addUDOperation(key, splitted[splitted.length - 1]);
                } catch (InputNumberException ex) {
                    System.out.println("operation " + key + " already exists");
                }
            }
        }

        /*try(ObjectInputStream reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            
            m = (UDAllOp) reader.readObject();
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }*/
    }

}
