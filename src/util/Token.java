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
    private int linha;
    private String token;
    
    public Token() {
        
    }

    public Token(Classe classe, String token, int linha) {
        this.classe = classe;
        this.token = token;
        this.linha  = linha;
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
    
    public int getLinha() {
        return this.linha;
    }
    
    public void setLinha(int linha) {
        this.linha = linha;
    }
    
    
}
