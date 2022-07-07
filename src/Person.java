import java.util.Map;
import java.util.LinkedHashMap;

public class Person {
    Person person;
    String name;
    static Map<String,Person> personData=new LinkedHashMap<>();
    DataLinkedList<String> likedSongs=new DataLinkedList<>();
    DataLinkedList<String> names=new DataLinkedList<>();
    public void addSong(String song){
        likedSongs.add(song);}

    public void addLikedSong(String name,String song){
        person=personData.get(name);
        addSong(song);
    }
    public void deleteSong(String song){
        likedSongs.remove(song);
    }
    public void deleteWantedSong(String name,String song){
        person=personData.get(name);
        deleteSong(song);
    }

    public void printSong(String name){
        person= personData.get(name);
        likedSongs.removeDuplicates();
        likedSongs.printList(likedSongs);
    }

    Person(String name){
        System.out.println("person "+name+ " is added");
        this.name=name;

    }
    Person(){}
}