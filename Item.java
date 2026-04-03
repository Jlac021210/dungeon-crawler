public class Item {
   private itemType itemType;
   private boolean isEquipped;
   private final boolean isWeapon;
   private final boolean isPotion;
   private final int damage;
   private final double protection;
   private final String type;
   private int potionHealth;
   private final String shortName;
   //boolean weapon, int damage, boolean potion, int protection, int potionHealth
   private final itemType[] itemTypes = {
            new itemType("Rusty Sword",true,15,false,0,0,"Sword"),
            new itemType("Healing Potion",false,0,true,0,50,"Healing Potion"),
            new itemType("Torch",false,0,false,0,0,"torch"),
            new itemType("Ancient Scroll",false,0,false,0,0,"Scroll"),
            new itemType("Leather Armor",false,0,false,0.90,0,"Armor"),
            new itemType("Silver Key",false,0,false,0,0,"Key"),
            new itemType("Magic Amulet",false,0,false,0,0,"Amulet"),
            new itemType("Goblin Knife",true,25,false,0,0,"Knife"),
            new itemType("Spellbook of Fire",false,0,false,0,0,"Spellbook"),
            new itemType("Bag of Gold Coins",false,0,false,0,0,"Coins"),
            new itemType("Mysterious Rune Stone",false,0,false,0,0,"Rune Stone"),
            new itemType("Skeleton Bone",false,0,false,0,0,"Bone"),
            new itemType("Cursed Ring",false,0,false,0,0,"Ring"),
            new itemType("Blanket of Invisibility",false,0,false,0,0,"Blanket"),
            new itemType("Iron Shield",false,0,false,0.75,0,"Shield"),
            new itemType("Dragon Egg",false,0,false,0,0,"Egg"),
            new itemType("Trap Disarming Kit",false,0,false,0,0,"Kit"),
            new itemType("Crystal Orb",false,0,false,0,0,"Orb"),
            new itemType("Venomous Dagger",true,35,false,0,0,"Dagger"),
            new itemType("Tattered Map",false,0,false,0,0,"Map")
        };

   public Item() {
      itemType = itemTypes[(int)(Math.random()*itemTypes.length)];
      type =  itemType.getType();
      isWeapon = itemType.isWeapon();
      damage =  itemType.getDamage();
      isPotion = itemType.isPotion();
      protection = itemType.getProtetion();
      potionHealth = itemType.getPotionHealth();
      shortName = itemType.getShortName();
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
   public String getShortName() {
      return shortName;
   }
   public String toString() {
      return "This is a "+this.type;
   }
}