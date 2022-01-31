package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {
    private Set<User> users = new HashSet<>();
    private Set<Rentable> vehicles = new HashSet<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {
        for (User u : users) {
            if (u.getUserName().equals(user.getUserName())) {
                throw new UserNameIsAlreadyTakenException("Name already taken.");
            }
        }
        users.add(user);
    }

    public void addRentable(Rentable r) {
        vehicles.add(r);
    }

    public Set<User> getUsers() {
        return new HashSet<>(users);
    }

    public Set<Rentable> getRentables() {
        return new HashSet<>(vehicles);
    }

    public Map<Rentable, User> getActualRenting() {
        return new HashMap<>(actualRenting);
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
      /*  if (LocalTime.now().plusHours(3).isAfter(time)) {
            throw new IllegalStateException("More than 3 hour not allowed.");
        }*/
        if (user.getBalance() >= rentable.calculateSumPrice(time.getMinute())) {
            throw new IllegalStateException("Low balance");
        }
        if (rentable.getRentingTime() != null) {
            throw new IllegalStateException("Vehicle already taken.");
        }
        actualRenting.put(rentable, user);

    }

    public void closeRent(Rentable rentable, int minutes) {
        if (actualRenting.containsKey(rentable)) {
            for (User u : users) {
                if (u.getUserName().equals(actualRenting.get(rentable).getUserName())) {
                    u.minusBalance(rentable.calculateSumPrice(minutes));
                }
            }
            rentable.closeRent();
            actualRenting.remove(rentable);
        }
    }

}
