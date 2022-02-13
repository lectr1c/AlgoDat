package me.lectr1c.F8;

public class Tests {
    public static void main(String[] args) {
        var htb = new HashTableBucket<String, Integer>(20);
        htb.put("Aa", 20);
        htb.put("BB", 31);
        htb.put("Aa", 30);
        htb.put("Yeetus", 420);
        htb.put("slomo", 224);
        System.out.println(htb.toString());
        htb.remove("Yeetus");
        htb.remove("BB");
        System.out.println(htb.toString());
        htb.put("BB", 3221);
        htb.rehash(40);
        htb.put("razzaq", 3783);
        htb.put("aaa", 34);

        System.out.println(htb.toString());
    }
}
