package Game;

public class Bot {
    private int moveBotHorizontal = 0;
    private int moveBotVertical = 0;
    private boolean isFiring = false;

    public int getMoveBotHorizontal() {
        return moveBotHorizontal;
    }

    public int getMoveBotVertical() {
        return moveBotVertical;
    }

    Bot() {
        int number;
        number = (int) (Math.random() * 100);
        if (number <= 25) {
            moveBotVertical = 1;
            System.out.println(number);
        } else if (number <= 50) {
            moveBotHorizontal = 1;
            System.out.println(number);
        } else if (number <= 75) {
            moveBotVertical = -1;
            System.out.println(number);
        } else if (number <= 100) {
            moveBotHorizontal = 1;
            System.out.println(number);
        }

        if (number%2 == 1){
            isFiring =true;
        }
    }

    public boolean isFiring() {
        return isFiring;
    }
}
