import java.util.ArrayList;

public class Player {
   private ArrayList<Item> inventory;
   private String playerName;
   private int health;
   private int currentX;
   private int currentY;
   private Item equipt;
   private boolean equipted = false;
   private double protection = 1.0;


   public Player(int health, String playerName, int startingX, int startingY) {
      // set the health and playerName to the passed parameters
      this.health = health;
      this.playerName = playerName;      
      
      // TODO: create the empty Inventory
      inventory = new ArrayList<Item>();
      // TODO: set the startingX and Y of the player
      this.currentX = startingX;
      this.currentY = startingY;
   }

   public void addItemToInventory(Item item) {
      inventory.add(item);
   }
   public void equipt(Item item) {
      equipt = item;
      item.equipt();
      equipted = true;
   }
   public void unEquipt(Item item) {
      if(equipt!=null){
         if(equipt.equals(item)){
            equipt = null;
            equipted = false;
         }
      }
   }
   public Item getEquipt() {
      return equipt;
   }
   public boolean isEquipt() {
      return equipted;
   }
   public double damage(double amount){
      health-=amount;
   return health;
   }
   public Item removeItemFromInventory(Item item) {
      inventory.remove(item);
      return item;
   }
   public Item getItem(String item) {
      for(int i=0;i<inventory.size();i++){
         if(inventory.get(i).getItemType().equalsIgnoreCase(item) || inventory.get(i).getShortName().equalsIgnoreCase(item)){
         
            return inventory.get(i);
         }
      }
      return null;
   }


    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getItemType().equalsIgnoreCase(itemName) || item.getShortName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
   
   
   public String look(Map map) {
      // TODO: This method will take the player's current X and Y, and return the contents of the room
      // they are in with a descriptive String
      return map.getRoom(currentX, currentY).toString();
      // HINT: Use map.getRoom(currentX, currentY) and call toString()
   }
   public Room currentRoom(Map map) {
      return map.getRoom(currentX, currentY);
   }
   public String getInv() {
      String returnString = "";
      for(Item item : inventory){
         returnString += item.getItemType()+"\n";
      }
      return returnString;
   }
   public void moveTo(int x, int y) {
      // TODO: Update the Player's currentX and currentY values.
      currentX=x;
      currentY=y;
   }
   public boolean validPos(String direction, Map map){
      if(direction.equals("UP")){
         if(currentY>=map.getNumCols()-1){
            return false;
         }
         currentY++;
         System.out.println("Your current position is: "+currentX+", "+currentY);
         return true;
      }
      if(direction.equals("DOWN")){
         if(currentY<=0){
            return false;
         }
         currentY+=-1;
         System.out.println("Your current position is: "+currentX+", "+currentY);
         return true;
      }
      if(direction.equals("RIGHT")){
         if(currentX>=map.getNumRows()-1){
            return false;
         }
         currentX++;
         System.out.println("Your current position is: "+currentX+", "+currentY);
         return true;
      }
      if(direction.equals("LEFT")){
         if(currentX<=0){
            return false;
         }
         currentX+=-1;
         System.out.println("Your current position is: "+currentX+", "+currentY);
         return true;
      }
      return false;
   }
   public Room getRoom(Map map) {
     return map.getRoom(currentX, currentY);
   }
   public void setProtection(Double num) {
     this.protection = num;
   }
   public double getProtection() {
     return this.protection;
   }
}