package net.sornsen;

/**
 * Created by Admin on 02-02-2015.
 */
public class Room {

    public String title;
    public String description;
    private int size;
    private int level;

    public void Room (String title, String description, int size, int level)
    {
        this.title = title;
        this.description = description;
        this.size = size;
        this.level = level;
    }

}
