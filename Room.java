import java.util.ArrayList;

public class Room {
   private ArrayList<Item> itemsInRoom = new ArrayList<>();
   private ArrayList<Monster> monstersInRoom = new ArrayList<>();
   private final int maxNumberOfMonsters = 2;
   private final int maxNumberOfItems = 2;
   
   public Room() {
      // TODO: Generate a random number of monsters and items between 1 and max (inclusive)
      int amountOfMonsters=(int)(Math.random()*maxNumberOfMonsters)+1;
      int amountOfItems=(int)(Math.random()*maxNumberOfItems)+1;
      
      // TODO: Create the ArrayLists to hold the Items and Monsters in the Room and populate them with Monsters and Items
      for(int i=0;i<amountOfMonsters;i++){
         monstersInRoom.add(new Monster());
      }
      for(int i=0;i<amountOfItems;i++){
         itemsInRoom.add(new Item());
      }
   }
   public Item getItemInRoom(String itemWord) {
       for (Item item : itemsInRoom) {
           if (item.getItemType().equalsIgnoreCase(itemWord)) {
               return item;
           }
       }
      return null;
   }
   public Monster getMonster(String monsterString) {
      for(Monster monster : monstersInRoom){
         if (monster.getMonsterType().equalsIgnoreCase(monsterString)) {

         
            return monster;
         }
      }
      return null;
   }
   public void removeItem(Item item) {
      itemsInRoom.remove(item);
   }
   public void removeMonster(Monster monster) {
      monstersInRoom.remove(monster);
   }
   public void addItem(Item item) {
      itemsInRoom.add(item);
   }

   public boolean hasItem(String itemName) {
       for (Item item : itemsInRoom) {
           if (item.getItemType().equalsIgnoreCase(itemName)) {
               return true;
           }
       }
       return false;
   }
   public boolean hasMonster(String monsterName) {
       for (Monster monster : monstersInRoom) {
           if (monster.getMonsterType().equalsIgnoreCase(monsterName)) {
               return true;
           }
       }
       return false;
   }
   
   public String toString() {
      String returnString = "Items in room: ";
      for(Item item : itemsInRoom){
         returnString+="\n    "+item.getItemType();
      }
      returnString += "\n\n Monsters in room: ";
      for(Monster monster : monstersInRoom){
         returnString+="\n    "+monster.getMonsterType();
      }
      

      // TODO: build a returnString that nicely formats the Monsters and Items in the Room
      // HINT: Use a for-each loop to go through the ArrayLists
      return returnString;
   }

   }