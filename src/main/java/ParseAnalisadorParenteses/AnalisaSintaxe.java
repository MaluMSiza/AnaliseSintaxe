/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParseAnalisadorParenteses;

import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author maria
 */
public class AnalisaSintaxe {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        String texto = "";
        File arquivotexto = new File("/Users/maria/OneDrive/Documentos"
                + "/NetBeansProjects/ProjetoCompiladores/textoinicial.txt");
        FileWriter arquivotextoreescrito = new FileWriter("/Users/maria/OneDrive/Documentos"
                + "/NetBeansProjects/ProjetoCompiladores/textofinal.txt");
        Scanner scan = new Scanner(arquivotexto);
        
        while(scan.hasNextLine()){
            
            String linhatxt = scan.nextLine() ;// usado para pegar apenas uma linha
            
            Stack<Character> pilhabase = new Stack<>();
        
            for(int i=0; i< linhatxt.length(); i++){
            
                if(linhatxt.charAt(i) == '(' || 
                   linhatxt.charAt(i) == '[' ||
                   linhatxt.charAt(i) == '{' ||
                   linhatxt.charAt(i) == '<'){

                       pilhabase.push(linhatxt.charAt(i));
                }
                else if( !pilhabase.empty() && // deve garantir primeiro que a pilha esteja cheia para não ocorrer erros
                        ((linhatxt.charAt(i) == ')' && pilhabase.peek() == '(') || 
                        (linhatxt.charAt(i) == ']' && pilhabase.peek() == '[')  ||
                        (linhatxt.charAt(i) == '}' && pilhabase.peek() == '{')  ||
                        (linhatxt.charAt(i) == '>' && pilhabase.peek() == '<'))) {

                       pilhabase.pop();
                }
                else{
                       pilhabase.push(linhatxt.charAt(i));
                }
            }
            if(pilhabase.empty()) {
                  texto = texto.concat(linhatxt + "- OK \n");
             } else {
                  texto = texto.concat(linhatxt + "- Inválido \n");
             }
           
        }
        arquivotextoreescrito.write(texto);
        arquivotextoreescrito.close();  
    }
}
