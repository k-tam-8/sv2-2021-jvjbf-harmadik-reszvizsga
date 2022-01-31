package vehiclerental;

import java.time.LocalDate;
import java.time.LocalTime;

public class Bike implements Rentable {
    private String id;
    private LocalTime rentingTime;

    public Bike(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public LocalTime getRentingTime() {
        return rentingTime;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * 15;
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
