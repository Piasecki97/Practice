package pl.damian;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();


    public static void main(String[] args) throws IOException {
       try(DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
           for(Location location : locations.values()) {
               locFile.writeInt(location.getLocationID());
               locFile.writeUTF(location.getDescription());
               System.out.println("Writing location" + location.getLocationID() + " : " + location.getDescription());
               System.out.println("Writing " + (location.getExits().size()-1) + "exits.");
               locFile.writeInt(location.getExits().size()-1);
               for(String direction : location.getExits().keySet()) {
                   if(!direction.equalsIgnoreCase("Q")) {
                       System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                       locFile.writeUTF(direction);
                       locFile.writeInt(location.getExits().get(direction));
                   }
               }
           }
       }
    }

    static {

        try (BufferedReader s = new BufferedReader(new FileReader("locations.txt"));
             Scanner se = new Scanner(new BufferedReader(new FileReader("directions.txt")))) {
            String input1;
            while ((input1 = s.readLine()) != null) {
                String[] data = input1.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc, description, tempExit));

            }
            while (se.hasNextLine()) {
                String input = se.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
