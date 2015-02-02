package net.sornsen;

import java.util.Scanner;

/**
 * Created by Admin on 02-02-2015.
 */
public class Battle {

    public Battle(Character player, Character enemy)
    {
        while (player.GetHealth() > 0 && enemy.GetHealth() > 0)
        {
            System.out.println("You have " + player.GetHealth() + "HP and the enemy has " + enemy.GetHealth() + "HP");
            System.out.println("(A)ttack, (H)eal, (F)Flee");
            Scanner scan = new Scanner(System.in);
            String move = scan.nextLine().toUpperCase();

            boolean turnSuccessful = true;
            if (move.equals("A"))
            {
                int attack = player.Attack();
                enemy.TakeDamage(attack);

                System.out.println("You attacked " + enemy.GetName() + " with a strength of " + attack + "HP!");
            }
            else if (move.equals("H"))
            {
                int heal = player.Heal();
                System.out.println("You healed " + heal + "HP");
            }
            else if (move.equals("F"))
            {

            }
            else
            {
                turnSuccessful = false;
            }

            if (turnSuccessful == true) {
                // Enemy logic here..
                int attack = enemy.Attack();
                player.TakeDamage(attack);

                System.out.println(enemy.GetName() + " attacked you with a strength of " + attack + "HP!");
            }
        }
    }
}
