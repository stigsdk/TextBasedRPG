package net.sornsen;

import java.util.Random;

/**
 * Created by Admin on 02-02-2015.
 */
public class Character{

    private String name;
    protected int maxHealth;
    protected int health;
    protected int level;

    public Character()
    {}
    public Character(String name, int maxHealth, int level)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.level = level;
    }

    public void TakeDamage(int damage)
    {
        this.health = this.health - damage;
    }

    public int Heal()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(10);
        int heal = (this.level * randInt / 10) + 1;

        this.health = this.health + heal;
        if (this.health > this.maxHealth)
        {
            this.health = this.maxHealth;
        }

        return heal;
    }

    public int Attack()
    {
        Random rand = new Random();
        int randInt = rand.nextInt(100);
        int attack = ((this.level * randInt) / 10) + 1;

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

    public int GetMaxHealth()
    {
        return this.maxHealth;
    }

    public int GetLevel()
    {
        return this.level;
    }
}
