package iuh.fit.demo7;

/**
 * Admin 3/10/2025
 **/
public class ParkingGarage {
    private int capacity;
    private int availablePlots;

    public ParkingGarage(int capacity) {
        this.capacity = capacity;
        this.availablePlots = capacity;
    }

    public int getAvailablePlots() {
        return availablePlots;
    }

    public synchronized void enter() {
        while (availablePlots == 0){
            System.out.println("The garage is being full! Please wait...");
            try {
                wait();
            } catch (Exception e) {

            }
        }

        if (availablePlots > 0) {
            --availablePlots;
            System.out.println("Vào thành công");
            notifyAll();
        }
    }

    public synchronized void leave() {
        while (availablePlots == capacity) {
            System.out.println("The garage is empty! Please wait...");
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (availablePlots < capacity) {
            System.out.println("Car un-parked successfully!");
            availablePlots++;
            notifyAll();
        }


    }
}
