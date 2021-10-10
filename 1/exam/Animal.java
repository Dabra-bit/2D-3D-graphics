
public class Animal implements Runnable{
    
    private String name; // Animal's name
    private int speed; // km/h
    private int goal;
    private double distance; // km
    private Thread th;

    Animal(String name, int speed, int goal) {
        this.name = name;
        this.speed = speed;
        this.goal = goal;
        this.distance = 0;
        System.out.println(this.name + " corre a " + String.valueOf(this.speed) + " km/h");
        this.th = new Thread(this);
        this.th.start();
    }
    
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()) {
                this.th.sleep(1);

                if(distance < goal) {
                    distance += (double) this.speed / 3600;
                } else {
                    System.out.println("<" + this.name + " llego a la meta.>");
                    Thread.currentThread().interrupt();
                }
            }
        } catch(InterruptedException iException){ }
    }

}
