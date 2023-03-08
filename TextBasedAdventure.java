
import java.util.Scanner;

public class TextBasedAdventure {
    boolean hasSword = false;
    Scanner keyboardInput = new Scanner(System.in);

    //Initial Message and starts game
    public void execute() {
        System.out.println("Welcome to Escape from the Cave! Press enter when you are ready to start...");
        keyboardInput.nextLine();
        System.out.println("You are trapped in a cave!");
        start();
    }

    //Start game by prompting user to pick a direction
    public void start() {
        System.out.println("You find yourself in a large room. What would you like to do?\n1. Go left \n2. Go right \n3. Go up");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            goLeft();
        }
        else if (input == 2) {
            goRight();
        }
        else if(input == 3) {
            goUp();
        }
    }

    public void start2()
    {
        System.out.println("You're in the room where you picked up the sword. What would you like to do?\n1. Go left \n2. Go more right");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            start();
        }
        else if (input == 2) {
            goMoreRight();
        }
    }

    //If user selects left prompt the user to select fight or flight and either 
    public void goLeft() {
        System.out.println("Oh no! You run into a giant! Fight or flight?\n1. Fight \n2. Flight \n3. Make Peace");
        int input = keyboardInput.nextInt();
        if (input == 1) {
            fight();
        }
        else if (input == 2) {
            start();
        }  
        else if (input == 3) {
            int min = 1;
            int max = 10;
            int peaceChances = (int)Math.floor(Math.random() * (max - min + 1) + min);
            if (peaceChances > 5) {
                start();
            } 
            else {
                fight();
            }
        }
    }

    //If the user goes right either pick up the sword enter a new room 
    public void goRight() {
        if (!hasSword) {
            System.out.println("You find a sword on the ground!");
            hasSword = true;
        }
        start2();
    }

    public void goMoreRight() {
        System.out.println("There's nothing here...");
        start2();
    }

    //If you go up you hit your head and are prompted to pick another direction
    public void goUp() {
        System.out.println("You hit your head! OUCH! Damn!");
        start();
    }

    //If the user has the sword they win and if not they lose 
    public void fight() {
        if (hasSword) {
            // makes a chance of not winning even with sword
            int chance1 = (int)(10 * Math.random());
            if (chance1 >= 5){
                System.out.println("You defeat the giant with your sword and run out of the cave!");
            } else {
                System.out.println("You swing your mighty sword and miss him. The giant kills you.");
            }
        } else {
            int chance2 = (int)(50 * Math.random());
            if (chance2 == 25){
                System.out.println("You punch the giants big toe and he runs away crying.");
            } else {
                System.out.println("You get stomped by the giant and red stuff goes everywhere.");
            }
        }
    }

    public static void main(String[] args) {
        new TextBasedAdventure().execute();
    }
}