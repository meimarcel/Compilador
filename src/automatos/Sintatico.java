/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatos;

import java.util.List;
import util.Classe;
import util.Token;


/**
 *
 * @author meimarcel
 */
public class Sintatico {
    private static Token token;
    private static List<String> code;
    
    public static void setCode(List<String> text) {
        code = text;
    }
    public static Token getToken() {
        return token;
    }
    
    
    public static String sintatico() {
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals("programa")) return "Erro: \"programa\" esperado";
        
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: identificador esperado";
        
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
        
        token = Lexico2.getTokens(code);
        String msg = bloco();         
        return (msg.equals("")? "Executado Com Sucesso!" : msg);
    }

    private static String bloco() {
        String msg = "";
        if(token.getToken().equals("tipo")) {
            msg = declara_tipo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        if(token.getToken().equals("var")) {
            msg = declara_var();
            if(!msg.equals("")) {
                return msg;
            }
        }
        while(token.getToken().equals("procedimento") || token.getToken().equals("funcao")) {
            if(token.getToken().equals("funcao")) {
                msg = declara_funcao();
                if(!msg.equals("")) {
                    return msg;
                }
            }
            else {
                msg = declara_procedimento();
                if(!msg.equals("")) {
                    return msg;
                }
            }
        }
        msg = comando_composto();
        return (msg.equals("")? "" : msg);
    }
    
    private static String declara_tipo() {
        token = Lexico2.getTokens(code);
        do {
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: Identificador esperado";
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals("=")) return "Erro: \"=\" esperado";
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: tipo esperado";
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            token = Lexico2.getTokens(code);
        } while(token.getClasse().equals(Classe.IDENTIFICADOR) && !token.getToken().equals("var"));
        return "";
    }
    
    private static String declara_var() {
        token = Lexico2.getTokens(code);
        String msg = "";
        do {
            msg = lista_identificador();
            if(!msg.equals("")) {
                return msg;
            }
            if(!token.getToken().equals(":")) return "Erro: \":\" esperado";
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: tipo esperado";
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            token = Lexico2.getTokens(code);
        } while(token.getClasse().equals(Classe.IDENTIFICADOR));
        return "";
    }
   
    private static String lista_identificador() {    
        boolean virgula = false;
        do {
            virgula = false;
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro Identificador esperado";
            token = Lexico2.getTokens(code);
            if(token.getToken().equals(",")) {virgula = true; token = Lexico2.getTokens(code);}
        } while(virgula == true);
        return "";
    }
    
    private static String declara_procedimento() {
        String msg = "";
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: Identificador esperado";
        token = Lexico2.getTokens(code);
        if(token.getToken().equals("(")) {
            msg = parametros_formais();
            if(!msg.equals("")) {
                return msg;
            }
            token = Lexico2.getTokens(code);
        }
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
        token = Lexico2.getTokens(code);
        msg = bloco();
        if (!msg.equals("")) {
            return msg;
        }
        token = Lexico2.getTokens(code);
        return "";
    }
    
    private static String declara_funcao() {
        String msg = "";
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: identificador esperado";
        token = Lexico2.getTokens(code);
        if(token.getToken().equals("(")) { 
            msg = parametros_formais();
            if(!msg.equals("")) {
                return msg;
            }
            token = Lexico2.getTokens(code);
        }
        if(!token.getToken().equals(":")) return "Erro: \":\" esperado";
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: identificador esperado"; 
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";       
        msg = bloco();
        if (!msg.equals("")) {
            return msg;
        }
        token = Lexico2.getTokens(code);
        return "";   
    } 
    
    
    
    private static String parametros_formais() {
        String msg = "";
        do {
            token = Lexico2.getTokens(code);
            if(token.getToken().equals("var")) token = Lexico2.getTokens(code);
            msg = lista_identificador();
            if(!msg.equals("")) {
                return msg;
            }
            if(!token.getToken().equals(":")) return "Erro: \":\" esperado";
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: tipo esperado";
            token = Lexico2.getTokens(code);
        } while(token.getToken().equals(";"));
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        return "";
    }
    
    private static String comando_composto() {
        String msg = "";
        if(!token.getToken().equals("inicio")) return "Erro: \"inicio\" esperado";
        token = Lexico2.getTokens(code);
        do {    
            msg = comando_sem_rotulo();
            if(!msg.equals("")) {
                return msg;
            }
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            token = Lexico2.getTokens(code);
        } while(token.getClasse().equals(Classe.IDENTIFICADOR) || token.getToken().equals("se") || token.getToken().equals("enquanto"));
        if(!token.getToken().equals("fim")) return "Erro: \"fim\" esperado";
        return "";
    }
    
    private static String comando_sem_rotulo() {
        String msg = "";
        if(token.getToken().equals("se")) {
            token = Lexico2.getTokens(code);
            msg = comando_condicional();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("enquanto")) {
            token = Lexico2.getTokens(code);
            msg = comando_repetitivo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("leia")) {
            token = Lexico2.getTokens(code);
            msg = comando_leia();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("imprima")) {
            token = Lexico2.getTokens(code);
            msg = comando_imprima();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getClasse().equals(Classe.IDENTIFICADOR)) {
            token = Lexico2.getTokens(code);
            if(token.getToken().equals(":=")) {
                token = Lexico2.getTokens(code);
                msg = expressao();
                if(!msg.equals("")) {
                    return msg;
                }
            }
            else if(token.getToken().equals("(")) {
                token = Lexico2.getTokens(code);
                msg = lista_expressao();
                if(!msg.equals("")) {
                    return msg;
                }
                token = Lexico2.getTokens(code);
                if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
                token = Lexico2.getTokens(code);
            }
        }
        return "";
    }
    
    private static String comando_condicional() {
        String msg = expressao();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals("entao")) return "Erro: \"entao\" esperado";
        token = Lexico2.getTokens(code);
        msg = comando_sem_rotulo();
        if(!msg.equals("")) {
            return msg;
        }
        if(token.getToken().equals("senao")) {
            token = Lexico2.getTokens(code);
            msg = comando_sem_rotulo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        return "";
    }
    
    private static String comando_repetitivo() {
        String msg = expressao();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals("do")) return "Erro: \"do\" esperado";
        token = Lexico2.getTokens(code);
        msg = comando_sem_rotulo();
        return msg.equals("")? "" : msg;
    }
        
    private static String comando_leia() { 
        if(!token.getToken().equals("(")) return "Erro: \"(\" esperado";
        token = Lexico2.getTokens(code);
        String msg = lista_identificador();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        token = Lexico2.getTokens(code);
        return "";
    }
    
    private static String comando_imprima() {  
        if(!token.getToken().equals("(")) return "Erro: \"(\" esperado";
        token = Lexico2.getTokens(code);
        String msg = lista_expressao();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        token = Lexico2.getTokens(code);     
        return "";
    }
    
    private static String lista_expressao() {
        String msg = "";
        do {
            msg = expressao();
            if(!msg.equals("")) {
                return msg;
            }
        } while(token.getToken().equals(";"));
        
        return "";
    }
    
    private static String expressao() {
        String msg = expressao_simples();
        if(!msg.equals("")) {
            return msg;
        }
        if(token.getToken().equals("=") || token.getToken().equals("<>") || token.getToken().equals("<") ||
            token.getToken().equals("<=") || token.getToken().equals(">") || token.getToken().equals(">=")) {
            token = Lexico2.getTokens(code);
            msg = expressao_simples();
            if(!msg.equals("")) {
                return msg;
            }
        }
        return "";
    }

    private static String expressao_simples() {
        String msg = termo();
        if(!msg.equals("")) {
            return msg;
        }
        while(token.getToken().equals("+") || token.getToken().equals("-") || token.getToken().equals("ou")) {
            token = Lexico2.getTokens(code);
            msg = termo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        return "";
    }
    
    private static String termo() {
        String msg = fator();
        if(!msg.equals("")) {
            return msg;
        }
        while(token.getToken().equals("*") || token.getToken().equals("div") || token.getToken().equals("e")) {
            token = Lexico2.getTokens(code);
            msg = fator();
            if(!msg.equals("")) {
                return msg;
            }
        }
        return "";
    }

    private static String fator() {
        String msg = "";
        if(token.getClasse().equals(Classe.DIGITO)) token = Lexico2.getTokens(code);
        else if(token.getToken().equals("(")) {
            token = Lexico2.getTokens(code);
            msg = expressao();
            if(!msg.equals("")) {
                return msg;
            }
            if(token.getToken().equals(")")) return "Erro: \")\" esperado";
            token = Lexico2.getTokens(code);
        }
        else if(token.getClasse().equals(Classe.IDENTIFICADOR)) {
            token = Lexico2.getTokens(code);
            if(token.getToken().equals("(")) {
                token = Lexico2.getTokens(code);
                msg = lista_expressao();
                if(!msg.equals("")) {
                    return msg;
                }
                if(token.getToken().equals(")")) token = Lexico2.getTokens(code);
                else return "Erro: \")\" esperado";
            } 
        }
        return "";
    }


}
