package net.sornsen;

public class Main{

    public static void main(String[] args) {
	// write your code here

        Character player = new Character("Stig", 100, 1);
        Character mob = new Character("Zombie", 10, 1);

        int attack = player.Attack();
        mob.TakeDamage(attack);
        System.out.println(mob.GetHealth());


    }
}
