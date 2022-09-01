/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionPostsgresql;

import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Embebidos
 */
public class encrypt implements Serializable {
    private static final long SerialVersionUID = 5486865543976730876L;
    private static final String key ="08wr?-Swobb5oscary51embebi32¡&6$";
    private static final String saLt ="W5&$0-'&543fgvw#4s-XDlandin-1$&M";
    private SecretKey SecretKeyTemp;
    
    public encrypt(){
        SecretKeyFactory secretKeyFactory;
        KeySpec keySpec;
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            keySpec = new PBEKeySpec(key.toCharArray(), saLt.getBytes(),65536,256);
            SecretKeyTemp = secretKeyFactory.generateSecret(keySpec);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    public String getAES(String data){
        byte[] iv = new byte[16];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(SecretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    public String getAESDecrypt(String data){
        byte[] iv = new byte[16]; 
        
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(SecretKeyTemp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        encrypt encrypt = new encrypt();
        //System.out.println(encrypt.getAES("hola"));
        System.out.println(encrypt.getAESDecrypt("fezP//N2qK7RLlhSzJfFZw=="));
    }
}
