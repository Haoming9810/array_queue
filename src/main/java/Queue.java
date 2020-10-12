public interface Queue {

    boolean add(int val);

    Integer poll();

    Integer peek();

    int size();
}
