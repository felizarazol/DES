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
public class CrearLlaves {
    
    public String llave;
    private ArrayList<Integer> key;
    
    private ArrayList<Integer> keyP;    //k' con PC-1
    
    //Partes izquierdas de las 16 llaves
    public ArrayList<Integer> c0 = new ArrayList<>();
    public ArrayList<Integer> c1 = new ArrayList<>();
    public ArrayList<Integer> c2 = new ArrayList<>();
    public ArrayList<Integer> c3 = new ArrayList<>();
    public ArrayList<Integer> c4 = new ArrayList<>();
    public ArrayList<Integer> c5 = new ArrayList<>();
    public ArrayList<Integer> c6 = new ArrayList<>();
    public ArrayList<Integer> c7 = new ArrayList<>();
    public ArrayList<Integer> c8 = new ArrayList<>();
    public ArrayList<Integer> c9 = new ArrayList<>();
    public ArrayList<Integer> c10 = new ArrayList<>();
    public ArrayList<Integer> c11 = new ArrayList<>();
    public ArrayList<Integer> c12 = new ArrayList<>();
    public ArrayList<Integer> c13 = new ArrayList<>();
    public ArrayList<Integer> c14 = new ArrayList<>();
    public ArrayList<Integer> c15 = new ArrayList<>();
    public ArrayList<Integer> c16 = new ArrayList<>();
    
    //Partes derechas de las 16 llaves
    public ArrayList<Integer> d0 = new ArrayList<>();
    public ArrayList<Integer> d1 = new ArrayList<>();
    public ArrayList<Integer> d2 = new ArrayList<>();
    public ArrayList<Integer> d3 = new ArrayList<>();
    public ArrayList<Integer> d4 = new ArrayList<>();
    public ArrayList<Integer> d5 = new ArrayList<>();
    public ArrayList<Integer> d6 = new ArrayList<>();
    public ArrayList<Integer> d7 = new ArrayList<>();
    public ArrayList<Integer> d8 = new ArrayList<>();
    public ArrayList<Integer> d9 = new ArrayList<>();
    public ArrayList<Integer> d10 = new ArrayList<>();
    public ArrayList<Integer> d11 = new ArrayList<>();
    public ArrayList<Integer> d12 = new ArrayList<>();
    public ArrayList<Integer> d13 = new ArrayList<>();
    public ArrayList<Integer> d14 = new ArrayList<>();
    public ArrayList<Integer> d15 = new ArrayList<>();
    public ArrayList<Integer> d16 = new ArrayList<>();
    
    //16 Llaves finales
    public ArrayList<Integer> k1 = new ArrayList<>();
    public ArrayList<Integer> k2 = new ArrayList<>();
    public ArrayList<Integer> k3 = new ArrayList<>();
    public ArrayList<Integer> k4 = new ArrayList<>();
    public ArrayList<Integer> k5 = new ArrayList<>();
    public ArrayList<Integer> k6 = new ArrayList<>();
    public ArrayList<Integer> k7 = new ArrayList<>();
    public ArrayList<Integer> k8 = new ArrayList<>();
    public ArrayList<Integer> k9 = new ArrayList<>();
    public ArrayList<Integer> k10 = new ArrayList<>();
    public ArrayList<Integer> k11 = new ArrayList<>();
    public ArrayList<Integer> k12 = new ArrayList<>();
    public ArrayList<Integer> k13 = new ArrayList<>();
    public ArrayList<Integer> k14 = new ArrayList<>();
    public ArrayList<Integer> k15 = new ArrayList<>();
    public ArrayList<Integer> k16 = new ArrayList<>();
    
    public CrearLlaves(String llave){
        this.llave = llave;
        ConvertHexa convertHexa = new ConvertHexa(llave);
        key = convertHexa.getBits();
        //Creacion de la k'
        PC_1();
        LSi();
        //Creacion de las 16 sub-llaves
        PC_2();
    }
    
    //Metodo para obtener las 16 Ci y Di
    private void LSi(){
        c0.addAll(keyP.subList(0, 28));
        d0.addAll(keyP.subList(28, keyP.size()));
        Integer tempoc1 = c0.get(0);
        Integer tempod1 = d0.get(0);
        c1.addAll(c0.subList(1, c0.size()));
        c1.add(tempoc1);
        tempoc1 = c1.get(0);
        d1.addAll(d0.subList(1, d0.size()));
        d1.add(tempod1);
        tempod1 = d1.get(0);
        c2.addAll(c1.subList(1, c1.size()));
        c2.add(tempoc1);
        tempoc1 = c2.get(0);
        Integer tempod2 = c2.get(1);
        d2.addAll(d1.subList(1, d1.size()));
        d2.add(tempod1);
        tempod1 = d2.get(0);
        Integer tempoc2 = d2.get(1);
        c3.addAll(c2.subList(2, c2.size()));
        c3.add(tempoc1);
        c3.add(tempoc2);
        tempoc1 = c3.get(0);
        tempoc2 = c3.get(1);
        d3.addAll(d2.subList(2, d2.size()));
        d3.add(tempod1);
        d3.add(tempod2);
        tempod1 = d3.get(0);
        tempod2 = d3.get(1);
        c4.addAll(c3.subList(2, c3.size()));
        c4.add(tempoc1);
        c4.add(tempoc2);
        tempoc1 = c4.get(0);
        tempoc2 = c4.get(1);
        d4.addAll(d3.subList(2, d3.size()));
        d4.add(tempod1);
        d4.add(tempod2);
        tempod1 = d4.get(0);
        tempod2 = d4.get(1);
        c5.addAll(c4.subList(2, c4.size()));
        c5.add(tempoc1);
        c5.add(tempoc2);
        tempoc1 = c5.get(0);
        tempoc2 = c5.get(1);
        d5.addAll(d4.subList(2, d4.size()));
        d5.add(tempod1);
        d5.add(tempod2);
        tempod1 = d5.get(0);
        tempod2 = d5.get(1);
        c6.addAll(c5.subList(2, c5.size()));
        c6.add(tempoc1);
        c6.add(tempoc2);
        tempoc1 = c6.get(0);
        tempoc2 = c6.get(1);
        d6.addAll(d5.subList(2, d5.size()));
        d6.add(tempod1);
        d6.add(tempod2);
        tempod1 = d6.get(0);
        tempod2 = d6.get(1);
        c7.addAll(c6.subList(2, c6.size()));
        c7.add(tempoc1);
        c7.add(tempoc2);
        tempoc1 = c7.get(0);
        tempoc2 = c7.get(1);
        d7.addAll(d6.subList(2, d6.size()));
        d7.add(tempod1);
        d7.add(tempod2);
        tempod1 = d7.get(0);
        tempod2 = d7.get(1);
        c8.addAll(c7.subList(2, c7.size()));
        c8.add(tempoc1);
        c8.add(tempoc2);
        tempoc1 = c8.get(0);
        d8.addAll(d7.subList(2, d7.size()));
        d8.add(tempod1);
        d8.add(tempod2);
        tempod1 = d8.get(0);
        c9.addAll(c8.subList(1, c8.size()));
        c9.add(tempoc1);
        tempoc1 = c9.get(0);
        tempoc2 = c9.get(1);
        d9.addAll(d8.subList(1, d8.size()));
        d9.add(tempod1);
        tempod1 = d9.get(0);
        tempod2 = d9.get(1);
        c10.addAll(c9.subList(2, c9.size()));
        c10.add(tempoc1);
        c10.add(tempoc2);
        tempoc1 = c10.get(0);
        tempoc2 = c10.get(1);
        d10.addAll(d9.subList(2, d9.size()));
        d10.add(tempod1);
        d10.add(tempod2);
        tempod1 = d10.get(0);
        tempod2 = d10.get(1);
        c11.addAll(c10.subList(2, c10.size()));
        c11.add(tempoc1);
        c11.add(tempoc2);
        tempoc1 = c11.get(0);
        tempoc2 = c11.get(1);
        d11.addAll(d10.subList(2, d10.size()));
        d11.add(tempod1);
        d11.add(tempod2);
        tempod1 = d11.get(0);
        tempod2 = d11.get(1);
        c12.addAll(c11.subList(2, c11.size()));
        c12.add(tempoc1);
        c12.add(tempoc2);
        tempoc1 = c12.get(0);
        tempoc2 = c12.get(1);
        d12.addAll(d11.subList(2, d11.size()));
        d12.add(tempod1);
        d12.add(tempod2);
        tempod1 = d12.get(0);
        tempod2 = d12.get(1);
        c13.addAll(c12.subList(2, c12.size()));
        c13.add(tempoc1);
        c13.add(tempoc2);
        tempoc1 = c13.get(0);
        tempoc2 = c13.get(1);
        d13.addAll(d12.subList(2, d12.size()));
        d13.add(tempod1);
        d13.add(tempod2);
        tempod1 = d13.get(0);
        tempod2 = d13.get(1);
        c14.addAll(c13.subList(2, c13.size()));
        c14.add(tempoc1);
        c14.add(tempoc2);
        tempoc1 = c14.get(0);
        tempoc2 = c14.get(1);
        d14.addAll(d13.subList(2, d13.size()));
        d14.add(tempod1);
        d14.add(tempod2);
        tempod1 = d14.get(0);
        tempod2 = d14.get(1);
        c15.addAll(c14.subList(2, c14.size()));
        c15.add(tempoc1);
        c15.add(tempoc2);
        tempoc1 = c15.get(0);
        d15.addAll(d14.subList(2, d14.size()));
        d15.add(tempod1);
        d15.add(tempod2);
        tempod1 = d15.get(0);
        c16.addAll(c15.subList(1, c15.size()));
        c16.add(tempoc1);
        d16.addAll(d15.subList(1, d15.size()));
        d16.add(tempod1);
//        System.out.println(c0 + " " + d0);
//        System.out.println(c1 + " " + d1);
//        System.out.println(c2 + " " + d2);
//        System.out.println(c3 + " " + d3);
//        System.out.println(c4 + " " + d4);
//        System.out.println(c5 + " " + d5);
//        System.out.println(c6 + " " + d6);
//        System.out.println(c7 + " " + d7);
//        System.out.println(c8 + " " + d8);
//        System.out.println(c9 + " " + d9);
//        System.out.println(c10 + " " + d10);
//        System.out.println(c11 + " " + d11);
//        System.out.println(c12 + " " + d12);
//        System.out.println(c13 + " " + d13);
//        System.out.println(c14 + " " + d14);
//        System.out.println(c15 + " " + d15);
//        System.out.println(c16 + " " + d16);
        
    }
    
    //Metodo para obtener la k' con PC-1
    private void PC_1(){
        //Se hace la permutacion, omitiendo 8 bits
        keyP = new ArrayList<>();
        keyP.add(key.get(57-1));
        keyP.add(key.get(49-1));
        keyP.add(key.get(41-1));
        keyP.add(key.get(33-1));
        keyP.add(key.get(25-1));
        keyP.add(key.get(17-1));
        keyP.add(key.get(9-1));
        keyP.add(key.get(1-1));
        keyP.add(key.get(58-1));
        keyP.add(key.get(50-1));
        keyP.add(key.get(42-1));
        keyP.add(key.get(34-1));
        keyP.add(key.get(26-1));
        keyP.add(key.get(18-1));
        keyP.add(key.get(10-1));
        keyP.add(key.get(2-1));
        keyP.add(key.get(59-1));
        keyP.add(key.get(51-1));
        keyP.add(key.get(43-1));
        keyP.add(key.get(35-1));
        keyP.add(key.get(27-1));
        keyP.add(key.get(19-1));
        keyP.add(key.get(11-1));
        keyP.add(key.get(3-1));
        keyP.add(key.get(60-1));
        keyP.add(key.get(52-1));
        keyP.add(key.get(44-1));
        keyP.add(key.get(36-1));
        keyP.add(key.get(63-1));
        keyP.add(key.get(55-1));
        keyP.add(key.get(47-1));
        keyP.add(key.get(39-1));
        keyP.add(key.get(31-1));
        keyP.add(key.get(23-1));
        keyP.add(key.get(15-1));
        keyP.add(key.get(7-1));
        keyP.add(key.get(62-1));
        keyP.add(key.get(54-1));
        keyP.add(key.get(46-1));
        keyP.add(key.get(38-1));
        keyP.add(key.get(30-1));
        keyP.add(key.get(22-1));
        keyP.add(key.get(14-1));
        keyP.add(key.get(6-1));
        keyP.add(key.get(61-1));
        keyP.add(key.get(53-1));
        keyP.add(key.get(45-1));
        keyP.add(key.get(37-1));
        keyP.add(key.get(29-1));
        keyP.add(key.get(21-1));
        keyP.add(key.get(13-1));
        keyP.add(key.get(5-1));
        keyP.add(key.get(28-1));
        keyP.add(key.get(20-1));
        keyP.add(key.get(12-1));
        keyP.add(key.get(4-1));
    }
    
    //Metodo para obtener las 16 llaves
    private void PC_2 (){
        k1 = PC_2(c1, d1);
        k2 = PC_2(c2, d2);
        k3 = PC_2(c3, d3);
        k4 = PC_2(c4, d4);
        k5 = PC_2(c5, d5);
        k6 = PC_2(c6, d6);
        k7 = PC_2(c7, d7);
        k8 = PC_2(c8, d8);
        k9 = PC_2(c9, d9);
        k10 = PC_2(c10, d10);
        k11 = PC_2(c11, d11);
        k12 = PC_2(c12, d12);
        k13 = PC_2(c13, d13);
        k14 = PC_2(c14, d14);
        k15 = PC_2(c15, d15);
        k16 = PC_2(c16, d16);
        
    }
    
    //Metodo que realiza el calculo de las 16 llaves
    private ArrayList PC_2(ArrayList ci, ArrayList di){
        ArrayList<Integer> concat = new ArrayList<>();
        concat.addAll(ci);
        concat.addAll(di);
        
        ArrayList<Integer> resul = new ArrayList();
        
        resul.add(concat.get(14-1));
        resul.add(concat.get(17-1));
        resul.add(concat.get(11-1));
        resul.add(concat.get(24-1));
        resul.add(concat.get(1-1));
        resul.add(concat.get(5-1));
        resul.add(concat.get(3-1));
        resul.add(concat.get(28-1));
        resul.add(concat.get(15-1));
        resul.add(concat.get(6-1));
        resul.add(concat.get(21-1));
        resul.add(concat.get(10-1));
        resul.add(concat.get(23-1));
        resul.add(concat.get(19-1));
        resul.add(concat.get(12-1));
        resul.add(concat.get(4-1));
        resul.add(concat.get(26-1));
        resul.add(concat.get(8-1));
        resul.add(concat.get(16-1));
        resul.add(concat.get(7-1));
        resul.add(concat.get(27-1));
        resul.add(concat.get(20-1));
        resul.add(concat.get(13-1));
        resul.add(concat.get(2-1));
        resul.add(concat.get(41-1));
        resul.add(concat.get(52-1));
        resul.add(concat.get(31-1));
        resul.add(concat.get(37-1));
        resul.add(concat.get(47-1));
        resul.add(concat.get(55-1));
        resul.add(concat.get(30-1));
        resul.add(concat.get(40-1));
        resul.add(concat.get(51-1));
        resul.add(concat.get(45-1));
        resul.add(concat.get(33-1));
        resul.add(concat.get(48-1));
        resul.add(concat.get(44-1));
        resul.add(concat.get(49-1));
        resul.add(concat.get(39-1));
        resul.add(concat.get(56-1));
        resul.add(concat.get(34-1));
        resul.add(concat.get(53-1));
        resul.add(concat.get(46-1));
        resul.add(concat.get(42-1));
        resul.add(concat.get(50-1));
        resul.add(concat.get(36-1));
        resul.add(concat.get(29-1));
        resul.add(concat.get(32-1));
        
        return resul;
        
    }
    
}
