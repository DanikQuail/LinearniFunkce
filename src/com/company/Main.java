package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int vysledek ;
        int jeTamVickrat = 0;
        ArrayList<LinearniFunkce> ArrayListFunkce = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("functions.txt"));
            String nextLine = br.readLine();

            while (nextLine != null) {
                LinearniFunkce Funkce = new LinearniFunkce();
                String[] raw = nextLine.substring(3).split(" " + (char) 42 + " ");
                Funkce.a = Integer.parseInt(raw[1].substring(0, raw[1].length() - 1));
                Funkce.b = Integer.parseInt(raw[3]);
                ArrayListFunkce.add(Funkce);
                nextLine = br.readLine();
            }


        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }   catch (IOException e) {
            e.printStackTrace();
        }

        int count = ArrayListFunkce.size();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukoly/count.txt"));
            bw.write(count + "");
            bw.close();
        }   catch (IOException e) {
            System.out.println(e);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukoly/count_distinct.txt"));

            for (int i = 0; i < ArrayListFunkce.size(); i++) {
                int jeTamZnova = 0;
                int a1 = ArrayListFunkce.get(i).a;
                int b1 = ArrayListFunkce.get(i).b;

                for (LinearniFunkce arr2Funkce : ArrayListFunkce) {
                    int a2 = arr2Funkce.a;
                    int b2 = arr2Funkce.b;
                    if (a1 == a2 && b1 == b2) {
                        jeTamZnova++;
                    }
                }
                if (jeTamZnova >= 2) {
                    jeTamVickrat++;
                }
            }

            vysledek = ArrayListFunkce.size() - jeTamVickrat;
            bw.write(String.valueOf(vysledek));

            bw.close();
            
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}