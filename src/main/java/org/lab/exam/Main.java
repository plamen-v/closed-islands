package org.lab.exam;

public class Main {
    public static void main(String[] args) {
        if(args.length > 0){
            int[][] map = InputReader.read(args[0]);
            Cartographer cartographer = new Cartographer();
            System.out.println(cartographer.getClosedIslandsCount(map));
        }else{
            System.out.println("Provide input file with formated data.");
            System.out.println("Example:");
            System.out.println("1 0 0");
            System.out.println("0 1 0");
            System.out.println("0 0 1");
        }
    }
}