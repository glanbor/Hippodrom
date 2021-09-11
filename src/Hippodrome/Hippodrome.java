package Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
 //       for (int i = 0; i < 10; i++) {
//            System.out.println();
 //       }
    }
    public Horse getWinner(){
        double max = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Победитель  " + getWinner().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<Horse>();
        horses.add(new Horse("Nina", 3,0));
        horses.add(new Horse("Andrew", 3,0));
        horses.add(new Horse("Igor", 3,0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

}
