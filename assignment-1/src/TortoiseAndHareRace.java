import java.util.Random;

public class TortoiseAndHareRace {

    public int tortoisePosition = 1;
    public int harePosition = 1;
    public static final int FINISH_LINE = 70;

    public Random random = new Random();

    public void simulateRace() {
        System.out.println("BANG !!!!!\nAND THEY'RE OFF !!!!!");

        while (tortoisePosition < FINISH_LINE && harePosition < FINISH_LINE) {
            moveTortoise();
            moveHare();
            printPositions();
        }
        announceWinner();
    }

    public void moveTortoise() {
        int move = random.nextInt(10) + 1;
        if (move <= 5) {
            tortoisePosition += 3;
        } else if (move <= 7) {
            tortoisePosition -= 6;
        } else {
            tortoisePosition += 1;
        }
        if (tortoisePosition < 1) tortoisePosition = 1;
    }

    public void moveHare() {
        int move = random.nextInt(10) + 1;
        if (move <= 2) {
        } else if (move <= 4) {
            harePosition += 9;
        } else if (move == 5) {
            harePosition -= 12;
        } else if (move <= 8) {
            harePosition += 1;
        } else {
            harePosition -= 2;
        }
        if (harePosition < 1) harePosition = 1;
    }

    public void printPositions() {
        for (int i = 1; i <= FINISH_LINE; i++) {
            if (i == tortoisePosition && i == harePosition) {
                System.out.print("OUCH!!!");
            } else if (i == tortoisePosition) {
                System.out.print("T");
            } else if (i == harePosition) {
                System.out.print("H");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public void announceWinner() {
        if (tortoisePosition >= FINISH_LINE && harePosition >= FINISH_LINE) {
            System.out.println("It's a tie!");
        } else if (tortoisePosition >= FINISH_LINE) {
            System.out.println("TORTOISE WINS!!! YAY!!!");
        } else {
            System.out.println("Hare wins. Boo!");
        }
    }

    public static void main(String[] args) {
        new TortoiseAndHareRace().simulateRace();
    }
}
