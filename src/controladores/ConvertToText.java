/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Julian
 */
public class ConvertToText {
    public ConvertToText(){ }
    
    public static String toText(ArrayList<Integer> cyphertext){
        String outputString = new String();
        String mensaje= new String();
        Iterator<Integer> nombreIterator = cyphertext.iterator();
        int contador=0;
        while(nombreIterator.hasNext()){
            Integer elemento = nombreIterator.next();
            outputString+=elemento;
            contador++;
            if((contador%8)==0){
                
                //System.out.println("output  "+outputString);
                //System.out.println("output  "+binarioADecimal(outputString));
                mensaje=mensaje+(char)(binarioADecimal(outputString));
                //System.out.println("output  "+mensaje);
                outputString="";
                
            }
        }
        //System.out.println("texto en Ascii:  "+mensaje);
        return mensaje;
    }

    /**
     *
     * @param numeroBinario
     * @return
     * Convierte un binario en decinal
     */
    public static int binarioADecimal(String numeroBinario){
        int longitud = numeroBinario.length();//Numero de digitos que tiene nuestro binario
        int resultado = 0;//Aqui almacenaremos nuestra respuesta final
        int potencia = longitud - 1;
        for(int i = 0;i < longitud;i++){//recorremos la cadena de numeros
         if(numeroBinario.charAt(i) == '1'){
          resultado += Math.pow(2,potencia);
         }
         potencia --;//drecremantamos la potencia
        }
        return resultado;
    }
}
