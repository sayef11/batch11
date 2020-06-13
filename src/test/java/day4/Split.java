package day4;

public class Split {

    public static void main(String[] args) {
// I have to create a split statement.
//It works with String.
//
     String comment = "You have_to be Smart";

     String[] result = comment.split(" ");
     /*System.out.println("result is "+result[4]);*/
    String[] war = result[2].split("_");
     System.out.println("My result is " + result[2]);


    }



}
