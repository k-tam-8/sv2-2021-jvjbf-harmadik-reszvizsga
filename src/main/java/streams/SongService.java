package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SongService {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public Optional<Song> shortestSong() {
        return songs.stream().sorted(Comparator.comparingInt(Song::getLength)).findFirst();
    }

    public List<Song> findSongByTitle(String title) {
        return songs.stream().filter(s -> s.getTitle().equals(title)).collect(Collectors.toList());
    }

    public boolean isPerformerInSong(Song song, String performer) {
        return songs.stream().filter(s -> s.equals(song)).anyMatch(s -> s.getPerformers().contains(performer));
    }

    public List<String> titlesBeforeDate(LocalDate ld) {
        return songs.stream().filter(s -> s.getRelease().isBefore(ld)).map(Song::getTitle).toList();
    }
}
