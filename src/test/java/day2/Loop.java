package day2; //package starts
//class goes below
public class Loop {
//main method
    public static void main(String[] args) {


        String[] countries = new String[6];
        countries[0] = "USA";
        countries[1] = "Bangladesh";
        countries[2] = "Pakistan";
        countries[3] = "UAE";
        countries[4] = "New Zeland";
        countries[5] = "Australia";


        String[] states = new String[6];
        states[0] = "New York";
        states[1] = "Dhaka";
        states[2] = "Rawalpindi";
        states[3] = "Dubai";
        states[4] = "Auckland";
        states[5] = "Melbourne";


        String[] places = new String[6];
        places[0] = "Brooklyn";
        places[1] = "Uttara";
        places[2] = "Balgaca";
        places[3] = "King Zayed";
        places[4] = "Shire";
        places[5] = "County Club";

        String[] streetName = new String[6];
        streetName[0]="Kings Street";
        streetName[1]="Park Road";
        streetName[2]="Wall Street";
        streetName[3]="Jackson Height";
        streetName[4]="Brooklyn Heights";
        streetName[5]="Madison Avenue";

        int[] houseAddress = new int[6];
        houseAddress[0] = 902441;
        houseAddress[1] = 126213;
        houseAddress[2] = 121314;
        houseAddress[3] = 111512;
        houseAddress[4] = 112333;
        houseAddress[5] = 113333;

        int[] phoneNumber= new int[6];
        phoneNumber[0]= 017200;
        phoneNumber[1]= 012333;
        phoneNumber[2]= 123345;
        phoneNumber[3]= 498246;
        phoneNumber[4]= 920844;
        phoneNumber[5]= 164104;

        // start of the for loop

        // for(int i=0; i<=5; i++)

        for (int i =1; i <states.length; i++) {
            System.out.println("\n" + "The country I live in is " + countries[1] + "\n" + "My state is " + states[1] + "\n" + "The place where I am staying is at " + places[1] + "\n" + "Street name is " + streetName[1] + "\n" + "My House Address is " + houseAddress[1] + "\n" + "My Phone Number is " + phoneNumber[1]+ "\n");


        } //end of the for loop


    } //end of the method


} //end of the class
