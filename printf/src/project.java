public class project {

    public static void main(String[] args){

        boolean myBoolean = true;
        char myChar = 'a';
        String myString = "Denizhan";
        int myInt = 3;
        double myDouble = 1000000000.2;

        /*
        System.out.printf("%b \n", myBoolean);
        System.out.printf("%c \n", myChar);
        System.out.printf("%s \n", myString);
        System.out.printf("%d \n", myInt);
        System.out.printf("%f \n", myDouble);
         */

        // System.out.printf("Hello %10s", myString);

        // System.out.printf("You have this much money: %.2f", myDouble);

        System.out.printf("You have this much money: %,f", myDouble);

    }
}
