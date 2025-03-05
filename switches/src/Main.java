
public class Main {
    public static void main(String[] args) {

        String day = "Pizza";

        switch(day) {
            case "Sunday":
                System.out.println("It is Sunday!");
                break;

            case "Monday":
                System.out.println("It is Monday!");
                break;

            case "Friday":
                System.out.println("It is Friday!");
                break;

            default:
                System.out.println("That is not a day!");
        }
    }
}