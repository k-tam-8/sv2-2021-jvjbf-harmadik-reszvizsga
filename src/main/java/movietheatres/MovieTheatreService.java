package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class MovieTheatreService {
    private Map<String, List<Movie>> shows = new TreeMap<>();

    public void readFromFile(Path path) {
        List<String> readFromFileList = new ArrayList<>();
        try {
            readFromFileList = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        for (String s : readFromFileList) {
            String[] strArr = s.split("-");
            String[] anotherStrArr = strArr[1].split(";");
            if (!shows.containsKey(strArr[0])) {
                shows.put(strArr[0], new ArrayList<>());
            }
            shows.get(strArr[0]).add(new Movie(anotherStrArr[0], LocalTime.parse(anotherStrArr[1])));
        }
    }

    public Map<String, List<Movie>> getShows() {
        return new TreeMap<>(shows);
    }

    public List<String> findMovie(String title) {
        List<String> cinemas = new ArrayList<>();
        for (Map.Entry<String, List<Movie>> entry : shows.entrySet()){
            if (entry.getValue().contains(title)){
                cinemas.add(entry.getKey());
            }
        }
        return cinemas;
    }

    public LocalTime findLatestShow(String title) {
        return null;
    }
}
