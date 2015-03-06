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
public class Cifrar {
    
    String texto;
    String llave;
    ArrayList<Integer> text = new ArrayList();
    
    public Cifrar (String texto, String llave){
        this.texto = texto;
        this.llave = llave;
        ArrayList<Integer> bloquesC = new ArrayList<>();
        
        //creacion del objeto que contiene las llaves
        //CrearLlaves crearLlaves = new CrearLlaves(llave);
        
        ConvertHexa convertBits = new ConvertHexa(texto); //Recordar Cambiar por ConvertirBits
        text = convertBits.getBits();
        System.out.println(text.size());
        //se crean bloques de 64 bits
        crearBloques();
    }
    
    private void crearBloques(){
        while (!text.isEmpty()) {
            ArrayList<Integer> bloque = new ArrayList<>();
            if (text.size() < 64){
                int dif = 64 - text.size();
                for (int i = 0; i < dif; i++){
                    text.add(0);
                }
            }
            
            for (int i = 0; i < 64; i ++){
                bloque.add(text.remove(0));
                
            }
            IP(bloque);
            
        }
        
        
    }
    
    private void IP (ArrayList<Integer> bloque){
        ArrayList<Integer> bloqueIP = new ArrayList<>();
        bloqueIP.add(bloque.get(58-1));
        bloqueIP.add(bloque.get(50-1));
        bloqueIP.add(bloque.get(42-1));
        bloqueIP.add(bloque.get(34-1));
        bloqueIP.add(bloque.get(26-1));
        bloqueIP.add(bloque.get(18-1));
        bloqueIP.add(bloque.get(10-1));
        bloqueIP.add(bloque.get(2-1));
        bloqueIP.add(bloque.get(60-1));
        bloqueIP.add(bloque.get(52-1));
        bloqueIP.add(bloque.get(44-1));
        bloqueIP.add(bloque.get(36-1));
        bloqueIP.add(bloque.get(28-1));
        bloqueIP.add(bloque.get(20-1));
        bloqueIP.add(bloque.get(12-1));
        bloqueIP.add(bloque.get(4-1));
        bloqueIP.add(bloque.get(62-1));
        bloqueIP.add(bloque.get(54-1));
        bloqueIP.add(bloque.get(46-1));
        bloqueIP.add(bloque.get(38-1));
        bloqueIP.add(bloque.get(30-1));
        bloqueIP.add(bloque.get(22-1));
        bloqueIP.add(bloque.get(14-1));
        bloqueIP.add(bloque.get(6-1));
        bloqueIP.add(bloque.get(64-1));
        bloqueIP.add(bloque.get(56-1));
        bloqueIP.add(bloque.get(48-1));
        bloqueIP.add(bloque.get(40-1));
        bloqueIP.add(bloque.get(32-1));
        bloqueIP.add(bloque.get(24-1));
        bloqueIP.add(bloque.get(16-1));
        bloqueIP.add(bloque.get(8-1));
        bloqueIP.add(bloque.get(57-1));
        bloqueIP.add(bloque.get(49-1));
        bloqueIP.add(bloque.get(41-1));
        bloqueIP.add(bloque.get(33-1));
        bloqueIP.add(bloque.get(25-1));
        bloqueIP.add(bloque.get(17-1));
        bloqueIP.add(bloque.get(9-1));
        bloqueIP.add(bloque.get(1-1));
        bloqueIP.add(bloque.get(59-1));
        bloqueIP.add(bloque.get(51-1));
        bloqueIP.add(bloque.get(43-1));
        bloqueIP.add(bloque.get(35-1));
        bloqueIP.add(bloque.get(27-1));
        bloqueIP.add(bloque.get(19-1));
        bloqueIP.add(bloque.get(11-1));
        bloqueIP.add(bloque.get(3-1));
        bloqueIP.add(bloque.get(61-1));
        bloqueIP.add(bloque.get(53-1));
        bloqueIP.add(bloque.get(45-1));
        bloqueIP.add(bloque.get(37-1));
        bloqueIP.add(bloque.get(29-1));
        bloqueIP.add(bloque.get(21-1));
        bloqueIP.add(bloque.get(13-1));
        bloqueIP.add(bloque.get(5-1));
        bloqueIP.add(bloque.get(63-1));
        bloqueIP.add(bloque.get(55-1));
        bloqueIP.add(bloque.get(47-1));
        bloqueIP.add(bloque.get(39-1));
        bloqueIP.add(bloque.get(31-1));
        bloqueIP.add(bloque.get(23-1));
        bloqueIP.add(bloque.get(15-1));
        bloqueIP.add(bloque.get(7-1));
        
    }
}
