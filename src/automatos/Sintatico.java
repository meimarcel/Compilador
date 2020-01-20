/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatos;

import java.util.ArrayList;
import java.util.Arrays;
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
    private static List<String> types = new ArrayList<String>(Arrays.asList("inteiro","real","caractere"));
    private static int linha = 1;
    
    public static void setCode(List<String> text) {
        code = text;
    }
    public static Token getToken() {
        return token;
    }
    
    
    public static String sintatico() {
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals("programa")) return "Erro: \"programa\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: identificador esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        String msg = bloco();
        if(msg.equals("")) {
            token = Lexico2.getTokens(code);
            linha = token.getLinha();
            if(!token.getClasse().equals(Classe.FIM_LEITURA)) {
                return "Linhas não reconhecidas após o término do código na linha: "+linha;
            } else {
                return "Executado Com Sucesso!";
            }
        }
        return msg+" na linha: "+linha;
    }

    private static String bloco() {
        String msg = "";
        if(token.getToken().equals("tipo")) {
            linha = token.getLinha();
            msg = declara_tipo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        if(token.getToken().equals("var")) {
            linha = token.getLinha();
            msg = declara_var();
            if(!msg.equals("")) {
                return msg;
            }
        }
        while(token.getToken().equals("procedimento") || token.getToken().equals("funcao")) {
            if(token.getToken().equals("funcao")) {
                linha = token.getLinha();
                msg = declara_funcao();
                if(!msg.equals("")) {
                    return msg;
                }
            }
            else {
                linha = token.getLinha();
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
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals("=")) return "Erro: \"=\" esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR) && types.indexOf(token.getToken()) == -1) return "Erro: tipo esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            linha = token.getLinha();
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
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR) && types.indexOf(token.getToken()) == -1) return "Erro: tipo esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
        } while(token.getClasse().equals(Classe.IDENTIFICADOR));
        return "";
    }
   
    private static String lista_identificador() {    
        boolean virgula = false;
        do {
            virgula = false;
            if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro Identificador esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(token.getToken().equals(",")) {virgula = true; token = Lexico2.getTokens(code);}
        } while(virgula == true);
        return "";
    }
    
    private static String declara_procedimento() {
        String msg = "";
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR)) return "Erro: Identificador esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(token.getToken().equals("(")) {
            linha = token.getLinha();
            msg = parametros_formais();
            if(!msg.equals("")) {
                return msg;
            }
            token = Lexico2.getTokens(code);
        }
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
        linha = token.getLinha();
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
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(token.getToken().equals("(")) { 
            linha = token.getLinha();
            msg = parametros_formais();
            if(!msg.equals("")) {
                return msg;
            }
            token = Lexico2.getTokens(code);
        }
        if(!token.getToken().equals(":")) return "Erro: \":\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(!token.getClasse().equals(Classe.IDENTIFICADOR) && types.indexOf(token.getToken()) == -1) return "Erro: identificador esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        if(!token.getToken().equals(";")) return "Erro: \";\" esperado";      
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
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
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(!token.getClasse().equals(Classe.IDENTIFICADOR) && types.indexOf(token.getToken()) == -1) return "Erro: tipo esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
        } while(token.getToken().equals(";"));
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        linha = token.getLinha();
        return "";
    }
    
    private static String comando_composto() {
        String msg = "";
        if(!token.getToken().equals("inicio")) return "Erro: \"inicio\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        do {    
            msg = comando_sem_rotulo();
            if(!msg.equals("")) {
                return msg;
            }
            if(!token.getToken().equals(";")) return "Erro: \";\" esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
        } while(token.getClasse().equals(Classe.IDENTIFICADOR) || token.getToken().equals("se") || token.getToken().equals("enquanto"));
        if(!token.getToken().equals("fim")) return "Erro: \"fim\" esperado";
        linha = token.getLinha();
        return "";
    }
    
    private static String comando_sem_rotulo() {
        String msg = "";
        if(token.getToken().equals("se")) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            msg = comando_condicional();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("enquanto")) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            msg = comando_repetitivo();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("leia")) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            msg = comando_leia();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getToken().equals("imprima")) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            msg = comando_imprima();
            if(!msg.equals("")) {
                return msg;
            }
        }
        else if(token.getClasse().equals(Classe.IDENTIFICADOR)) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(token.getToken().equals(":=")) {
                linha = token.getLinha();
                token = Lexico2.getTokens(code);
                msg = expressao();
                if(!msg.equals("")) {
                    return msg;
                }
            }
            else if(token.getToken().equals("(")) {
                linha = token.getLinha();
                msg = lista_expressao();
                if(!msg.equals("")) {
                    return msg;
                }
                if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
                linha = token.getLinha();
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
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        msg = comando_sem_rotulo();
        if(!msg.equals("")) {
            return msg;
        }
        if(token.getToken().equals("senao")) {
            linha = token.getLinha();
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
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        msg = comando_sem_rotulo();
        return msg.equals("")? "" : msg;
    }
        
    private static String comando_leia() { 
        if(!token.getToken().equals("(")) return "Erro: \"(\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        String msg = lista_identificador();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);
        return "";
    }
    
    private static String comando_imprima() {  
        if(!token.getToken().equals("(")) return "Erro: \"(\" esperado";
        linha = token.getLinha();
        String msg = lista_expressao();
        if(!msg.equals("")) {
            return msg;
        }
        if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
        linha = token.getLinha();
        token = Lexico2.getTokens(code);     
        return "";
    }
    
    private static String lista_expressao() {
        String msg = "";
        do {
            token = Lexico2.getTokens(code);
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
            linha = token.getLinha();
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
            linha = token.getLinha();
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
            linha = token.getLinha();
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
        if(token.getClasse().equals(Classe.DIGITO)){linha = token.getLinha(); token = Lexico2.getTokens(code);}
        else if(token.getToken().equals("(")) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            msg = expressao();
            if(!msg.equals("")) {
                return msg;
            }
            if(!token.getToken().equals(")")) return "Erro: \")\" esperado";
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
        }
        else if(token.getClasse().equals(Classe.IDENTIFICADOR)) {
            linha = token.getLinha();
            token = Lexico2.getTokens(code);
            if(token.getToken().equals("(")) {
                linha = token.getLinha();
                msg = lista_expressao();
                if(!msg.equals("")) {
                    return msg;
                }
                if(token.getToken().equals(")")){linha = token.getLinha(); token = Lexico2.getTokens(code);}
                else return "Erro: \")\" esperado";
            } 
        } else {
            return "Erro: \"idetificador | numero | função | expressão\" esperado";
        }
        return "";
    }


}
