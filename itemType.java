public class itemType{
   private final boolean weapon;
   private final int damage;
   private final boolean potion;
   private final double protection;
   private final String type;
   private final int potionHealth;
   private final String shortName;
   
   public itemType(String type, boolean weapon, int damage, boolean potion, double protection, int potionHealth, String shortName){
      this.weapon = weapon;
      this.damage = damage;
      this.potion = potion;
      this.protection = protection;
      this.potionHealth = potionHealth;
      this.type = type;
      this.shortName = shortName;
   }
   public boolean isWeapon(){
      return this.weapon;
   }
   public String getShortName(){
      return this.shortName;
   }
   public String getType(){
      return this.type;
   }
   public int getDamage(){
      return this.damage;
   }
   public boolean isPotion(){
      return this.potion;
   }
   public double getProtetion(){
      return this.protection;
   }
   public int getPotionHealth(){
      return this.potionHealth;
   }
}