package CharacterSet;
import Interfaces.WarCry;

public abstract class Monster extends Character implements WarCry {
    private String origin;

    public Monster() {
        super();
    }

    public Monster(String name, int age, String kingdom, int health, int damage, String origin) {
        super(name, age, kingdom, health, damage);
        this.origin = origin;
    }


    // Getters & Setters
    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    


    // Display Output
    @Override
    public String toString() {
        return super.toString() + "\nOrigin : " + origin;
    }

	
}