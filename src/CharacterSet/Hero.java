package CharacterSet;
import HasARelationship.Weapon;

public class Hero extends Character {
    private Weapon weapon;
    private String heroType;
    private int numOfMonsterKill;



    public Hero() {
        super();
    }

    public Hero(String name, int age, String kingdom, int health, int damage, Weapon weapon, String heroType) {
        super(name, age, kingdom, health,damage);
        this.weapon = weapon;
        this.heroType = heroType;
        this.numOfMonsterKill = 0;
    }

    // Getters & Setters
    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getHeroType() {
        return this.heroType;
    }

    public void setHeroType(String heroType) {
        this.heroType = heroType;
    }

    public int getNumOfMonsterKill() {
        return this.numOfMonsterKill;
    }

    public void setNumOfMonsterKill(int numOfMonsterKill) {
        this.numOfMonsterKill = numOfMonsterKill;
    }

    @Override
	public int compareTo(Character o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}
    
    public void calcHeroesNewDamage() {
    	this.damage += weapon.damageIncrease;
    }
    
    @Override
	public void calcDamage(int damage) {
		this.health -= damage;
		if(this.health < 0)
			this.health = 0;
	}
    
    // Display Output
    @Override
    public String toString() {
        return "\nHero" + super.toString() + weapon + "\nHero Type : " + heroType + "\nNumber of Kill : " + numOfMonsterKill;
    }

}