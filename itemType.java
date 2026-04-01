public class itemType{
   private final boolean weapon;
   private final int damage;
   private final boolean potion;
   private final double protection;
   private final String type;
   private final int potionHealth;
   
   public itemType(String type, boolean weapon, int damage, boolean potion, double protection, int potionHealth){
      this.weapon = weapon;
      this.damage = damage;
      this.potion = potion;
      this.protection = protection;
      this.potionHealth = potionHealth;
      this.type = type;
   }
   public boolean isWeapon(){
      return this.weapon;
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