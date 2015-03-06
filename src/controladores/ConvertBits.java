/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;

/**
 *
 * @author estma_000
 */
public class ConvertBits {
    
    /*Esta clase es la encargada de tomar la palabra a cifrar y convertirla en 
    una cadena de 8 bits
    Implementa dos métodos, el primero recupera el valor en ASCII y el segundo
    lo convierte a bits, y completa con ceros a la izquierda segun sea el caso*/

    String palabra;
    ArrayList<Integer> ind = new ArrayList();
    ArrayList<Integer> bits = new ArrayList();
    
    public ConvertBits(String palabra) {
        this.palabra = palabra;
        convertir();
        conseguirBits();
        
    }
    
    private void convertir(){
        for (int i = 0; i < palabra.length(); i++){
           ind.add(palabra.codePointAt(i));
       }
       
    }
    
    private void conseguirBits(){
        for (int i = 0; i < ind.size(); i++){
            if (ind.get(i) < 128){
                bits.add(0);
            }
            if (ind.get(i) < 64){
                bits.add(0);
            }
            if (ind.get(i) < 32){
                bits.add(0);
            }
            if (ind.get(i) < 16){
                bits.add(0);
            }
            if (ind.get(i) < 8){
                bits.add(0);
            }
            if (ind.get(i) < 4){
                bits.add(0);
            }
            if (ind.get(i) < 2){
                bits.add(0);
            }
            String cadena = Integer.toString(ind.get(i),2);
            for (int j = 0; j < cadena.length(); j++){
                bits.add(Integer.parseInt(""+ cadena.charAt(j)));
            }
        }
        
//        for (int i = 0; i < bits.size(); i++){
//            if (i%8 ==0){
//                System.out.println("");
//            }
//            System.out.print(bits.get(i));
//        }

    }
    
}
