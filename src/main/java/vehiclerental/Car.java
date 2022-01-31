package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable {
    private String id;
    private LocalTime rentingTime;
    private int minFee;

    public Car(String id, int minutes) {
        this.id = id;
        this.minFee = minutes;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * this.minFee;
    }

    @Override
    public LocalTime getRentingTime() {
        return this.rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        this.rentingTime = time;
    }

    @Override
    public void closeRent() {
        this.rentingTime = null;
    }
}
