package CharacterSet;

import java.util.Objects;

public abstract class Character implements Comparable<Character> {
    protected String name;
    protected int age;
    protected String kingdom;
    protected int health;
    protected int damage;


    public Character() {
        
    }

    public Character(String name, int age, String kingdom, int health, int damage) {
        this.name = name;
        this.age = age;
        this.kingdom = kingdom;
        this.health = health;
        this.damage = damage;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKingdom() {
        return this.kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    public abstract void calcDamage(int damage);

    @Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		return Objects.equals(name, other.name);
	}
	
	public boolean isDead() {
		if(health == 0)
			return true;
		return false;
	}

	// Display Output
    @Override
    public String toString() {
        return  "\nName : " + name + "\nAge : " + age + "\nKingdom : " + kingdom + "\nHealth : " + health + "\nDamage : " + damage;
    }
    

}