package day3;

public class Loop_conditional_statements {
    public static void main(String[] args) {

        String[] city = new String[5];

        city[0] = "Dhaka";
        city[1] = "Denver";
        city[2] = "Kentucky";
        city[3] = "Manhattan";
        city[4] = "Long Island";

        for(int i = 0; i <=4; i++) {

        if (city[i]=="Brooklyn"){

            System.out.println(" My city is " + city[i]);

        } else if (city[i]=="Bronx"){

            System.out.println(" My city is " + city[i]);
        }
        else if (city[i]=="Queens"){

            System.out.println("My city is " + city[i]);
        }


            else  {

                System.out.println("My city is not available ");

            }

        }//ends for loop


    }//end main method


}//end class
