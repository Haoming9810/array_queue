public interface Queue {

    boolean add(int val);

    Integer poll();

    Integer peak();

    int size();
}
