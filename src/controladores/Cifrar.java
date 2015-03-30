/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import static controladores.ConvertToText.binarioADecimal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estma_000
 */
public class Cifrar {
    
    private String texto;
    public static String llave;
    
    public static CrearLlaves crearLlaves;
    
    private ArrayList<Integer> text = new ArrayList();
    
    //Mensaje en bits original
    public static ArrayList<Integer> bloque = new ArrayList<>();
    
    //Array para la funcion IP
    public static ArrayList<Integer> bloqueIP;
    
    //Array para la funcion inversa de IP
    public static ArrayList<Integer> cyphertext;
    
    //Arrays para almacenar el lado izquierdo del mensaje
    public static ArrayList<Integer> L0 = new ArrayList<>();
    public static ArrayList<Integer> L1 = new ArrayList<>();
    public static ArrayList<Integer> L2 = new ArrayList<>();
    public static ArrayList<Integer> L3 = new ArrayList<>();
    public static ArrayList<Integer> L4 = new ArrayList<>();
    public static ArrayList<Integer> L5 = new ArrayList<>();
    public static ArrayList<Integer> L6 = new ArrayList<>();
    public static ArrayList<Integer> L7 = new ArrayList<>();
    public static ArrayList<Integer> L8 = new ArrayList<>();
    public static ArrayList<Integer> L9 = new ArrayList<>();
    public static ArrayList<Integer> L10 = new ArrayList<>();
    public static ArrayList<Integer> L11 = new ArrayList<>();
    public static ArrayList<Integer> L12 = new ArrayList<>();
    public static ArrayList<Integer> L13 = new ArrayList<>();
    public static ArrayList<Integer> L14 = new ArrayList<>();
    public static ArrayList<Integer> L15 = new ArrayList<>();
    public static ArrayList<Integer> L16 = new ArrayList<>();
    
    //Arrays para almacenar el lado derecho del mensaje
    public static ArrayList<Integer> R0 = new ArrayList<>();
    public static ArrayList<Integer> R1 = new ArrayList<>();
    public static ArrayList<Integer> R2 = new ArrayList<>();
    public static ArrayList<Integer> R3 = new ArrayList<>();
    public static ArrayList<Integer> R4 = new ArrayList<>();
    public static ArrayList<Integer> R5 = new ArrayList<>();
    public static ArrayList<Integer> R6 = new ArrayList<>();
    public static ArrayList<Integer> R7 = new ArrayList<>();
    public static ArrayList<Integer> R8 = new ArrayList<>();
    public static ArrayList<Integer> R9 = new ArrayList<>();
    public static ArrayList<Integer> R10 = new ArrayList<>();
    public static ArrayList<Integer> R11 = new ArrayList<>();
    public static ArrayList<Integer> R12 = new ArrayList<>();
    public static ArrayList<Integer> R13 = new ArrayList<>();
    public static ArrayList<Integer> R14 = new ArrayList<>();
    public static ArrayList<Integer> R15 = new ArrayList<>();
    public static ArrayList<Integer> R16 = new ArrayList<>();
    
    //Arrays de la expansion de las cadenas Ri
    public static ArrayList<Integer> E1 = new ArrayList<>();
    public static ArrayList<Integer> E2 = new ArrayList<>();
    public static ArrayList<Integer> E3 = new ArrayList<>();
    public static ArrayList<Integer> E4 = new ArrayList<>();
    public static ArrayList<Integer> E5 = new ArrayList<>();
    public static ArrayList<Integer> E6 = new ArrayList<>();
    public static ArrayList<Integer> E7 = new ArrayList<>();
    public static ArrayList<Integer> E8 = new ArrayList<>();
    public static ArrayList<Integer> E9 = new ArrayList<>();
    public static ArrayList<Integer> E10 = new ArrayList<>();
    public static ArrayList<Integer> E11 = new ArrayList<>();
    public static ArrayList<Integer> E12 = new ArrayList<>();
    public static ArrayList<Integer> E13 = new ArrayList<>();
    public static ArrayList<Integer> E14 = new ArrayList<>();
    public static ArrayList<Integer> E15 = new ArrayList<>();
    public static ArrayList<Integer> E16 = new ArrayList<>();
    
     //Creacion de los S-Box
    public String [][] S_B1 = new String [4][16];
    public String [][] S_B2 = new String [4][16];
    public String [][] S_B3 = new String [4][16];
    public String [][] S_B4 = new String [4][16];
    public String [][] S_B5 = new String [4][16];
    public String [][] S_B6 = new String [4][16];
    public String [][] S_B7 = new String [4][16];
    public String [][] S_B8 = new String [4][16];
    
    public static String mensajeCifrado= new String("");
    
    /*Este objeto cifra el mensaje a partir de las llaves ya creadas
    Falta crear la ultima permutacion, y revisar las excepciones*/
    public Cifrar (String texto, String llave){
        this.texto = texto;
        this.llave = llave;
        ArrayList<Integer> bloquesC = new ArrayList<Integer>();
        //creacion del objeto que contiene las llaves
        crearLlaves = new CrearLlaves(llave);
        ConvertHexa convertBits = new ConvertHexa(texto);
        text = convertBits.getBits();
        if (text.size() > 64){
            Iterator<Integer> nombreIterator = text.iterator();
            int contador=0;
            while(nombreIterator.hasNext()){
                Integer elemento = nombreIterator.next();
                bloquesC.add(elemento);
                contador++;
                if((contador%64)==0||!nombreIterator.hasNext()){
                    cifrarTextos64(bloquesC, llave);
                    //System.out.println("output  "+mensajeCifrado);
                    bloquesC.clear();
                    L0.clear();L1.clear();L2.clear();L3.clear();L4.clear();
                    L5.clear();L6.clear();L7.clear();L8.clear();L9.clear();
                    L9.clear();L10.clear();L11.clear();L12.clear();L13.clear();
                    L14.clear();L15.clear();L16.clear();
                    
                    R0.clear();R1.clear();R2.clear();R3.clear();R4.clear();
                    R5.clear();R6.clear();R7.clear();R8.clear();R9.clear();
                    R9.clear();R10.clear();R11.clear();R12.clear();R13.clear();
                    R14.clear();R15.clear();R16.clear();
                    
                    E1.clear();E2.clear();E3.clear();E4.clear();
                    E5.clear();E6.clear();E7.clear();E8.clear();E9.clear();
                    E9.clear();E10.clear();E11.clear();E12.clear();E13.clear();
                    E14.clear();E15.clear();E16.clear();
                    
                    S_B1 = new String [4][16];
                    S_B2 = new String [4][16];
                    S_B3 = new String [4][16];
                    S_B4 = new String [4][16];
                    S_B5 = new String [4][16];
                    S_B6 = new String [4][16];
                    S_B7 = new String [4][16];
                    S_B8 = new String [4][16]; 

                }
            }
        }else{
            cifrarTextos64(text, llave);
        }
        
    }
    
    private void cifrarTextos64(ArrayList<Integer> texto, String llave){
        
        //Creacion de los S-Box
        iniciarS_Box();
        //se crean bloques de 64 bits
        crearBloques(texto);
        //se hacen los 16 rounds
        creacionSubcadenas();
        //Se aplica la inversa de IP
        IPinv(R16, L16);
//        System.out.println("");
//        System.out.println("cypherTp"+cyphertext);
//        System.out.println("");
        mensajeCifrado=mensajeCifrado+ConvertToText.toText(cyphertext);
        
    }
    //Se crean bloques de 64 bits, para mensajeCifrados largos
    private void crearBloques(ArrayList<Integer> text){
        while (!text.isEmpty()) {
            
            if (text.size() <= 64){
                int dif = 64 - text.size();
                for (int i = 0; i < dif; i++){
                    text.add(0);
                }
            }else{
                System.out.print("Que mensajeCifrado tan largo!!!");
                System.exit(0);
            }
            
            for (int i = 0; i < 64; i ++){
                bloque.add(text.remove(0));
                
            }
            //Se aplica IP
            IP(bloque);
            //Creacion de L0 y R0
            L0.addAll(bloqueIP.subList(0, 32));
            R0.addAll(bloqueIP.subList(32, bloqueIP.size()));
            
        }
        
        
    }
    
    private void IP (ArrayList<Integer> bloque){
        bloqueIP = new ArrayList<>();
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
    
    private void IPinv (ArrayList<Integer> bloqueIzq, ArrayList<Integer> bloqueDer){
        ArrayList<Integer> bloque = new ArrayList<>();
        bloque.addAll(bloqueIzq);
        bloque.addAll(bloqueDer);
        cyphertext = new ArrayList<>();
        cyphertext.add(bloque.get(40-1));
        cyphertext.add(bloque.get(8-1));
        cyphertext.add(bloque.get(48-1));
        cyphertext.add(bloque.get(16-1));
        cyphertext.add(bloque.get(56-1));
        cyphertext.add(bloque.get(24-1));
        cyphertext.add(bloque.get(64-1));
        cyphertext.add(bloque.get(32-1));
        cyphertext.add(bloque.get(39-1));
        cyphertext.add(bloque.get(7-1));
        cyphertext.add(bloque.get(47-1));
        cyphertext.add(bloque.get(15-1));
        cyphertext.add(bloque.get(55-1));
        cyphertext.add(bloque.get(23-1));
        cyphertext.add(bloque.get(63-1));
        cyphertext.add(bloque.get(31-1));
        cyphertext.add(bloque.get(38-1));
        cyphertext.add(bloque.get(6-1));
        cyphertext.add(bloque.get(46-1));
        cyphertext.add(bloque.get(14-1));
        cyphertext.add(bloque.get(54-1));
        cyphertext.add(bloque.get(22-1));
        cyphertext.add(bloque.get(62-1));
        cyphertext.add(bloque.get(30-1));
        cyphertext.add(bloque.get(37-1));
        cyphertext.add(bloque.get(5-1));
        cyphertext.add(bloque.get(45-1));
        cyphertext.add(bloque.get(13-1));
        cyphertext.add(bloque.get(53-1));
        cyphertext.add(bloque.get(21-1));
        cyphertext.add(bloque.get(61-1));
        cyphertext.add(bloque.get(29-1));
        cyphertext.add(bloque.get(36-1));
        cyphertext.add(bloque.get(4-1));
        cyphertext.add(bloque.get(44-1));
        cyphertext.add(bloque.get(12-1));
        cyphertext.add(bloque.get(52-1));
        cyphertext.add(bloque.get(20-1));
        cyphertext.add(bloque.get(60-1));
        cyphertext.add(bloque.get(28-1));
        cyphertext.add(bloque.get(35-1));
        cyphertext.add(bloque.get(3-1));
        cyphertext.add(bloque.get(43-1));
        cyphertext.add(bloque.get(11-1));
        cyphertext.add(bloque.get(51-1));
        cyphertext.add(bloque.get(19-1));
        cyphertext.add(bloque.get(59-1));
        cyphertext.add(bloque.get(27-1));
        cyphertext.add(bloque.get(34-1));
        cyphertext.add(bloque.get(2-1));
        cyphertext.add(bloque.get(42-1));
        cyphertext.add(bloque.get(10-1));
        cyphertext.add(bloque.get(50-1));
        cyphertext.add(bloque.get(18-1));
        cyphertext.add(bloque.get(58-1));
        cyphertext.add(bloque.get(26-1));
        cyphertext.add(bloque.get(33-1));
        cyphertext.add(bloque.get(1-1));
        cyphertext.add(bloque.get(41-1));
        cyphertext.add(bloque.get(9-1));
        cyphertext.add(bloque.get(49-1));
        cyphertext.add(bloque.get(17-1));
        cyphertext.add(bloque.get(57-1));
        cyphertext.add(bloque.get(25-1));
    }
    
    private void creacionSubcadenas(){
        L1 = R0;
        //System.out.println("R0 = " + R0);
        E1 = expansion(R0);
        R1 = XOR(L0, innerFunction(XOR(crearLlaves.k1, E1)));
        L2 = R1;
        E2 = expansion(R1);
        R2 = XOR(L1, innerFunction(XOR(crearLlaves.k2, E2)));
        L3 = R2;
        E3 = expansion(R2);
        R3 = XOR(L2, innerFunction(XOR(crearLlaves.k3, E3)));
        L4 = R3;
        E4 = expansion(R3);
        R4 = XOR(L3, innerFunction(XOR(crearLlaves.k4, E4)));
        L5 = R4;
        E5 = expansion(R4);
        R5 = XOR(L4, innerFunction(XOR(crearLlaves.k5, E5)));
        L6 = R5;
        E6 = expansion(R5);
        R6 = XOR(L5, innerFunction(XOR(crearLlaves.k6, E6)));
        L7 = R6;
        E7 = expansion(R6);
        R7 = XOR(L6, innerFunction(XOR(crearLlaves.k7, E7)));
        L8 = R7;
        E8 = expansion(R7);
        R8 = XOR(L7, innerFunction(XOR(crearLlaves.k8, E8)));
        L9 = R8;
        E9 = expansion(R8);
        R9 = XOR(L8, innerFunction(XOR(crearLlaves.k9, E9)));
        L10 = R9;
        E10 = expansion(R9);
        R10 = XOR(L9, innerFunction(XOR(crearLlaves.k10, E10)));
        L11 = R10;
        E11 = expansion(R10);
        R11 = XOR(L10, innerFunction(XOR(crearLlaves.k11, E11)));
        L12 = R11;
        E12 = expansion(R11);
        R12 = XOR(L11, innerFunction(XOR(crearLlaves.k12, E12)));
        L13 = R12;
        E13 = expansion(R12);
        R13 = XOR(L12, innerFunction(XOR(crearLlaves.k13, E13)));
        L14 = R13;
        E14 = expansion(R13);
        R14 = XOR(L13, innerFunction(XOR(crearLlaves.k14, E14)));
        L15 = R14;
        E15 = expansion(R14);
        R15 = XOR(L14, innerFunction(XOR(crearLlaves.k15, E15)));
        L16 = R15;
        E16 = expansion(R15);
        R16 = XOR(L15, innerFunction(XOR(crearLlaves.k16, E16)));
        
    }
    
    private ArrayList<Integer> innerFunction(ArrayList<Integer> Ri_1){
        ArrayList<Integer> Bi = new ArrayList<>();
        ArrayList<Integer> tempo = new ArrayList<>();
        //Este ciclo genera los Bi para la entrada, recorriendo toda la lista
        //y llamando a la funcion que devuelve los Si cada 6 valores
        for (int i = 0; i < Ri_1.size(); i++){
            Bi.add(Ri_1.get(i));
            if (i == 5){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 11){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 17){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 23){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 29){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 35){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 41){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
            if (i == 47){
                tempo.addAll(buscar(Bi, i));
                Bi.clear();
            }
        }
        return perI(tempo);
    }
    
    private ArrayList<Integer> XOR (ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> tempo = new ArrayList<>();
        for (int i = 0; i < A.size(); i++){
            if (A.get(i).equals(B.get(i))){
                tempo.add(0);
            }
            else {
                tempo.add(1);
            }
        }
        return tempo;
    }
    
    private ArrayList<Integer> expansion (ArrayList<Integer> Ri){
        ArrayList<Integer> tempo = new ArrayList<>();
        tempo.add(Ri.get(32-1));
        tempo.add(Ri.get(1-1));
        tempo.add(Ri.get(2-1));
        tempo.add(Ri.get(3-1));
        tempo.add(Ri.get(4-1));
        tempo.add(Ri.get(5-1));
        tempo.add(Ri.get(4-1));
        tempo.add(Ri.get(5-1));
        tempo.add(Ri.get(6-1));
        tempo.add(Ri.get(7-1));
        tempo.add(Ri.get(8-1));
        tempo.add(Ri.get(9-1));
        tempo.add(Ri.get(8-1));
        tempo.add(Ri.get(9-1));
        tempo.add(Ri.get(10-1));
        tempo.add(Ri.get(11-1));
        tempo.add(Ri.get(12-1));
        tempo.add(Ri.get(13-1));
        tempo.add(Ri.get(12-1));
        tempo.add(Ri.get(13-1));
        tempo.add(Ri.get(14-1));
        tempo.add(Ri.get(15-1));
        tempo.add(Ri.get(16-1));
        tempo.add(Ri.get(17-1));
        tempo.add(Ri.get(16-1));
        tempo.add(Ri.get(17-1));
        tempo.add(Ri.get(18-1));
        tempo.add(Ri.get(19-1));
        tempo.add(Ri.get(20-1));
        tempo.add(Ri.get(21-1));
        tempo.add(Ri.get(20-1));
        tempo.add(Ri.get(21-1));
        tempo.add(Ri.get(22-1));
        tempo.add(Ri.get(23-1));
        tempo.add(Ri.get(24-1));
        tempo.add(Ri.get(25-1));
        tempo.add(Ri.get(24-1));
        tempo.add(Ri.get(25-1));
        tempo.add(Ri.get(26-1));
        tempo.add(Ri.get(27-1));
        tempo.add(Ri.get(28-1));
        tempo.add(Ri.get(29-1));
        tempo.add(Ri.get(28-1));
        tempo.add(Ri.get(29-1));
        tempo.add(Ri.get(30-1));
        tempo.add(Ri.get(31-1));
        tempo.add(Ri.get(32-1));
        tempo.add(Ri.get(1-1));
        return tempo;
        
    }
    
    private void iniciarS_Box(){
        
        //Primera tabla
        S_B1[0][0] = "1110";//14
        S_B1[0][1] = "0100";//4
        S_B1[0][2] = "1101";//13
        S_B1[0][3] = "0001";//1
        S_B1[0][4] = "0010";//2
        S_B1[0][5] = "1111";//15
        S_B1[0][6] = "1011";//11
        S_B1[0][7] = "1000";//8
        S_B1[0][8] = "0011";//3
        S_B1[0][9] = "1010";//10
        S_B1[0][10] = "0110";//6
        S_B1[0][11] = "1100";//12
        S_B1[0][12] = "0101";//5
        S_B1[0][13] = "1001";//9
        S_B1[0][14] = "0000";//0
        S_B1[0][15] = "0111";//7
        
        S_B1[1][0] = "0000";//0
        S_B1[1][1] = "1111";//15
        S_B1[1][2] = "0111";//7
        S_B1[1][3] = "0100";//4
        S_B1[1][4] = "1110";//14
        S_B1[1][5] = "0010";//2
        S_B1[1][6] = "1101";//13
        S_B1[1][7] = "0001";//1
        S_B1[1][8] = "1010";//10
        S_B1[1][9] = "0110";//6
        S_B1[1][10] = "1100";//12
        S_B1[1][11] = "1011";//11
        S_B1[1][12] = "1001";//9
        S_B1[1][13] = "0101";//5
        S_B1[1][14] = "0011";//3
        S_B1[1][15] = "1000";//8
        
        S_B1[2][0] = "0100";//4
        S_B1[2][1] = "0001";//1
        S_B1[2][2] = "1110";//14
        S_B1[2][3] = "1000";//8
        S_B1[2][4] = "1101";//13
        S_B1[2][5] = "0110";//6
        S_B1[2][6] = "0010";//2
        S_B1[2][7] = "1011";//11
        S_B1[2][8] = "1111";//15
        S_B1[2][9] = "1100";//12
        S_B1[2][10] = "1001";//9
        S_B1[2][11] = "0111";//7
        S_B1[2][12] = "0011";//3
        S_B1[2][13] = "1010";//10
        S_B1[2][14] = "0101";//5
        S_B1[2][15] = "0000";//0
        
        S_B1[3][0] = "1111";//15
        S_B1[3][1] = "1100";//12
        S_B1[3][2] = "1000";//8
        S_B1[3][3] = "0010";//2
        S_B1[3][4] = "0100";//4
        S_B1[3][5] = "1001";//9
        S_B1[3][6] = "0001";//1
        S_B1[3][7] = "0111";//7
        S_B1[3][8] = "0101";//5
        S_B1[3][9] = "1011";//11
        S_B1[3][10] = "0011";//3
        S_B1[3][11] = "1110";//14
        S_B1[3][12] = "1010";//10
        S_B1[3][13] = "0000";//0
        S_B1[3][14] = "0110";//6
        S_B1[3][15] = "1101";//13
               
        //Segunda tabla
        S_B2[0][0] = "1111";//15
        S_B2[0][1] = "0001";//1
        S_B2[0][2] = "1000";//8
        S_B2[0][3] = "1110";//14
        S_B2[0][4] = "0110";//6
        S_B2[0][5] = "1011";//11
        S_B2[0][6] = "0011";//3
        S_B2[0][7] = "0100";//4
        S_B2[0][8] = "1001";//9
        S_B2[0][9] = "0111";//7
        S_B2[0][10] = "0010";//2
        S_B2[0][11] = "1101";//13
        S_B2[0][12] = "1100";//12
        S_B2[0][13] = "0000";//0
        S_B2[0][14] = "0101";//5
        S_B2[0][15] = "1010";//10
        
        S_B2[1][0] = "0011";//3
        S_B2[1][1] = "1101";//13
        S_B2[1][2] = "0100";//4
        S_B2[1][3] = "0111";//7
        S_B2[1][4] = "1111";//15
        S_B2[1][5] = "0010";//2
        S_B2[1][6] = "1000";//8
        S_B2[1][7] = "1110";//14
        S_B2[1][8] = "1100";//12
        S_B2[1][9] = "0000";//0
        S_B2[1][10] = "0001";//1
        S_B2[1][11] = "1010";//10
        S_B2[1][12] = "0110";//6
        S_B2[1][13] = "1001";//9
        S_B2[1][14] = "1011";//11
        S_B2[1][15] = "0101";//5
        
        S_B2[2][0] = "0000";//0
        S_B2[2][1] = "1110";//14
        S_B2[2][2] = "0111";//7
        S_B2[2][3] = "1011";//11
        S_B2[2][4] = "1010";//10
        S_B2[2][5] = "0100";//4
        S_B2[2][6] = "1101";//13
        S_B2[2][7] = "0001";//1
        S_B2[2][8] = "0101";//5
        S_B2[2][9] = "1000";//8
        S_B2[2][10] = "1100";//12
        S_B2[2][11] = "0110";//6
        S_B2[2][12] = "1001";//9
        S_B2[2][13] = "0011";//3
        S_B2[2][14] = "0010";//2
        S_B2[2][15] = "1111";//15
        
        S_B2[3][0] = "1101";//13
        S_B2[3][1] = "1000";//8
        S_B2[3][2] = "1010";//10
        S_B2[3][3] = "0001";//1
        S_B2[3][4] = "0011";//3
        S_B2[3][5] = "1111";//15
        S_B2[3][6] = "0100";//4
        S_B2[3][7] = "0010";//2
        S_B2[3][8] = "1011";//11
        S_B2[3][9] = "0110";//6
        S_B2[3][10] = "0111";//7
        S_B2[3][11] = "1100";//12
        S_B2[3][12] = "0000";//0
        S_B2[3][13] = "0101";//5
        S_B2[3][14] = "1110";//14
        S_B2[3][15] = "1001";//9
        
        //Tercera tabla
        S_B3[0][0] = "1010";//10
        S_B3[0][1] = "0000";//0
        S_B3[0][2] = "1001";//9
        S_B3[0][3] = "1110";//14
        S_B3[0][4] = "0110";//6
        S_B3[0][5] = "0011";//3
        S_B3[0][6] = "1111";//15
        S_B3[0][7] = "0101";//5
        S_B3[0][8] = "0001";//1
        S_B3[0][9] = "1101";//13
        S_B3[0][10] = "1100";//12
        S_B3[0][11] = "0111";//7
        S_B3[0][12] = "1011";//11
        S_B3[0][13] = "0100";//4
        S_B3[0][14] = "0010";//2
        S_B3[0][15] = "1000";//8
        
        S_B3[1][0] = "1101";//13
        S_B3[1][1] = "0111";//7
        S_B3[1][2] = "0000";//0
        S_B3[1][3] = "1001";//9
        S_B3[1][4] = "0011";//3
        S_B3[1][5] = "0100";//4
        S_B3[1][6] = "0110";//6
        S_B3[1][7] = "1010";//10
        S_B3[1][8] = "0010";//2
        S_B3[1][9] = "1000";//8
        S_B3[1][10] = "0101";//5
        S_B3[1][11] = "1110";//14
        S_B3[1][12] = "1100";//12
        S_B3[1][13] = "1011";//11
        S_B3[1][14] = "1111";//15
        S_B3[1][15] = "0001";//1
        
        S_B3[2][0] = "1101";//13
        S_B3[2][1] = "0110";//6
        S_B3[2][2] = "0100";//4
        S_B3[2][3] = "1001";//9
        S_B3[2][4] = "1000";//8
        S_B3[2][5] = "1111";//15
        S_B3[2][6] = "0011";//3
        S_B3[2][7] = "0000";//0
        S_B3[2][8] = "1011";//11
        S_B3[2][9] = "0001";//1
        S_B3[2][10] = "0010";//2
        S_B3[2][11] = "1100";//12
        S_B3[2][12] = "0101";//5
        S_B3[2][13] = "1010";//10
        S_B3[2][14] = "1110";//14
        S_B3[2][15] = "0111";//7
        
        S_B3[3][0] = "0001";//1
        S_B3[3][1] = "1010";//10
        S_B3[3][2] = "1101";//13
        S_B3[3][3] = "0000";//0
        S_B3[3][4] = "0110";//6
        S_B3[3][5] = "1001";//9
        S_B3[3][6] = "1000";//8
        S_B3[3][7] = "0111";//7
        S_B3[3][8] = "0100";//4
        S_B3[3][9] = "1111";//15
        S_B3[3][10] = "1110";//14
        S_B3[3][11] = "0011";//3
        S_B3[3][12] = "1011";//11
        S_B3[3][13] = "0101";//5
        S_B3[3][14] = "0010";//2
        S_B3[3][15] = "1100";//12
        
        //Cuarta tabla
        S_B4[0][0] = "0111";//7
        S_B4[0][1] = "1101";//13
        S_B4[0][2] = "1110";//14
        S_B4[0][3] = "0011";//3
        S_B4[0][4] = "0000";//0
        S_B4[0][5] = "0110";//6
        S_B4[0][6] = "1001";//9
        S_B4[0][7] = "1010";//10
        S_B4[0][8] = "0001";//1
        S_B4[0][9] = "0010";//2
        S_B4[0][10] = "1000";//8
        S_B4[0][11] = "0101";//5
        S_B4[0][12] = "1011";//11
        S_B4[0][13] = "1100";//12
        S_B4[0][14] = "0100";//4
        S_B4[0][15] = "1111";//15
        
        S_B4[1][0] = "1101";//13
        S_B4[1][1] = "1000";//8
        S_B4[1][2] = "1011";//11
        S_B4[1][3] = "0101";//5
        S_B4[1][4] = "0110";//6
        S_B4[1][5] = "1111";//15
        S_B4[1][6] = "0000";//0
        S_B4[1][7] = "0011";//3
        S_B4[1][8] = "0100";//4
        S_B4[1][9] = "0111";//7
        S_B4[1][10] = "0010";//2
        S_B4[1][11] = "1100";//12
        S_B4[1][12] = "0001";//1
        S_B4[1][13] = "1010";//10
        S_B4[1][14] = "1110";//14
        S_B4[1][15] = "1001";//9
        
        S_B4[2][0] = "1010";//10
        S_B4[2][1] = "0110";//6
        S_B4[2][2] = "1001";//9
        S_B4[2][3] = "0000";//0
        S_B4[2][4] = "1100";//12
        S_B4[2][5] = "1011";//11
        S_B4[2][6] = "0111";//7
        S_B4[2][7] = "1101";//13
        S_B4[2][8] = "1111";//15
        S_B4[2][9] = "0001";//1
        S_B4[2][10] = "0011";//3
        S_B4[2][11] = "1110";//14
        S_B4[2][12] = "0101";//5
        S_B4[2][13] = "0010";//2
        S_B4[2][14] = "1000";//8
        S_B4[2][15] = "0100";//4
        
        S_B4[3][0] = "0011";//3
        S_B4[3][1] = "1111";//15
        S_B4[3][2] = "0000";//0
        S_B4[3][3] = "0110";//6
        S_B4[3][4] = "1010";//10
        S_B4[3][5] = "0001";//1
        S_B4[3][6] = "1101";//13
        S_B4[3][7] = "1000";//8
        S_B4[3][8] = "1001";//9
        S_B4[3][9] = "0100";//4
        S_B4[3][10] = "0101";//5
        S_B4[3][11] = "1011";//11
        S_B4[3][12] = "1100";//12
        S_B4[3][13] = "0111";//7
        S_B4[3][14] = "0010";//2
        S_B4[3][15] = "1110";//14
        
        //Quinta Tabla 
        S_B5[0][0] = "0010";
        S_B5[0][1] = "1100";
        S_B5[0][2] = "0100";
        S_B5[0][3] = "0001";
        S_B5[0][4] = "0111";
        S_B5[0][5] = "1010";
        S_B5[0][6] = "1011";
        S_B5[0][7] = "0110";
        S_B5[0][8] = "1000";
        S_B5[0][9] = "0101";
        S_B5[0][10] = "0011";
        S_B5[0][11] = "1111";
        S_B5[0][12] = "1101";
        S_B5[0][13] = "0000";
        S_B5[0][14] = "1110";
        S_B5[0][15] = "1001";
        
        S_B5[1][0] = "1110";
        S_B5[1][1] = "1011";
        S_B5[1][2] = "0010";
        S_B5[1][3] = "1100";
        S_B5[1][4] = "0100";
        S_B5[1][5] = "0111";
        S_B5[1][6] = "1101";
        S_B5[1][7] = "0001";
        S_B5[1][8] = "0101";
        S_B5[1][9] = "0000";
        S_B5[1][10] = "1111";
        S_B5[1][11] = "1010";
        S_B5[1][12] = "0011";
        S_B5[1][13] = "1001";
        S_B5[1][14] = "1000";
        S_B5[1][15] = "0110";
        
        S_B5[2][0] = "0100";
        S_B5[2][1] = "0010";
        S_B5[2][2] = "0001";
        S_B5[2][3] = "1011";
        S_B5[2][4] = "1010";
        S_B5[2][5] = "1101";
        S_B5[2][6] = "0111";
        S_B5[2][7] = "1000";
        S_B5[2][8] = "1111";
        S_B5[2][9] = "1001";
        S_B5[2][10] = "1100";
        S_B5[2][11] = "0101";
        S_B5[2][12] = "0110";
        S_B5[2][13] = "0011";
        S_B5[2][14] = "0000";
        S_B5[2][15] = "1110";
        
        S_B5[3][0] = "1011";
        S_B5[3][1] = "1000";
        S_B5[3][2] = "1100";
        S_B5[3][3] = "0111";
        S_B5[3][4] = "0001";
        S_B5[3][5] = "1110";
        S_B5[3][6] = "0010";
        S_B5[3][7] = "1101";
        S_B5[3][8] = "0110";
        S_B5[3][9] = "1111";
        S_B5[3][10] = "0000";
        S_B5[3][11] = "1001";
        S_B5[3][12] = "1010";
        S_B5[3][13] = "0100";
        S_B5[3][14] = "0101";
        S_B5[3][15] = "0011";
        
        //Sexta tabla
        S_B6[0][0] = "1100";
        S_B6[0][1] = "0001";
        S_B6[0][2] = "1010";
        S_B6[0][3] = "1111";
        S_B6[0][4] = "1001";
        S_B6[0][5] = "0010";
        S_B6[0][6] = "0110";
        S_B6[0][7] = "1000";
        S_B6[0][8] = "0000";
        S_B6[0][9] = "1101";
        S_B6[0][10] = "0011";
        S_B6[0][11] = "0100";
        S_B6[0][12] = "1110";
        S_B6[0][13] = "0111";
        S_B6[0][14] = "0101";
        S_B6[0][15] = "1011";
        
        S_B6[1][0] = "1010";
        S_B6[1][1] = "1111";
        S_B6[1][2] = "0100";
        S_B6[1][3] = "0010";
        S_B6[1][4] = "0111";
        S_B6[1][5] = "1100";
        S_B6[1][6] = "1001";
        S_B6[1][7] = "0101";
        S_B6[1][8] = "0110";
        S_B6[1][9] = "0001";
        S_B6[1][10] = "1101";
        S_B6[1][11] = "1110";
        S_B6[1][12] = "0000";
        S_B6[1][13] = "1011";
        S_B6[1][14] = "0011";
        S_B6[1][15] = "1000";
        
        S_B6[2][0] = "1001";
        S_B6[2][1] = "1110";
        S_B6[2][2] = "1111";
        S_B6[2][3] = "0101";
        S_B6[2][4] = "0010";
        S_B6[2][5] = "1000";
        S_B6[2][6] = "1100";
        S_B6[2][7] = "0011";
        S_B6[2][8] = "0111";
        S_B6[2][9] = "0000";
        S_B6[2][10] = "0100";
        S_B6[2][11] = "1010";
        S_B6[2][12] = "0001";
        S_B6[2][13] = "1101";
        S_B6[2][14] = "1011";
        S_B6[2][15] = "0110";
        
        S_B6[3][0] = "0100";
        S_B6[3][1] = "0011";
        S_B6[3][2] = "0010";
        S_B6[3][3] = "1100";
        S_B6[3][4] = "1001";
        S_B6[3][5] = "0101";
        S_B6[3][6] = "1111";
        S_B6[3][7] = "1010";
        S_B6[3][8] = "1011";
        S_B6[3][9] = "1110";
        S_B6[3][10] = "0001";
        S_B6[3][11] = "0111";
        S_B6[3][12] = "0110";
        S_B6[3][13] = "0000";
        S_B6[3][14] = "1000";
        S_B6[3][15] = "1101";
        
        //Septima tabla
        S_B7[0][0] = "0100";
        S_B7[0][1] = "1011";
        S_B7[0][2] = "0010";
        S_B7[0][3] = "1110";
        S_B7[0][4] = "1111";
        S_B7[0][5] = "0000";
        S_B7[0][6] = "1000";
        S_B7[0][7] = "1101";
        S_B7[0][8] = "0011";
        S_B7[0][9] = "1100";
        S_B7[0][10] = "1001";
        S_B7[0][11] = "0111";
        S_B7[0][12] = "0101";
        S_B7[0][13] = "1010";
        S_B7[0][14] = "0110";
        S_B7[0][15] = "0001";
        
        S_B7[1][0] = "1101";
        S_B7[1][1] = "0000";
        S_B7[1][2] = "1011";
        S_B7[1][3] = "0111";
        S_B7[1][4] = "0100";
        S_B7[1][5] = "1001";
        S_B7[1][6] = "0001";
        S_B7[1][7] = "1010";
        S_B7[1][8] = "1110";
        S_B7[1][9] = "0011";
        S_B7[1][10] = "0101";
        S_B7[1][11] = "1100";
        S_B7[1][12] = "0010";
        S_B7[1][13] = "1111";
        S_B7[1][14] = "1000";
        S_B7[1][15] = "0110";
        
        S_B7[2][0] = "0001";
        S_B7[2][1] = "0100";
        S_B7[2][2] = "1011";
        S_B7[2][3] = "1101";
        S_B7[2][4] = "1100";
        S_B7[2][5] = "0011";
        S_B7[2][6] = "0111";
        S_B7[2][7] = "1110";
        S_B7[2][8] = "1010";
        S_B7[2][9] = "1111";
        S_B7[2][10] = "0110";
        S_B7[2][11] = "1000";
        S_B7[2][12] = "0000";
        S_B7[2][13] = "0101";
        S_B7[2][14] = "1001";
        S_B7[2][15] = "0010";
        
        S_B7[3][0] = "0110";
        S_B7[3][1] = "1011";
        S_B7[3][2] = "1101";
        S_B7[3][3] = "1000";
        S_B7[3][4] = "0001";
        S_B7[3][5] = "0100";
        S_B7[3][6] = "1010";
        S_B7[3][7] = "0111";
        S_B7[3][8] = "1001";
        S_B7[3][9] = "0101";
        S_B7[3][10] = "0000";
        S_B7[3][11] = "1111";
        S_B7[3][12] = "1110";
        S_B7[3][13] = "0010";
        S_B7[3][14] = "0011";
        S_B7[3][15] = "1100";
        
        //Octava tabla
        S_B8[0][0] = "1101";
        S_B8[0][1] = "0010";
        S_B8[0][2] = "1000";
        S_B8[0][3] = "0100";
        S_B8[0][4] = "0110";
        S_B8[0][5] = "1111";
        S_B8[0][6] = "1011";
        S_B8[0][7] = "0001";
        S_B8[0][8] = "1010";
        S_B8[0][9] = "1001";
        S_B8[0][10] = "0011";
        S_B8[0][11] = "1110";
        S_B8[0][12] = "0101";
        S_B8[0][13] = "0000";
        S_B8[0][14] = "1100";
        S_B8[0][15] = "0111";
        
        S_B8[1][0] = "0001";
        S_B8[1][1] = "1111";
        S_B8[1][2] = "1101";
        S_B8[1][3] = "1000";
        S_B8[1][4] = "1010";
        S_B8[1][5] = "0011";
        S_B8[1][6] = "0111";
        S_B8[1][7] = "0100";
        S_B8[1][8] = "1100";
        S_B8[1][9] = "0101";
        S_B8[1][10] = "0110";
        S_B8[1][11] = "1011";
        S_B8[1][12] = "0000";
        S_B8[1][13] = "1110";
        S_B8[1][14] = "1001";
        S_B8[1][15] = "0010";
        
        S_B8[2][0] = "0111";
        S_B8[2][1] = "1011";
        S_B8[2][2] = "0100";
        S_B8[2][3] = "0001";
        S_B8[2][4] = "1001";
        S_B8[2][5] = "1100";
        S_B8[2][6] = "1110";
        S_B8[2][7] = "0010";
        S_B8[2][8] = "0000";
        S_B8[2][9] = "0110";
        S_B8[2][10] = "1010";
        S_B8[2][11] = "1101";
        S_B8[2][12] = "1111";
        S_B8[2][13] = "0011";
        S_B8[2][14] = "0101";
        S_B8[2][15] = "1000";
        
        S_B8[3][0] = "0010";
        S_B8[3][1] = "0001";
        S_B8[3][2] = "1110";
        S_B8[3][3] = "0111";
        S_B8[3][4] = "0100";
        S_B8[3][5] = "1010";
        S_B8[3][6] = "1000";
        S_B8[3][7] = "1101";
        S_B8[3][8] = "1111";
        S_B8[3][9] = "1100";
        S_B8[3][10] = "1001";
        S_B8[3][11] = "0000";
        S_B8[3][12] = "0011";
        S_B8[3][13] = "0101";
        S_B8[3][14] = "0110";
        S_B8[3][15] = "1011";
        
    }
    
    //Sirve para buscar en las tablas anteriormente creadas
    private ArrayList<Integer> buscar(ArrayList<Integer> Bi, int tabla){
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        r.add(Bi.get(0));
        r.add(Bi.get(Bi.size()-1));
        c.add(Bi.get(1));
        c.add(Bi.get(2));
        c.add(Bi.get(3));
        c.add(Bi.get(4));
        
        //Se convierten los numeros r y c a decimal
        int r0 = 0;
        int c0 = 0;
        for (int i = 0; i < r.size(); i++){
            r0 += (int) (r.get(r.size() - 1 - i)*Math.pow(2, i));
        }
        for (int i = 0; i < c.size(); i++){
            c0 += (int) (c.get(c.size() - 1 - i)*Math.pow(2, i));
        }
        //Con los numeros en decimales, se puede buscar en las tablas
        ArrayList<Integer> tempo = new ArrayList<>();
        String resultado = new String();
        //System.out.print(tabla + " ");
        if (tabla == 5){
            resultado = S_B1[r0][c0];
        }
        if (tabla == 11){
            resultado = S_B2[r0][c0];
        }
        if (tabla == 17){
            resultado = S_B3[r0][c0];
        }
        if (tabla == 23){
            resultado = S_B4[r0][c0];
        }
        if (tabla == 29){
            resultado = S_B5[r0][c0];
        }
        if (tabla == 35){
            resultado = S_B6[r0][c0];
        }
        if (tabla == 41){
            resultado = S_B7[r0][c0];
        }
        if (tabla == 47){
            resultado = S_B8[r0][c0];
        }
        //Se convierte el String recuperado a un ArrayList
        for (int i = 0; i < resultado.length(); i++){
            tempo.add(Integer.parseInt("" + resultado.charAt(i)));
        }
        return tempo;
    }
    
    private ArrayList<Integer> perI (ArrayList<Integer> Ci){
        ArrayList<Integer> tempo = new ArrayList<>();
        tempo.add(Ci.get(16-1));
        tempo.add(Ci.get(7-1));
        tempo.add(Ci.get(20-1));
        tempo.add(Ci.get(21-1));
        tempo.add(Ci.get(29-1));
        tempo.add(Ci.get(12-1));
        tempo.add(Ci.get(28-1));
        tempo.add(Ci.get(17-1));
        tempo.add(Ci.get(1-1));
        tempo.add(Ci.get(15-1));
        tempo.add(Ci.get(23-1));
        tempo.add(Ci.get(26-1));
        tempo.add(Ci.get(5-1));
        tempo.add(Ci.get(18-1));
        tempo.add(Ci.get(31-1));
        tempo.add(Ci.get(10-1));
        tempo.add(Ci.get(2-1));
        tempo.add(Ci.get(8-1));
        tempo.add(Ci.get(24-1));
        tempo.add(Ci.get(14-1));
        tempo.add(Ci.get(32-1));
        tempo.add(Ci.get(27-1));
        tempo.add(Ci.get(3-1));
        tempo.add(Ci.get(9-1));
        tempo.add(Ci.get(19-1));
        tempo.add(Ci.get(13-1));
        tempo.add(Ci.get(30-1));
        tempo.add(Ci.get(6-1));
        tempo.add(Ci.get(22-1));
        tempo.add(Ci.get(11-1));
        tempo.add(Ci.get(4-1));
        tempo.add(Ci.get(25-1));
        return tempo;
        
    }
}
