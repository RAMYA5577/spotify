import  java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Album {
    String name;
    String artist;
    private List<songs> song;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.song = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getArtist() {

        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<songs> getSongs() {
        return song;
    }

    public void setSongs(List<songs> songs) {
        this.song = songs;
    }

    public boolean findSong(String title){
        for(songs s : song){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

    void addSongToAlbum(String title,double duration){
        songs s=new songs(name,duration);
        if(findSong(s.getTitle())==true){
            System.out.println("song already present in album");
        }
        else{
            song.add(s);
            System.out.println("New song has been added");
        }
        return;
    }

    //polymorphism
    public void addToPlayListFromAlbum(String title,LinkedList<songs> playList){
        if(findSong(title)==true){
            for(songs s: song){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    System.out.println("song has been added to your playlist");
                    break;
                }
            }
        }
        else{
            System.out.println("Song is not present in the Album");
        }
        return;
    }

    public void addToPlayListFromAlbum(int trackNo, LinkedList<songs> playList){
        int index=trackNo-1;
        if(index>=0 && index<song.size()){
            System.out.println("song has been added to your playlist");
            playList.add(song.get(index));

        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }
}
