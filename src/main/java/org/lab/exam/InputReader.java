package org.lab.exam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public static int[][] read(String file) throws Exception {
        List<int[]> list = new ArrayList<>();
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] split = myReader.nextLine().split(" ");
                int[] row = new int[split.length];
                for (int i = 0; i < split.length; i++) {
                    int val = parseInputValue(split[i]);
                    row[i] = val;
                }
                list.add(row);
            }
            myReader.close();

        int[][] input = new int[list.size()][];
        input = list.toArray(input);
        return list.toArray(input);
    }

    private static int parseInputValue(String s) throws Exception {
        int i = Integer.parseInt(s);
        if(i < 0 || i > 1 ){
            throw new Exception("Input value out of range [0,1].");
        }
        return i;
    }
}
