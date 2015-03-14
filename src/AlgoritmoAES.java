/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
import controladores.*;

public class AlgoritmoAES {

    public static void main(String[] args) {
        AESKey aesKey = new AESKey();

        AESEncriptacion tmp = new AESEncriptacion(aesKey);
        //aesKey = tmp.generaKey();
        aesKey.setEncoded("578114608993759586211708211836505");
        AESEncriptacion ejemplo = new AESEncriptacion(aesKey);

        String encriptado = ejemplo.encripta("AES es muy facil");
        String desencriptado = ejemplo.desencriptar(encriptado);

        System.out.println(encriptado);
        System.out.println(desencriptado);
    }
}
