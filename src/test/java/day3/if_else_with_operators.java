package day3;

public class if_else_with_operators {

    public static void main(String[] args) {

    int grade = 49;

//the condition starts down below

    if (grade >= 90 && grade <= 100){
        System.out.println("The grade is A");
    }
    else if (grade >= 80 && grade < 90){
        System.out.println("The grade is B");
    }
    else if (grade >= 70 && grade < 80)
    {
        System.out.println("The grade is C");
    }
    else {
        System.out.println(" The grade is Fail");

    }

    }//end of main method

}//end of class
