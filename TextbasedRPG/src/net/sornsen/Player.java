package net.sornsen;

/**
 * Created by Admin on 02-02-2015.
 */
public class Player extends Character
{
    private int xp;
    private int nextXpLevel;

    public Player(String name, int maxHealth, int level)
    {
        super(name, maxHealth, level);
        this.xp = 0;
        this.nextXpLevel = 10;
    }

    public void AddXp(int xp)
    {
        this.xp += xp;
        while (this.xp >= this.nextXpLevel)
        {
            IncreaseLevel(1);
            this.nextXpLevel = (int) (this.nextXpLevel * 1.5);
        }
    }

    private void IncreaseLevel(int level)
    {
        this.level += level;
    }
}
