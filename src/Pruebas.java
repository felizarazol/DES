
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estma_000
 */
public class Pruebas {
   public static void main(String[] args) {
//        int i = 12;
//        String cadena = Integer.toString(i,2);
//        ArrayList<Integer> ind = new ArrayList();
//        for (i = 0; i < cadena.length(); i++){
//            ind.add(Integer.parseInt(""+ cadena.charAt(i)));
//        }
//        for (i = 0; i < ind.size(); i++){
//            System.out.println(ind.get(i));
//        }
       String cadena = "Asto es una cadena";
       for (int i = 0; i < cadena.length(); i++){
           System.out.print(cadena.charAt(i) + "=" + cadena.codePointAt(i) + "  ");
       }
    } 
    
}
