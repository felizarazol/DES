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
public class ConvertHexa {

    /*Esta clase permite recuperar los valores de la llave ingresada por el 
    usuario.
    La primera funcion convierte la cadena recibida en numeros en formato
    hexadecimal. La segunda permite convertir este valor en grupos de 4 bits por
    cada numero hexadecimal*/
    
    String llave;
    ArrayList<Integer> codigo = new ArrayList<>();
    ArrayList<Integer> bits = new ArrayList<>();
    
    public ConvertHexa(String llave) {
        this.llave = llave;
        convertir();
        conseguirBits();
    }
    
    private void convertir(){
        for (int i = 0; i < llave.length(); i++){
//           System.out.print(llave.charAt(i));
           switch(llave.charAt(i)){
               case '0':
                   codigo.add(0);
                   break;
               case '1':
                   codigo.add(1);
                   break;
               case '2':
                   codigo.add(2);
                   break;
               case '3':
                   codigo.add(3);
                   break;
               case '4':
                   codigo.add(4);
                   break;
               case '5':
                   codigo.add(5);
                   break;
               case '6':
                   codigo.add(6);
                   break;
               case '7':
                   codigo.add(7);
                   break;
               case '8':
                   codigo.add(8);
                   break;
               case '9':
                   codigo.add(9);
                   break;
               case 'A':
                   codigo.add(10);
                   break;
               case 'B':
                   codigo.add(11);
                   break;
               case 'C':
                   codigo.add(12);
                   break;
               case 'D':
                   codigo.add(13);
                   break;
               case 'E':
                   codigo.add(14);
                   break;
               case 'F':
                   codigo.add(15);
               default:
                   System.err.println("La llave es inválida. Ingrese otra nuevamente.");
           }
        }
    }
    
    private void conseguirBits(){
        for (int i = 0; i < codigo.size(); i++){
            int numero = codigo.get(i);
            if (numero < 8){
                bits.add(0);
            }
            if (numero < 4){
                bits.add(0);
            }
            if (numero < 2){
                bits.add(0);
            }
            String binario = Integer.toBinaryString(numero);
            for (int j = 0; j < binario.length(); j++){
                bits.add(Integer.parseInt("" + binario.charAt(j)));
            }
        }
//        for (int i = 0; i < bits.size(); i++){
//            if (i % 4 == 0){
//                System.out.println();
//            }
//            System.out.print(bits.get(i));
//        }
    }
}
