public class Conditional {
// =========================== if - else if - else ==============================================================
    public static void main(String[] args) {
        int highScore = 50;
        if(highScore == 50) System.out.println("This is an expression");


        System.out.println("Your final score was " + finalScore(800, 5, 100));
        // Print out a second score on the screen
        System.out.println("Your final score was " + finalScore(10000, 8, 200));
    }

    public static int finalScore(int score, int levelCompleted, int bonus){
        if(score < 5000 && score >1000) {
            System.out.println("Score was less than 5000 but greater than 1000 : " + score);
        } else if(score < 1000) {
            System.out.println("Score was less than 1000 : " + score);
        } else {
            System.out.println("Got here with score : " + score);
        }

        return score + (levelCompleted * bonus);
    }
}
