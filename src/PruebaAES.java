/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
import controladores.AESConstants;
import controladores.AESEncript;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Main class for the AES 128-bit key encryption.
 * <p/>
 * I used this tutorial for the implementation details:
 * http://cboard.cprogramming.com/c-programming/87805-%5Btutorial%5D-implementing-advanced-encryption-standard.html
 * <p/>
 * Java bytes are signed so I work with chars instead.
 *
 * @author Johan Stenberg <jostenbe@kth.se>
 */
public class PruebaAES {

    /**
     * Encrypts the plaintext with the provided key and then
     * prints it.
     *
     * @param key       The key to be used.
     * @param plainText The plaintext to be encrypted.
     */ 
   private static void solve(char[] key, char[] plainText) {
        AESEncript.fillInitialStateMatrix(plainText);

        byte[] encryption = AESEncript.AES(key);
        try {
            System.out.write(encryption);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Main method.
     *
     * @param args Not used.
     * @throws Throwable Not used.
     */
    public static void main(String... args) throws Throwable {
        InputStream bufferedInputStream = new BufferedInputStream(System.in);
        boolean hasKey = false;
        char[] key = new char[AESConstants.BLOCK_LENGTH];
        byte[] bytes;
        while (true) {
            bytes = new byte[AESConstants.BLOCK_LENGTH];
            int next = bufferedInputStream.read(bytes);
            if (next == -1) break;
            char[] input = AESEncript.byteArrayToCharArray(bytes);

            if (!hasKey) {
                for (int i = 0; i < input.length; ++i) {
                    key[i] = input[i];
                }
                hasKey = true;
            } else {
                solve(key, input);
            }
        }
    }
}
