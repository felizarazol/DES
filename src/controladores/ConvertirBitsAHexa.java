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
public class ConvertirBitsAHexa {

    public static String convertirBitsHexa(ArrayList<Integer> plainText){
    Iterator<Integer> it = plainText.iterator();
        String temp= new String("");
        String salida= new String("");
        int contador=0;
        while(it.hasNext()){
                Integer elemento = it.next();
                temp= temp + elemento;
                contador++;
                if(contador==4){
                    if(temp.equals("0000")) salida=salida + "0";
                    if(temp.equals("0001")) salida=salida + "1";
                    if(temp.equals("0010")) salida=salida + "2";
                    if(temp.equals("0011")) salida=salida + "3";
                    if(temp.equals("0100")) salida=salida + "4";
                    if(temp.equals("0101")) salida=salida + "5";
                    if(temp.equals("0110")) salida=salida + "6";
                    if(temp.equals("0111")) salida=salida + "7";
                    if(temp.equals("1000")) salida=salida + "8";
                    if(temp.equals("1001")) salida=salida + "9";
                    if(temp.equals("1010")) salida=salida + "A";
                    if(temp.equals("1011")) salida=salida + "B";
                    if(temp.equals("1100")) salida=salida + "C";
                    if(temp.equals("1101")) salida=salida + "D";
                    if(temp.equals("1110")) salida=salida + "E";
                    if(temp.equals("1111")) salida=salida + "F";
                    contador=0;
                    temp="";
                }
                
        }
        return salida;
    }
}
