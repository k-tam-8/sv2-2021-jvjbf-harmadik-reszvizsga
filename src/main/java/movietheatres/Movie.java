package movietheatres;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.Objects;

public class Movie implements Comparator<Movie>{

    private String title;
    private LocalTime startTime;

    public Movie(String title, LocalTime startTime) {
        this.title = title;
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public int compare(Movie o1, Movie o2) {
      return o1.startTime.compareTo(o2.startTime);
    }
}