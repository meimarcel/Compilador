/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import automatos.Lexico2;
import automatos.Sintatico;
import java.util.List;
import util.Classe;
import util.File;
import util.Token;

/**
 *
 * @author meimarcel
 */
public class Main {
    public static void main(String[] args) {
        String path = "src/codes/code4.txt";
        List<String> code = File.Read(path);
        Token token;
        
        /*while((token = Lexico2.getTokens(code)) != null) {
            if(token.getClasse().equals(Classe.INVALIDO)) {
                System.out.println("Error Token inválido : "+token.getToken());
                break;
            } else {
                System.out.println(token.getClasse()+" : "+token.getToken());
            } 
        }*/
        Sintatico.setCode(code);
        String status = Sintatico.sintatico();
        System.out.println(status);
        System.out.println(Sintatico.getToken().getToken());
    }
}
