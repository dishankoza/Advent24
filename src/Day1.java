package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Day1{

    public static void main(String[] args) {
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader("src/input/day1.txt"));
            String line;
            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            while((line = inputReader.readLine()) != null){
                String[] str = line.split("   ");
                arr1.add(Integer.parseInt(str[0]));
                arr2.add(Integer.parseInt(str[1]));
            }
            arr1.sort(null);
            arr2.sort(null);
            long distance = 0;
            for(int i = 0; i < arr1.size(); i++){
                distance += Math.abs(arr1.get(i) - arr2.get(i));
            }
            System.out.println("Total distance: " + distance);
            HashMap<Integer, Integer> rFreq = new HashMap<>();
            for(Integer num: arr2){
                rFreq.put(num, rFreq.getOrDefault(num, 0) + 1);
            }
            long similarity = 0;
            for(Integer num: arr1){
                similarity += rFreq.getOrDefault(num, 0)*num; 
            }
            System.out.println("Total similarity: " +similarity);
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}