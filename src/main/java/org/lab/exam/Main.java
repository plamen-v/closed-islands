package org.lab.exam;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                int[][] map = InputReader.read(args[0]);
                Cartographer cartographer = new Cartographer();
                System.out.println(cartographer.getClosedIslandsCount(map));
            } else {
                System.out.println("Please provide the path to the input file as parameter.");
                System.out.println("Example:");
                System.out.println("1 0 0");
                System.out.println("0 1 0");
                System.out.println("0 0 1");
            }
        } catch (Exception ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}