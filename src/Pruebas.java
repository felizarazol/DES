
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
import controladores.Descifrar;
import java.util.Scanner;
public class Pruebas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text= sc.nextLine();
        String key= sc.nextLine();
        Descifrar d = new Descifrar(text, key);
        
        System.out.println("Directorio ejecucion = " + System.getProperty("user.dir"));
    } 
    
}
