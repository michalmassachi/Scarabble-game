package test;

//import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

public class BloomFilter
{
    int bytes;
    String alg1,alg2;
    BitSet b;

    public BloomFilter(int bytes,String alg1,String alg2)
    {
       this.bytes=bytes;
       this.alg1=alg1;
       this.alg2=alg2;
       b=new BitSet(bytes);
    }

    public void add(String s)
    {
        byte[] bts;
        int x;
        int m;

            try {
                MessageDigest md1 = MessageDigest.getInstance(alg1);
                bts= md1.digest(s.getBytes());
                BigInteger b1 = new BigInteger(bts);
                x = Math.abs(b1.intValue());
                m = x%bytes;
                b.set(m);
            } catch (Exception e) {
                System.out.println("Exception thrown : " + e);
            }
            try {
                MessageDigest md2 = MessageDigest.getInstance(alg2);
                bts = md2.digest(s.getBytes());
                BigInteger b2 = new BigInteger(bts);
                x = Math.abs(b2.intValue());
                m = x%bytes;
                b.set(m);
            } catch (Exception e) {
                System.out.println("Exception thrown : " + e);
            }
    }
    public Boolean contains(String s)
    {
        byte[] bts;
        int x;
        int m;

        try {
            MessageDigest md1 = MessageDigest.getInstance(alg1);
            bts= md1.digest(s.getBytes());
            BigInteger b1 = new BigInteger(bts);
            x = Math.abs(b1.intValue());
            m = x%bytes;
            if(!b.get(m))
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }
        try {
            MessageDigest md2 = MessageDigest.getInstance(alg2);
            bts = md2.digest(s.getBytes());
            BigInteger b2 = new BigInteger(bts);
            x = Math.abs(b2.intValue());
            m = x%bytes;
            if(!b.get(m))
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception thrown : " + e);
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b.length());
        for (int i = 0; i <= b.length() - 1; i++) {
            sb.append(b.get(i) ? 1 : 0);
        }
        return sb.toString();
    }

}

