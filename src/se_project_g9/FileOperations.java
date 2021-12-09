/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se_project_g9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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

    /**
     *
     * @param filename the file object.
     * @param map the operations to save
     * @throws IOException 
     */
    public static void writeIn(File filename, UDAllOp map) throws IOException {

        try ( PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (String key : map.keySet()) {
                writer.print(key + " : " + map.get(key).toString() + '\n');
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param filename the file object
     * @param ope the operation class to load a command
     * @throws FileNotFoundException
     */
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
    }

}
