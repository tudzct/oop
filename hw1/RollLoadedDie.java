public class RollLoadedDie {
    public static void main(String[] args) {
        double prob = Math.random();
        int roll;

        if (prob < 1.0/8.0) roll = 1;
        else if (prob < 2.0/8.0) roll = 2;
        else if (prob < 3.0/8.0) roll = 3;
        else if (prob < 4.0/8.0) roll = 4;
        else if (prob < 5.0/8.0) roll = 5;
        else roll = 6;
        System.out.println(roll);
    }
}
