package net.sornsen;

public class Main{

    public static void main(String[] args) {
	// write your code here

        Player player = new Player("Stig", 100, 1);
        Character mob = new Character("Zombie",50, 1);

        Battle battle = new Battle(player, mob);



    }

    public static void WriteText(String text)
    {
        System.out.println(text);
    }
}
