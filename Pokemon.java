package INF100_17H;
import java.util.Random;

public class Pokemon{
  private String name;
  private int healthPoints;
  private int maxHealthPoints;
  private int strength;
  private double criticalChance;
  private Random random;
  
  public Pokemon(String name) {
    this.random = new Random();
    this.name = name;
    this.healthPoints =
      (int) Math.abs(Math.round(100 + 10 * random.nextGaussian()));
    this.maxHealthPoints = this.healthPoints;
    this.strength =
      (int) Math.abs(Math.round(20 + 10 * random.nextGaussian()));
    this.criticalChance = Math.abs(0.1 * random.nextGaussian());
  }
  
  public String toString() {
    String toString = name + " HP: " + healthPoints + "/" + maxHealthPoints + " STR: " + strength + " CHC: " + Math.round(criticalChance*100) + "% \n"; 
    return toString;
  }
  
  public String getName() {
    return name;
  }
  
  public boolean isConscious() {
    boolean isConscious = true;
    if(healthPoints<1){
      return false;
    } 
    return true;
  }
  
  public void damage(int damageTaken) {
    healthPoints = healthPoints - damageTaken;
    
    if(healthPoints< -1){
      healthPoints = 0;
    }
    
    System.out.println("\n"+ name + " takes " + damageTaken + " damage and is left with " + healthPoints + "/" + maxHealthPoints + " HP.");
  }
  
  public void attack(Pokemon target) {
    int damageInflicted =
      (int) (this.strength + this.strength / 2 * random.nextGaussian());
    
    double critRoll = Math.abs(this.random.nextGaussian());
    //System.out.println(name + " rolled a " + Math.round(critRoll*100) + " out of " + Math.round(criticalChance*100) + "."); //add for testing
    
    if (critRoll < criticalChance){
      damageInflicted = damageInflicted * 2;
      System.out.println("It was a critical hit!\n");
    }
    
    if (damageInflicted < 0) {
      damageInflicted = 0;
    }
    System.out.printf("%s attacks %s.%n", this.getName(), target.getName());
    
    target.damage(damageInflicted);
    
    if(!target.isConscious()){
      System.out.println(target.getName() + " is defeated by " + this.getName() + ".");
    }
  }
}
