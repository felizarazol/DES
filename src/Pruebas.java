
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
        ArrayList<Integer> r = new ArrayList<>();
        r.add(1);
        r.add(1);
        int x = 0;
        for (int i = 0; i < 2; i++){
            x += (int) (r.get(r.size() - 1 - i)*Math.pow(2, i));
        }
        System.out.println(x);
    } 
    
}
