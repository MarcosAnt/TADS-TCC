/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tads.tccpool.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class MD5 {
  
  public MD5(){};
  
  public static String criptografar(String msg) {
    
    MessageDigest digest;
    
    try {
      digest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
    digest.update(msg.getBytes(), 0, msg.length());
    
    return new BigInteger(1, digest.digest()).toString(16);
  }
}
