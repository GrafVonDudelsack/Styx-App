package Main;

import java.security.*;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

public class Security {

  public static SecretKeySpec KeyAESGenerator(String pw) {
      String keyStr = pw;
     
      try{
          byte[] key = (keyStr).getBytes("UTF-8"); 
          MessageDigest sha = MessageDigest.getInstance("SHA-256");
          key = sha.digest(key);
          key = Arrays.copyOf(key, 16);     
          SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
          return secretKeySpec;
      }
      catch(Exception e)
      {
          System.out.println(e);
          System.exit (-1); 
      }
      return null;
  }

  
  public static byte[] ByteArrayVerschlüsseln (byte[] t, String pw) {
      
      try
      {
          Cipher cipher = Cipher.getInstance("AES");
          cipher.init(Cipher.ENCRYPT_MODE, KeyAESGenerator(pw));
          byte[] encrypted = cipher.doFinal(t);           
          Base64.Encoder myEncoder = Base64.getEncoder();
          byte[] geheim = myEncoder.encode(encrypted);
          return geheim;
      }
      catch(Exception e)
      {
          System.out.println(e);
          System.exit (-1); 
      }      
      return null;
  }
  
   public static byte[] ByteArrayEntschlüsseln (byte[] Geheimtext, String p) {
     
      byte[] geheim = Geheimtext;
      try
      {  
          Base64.Decoder myDecoder2 = Base64.getDecoder();
          byte[] crypted2 = myDecoder2.decode(geheim);
          Cipher cipher2 = Cipher.getInstance("AES");
          cipher2.init(Cipher.DECRYPT_MODE, KeyAESGenerator(p));
          byte[] cipherData2 = cipher2.doFinal(crypted2);          
          return cipherData2;
      }
      catch(Exception e)
      {
          System.out.println(e);
          System.exit (-1); 
      }

      return null;
      
  }
}
