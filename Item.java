public class Item {
   private itemType itemType;
   private boolean isEquipped;
   private final boolean isWeapon;
   private final boolean isPotion;
   private final int damage;
   private final double protection;
   private final String type;
   private int potionHealth;
   //boolean weapon, int damage, boolean potion, int protection, int potionHealth
   private final itemType[] itemTypes = {
            new itemType("Rusty Sword",true,15,false,0,0),
            new itemType("Healing Potion",false,0,true,0,50),
            new itemType("Torch",false,0,false,0,0),
            new itemType("Ancient Scroll",false,0,false,0,0),
            new itemType("Leather Armor",false,0,false,0.25,0),
            new itemType("Silver Key",false,0,false,0,0),
            new itemType("Magic Amulet",false,0,false,0,0),
            new itemType("Goblin Dagger",true,25,false,0,0),
            new itemType("Spellbook of Fire",false,0,false,0,0),
            new itemType("Bag of Gold Coins",false,0,false,0,0),
            new itemType("Mysterious Rune Stone",false,0,false,0,0),
            new itemType("Skeleton Bone",false,0,false,0,0),
            new itemType("Cursed Ring",false,0,false,0,0),
            new itemType("Potion of Invisibility",false,0,false,0,0),
            new itemType("Iron Shield",false,0,false,0.25,0),
            new itemType("Dragon Egg",false,0,false,0,0),
            new itemType("Trap Disarming Kit",false,0,false,0,0),
            new itemType("Crystal Orb",false,0,false,0,0),
            new itemType("Venomous Dagger",true,35,false,0,0),
            new itemType("Tattered Map",false,0,false,0,0)
        };

   public Item() {
      itemType = itemTypes[(int)(Math.random()*itemTypes.length)];
      type =  itemType.getType();
      isWeapon = itemType.isWeapon();
      damage =  itemType.getDamage();
      isPotion = itemType.isPotion();
      protection = itemType.getProtetion();
      potionHealth = itemType.getPotionHealth();
    }
   public int getDamage(){
      return this.damage;
   }
   public double getProtection(){
      return this.protection;
   }
   public boolean isEquipttable(){
      return isWeapon;
   }
   public boolean isPotion(){
      return isPotion;
   }
   public boolean isEquippted(){
      return isEquipped;
   } 
   public void equipt(){
      isEquipped = true;
   }
   public String getItemType() {
      return type;
   }
   public String toString() {
      return "This is a "+this.type;
   }
}