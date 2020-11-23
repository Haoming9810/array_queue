import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DictTest {
    @Test
    public void userLookupTest() {
        Map<String, String> nameDb = new HashMap<>();

        nameDb.put("Katie", "123");
        nameDb.put("Jerry", "xyz");
        nameDb.put("Alex", "132");

        nameDb.put("Sam", "abc");
        nameDb.put("Ron", "def");
        nameDb.put("Tim", "opq");
        nameDb.put("Joe", "789");

        System.out.println(nameDb.toString());

        System.out.println("Does Alex exist in the DB? " + nameDb.containsKey("Alex"));
        System.out.println("Does Andrew exist in the DB? " + nameDb.containsKey("Andrew"));
    }

    @Test
    public void play() {
        Dictionary dict = new ArrayDictionary(10);
        dict.put("Alex", "12$%^");
        dict.put("Ron", "%^&*");
        dict.put("Sam", "4321()");
        System.out.println(dict);
    }
}