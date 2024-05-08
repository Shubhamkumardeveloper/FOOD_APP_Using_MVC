package com.ty.com.ty.service.implementation;

import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtil {

    private static final String ALGORITHM = "AES";
    private static final String ENCRYPTION_KEY = "ThisIsAStrongKey"; // Change this to a strong and secret key

    public static String encrypt(String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception gracefully in your application
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception gracefully in your application
        }
    }

//    public static void main(String[] args) {
//        String dataToEncrypt = "12345";
//        String encryptedData = encrypt(dataToEncrypt);
//        System.out.println("Encrypted Data: " + encryptedData);
//
//        String decryptedData = decrypt(encryptedData);
//        System.out.println("Decrypted Data: " + decryptedData);
//    }
}
