public class Monster {
private monsterType monsterType;

private String type;
private int damage;
private int health;
   //String type, int damage, int health
   private final monsterType[] monsterTypes = {
            new monsterType("Goblin",5,25),
            new monsterType("Skeleton Warrior",5,25),
            new monsterType("Zombie",5,25),
            new monsterType("Orc",5,25),
            new monsterType("Dark Sorcerer",10,25),
            new monsterType("Giant Spider",15,25),
            new monsterType("Vampire Bat",8,5),
            new monsterType("Slime",10,10),
            new monsterType("Mimic",8,10),
            new monsterType("Lich",8,20),
            new monsterType("Troll",15,50),
            new monsterType("Werewolf",15,70),
            new monsterType("Gargoyle",15,70),
            new monsterType("Wraith",15,60),
            new monsterType("Minotaur",20,60),
            new monsterType("Basilisk",20,100),
            new monsterType("Doppelgänger",20,50),
            new monsterType("Demon Hound",25,50),
            new monsterType("Cave Serpent",25,50),
            new monsterType("Ancient Dragon",30,100)
        };

   public Monster() {
     monsterType = monsterTypes[(int)(Math.random()*monsterTypes.length)];
     type =  monsterType.getType();
     health =  monsterType.getHealth();
     damage =  monsterType.getDamage();
   }
   
   
   public String getMonsterType() {
      return this.type;
   }
   public int damage(int damageAmount){
      health-=damageAmount;
      return health;
   }
   public int getHealth(){
      return this.health;
   }
   public int getDamage(){
      return this.damage;
   }
   public String toString() {
      return "This is a "+this.type;
   }
}