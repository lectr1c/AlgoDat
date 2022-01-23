package me.lectr1c.F1;

import java.util.ArrayList;

public class P1P2 {
    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for(int i = 0; i < aList.size(); i++){
            if(aList.get(i).equals(oldItem)){
                aList.set(i, newItem);
            }
        }
    }

    public static void delete(ArrayList<String> aList, String target){
        for(int i = 0; i < aList.size(); i++)
            if(aList.get(i).equals(target)){
                aList.remove(i);
                return;
            }
    }
}
