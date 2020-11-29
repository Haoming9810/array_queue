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
    public void test1() {
        Dictionary dict = new ArrayDictionary(10);

        dict.put("Jerry", "467");
        dict.put("Alex", "132");
        dict.put("Sam", "234");
        dict.put("Ron", "999");
        dict.put("Tim", "012");
        dict.put("Katie", "549");
        dict.put("Joe", "333");

        System.out.println(dict);
    }
}