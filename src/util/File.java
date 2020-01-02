/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author meimarcel
 */
public class File {
    public static List<String> Read(String path){
        try {
            FileReader file = new FileReader(path);
            BufferedReader arq = new BufferedReader(file);
            try {
                List<String> code = arq.lines().collect(Collectors.toList());
                arq.close();
                return code;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return null;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return null;
        }
    }
    
}
