/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ism.cdsd.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ousmane3ndiaye
 */
public class TestRSA {
    
    public static void main(String[] args) throws Exception, NoSuchPaddingException {
        KeyPairGenerator kp=KeyPairGenerator.getInstance("RSA");
        kp.initialize(1024);
        KeyPair keypair = kp.generateKeyPair();
        PublicKey pu = keypair.getPublic();
        PrivateKey priv = keypair.getPrivate();
        
        System.out.println(Base64.getEncoder().encodeToString(pu.getEncoded()));
        System.out.println(Base64.getEncoder().encodeToString(priv.getEncoded()));
        
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pu);
        
        byte[] chiffr = cipher.doFinal("Bonjour".getBytes());
        
        System.out.println(Base64.getEncoder().encodeToString(chiffr));
        
         cipher.init(Cipher.DECRYPT_MODE, priv);
        
        byte[] dechiffr = cipher.doFinal(chiffr);
        System.out.println(new String(dechiffr));
        
        
    }
    
}
