import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        boolean exitGame = false;
        Game game = new Game();
        Map dungeonMap = new Map(5, 6);

        Scanner scanner = new Scanner(System.in);
        Player player = new Player(100, "Hero", ((int) (Math.random() * dungeonMap.getNumRows())), ((int) (Math.random() * dungeonMap.getNumCols())));
        System.out.println("Use: equipts armor or shields\nEquipt: puts a weapon in the main hand to fight\nTake/Grab: takes item from room and stores it in player inventory\nDrop: Drops item\nFight: attacks a monster in the room\nMove: Can move left right up down\n\nP.S you can only equipt swords, daggers or knives\n");
        while (!exitGame) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Exiting game. Goodbye!");
                exitGame = true;
            } else if (input.equals("LOOK") || input.equals("SEARCH")) {
                System.out.println(player.look(dungeonMap));
            } else if (input.startsWith("USE")) {
                if(player.hasItem(input.substring(4))) {
                    Item item = player.getItem(input.substring(4));
                    if ((input.substring(4).equalsIgnoreCase(item.getItemType()) || input.substring(4).equalsIgnoreCase(item.getShortName())) && item.getProtection()>0){
                        player.setProtection(item.getProtection());
                        System.out.println("You are now using "+item.getItemType());
                    }
                }    
            } else if (input.startsWith("EQUIPT ")) {
                if(player.hasItem(input.substring(7))) {
                    Item item = player.getItem(input.substring(7));
                    if ((input.substring(7).equalsIgnoreCase(item.getItemType()) || input.substring(7).equalsIgnoreCase(item.getShortName())) && item.isEquipttable()) {
                        player.equipt(item);
                        System.out.println("Equippted: " + item.getItemType());
                    }else{
                        System.out.println("The "+item.getItemType()+" isn't a weapon and can't be equippted");
                    }
                }else{
                    System.out.println("The player doesn't have: "+input.substring(7).toLowerCase());
                }
            } else if (input.startsWith("TAKE ") || input.startsWith("GRAB ")) {
                if(player.currentRoom(dungeonMap).hasItem(input.substring(5))) {
                    Item item = player.currentRoom(dungeonMap).getItemInRoom(input.substring(5));
                    if (input.substring(5).equalsIgnoreCase(item.getItemType()) || input.substring(5).equalsIgnoreCase(item.getShortName())) {
                        player.addItemToInventory(item);
                        player.currentRoom(dungeonMap).removeItem(item);
                        System.out.println("Grabbed: " + item.getItemType());
                    }
                }else{
                    System.out.println("This room doesn't have: "+input.substring(5).toLowerCase());
                }

            } else if (input.startsWith("DROP ")) {
                if(player.hasItem(input.substring(5))) {
                    Item item = player.getItem(input.substring(5));
                    if (input.substring(5).equalsIgnoreCase(item.getItemType()) || input.substring(5).equalsIgnoreCase(item.getShortName())) {
                        player.removeItemFromInventory(item);
                        player.unEquipt(item);
                        player.currentRoom(dungeonMap).addItem(item);
                        System.out.println("Dropped: " + item.getItemType());
                    }
                }else{
                    System.out.println("The player doesn't have: "+input.substring(5).toLowerCase());
                }
            }else if (input.startsWith("FIGHT ")) {
            int damage = 0;
                if(player.isEquipt()) {
                    Item item = player.getEquipt();
                    damage=item.getDamage();
                    if(player.currentRoom(dungeonMap).hasMonster(input.substring(6))){
                        Monster monster = player.currentRoom(dungeonMap).getMonster(input.substring(6));
                        int damageTotal = monster.damage(damage);
                        double playerDamage = player.damage(monster.getDamage()*player.getProtection());
                        if(playerDamage<=0){
                           System.out.println("You died");
                           exitGame = true;
                        }else{
                           System.out.println(monster.getMonsterType()+" attacks back and your health is now "+playerDamage);
                        }
                        if(damageTotal<=0){
                           player.currentRoom(dungeonMap).removeMonster(monster);
                           System.out.println(monster.getMonsterType()+" had died");
                        }else{
                           System.out.println(monster.getMonsterType()+" was attacked with a "+item.getItemType()+" and did "+damage+" damage");
                        }
                    }else{
                        System.out.println("There is no monster in this room with the name: "+input.substring(6).toLowerCase());
                    }
                }else{
                     System.out.println("You don't have anything equippted");
                }
            }else if (input.startsWith("MOVE ")) {
                String direction = input.substring(5);
                if (!player.validPos(direction, dungeonMap)) {
                    System.out.println("You're trying to move in an invalid direction or out of bounds. Please choose UP, DOWN, LEFT or RIGHT");
                }else{
                  System.out.println(player.look(dungeonMap));
                }
            }else{
               System.out.println("That command doesn't exist");
            }
        }
    }
}