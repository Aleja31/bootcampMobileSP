import java.util.Random;
import java.util.Scanner;

public class Challenge1 {
    
    public String generateString(String type){
        String result = null;
        Random rand = new Random();

        if( type.equals("TipoA")) {
            result = "54";
        } else if ( type.equals("TipoB") ) {
            result = "08";
        } else {
            return "-1";
        }
        // Generate 8 extra numbers
        for (int i = 1; i <= 8; i++){
            //Generate a random number between 0 and 9
            result = result +  rand.nextInt(9);
        }
        return result;
    }

   
    public char[] generateAsc (String number){
        char array[]= number.toCharArray();  


        for (int i = 0 ; i < array.length - 1 ; i++) {
            int min = i;
 
            //Looking for the minimum number
            for (int j = i + 1 ; j < array.length ; j++) {
                if (Integer.parseInt(String.valueOf(array[j])) < Integer.parseInt(String.valueOf(array[min]))) { //changing int to char
                    min = j;    //find the minimum number
                }
            }
 
            if (i != min) {
                //changing the values
                char aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }
        return array;
    }

    public char[] generateDesc (String number) {
        char array2[]= number.toCharArray();  

      
        for (int i = 0 ; i < array2.length - 1 ; i++) {
            int max = i;
 
            //Looking for the minimum number
            for (int j = i + 1 ; j < array2.length ; j++) {
                if (Integer.parseInt(String.valueOf(array2[j])) > Integer.parseInt(String.valueOf(array2[max]))) { //changing int to char
                    max = j;     //find the minimum number
                }
            }
 
            if (i != max) {
                 //changing the values
                char aux2 = array2[i];
                array2[i] = array2[max];
                array2[max] = aux2;
            }
        }
        return array2;
    }





    public static void main(String[] args) throws Exception {
        Challenge1 challenge = new Challenge1();
        Scanner read = new Scanner (System.in);

        String option = null; 
        String result2 = null;
        String option2 = null;
        

        System.out.println ("Welcome to my first Mini-Challenge of Mobile bootcamp Sophos 2022");

        while (option == null){
            System.out.println ("Please type one of the below options:\n" + "Type 'TipoA' if you want to generate a string whith prefix of 54\n" + "Type 'TipoB' if you want to generate a string whith prefix of 08\n" + "Please type your selection: \n");
          
            option = read.nextLine();
            result2 = challenge.generateString(option);

            if(result2.equals("-1")){
                System.out.println ("You should type an option between TipoA or TipoB, you have typed: " + option);
                System.out.println ("Would like to try again? yes/no");
                option = read.nextLine();

                if(option.equalsIgnoreCase("yes")){
                    option = null;
                } else { break;}

            }else {
                System.out.println("Your number is: " + result2);
                System.out.println ("How do you want to sort your number?\n" + "Please type one of the below options:\n" + "Type 'Asc' if you want to sort the numbers from minimun to maximun\n"+ "Type 'Desc' if you want to sort the numbers from maximun to minimun \n" + "Please type your selection: \n");
                
                option2 = read.nextLine();

                if (option2.equals("Asc")){
                    char[] asc = challenge.generateAsc(result2);
                    System.out.print("Your sort number is: ");
                    System.out.print(asc);   
                } else if (option2.equals("Desc")){
                    char[] desc = challenge.generateDesc(result2);
                    System.out.print("Your sort number is: ");
                    System.out.print(desc); 
                } else {
                    System.out.println("You have selected an incorrect option.");}
                }             
                
            }
            read.close();
        }

}

        
    
