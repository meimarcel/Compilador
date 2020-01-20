/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.regex.Pattern;
import util.Classe;
import util.Token;

/**
 *
 * @author meimarcel
 */
public class Lexico2 {
        private static int i = 0, j = 0;
    
    private final static List<String> PALAVRAS_RESERVADAS = asList("programa", "se", "entao", "senao", "enquanto", "faca", "ate", "repita",
            "inteiro", "real", "caractere", "caso", "escolha", "fimescolha", "procedimento", "funcao", "de", "para", "fimse", "inicio", "fim");
    
    private final static String LINGUAGEM = "[a-zA-Z0-9\\;\\,\\.\\+\\-\\*\\(\\)\\<\\>\\:\\=\\{\\}\\/\\@\\s]";
    private final static Pattern PATTERN = Pattern.compile(LINGUAGEM, Pattern.CASE_INSENSITIVE);
    
    public static Token getTokens(List<String> code) {
        String token = "";
        boolean end = false;
        boolean automato1 = true;
        boolean automato2 = true;
        boolean automato3 = true;
        int state = 0;
        for(; j < code.size(); j++) {
            String line = code.get(j);
            line += "\n";
            String chars[] = line.split("");
            for(; i < chars.length; i++) {
                if(automato1) {
                    switch(state) {
                         case 0:
                                switch(chars[i]) {
                                    case "a" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "b" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "c" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "d" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "e" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "f" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "g" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "h" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "i" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "j" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "k" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "l" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "m" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "n" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "o" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "p" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "q" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "r" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "s" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "t" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "u" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "v" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "w" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "x" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "y" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "z" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "A" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "B" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "C" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "D" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "E" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "F" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "G" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "H" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "I" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "J" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "K" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "L" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "M" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "N" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "O" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "P" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "Q" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "R" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "S" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "T" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "U" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "V" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "W" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "X" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "Y" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    case "Z" : state = 1; automato1 = true; automato2 = false; automato3 = false; break;
                                    default: end = true; break;
                                };
                                break;
                            case 1 :
                                switch(chars[i]) {
                                    case "a" : state = 1; break;
                                    case "b" : state = 1; break;
                                    case "c" : state = 1; break;
                                    case "d" : state = 1; break;
                                    case "e" : state = 1; break;
                                    case "f" : state = 1; break;
                                    case "g" : state = 1; break;
                                    case "h" : state = 1; break;
                                    case "i" : state = 1; break;
                                    case "j" : state = 1; break;
                                    case "k" : state = 1; break;
                                    case "l" : state = 1; break;
                                    case "m" : state = 1; break;
                                    case "n" : state = 1; break;
                                    case "o" : state = 1; break;
                                    case "p" : state = 1; break;
                                    case "q" : state = 1; break;
                                    case "r" : state = 1; break;
                                    case "s" : state = 1; break;
                                    case "t" : state = 1; break;
                                    case "u" : state = 1; break;
                                    case "v" : state = 1; break;
                                    case "w" : state = 1; break;
                                    case "x" : state = 1; break;
                                    case "y" : state = 1; break;
                                    case "z" : state = 1; break;
                                    case "A" : state = 1; break;
                                    case "B" : state = 1; break;
                                    case "C" : state = 1; break;
                                    case "D" : state = 1; break;
                                    case "E" : state = 1; break;
                                    case "F" : state = 1; break;
                                    case "G" : state = 1; break;
                                    case "H" : state = 1; break;
                                    case "I" : state = 1; break;
                                    case "J" : state = 1; break;
                                    case "K" : state = 1; break;
                                    case "L" : state = 1; break;
                                    case "M" : state = 1; break;
                                    case "N" : state = 1; break;
                                    case "O" : state = 1; break;
                                    case "P" : state = 1; break;
                                    case "Q" : state = 1; break;
                                    case "R" : state = 1; break;
                                    case "S" : state = 1; break;
                                    case "T" : state = 1; break;
                                    case "U" : state = 1; break;
                                    case "V" : state = 1; break;
                                    case "W" : state = 1; break;
                                    case "X" : state = 1; break;
                                    case "Y" : state = 1; break;
                                    case "Z" : state = 1; break;
                                    case "0" : state = 1; break;
                                    case "1" : state = 1; break;
                                    case "2" : state = 1; break;
                                    case "3" : state = 1; break;
                                    case "4" : state = 1; break;
                                    case "5" : state = 1; break;
                                    case "6" : state = 1; break;
                                    case "7" : state = 1; break;
                                    case "8" : state = 1; break;
                                    case "9" : state = 1; break;
                                    case "_" : state = 2; break;
                                    default: end = true; break;
                                };
                                break;
                            case 2:
                                switch(chars[i]) {
                                    case "a" : state = 1; break;
                                    case "b" : state = 1; break;
                                    case "c" : state = 1; break;
                                    case "d" : state = 1; break;
                                    case "e" : state = 1; break;
                                    case "f" : state = 1; break;
                                    case "g" : state = 1; break;
                                    case "h" : state = 1; break;
                                    case "i" : state = 1; break;
                                    case "j" : state = 1; break;
                                    case "k" : state = 1; break;
                                    case "l" : state = 1; break;
                                    case "m" : state = 1; break;
                                    case "n" : state = 1; break;
                                    case "o" : state = 1; break;
                                    case "p" : state = 1; break;
                                    case "q" : state = 1; break;
                                    case "r" : state = 1; break;
                                    case "s" : state = 1; break;
                                    case "t" : state = 1; break;
                                    case "u" : state = 1; break;
                                    case "v" : state = 1; break;
                                    case "w" : state = 1; break;
                                    case "x" : state = 1; break;
                                    case "y" : state = 1; break;
                                    case "z" : state = 1; break;
                                    case "A" : state = 1; break;
                                    case "B" : state = 1; break;
                                    case "C" : state = 1; break;
                                    case "D" : state = 1; break;
                                    case "E" : state = 1; break;
                                    case "F" : state = 1; break;
                                    case "G" : state = 1; break;
                                    case "H" : state = 1; break;
                                    case "I" : state = 1; break;
                                    case "J" : state = 1; break;
                                    case "K" : state = 1; break;
                                    case "L" : state = 1; break;
                                    case "M" : state = 1; break;
                                    case "N" : state = 1; break;
                                    case "O" : state = 1; break;
                                    case "P" : state = 1; break;
                                    case "Q" : state = 1; break;
                                    case "R" : state = 1; break;
                                    case "S" : state = 1; break;
                                    case "T" : state = 1; break;
                                    case "U" : state = 1; break;
                                    case "V" : state = 1; break;
                                    case "W" : state = 1; break;
                                    case "X" : state = 1; break;
                                    case "Y" : state = 1; break;
                                    case "Z" : state = 1; break;
                                    case "0" : state = 1; break;
                                    case "1" : state = 1; break;
                                    case "2" : state = 1; break;
                                    case "3" : state = 1; break;
                                    case "4" : state = 1; break;
                                    case "5" : state = 1; break;
                                    case "6" : state = 1; break;
                                    case "7" : state = 1; break;
                                    case "8" : state = 1; break;
                                    case "9" : state = 1; break;
                                    default: end = true; break;
                                }
                                break;                            
                    }
                    if(end) {
                        if(state == 1) {
                            if(PALAVRAS_RESERVADAS.indexOf(token) == -1) { 
                                return new Token(Classe.IDENTIFICADOR, token, j + 1);
                            } else {
                                return new Token(Classe.PALAVRA_RESERVADA, token, j + 1);
                            }
                        } 
                        else if(state == 2) {
                            return new Token(Classe.INVALIDO, token, j + 1);
                        }
                        state = 0;
                        token = "";
                        end = false;
                        automato2 = true;
                        automato3 = true;
                    } else {
                        token += chars[i];
                    }
                }
                
                if(automato2) {
                    switch(state) {
                        case 0:
                            switch(chars[i]) {
                                case "0" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "1" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "2" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "3" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "4" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "5" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "6" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "7" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "8" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "9" : state = 1; automato1 = false; automato2 = true; automato3 = false; break;
                                case "-" : state = 2; automato1 = false; automato2 = true; automato3 = false; break;
                                default : end = true; break; 
                            };
                            break;
                        case 1:
                            switch(chars[i]) {
                                case "0" : state = 1; break;
                                case "1" : state = 1; break;
                                case "2" : state = 1; break;
                                case "3" : state = 1; break;
                                case "4" : state = 1; break;
                                case "5" : state = 1; break;
                                case "6" : state = 1; break;
                                case "7" : state = 1; break;
                                case "8" : state = 1; break;
                                case "9" : state = 1; break;
                                case "," : state = 3; break;
                                default : end = true; break;
                            };
                            break;
                        case 2:
                            switch(chars[i]) {
                                case "0" : state = 1; break;
                                case "1" : state = 1; break;
                                case "2" : state = 1; break;
                                case "3" : state = 1; break;
                                case "4" : state = 1; break;
                                case "5" : state = 1; break;
                                case "6" : state = 1; break;
                                case "7" : state = 1; break;
                                case "8" : state = 1; break;
                                case "9" : state = 1; break;
                                case "-" : state = 5; end = true; break;
                                default : end = true; break;
                            };
                            break;
                        case 3:
                            switch(chars[i]) {
                                case "0" : state = 4; break;
                                case "1" : state = 4; break;
                                case "2" : state = 4; break;
                                case "3" : state = 4; break;
                                case "4" : state = 4; break;
                                case "5" : state = 4; break;
                                case "6" : state = 4; break;
                                case "7" : state = 4; break;
                                case "8" : state = 4; break;
                                case "9" : state = 4; break;
                                default : end = true; break;
                            };
                            break;
                        case 4:
                            switch(chars[i]) {
                                case "0" : state = 4; break;
                                case "1" : state = 4; break;
                                case "2" : state = 4; break;
                                case "3" : state = 4; break;
                                case "4" : state = 4; break;
                                case "5" : state = 4; break;
                                case "6" : state = 4; break;
                                case "7" : state = 4; break;
                                case "8" : state = 4; break;
                                case "9" : state = 4; break;
                                default : end = true; break;
                            };
                            break;
                    }
                    if(end) {
                        if(state == 1 || state == 4) {
                            return new Token(Classe.DIGITO, token, j + 1);
                        }
                        else if(state == 3) {
                            return new Token(Classe.INVALIDO, token, j + 1);
                        }
                        else if(state == 2) {
                            return new Token(Classe.SIMBOLO_ESPECIAL, token, j + 1);
                        }
                        else if(state == 5) {
                            token += chars[i];
                            ++i;
                            return new Token(Classe.SIMBOLO_ESPECIAL, token, j + 1);
                        }
                        token = "";
                        state = 0;
                        end = false;
                        automato1 = true;
                        automato3 = true;
                    } else {
                        token += chars[i];
                    }
                }
                if(automato3) {
                    switch(state) {
                        case 0 :
                            switch(chars[i]) {
                                case ";" : state = 1; end = true; break;
                                case "," : state = 1; end = true; break;
                                case "." : state = 1; end = true; break;
                                case "*" : state = 1; end = true; break;
                                case "(" : state = 1; end = true; break;
                                case ")" : state = 1; end = true; break;
                                case "{" : state = 1; end = true; break;
                                case "}" : state = 1; end = true; break;
                                case "=" : state = 1; end = true; break;
                                case ":" : state = 2; automato1 = false; automato2 = false; automato3 = true; break;
                                case ">" : state = 2; automato1 = false; automato2 = false; automato3 = true; break;
                                case "<" : state = 3; automato1 = false; automato2 = false; automato3 = true; break;
                                case "+" : state = 4; automato1 = false; automato2 = false; automato3 = true; break;
                                case "@" : state = 6; automato1 = false; automato2 = false; automato3 = true; break;
                                case "/" : state = 12; automato1 = false; automato2 = false; automato3 = true; break;
                                default : end = true; break;
                            };
                            break;
                        case 2 :
                            switch(chars[i]) {
                                case "=" : state = 1; end = true; break;
                                default : end = true; break;
                            };
                            break;
                        case 3 :
                            switch(chars[i]) {
                                case ">" : state = 1; end = true; break;
                                case "=" : state = 1; end = true; break;
                                default : end = true; break;
                            };
                            break;
                        case 4 :
                            switch(chars[i]) {
                                case "+" : state = 1; end = true; break;
                                default : end = true; break;
                            };
                            break;
                        case 6 :
                            switch(chars[i]) {
                                case "@" : state = 7; break;
                                case "/" : state = 9; break;
                                default : end = true; break;
                            };
                            break;
                        case 7 :
                            switch(chars[i]) {
                                case "\n" : state = 8; end = true; break;
                                default : state = 7; break;
                            };
                            break;
                        case 9 :
                            switch(chars[i]) {
                                case "/" : state = 10; break;
                                default : state = 9; break;
                            };
                            break;
                        case 10 :
                            switch(chars[i]) {
                                case "/" : state = 10; break;
                                case "@" : state = 11; end = true; break;
                                default : state = 9; break;
                            };
                            break;
                        case 12 :
                            switch(chars[i]) {
                                case "/" : state = 13; break;
                                default : end = true; break;
                            };
                            break;
                        case 13 :
                            switch(chars[i]) {
                                case "/" : state = 14; break;
                                default : state = 13; break;
                            };
                            break;
                        case 14 :
                            switch(chars[i]) {
                                case "/" : state = 15; end = true; break;
                                default : state = 13; break;
                            };
                            break;
                    }
                    
                    if(end) {
                        if(state == 1) {
                            token += chars[i];
                            ++i;
                            return new Token(Classe.SIMBOLO_ESPECIAL, token, j + 1);
                        }
                        else if(state == 2 || state == 3 || state == 4 || state == 6 || state == 12) {
                            return new Token(Classe.SIMBOLO_ESPECIAL, token, j + 1);
                        }
                        token = "";
                        state = 0;
                        end = false;
                        automato1 = true;
                        automato2 = true;
                    } else {
                        if(state != 7 || state != 9 || state != 13) {
                            token += chars[i];
                        }
                    }
                }
                
                if(!chars[i].equals("\n") && automato1 && automato2 && automato3 && !PATTERN.matcher(chars[i]).matches()) {
                    String aux = chars[i];
                    i++;
                    return new Token(Classe.INVALIDO, aux, j + 1);
                }
            }
            i = 0;
        }
        if((state == 13 || state == 14 || state == 9 || state == 10) && automato3) {
            return new Token(Classe.INVALIDO,"Comentário não fechado", j + 1);
        }
        return new Token(Classe.FIM_LEITURA,"", j + 1);
    }
    
}
