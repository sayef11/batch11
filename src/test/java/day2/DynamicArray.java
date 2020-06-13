package day2;

import java.util.ArrayList;

//parent class start here
public class DynamicArray {
//main method goes below this line
    public static void main(String[] args) {

        ArrayList<String> countries = new ArrayList<>();

        countries.add("Bangladesh");
        countries.add("Pakistan");
        countries.add("USA");
        countries.add("UAE");
        countries.add("Australia");

        int[] num = new int[5];

        num[0]=25;
        num[1]=50;
        num[2]=100;
        num[3]=150;
        num[4]=200;


        System.out.println(" The country where I live in is " + countries.get(0) + " && the routing number is " + num[3] );


    }



}
