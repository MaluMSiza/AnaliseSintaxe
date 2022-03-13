/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package n1b1lp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 *
 * @author maria
 */
public class AcessoDados {
    
    public static void main(String[] args) throws FileNotFoundException {
     
       
        ArrayList<Funcionario> arrfun = new ArrayList<>();
        System.out.println("teste");
        
        try{ 
            
            File arquivotexto = new File("dados.txt");
            FileReader lerTexto = new FileReader(arquivotexto);
            BufferedReader bur = new BufferedReader(lerTexto);
        
        while (bur.ready()) {
            String texto = bur.readLine();
            String textoSeparado[] = texto.split(";");

            Funcionario fun1 = new Funcionario();
            fun1.setCodigo(Long.parseLong(textoSeparado[1]));
            fun1.setNome(textoSeparado[2]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fun1.setNascimento(LocalDate.parse(textoSeparado[3], formatter));
            fun1.setContratacao(LocalDate.parse(textoSeparado[4], formatter).atStartOfDay());

            arrfun.add(fun1);
           
        }
         bur.close();

         for(int i = 0; i < arrfun.size(); i++) {
            System.out.println("Nome do funcionario salv "+arrfun.get(i).getNome());
        }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");

        }
    }
}
