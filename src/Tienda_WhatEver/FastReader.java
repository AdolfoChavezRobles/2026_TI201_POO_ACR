package Tienda_WhatEver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastReader {

    BufferedReader b;

    StringTokenizer s;

    public FastReader() {
        b = new BufferedReader(new InputStreamReader(System.in));
    }
    
    String next() {

        while (s == null || !s.hasMoreElements()) {
            try {
                s = new StringTokenizer(b.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s.nextToken();
    }

    char nextChar() {
        return next().charAt(0);
    }
}
