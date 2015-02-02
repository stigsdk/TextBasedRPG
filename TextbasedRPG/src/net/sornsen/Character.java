package net.sornsen;

import java.util.Random;

/**
 * Created by Admin on 02-02-2015.
 */
public class Character{

    private String name;
    private int health;
    private int level;

    public Character(String name, int health, int level)
    {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    public void TakeDamage(int damage)
    {
        this.health = this.health - damage;
    }

    public int Attack()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        int attack = (this.level * randInt / 10) + 1;

        return attack;
    }

    public String GetName()
    {
        return this.name;
    }

    public int GetHealth()
    {
        return this.health;
    }

    public int GetLevel()
    {
        return this.level;
    }
}
