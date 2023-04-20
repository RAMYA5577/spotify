import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {


        Album album1=new Album("Moosa","Sidhu Moosewala");
        album1.addSongToAlbum("295",4.05);
        album1.addSongToAlbum("LastRide",5.5);
        album1.addSongToAlbum("So High",3.05);

        Album album2=new Album("Arjith's songs", "Arjith Singh");
        album2.addSongToAlbum("Kesariya",5);
        album2.addSongToAlbum("Jeena Jeena",4.05);
        album2.addSongToAlbum("Gerua",6);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("295"));

        LinkedList<songs> myPlayList=new LinkedList<>();
        album1.addToPlayListFromAlbum("295",myPlayList);
        album2.addToPlayListFromAlbum(2,myPlayList);
        album1.addToPlayListFromAlbum("LastRide",myPlayList);
        album2.addToPlayListFromAlbum("Jeena Jeena",myPlayList);

        play(myPlayList);
    }

    public static void play(LinkedList<songs> PlayList){
        ListIterator<songs> itr=PlayList.listIterator();
        Scanner sc= new Scanner(System.in);
        boolean isForward=false;

        if(PlayList.size()>0){
            System.out.println("currently paying: ");
            System.out.println(itr.next());
            isForward=true;
        }
        else{
            System.out.println("playlist is empty");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit=false;
        while(!quit){
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("you have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if (isForward == true) {
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("you are at the start of the play list");
                    }
                    break;
                case 3:
                    if(isForward==true) {
                        if (itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        } else {
                            System.out.println("song does not happens");
                        }
                    }
                    else {
                        if (itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward=true;
                        }
                        else{
                            System.out.println("song is not present");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(PlayList);
                    break;
                case 7:
                    quit=true;
                    break;
            }
        }
    }

public static void printSongs(LinkedList<songs> PlayList){
        for(songs s: PlayList)
            System.out.println(s);
        return;
}
    public static void printMenu(){

        System.out.println("1-play next song");
        System.out.println("2-play previous song");
        System.out.println("3-repeat the current song");
        System.out.println("4-show menu again");
        System.out.println("5-Delete the current song");
        System.out.println("6-print all the songs in playList");
        System.out.println("7-Exit");
    }

}