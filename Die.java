import java.util.*;

public class Die {
    public static void main(String[] args) {

        int target = 0;
        int die1 = 0;
        int die2 = 0;
        boolean done = false;

        System.out.println("Which dice number between 2-12 are we looking for?");
        Scanner sc = new Scanner(System.in);

        while (!done) {
            try {
                target = sc.nextInt();
                if ((target < 2) || (target > 12)) {
                    System.out.println("Bad number! This isn't a DnD roll.");
                } else if ((target >= 2) || (target <= 12)) {
                    done = true;
                    System.out.println("You have chosen: " + target);
                }
            } catch (InputMismatchException exception) {
                System.out.println("Bad input! Restart.");
                System.exit(1);
            }
        }

        int max = 0;


        System.out.println("How many times can we roll?");
        Scanner sc2 = new Scanner(System.in);

        try {
            max = sc2.nextInt();
            while (max < 1) {
                System.out.println("Must be 1 or more tries!");
                max = sc2.nextInt();

            }
        } catch (InputMismatchException exception) {
            System.out.println("Bad input! Restart.");
            System.exit(1);
        }

        int sum = 0;

        while (true) {
            for (int i = 0; i < max; i++) {
                die1 = (int)(Math.random() * 6) + 1;
                die2 = (int)(Math.random() * 6) + 1;
                sum = die1 + die2;

                System.out.println("Rolled a " + die1 + " plus " + die2 + " for a total of: " + sum);
            }

            if (sum == target) {
                System.out.println("Great success! Found " + target + " in " + max + " rolls.");
                System.exit(1);
            }
        }
    }
}
