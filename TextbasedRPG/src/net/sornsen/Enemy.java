package net.sornsen;

import java.util.Random;

/**
 * Created by Admin on 03-02-2015.
 */
public class Enemy extends Character {

    public Enemy(String name, int maxHealth, int level)
    {
        super(name, maxHealth, level);
    }

    public int DropXP()
    {
        // Auto generate XP for enemy to drop
        Random rand = new Random();
        int randInt = ((rand.nextInt(10) + 1) * this.level);
        int xp = randInt;
        return xp;
    }

}
