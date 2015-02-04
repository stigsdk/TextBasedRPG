package net.sornsen;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Admin on 02-02-2015.
 */
public class Battle
{

    public Battle(Player player, Enemy enemy)
    {
        Main.WriteText("You have encountered an enemy!");
        Main.WriteText("(A)ttack, (H)eal, (E)Escape");

        boolean playerEscaped = false;
        while (player.GetHealth() > 0 && enemy.GetHealth() > 0 && playerEscaped == false)
        {
            Main.WriteText("You: " + player.GetHealth() + "HP (lvl " + player.GetLevel() + ") | " + enemy.GetName() + ": " + enemy.GetHealth() + "HP (lvl " + enemy.GetLevel() + ")");

            Scanner scan = new Scanner(System.in);
            String move = scan.nextLine().toUpperCase();

            if (move.equals("A") || move.equals("H") || move.equals("E")) {

                if (move.equals("A"))
                {
                    int playerAttack = player.Attack();
                    enemy.TakeDamage(playerAttack);

                    Main.WriteText("You attacked " + enemy.GetName() + " with a strength of " + playerAttack + "HP!");

                } else if (move.equals("H"))
                {
                    int heal = player.Heal();
                    Main.WriteText("You healed " + heal + "HP!");

                } else if (move.equals("E"))
                {
                    Random rand = new Random();
                    int randInt = rand.nextInt(100);
                    if (randInt < 33)
                    {
                        playerEscaped = true;
                    }
                    else
                    {
                        Main.WriteText("You had no luck escaping this time..");
                    }
                }

                if (enemy.GetHealth() > 0 && playerEscaped == false)
                {
                    Random rand = new Random();
                    int randInt = rand.nextInt(100);
                    if (randInt < 10 && enemy.GetMaxHealth() != enemy.GetHealth())
                    {
                        int heal = enemy.Heal();
                        Main.WriteText(enemy.GetName() + " healed + " + heal + "HP!");
                    }
                    else
                    {
                        int enemyAttack = enemy.Attack();
                        player.TakeDamage(enemyAttack);
                        Main.WriteText(enemy.GetName() + " attacked you with a strength of " + enemyAttack + "HP!");
                    }
                }
            }
            else
            {
                Main.WriteText("(A)ttack, (H)eal, (E)Escape");
            }
        }

        if (enemy.GetHealth() <= 0)
        {
            Main.WriteText("You killed " + enemy.GetName());
            int droppedXp = enemy.DropXP();
            int oldLevel = player.GetLevel();
            player.AddXp(droppedXp);
            Main.WriteText("You got " + droppedXp + "XP from " + enemy.GetName());
            if (player.GetLevel() > oldLevel)
            {
                Main.WriteText("You have now reached level " + player.GetLevel());
            }

        }
        else if (player.GetHealth() <= 0)
        {
            Main.WriteText("You died..");
        }
        else if (playerEscaped)
        {
            Main.WriteText("You escaped..");
        }
    }
}
