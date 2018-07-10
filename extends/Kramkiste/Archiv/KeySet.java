package rsa;

import java.math.BigInteger;

public class KeySet
{
  BigInteger modulus;
  BigInteger publicKey;
  BigInteger privateKey;
  public static final int radix = 36;
  
  public KeySet(BigInteger modulus, BigInteger publicKeyExponent, BigInteger privateKeyExponent)
  {
    this.modulus = modulus;
    this.publicKey = publicKeyExponent;
    this.privateKey = privateKeyExponent;
  }
  
  public String toString()
  {
    return 
    
      "modulus = " + this.modulus.toString() + "\n\n" + "public exponent = " + this.publicKey.toString() + "\n\n" + "private exponent = " + this.privateKey.toString();
  }
  
  public static BigInteger parseInt(String input)
  {
    return new BigInteger(input, 36);
  }
  
  public static String intString(BigInteger input)
  {
    return input.toString(36);
  }
}
