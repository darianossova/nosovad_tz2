package org.example;

import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.IOException;
import java.io.FileReader;

public class App {

    String[] digits;
    BufferedReader in;

    public App (String file) throws IOException {

        this.in = new BufferedReader(new FileReader(file));
        this.digits = in.readLine().split(" ");

    }

    public String _min() {

        BigInteger min = new BigInteger("9".repeat(999)), digit;
        for (String s : this.digits) {
            digit = new BigInteger(s);
            min = min.compareTo(digit) < 0 ? min : digit;
        }

        return min.toString();
    }

    public String _max() {

        BigInteger max = new BigInteger("0"), digit;
        for (String s : this.digits) {
            digit = new BigInteger(s);
            max = max.compareTo(digit) > 0 ? max : digit;
        }

        return max.toString();
    }

    public String _sum() {

        BigInteger sum = new BigInteger("0"), digit;
        for (String s : this.digits) {
            digit = new BigInteger(s);
            sum = sum.add(digit);
        }

        return sum.toString();
    }

    public String _mult() {

        BigInteger mult = new BigInteger("1"), digit;
        for (String s : this.digits) {
            digit = new BigInteger(s);
            mult = mult.multiply(digit);
        }

        return mult.toString();
    }
}