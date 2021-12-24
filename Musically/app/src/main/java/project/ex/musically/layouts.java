package project.ex.musically;

public class layouts {
    int image;
    String lyrics,artist,song;
    layouts(int image, String lyrics, String artist, String song){
        this.image = image;
        this.lyrics = lyrics;
        this.artist = artist;
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public int getImage() {
        return image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public String getSong() {
        return song;
    }
}
