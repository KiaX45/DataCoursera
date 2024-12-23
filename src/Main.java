
import java.util.Random;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        sayHello("Luis", "Camilo");
        random("tails", "heads");
    }

    public static void sayHello(String name1, String name2){
        System.out.println("Hello" + name1 + " " + name2);
    }

    public static void random(String option1, String option2) {
        Random rand = new Random();
        int choice = rand.nextInt(2);
        System.out.println(choice == 0 ? option1 : option2);
    }


}