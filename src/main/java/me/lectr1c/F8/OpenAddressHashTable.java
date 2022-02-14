package me.lectr1c.F8;

public class OpenAddressHashTable<K, V> {

    private static class Entry<K, V> {

        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }

    private Entry<K, V>[] table;
    private int nrOfEntries;

    @SuppressWarnings("unchecked")
    public OpenAddressHashTable(int initialSize) {
        table = new Entry[initialSize];
        nrOfEntries = 0;
    }

    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        while (table[index] != null && (table[index].key == null || !table[index].key.equals(key))) {
            index++;
            index %= table.length;
        }
        if (table[index] == null) return null;

        return table[index].value;
    }

    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;

        if (get(key) != null){
            table[index].value = value;
            return value;
        }

        nrOfEntries++;
        if(nrOfEntries > (0.75 * table.length)) rehash(table.length*2);

        while (table[index] != null && (table[index].key == null || !table[index].key.equals(key))) {
            index++;
            index %= table.length;
        }

        table[index] = new Entry<>(key, value);
        return value;
    }

    public void rehash(int newSize) {
        Entry<K, V>[] oldArray = table.clone();
        table = new Entry[newSize];

        for (Entry<K, V> kvEntry : oldArray) {
            if (kvEntry != null && kvEntry.value != null) {
                this.put(kvEntry.key, kvEntry.value);
            }
        }
        oldArray = null;
    }

    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        while (table[index] != null && (table[index].key == null || !table[index].key.equals(key))) {
            index++;
            index %= table.length;
        }
        if (table[index] == null) return null;
        V oldvalue = table[index].value;
        table[index].key = null;
        table[index].value = null;
        return oldvalue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("Hash Index: ").append(i).append("  ").append(table[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
