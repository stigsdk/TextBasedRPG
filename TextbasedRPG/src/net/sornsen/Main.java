package net.sornsen;

public class Main{

    public static void main(String[] args) {
	// write your code here

        Player player = new Player("Stig", 500, 1);
        Enemy mob1 = new Enemy("Zombie", 10, 1);

        Enemy mob2 = new Enemy("Zombie", 10, 2);

        Enemy mob3 = new Enemy("Zombie", 50, 50);
        Battle battle1 = new Battle(player, mob1);
        Battle battle2 = new Battle(player, mob2);
        Battle battle3 = new Battle(player, mob3);



    }

    public static void WriteText(String text)
    {
        System.out.println(text);
    }
}
