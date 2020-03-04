import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Ship<Droid> ship = new Ship();
        ship.setDroid(new Droid("Droid1"));
        ship.setDroid(new Droid("Droid2"));
        System.out.println(ship + "\n");

        PriorityQueue<Droid> priorityQueue = new PriorityQueue<>(2, new DroidComparator());
        priorityQueue.add(new Droid("Droid2"));
        priorityQueue.add(new Droid("Droid1"));
        System.out.println(priorityQueue);

        MyPriorityQueue<Droid> myPriorityQueue = new MyPriorityQueue<>();
        myPriorityQueue.add(new Droid("Droid2"));
        myPriorityQueue.add(new Droid("Droid1"));
        System.out.println(myPriorityQueue);
    }
}
