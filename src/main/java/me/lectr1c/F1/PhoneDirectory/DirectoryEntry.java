/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.lectr1c.F1.PhoneDirectory;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    private String name;
    private String number;

    public String getNumber() { return number; }
    public String getName() { return name; }
    
    public DirectoryEntry(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;

        if (obj instanceof DirectoryEntry){
            DirectoryEntry entry = (DirectoryEntry) obj;

            return this.name.equals(entry.getName());
        }

        return false;
    }
    
}
