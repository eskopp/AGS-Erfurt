package rsa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Random;

public class MersenneTwister
  extends Random
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = -4035832775130174188L;
  private static final int N = 624;
  private static final int M = 397;
  private static final int MATRIX_A = -1727483681;
  private static final int UPPER_MASK = Integer.MIN_VALUE;
  private static final int LOWER_MASK = Integer.MAX_VALUE;
  private static final int TEMPERING_MASK_B = -1658038656;
  private static final int TEMPERING_MASK_C = -272236544;
  private int[] mt;
  private int mti;
  private int[] mag01;
  private double __nextNextGaussian;
  private boolean __haveNextNextGaussian;
  
  public strictfp Object clone()
  {
    try
    {
      MersenneTwister f = (MersenneTwister)super.clone();
      f.mt = ((int[])this.mt.clone());
      f.mag01 = ((int[])this.mag01.clone());
      return f;
    }
    catch (CloneNotSupportedException e)
    {
      throw new InternalError();
    }
  }
  
  public strictfp boolean stateEquals(Object o)
  {
    if (o == this) {
      return true;
    }
    if ((o == null) || (!(o instanceof MersenneTwister))) {
      return false;
    }
    MersenneTwister other = (MersenneTwister)o;
    if (this.mti != other.mti) {
      return false;
    }
    for (int x = 0; x < this.mag01.length; x++) {
      if (this.mag01[x] != other.mag01[x]) {
        return false;
      }
    }
    for (int x = 0; x < this.mt.length; x++) {
      if (this.mt[x] != other.mt[x]) {
        return false;
      }
    }
    return true;
  }
  
  public strictfp void readState(DataInputStream stream)
    throws IOException
  {
    int len = this.mt.length;
    for (int x = 0; x < len; x++) {
      this.mt[x] = stream.readInt();
    }
    len = this.mag01.length;
    for (int x = 0; x < len; x++) {
      this.mag01[x] = stream.readInt();
    }
    this.mti = stream.readInt();
    this.__nextNextGaussian = stream.readDouble();
    this.__haveNextNextGaussian = stream.readBoolean();
  }
  
  public strictfp void writeState(DataOutputStream stream)
    throws IOException
  {
    int len = this.mt.length;
    for (int x = 0; x < len; x++) {
      stream.writeInt(this.mt[x]);
    }
    len = this.mag01.length;
    for (int x = 0; x < len; x++) {
      stream.writeInt(this.mag01[x]);
    }
    stream.writeInt(this.mti);
    stream.writeDouble(this.__nextNextGaussian);
    stream.writeBoolean(this.__haveNextNextGaussian);
  }
  
  public strictfp MersenneTwister()
  {
    this(System.currentTimeMillis());
  }
  
  public strictfp MersenneTwister(long seed)
  {
    super(seed);
    setSeed(seed);
  }
  
  public strictfp MersenneTwister(int[] array)
  {
    super(System.currentTimeMillis());
    
    setSeed(array);
  }
  
  public synchronized strictfp void setSeed(long seed)
  {
    super.setSeed(seed);
    
    this.__haveNextNextGaussian = false;
    
    this.mt = new int['?'];
    
    this.mag01 = new int[2];
    this.mag01[0] = 0;
    this.mag01[1] = -1727483681;
    
    this.mt[0] = ((int)(seed & 0xFFFFFFFFFFFFFFFF));
    for (this.mti = 1; this.mti < 624; this.mti += 1)
    {
      this.mt[this.mti] = (1812433253 * (this.mt[(this.mti - 1)] ^ this.mt[(this.mti - 1)] >>> 30) + this.mti);
      
      this.mt[this.mti] &= 0xFFFFFFFF;
    }
  }
  
  public synchronized strictfp void setSeed(int[] array)
  {
    if (array.length == 0) {
      throw new IllegalArgumentException(
        "Array  length  must  be  greater  than  zero");
    }
    setSeed(19650218L);
    int i = 1;
    int j = 0;
    for (int k = 624 > array.length ? 624 : array.length; k != 0; k--)
    {
      this.mt[i] = 
        ((this.mt[i] ^ (this.mt[(i - 1)] ^ this.mt[(i - 1)] >>> 30) * 1664525) + array[j] + j);
      this.mt[i] &= 0xFFFFFFFF;
      i++;
      j++;
      if (i >= 624)
      {
        this.mt[0] = this.mt['?'];
        i = 1;
      }
      if (j >= array.length) {
        j = 0;
      }
    }
    for (k = 623; k != 0; k--)
    {
      this.mt[i] = 
        ((this.mt[i] ^ (this.mt[(i - 1)] ^ this.mt[(i - 1)] >>> 30) * 1566083941) - i);
      this.mt[i] &= 0xFFFFFFFF;
      i++;
      if (i >= 624)
      {
        this.mt[0] = this.mt['?'];
        i = 1;
      }
    }
    this.mt[0] = Integer.MIN_VALUE;
  }
  
  protected synchronized strictfp int next(int bits)
  {
    if (this.mti >= 624)
    {
      int[] mt = this.mt;
      int[] mag01 = this.mag01;
      for (int kk = 0; kk < 227; kk++)
      {
        int y = mt[kk] & 0x80000000 | mt[(kk + 1)] & 0x7FFFFFFF;
        mt[kk] = (mt[(kk + 397)] ^ y >>> 1 ^ mag01[(y & 0x1)]);
      }
      for (; kk < 623; kk++)
      {
        int y = mt[kk] & 0x80000000 | mt[(kk + 1)] & 0x7FFFFFFF;
        mt[kk] = (mt[(kk + 65309)] ^ y >>> 1 ^ mag01[(y & 0x1)]);
      }
      int y = mt['?'] & 0x80000000 | mt[0] & 0x7FFFFFFF;
      mt['?'] = (mt['?'] ^ y >>> 1 ^ mag01[(y & 0x1)]);
      
      this.mti = 0;
    }
    int y = this.mt[(this.mti++)];
    y ^= y >>> 11;
    y ^= y << 7 & 0x9D2C5680;
    y ^= y << 15 & 0xEFC60000;
    y ^= y >>> 18;
    
    return y >>> 32 - bits;
  }
  
  private synchronized strictfp void writeObject(ObjectOutputStream out)
    throws IOException
  {
    out.defaultWriteObject();
  }
  
  private synchronized strictfp void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
  }
  
  public strictfp boolean nextBoolean()
  {
    return next(1) != 0;
  }
  
  public strictfp boolean nextBoolean(float probability)
  {
    if ((probability < 0.0F) || (probability > 1.0F)) {
      throw new IllegalArgumentException(
        "probability  must  be  between  0.0  and  1.0  inclusive.");
    }
    if (probability == 0.0F) {
      return false;
    }
    if (probability == 1.0F) {
      return true;
    }
    return nextFloat() < probability;
  }
  
  public strictfp boolean nextBoolean(double probability)
  {
    if ((probability < 0.0D) || (probability > 1.0D)) {
      throw new IllegalArgumentException(
        "probability  must  be  between  0.0  and  1.0  inclusive.");
    }
    if (probability == 0.0D) {
      return false;
    }
    if (probability == 1.0D) {
      return true;
    }
    return nextDouble() < probability;
  }
  
  public strictfp int nextInt(int n)
  {
    if (n <= 0) {
      throw new IllegalArgumentException("n  must  be  positive   got:  " + 
        n);
    }
    if ((n & -n) == n) {
      return (int)(n * next(31) >> 31);
    }
    int bits;
    int val;
    do
    {
      bits = next(31);
      val = bits % n;
    } while (bits - val + (n - 1) < 0);
    return val;
  }
  
  public strictfp long nextLong(long n)
  {
    if (n <= 0L) {
      throw new IllegalArgumentException("n  must  be  positive   got:  " + 
        n);
    }
    long bits;
    long val;
    do
    {
      bits = nextLong() >>> 1;
      val = bits % n;
    } while (bits - val + (n - 1L) < 0L);
    return val;
  }
  
  public strictfp double nextDouble()
  {
    return ((next(26) << 27) + next(27)) / 9.007199254740992E15D;
  }
  
  public strictfp float nextFloat()
  {
    return next(24) / 1.6777216E7F;
  }
  
  public strictfp void nextBytes(byte[] bytes)
  {
    for (int x = 0; x < bytes.length; x++) {
      bytes[x] = ((byte)next(8));
    }
  }
  
  public strictfp char nextChar()
  {
    return (char)next(16);
  }
  
  public strictfp short nextShort()
  {
    return (short)next(16);
  }
  
  public strictfp byte nextByte()
  {
    return (byte)next(8);
  }
  
  public synchronized strictfp double nextGaussian()
  {
    if (this.__haveNextNextGaussian)
    {
      this.__haveNextNextGaussian = false;
      return this.__nextNextGaussian;
    }
    double v1;
    double v2;
    double s;
    do
    {
      v1 = 2.0D * nextDouble() - 1.0D;
      v2 = 2.0D * nextDouble() - 1.0D;
      s = v1 * v1 + v2 * v2;
    } while ((s >= 1.0D) || (s == 0.0D));
    double multiplier = StrictMath.sqrt(-2.0D * StrictMath.log(s) / s);
    this.__nextNextGaussian = (v2 * multiplier);
    this.__haveNextNextGaussian = true;
    return v1 * multiplier;
  }
  
  public static strictfp void main(String[] args)
  {
    MersenneTwister r = new MersenneTwister(new int[] { 291, 564, 837, 1110 });
    System.out
      .println("Output  of  MersenneTwister  with  new  (2002/1/26)  seeding  mechanism");
    for (int j = 0; j < 1000; j++)
    {
      long l = r.nextInt();
      if (l < 0L) {
        l += 4294967296L;
      }
      String s = String.valueOf(l);
      while (s.length() < 10) {
        s = "  " + s;
      }
      System.out.print(s + "  ");
      if (j % 5 == 4) {
        System.out.println();
      }
    }
    long SEED = 4357L;
    
    System.out.println("\nTime  to  test  grabbing  100000000  ints");
    
    r = new MersenneTwister(4357L);
    long ms = System.currentTimeMillis();
    int xx = 0;
    for (j = 0; j < 100000000; j++) {
      xx += r.nextInt();
    }
    System.out.println("Mersenne  Twister:  " + (
      System.currentTimeMillis() - ms) + "  Ignore  this:  " + xx);
    
    System.out
      .println("To  compare  this  with  java.util.Random   run  this  same  test  on  MersenneTwisterFast.");
    System.out
      .println("The  comparison  with  Random  is  removed  from  MersenneTwister  because  it  is  a  proper");
    System.out
      .println("subclass  of  Random  and  this  unfairly  makes  some  of  Random's  methods  un-inlinable ");
    System.out
      .println("so  it  would  make  Random  look  worse  than  it  is.");
    
    System.out.println("\nGrab  the  first  1000  booleans");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextBoolean() + "  ");
      if (j % 8 == 7) {
        System.out.println();
      }
    }
    if (j % 8 != 7) {
      System.out.println();
    }
    System.out.println("\nGrab  1000  booleans  of  increasing  probability  using  nextBoolean(double)");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextBoolean(j / 999.0D) + "  ");
      if (j % 8 == 7) {
        System.out.println();
      }
    }
    if (j % 8 != 7) {
      System.out.println();
    }
    System.out.println("\nGrab  1000  booleans  of  increasing  probability  using  nextBoolean(float)");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextBoolean(j / 999.0F) + "  ");
      if (j % 8 == 7) {
        System.out.println();
      }
    }
    if (j % 8 != 7) {
      System.out.println();
    }
    byte[] bytes = new byte['?'];
    System.out.println("\nGrab  the  first  1000  bytes  using  nextBytes");
    r = new MersenneTwister(4357L);
    r.nextBytes(bytes);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(bytes[j] + "  ");
      if (j % 16 == 15) {
        System.out.println();
      }
    }
    if (j % 16 != 15) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  bytes  --  must  be  same  as  nextBytes");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      byte b;
      System.out.print((b = r.nextByte()) + "  ");
      if (b != bytes[j]) {
        System.out.print("BAD  ");
      }
      if (j % 16 == 15) {
        System.out.println();
      }
    }
    if (j % 16 != 15) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  shorts");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextShort() + "  ");
      if (j % 8 == 7) {
        System.out.println();
      }
    }
    if (j % 8 != 7) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  ints");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextInt() + "  ");
      if (j % 4 == 3) {
        System.out.println();
      }
    }
    if (j % 4 != 3) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  ints  of  different  sizes");
    r = new MersenneTwister(4357L);
    int max = 1;
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextInt(max) + "  ");
      max *= 2;
      if (max <= 0) {
        max = 1;
      }
      if (j % 4 == 3) {
        System.out.println();
      }
    }
    if (j % 4 != 3) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  longs");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextLong() + "  ");
      if (j % 3 == 2) {
        System.out.println();
      }
    }
    if (j % 3 != 2) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  longs  of  different  sizes");
    r = new MersenneTwister(4357L);
    long max2 = 1L;
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextLong(max2) + "  ");
      max2 *= 2L;
      if (max2 <= 0L) {
        max2 = 1L;
      }
      if (j % 4 == 3) {
        System.out.println();
      }
    }
    if (j % 4 != 3) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  floats");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextFloat() + "  ");
      if (j % 4 == 3) {
        System.out.println();
      }
    }
    if (j % 4 != 3) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  doubles");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextDouble() + "  ");
      if (j % 3 == 2) {
        System.out.println();
      }
    }
    if (j % 3 != 2) {
      System.out.println();
    }
    System.out.println("\nGrab  the  first  1000  gaussian  doubles");
    r = new MersenneTwister(4357L);
    for (j = 0; j < 1000; j++)
    {
      System.out.print(r.nextGaussian() + "  ");
      if (j % 3 == 2) {
        System.out.println();
      }
    }
    if (j % 3 != 2) {
      System.out.println();
    }
  }
}
