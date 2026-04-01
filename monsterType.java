public class monsterType {
   private final String type;
   private final int damage;
   private final int health;
   
   public monsterType(String type, int damage, int health){
      this.type=type;
      this.damage=damage;
      this.health=health;
   }
   public String getType(){
      return type;
   }
   public int getDamage(){
      return damage;
   }
   public int getHealth(){
      return health;
   }
   public String toString(){
      return "This is a "+type+" it has "+health+" health and it does "+damage+" damage";
   }
      
}