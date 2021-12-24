package project.ex.musically;

public class Media {
    int image,song;
    String artist,song_name,album;
    Media(int image, int song, String artist,String song_name, String album){
        this.image = image;
        this.song= song;
        this.artist =artist;
        this.song_name =song_name;
        this.album = album;
    }

    public int getImage() {
        return image;
    }

    public int getSong() {
        return song;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getSong_name() {
        return song_name;
    }
}
