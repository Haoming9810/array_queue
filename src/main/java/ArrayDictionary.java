public class ArrayDictionary implements Dictionary {
    private int count;
    private KVEntry[] entries;

    public ArrayDictionary(int capacity) {
        entries = new KVEntry[capacity];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private int hashFunction(String key) {
        // return key.hashCode() % entries.length;
        return key.length() % entries.length;
    }

    @Override
    public void put(String key, String value) {

        int hashedKey = hashFunction(key);

        // when there's no entry yet
        if (entries[hashedKey] == null) {
            entries[hashedKey] = new KVEntry(key, value);
            count++;
            return;
        }

        KVEntry ptr = entries[hashedKey];
        KVEntry pNewNode = null;
        while (ptr != null) {
            // update value if key already exists
            if (ptr.key == key) {
                ptr.value = value;
                return;
            }
            pNewNode = ptr;
            ptr = ptr.next;
        }

        // add an entry to the end of the chain
        pNewNode.next = new KVEntry(key, value);
        return;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] == null) {
                builder.append("dictionary[" + i + "] = null\n");
                continue;
            }
            KVEntry ptr = entries[i];
            builder.append("dictionary[" + i + "] = {");
            while (ptr != null) {
                builder.append("(" + ptr.key + ", " + ptr.value + ")");
                ptr = ptr.next;
            }
            builder.append("}\n");
        }
        return builder.toString();
    }
}
