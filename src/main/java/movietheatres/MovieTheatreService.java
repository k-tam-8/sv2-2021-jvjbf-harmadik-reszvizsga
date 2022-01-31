package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MovieTheatreService {
    private Map<String, Movie> shows =new TreeMap<>();

    public void readFromFile(Path path) {
        List<String> readFromFileList = new ArrayList<>();
        try {
            readFromFileList = Files.readAllLines(path);
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        for (String s : readFromFileList){
            String[] strArr = s.split("-");
            String[] anotherStrArr = strArr[1].split(";");
            shows.put(strArr[0], new Movie(anotherStrArr[0], LocalTime.parse(anotherStrArr[1])));
        }
    }

    public Map<String, Movie> getShows() {
        return new TreeMap<>(shows);
    }
}
