package net.sornsen;

import java.util.Scanner;

/**
 * Created by Admin on 02-02-2015.
 */
public class Battle
{
    public Battle(Player player, Character enemy)
    {
        Main.WriteText("(A)ttack, (H)eal, (F)Flee");

        while (player.GetHealth() > 0 && enemy.GetHealth() > 0)
        {
            Main.WriteText("You: " + player.GetHealth() + "HP | " + enemy.GetName() + ": " + enemy.GetHealth() + "HP");

            Scanner scan = new Scanner(System.in);
            String move = scan.nextLine().toUpperCase();

            if (move.equals("A") || move.equals("H") || move.equals("F")) {

                if (move.equals("A"))
                {
                    int playerAttack = player.Attack();
                    enemy.TakeDamage(playerAttack);

                    Main.WriteText("You attacked " + enemy.GetName() + " with a strength of " + playerAttack + "HP!");

                } else if (move.equals("H"))
                {
                    int heal = player.Heal();
                    Main.WriteText("You healed " + heal + "HP");

                } else if (move.equals("F"))
                {

                }

                if (enemy.GetHealth() > 0)
                {
                    // Enemy logic here..
                    int enemyAttack = enemy.Attack();
                    player.TakeDamage(enemyAttack);
                    Main.WriteText(enemy.GetName() + " attacked you with a strength of " + enemyAttack + "HP!");
                }
            }
            else
            {
                Main.WriteText("(A)ttack, (H)eal, (F)Flee");
            }
        }

        if (enemy.GetHealth() <= 0)
        {
            Main.WriteText("You killed " + enemy.GetName());
        }
        else if (player.GetHealth() <= 0)
        {
            Main.WriteText("You died..");
        }
    }
}
