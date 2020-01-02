/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author meimarcel
 */
public class Token {
    private Classe classe;
    private String token;
    
    public Token() {
        
    }

    public Token(Classe classe, String token) {
        this.classe = classe;
        this.token = token;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
