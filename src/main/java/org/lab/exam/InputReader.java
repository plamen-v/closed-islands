package org.lab.exam;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public static int[][] read(String file){
        List<int[]> list = new ArrayList<>();
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int[] data = Arrays.stream(myReader.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
                list.add(data);
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int[][] input = new int[list.size()][];
        input = list.toArray(input);
        return input;
    }
}
