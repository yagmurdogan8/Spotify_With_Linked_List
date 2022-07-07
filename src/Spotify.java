import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Spotify {
    static Map<String, Person> personData = new LinkedHashMap<>();
    static Person person = new Person();

    public static void addUser(String name) {
        person = new Person(name);

    }


    public static Map<DataLinkedList, DataLinkedList> test = new LinkedHashMap<>();
    public static Map<String, DataLinkedList> users = new HashMap<>();

    public static void main(String[] args) {
        Person person1 = new Person();
        DataLinkedList songLinkedList = new DataLinkedList();
        DataLinkedList nameLinkedList = new DataLinkedList();

        Scanner scan = new Scanner(System.in);

        String name = null;
        boolean exit = true;
        System.out.println("Enter command");
        System.out.println("To exit the process please type 'EXIT'");
        while (exit) {
            try {
                String value[] = new String[50];
                String input = scan.nextLine(); //reads the console input and trims excess whitespace
                // String[] values = input.split("\\s", 3);
                switch (input.toUpperCase()) {
                    case "EXIT":
                        //we need a command to exit the loop and terminate the application
                        exit = false;
                        System.out.println("Process finished successfully");
                        break;

                    case "C":

                        System.out.println("Please type the name");
                        name = scan.nextLine();
                        addUser(name);
                        if (!nameLinkedList.contains(name)) {
                            nameLinkedList.add(name);
                        }
                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    case "S":
                        System.out.println("Please fill for " + name + " first");
                        System.out.println("Please type the name of the user");
                        String name1 = scan.nextLine();
                        System.out.println("Please type the name of the song");
                        String song = scan.nextLine();

                        if (name1.equals(name)) {

                            person.addLikedSong(name1, song);
                            System.out.println("Song added successfully");


                        } else {
                            System.out.println("Please fill the last created person's songs");
                        }


                        if (nameLinkedList.contains(name1)) {
                            songLinkedList.add(song);

                        }
                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");

                        break;
                    case "E":
                        System.out.println("Please type the name");
                        String name3 = scan.nextLine();
                        System.out.println("Please type the name of the song which you want to delete");
                        String deleteTheSong = scan.nextLine();
                        person.deleteWantedSong(name3, deleteTheSong);

                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    case "L":

                        System.out.println("Please type the name");
                        String name4 = scan.nextLine();
                        person.printSong(name4);

                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    case "N":
                        System.out.println("Existing users are:");
                        // person.printUser();
                        nameLinkedList.removeDuplicates();
                        nameLinkedList.printList(nameLinkedList);
                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    case "M":
                        System.out.println("All liked songs: ");
                        songLinkedList.removeDuplicates();
                        songLinkedList.printList(songLinkedList);
                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    case "R":

                        System.out.println("-----------------------------------------------");
                        System.out.println("Enter command");
                        break;
                    default:
                        System.out.println("Unsupported command " + input);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}