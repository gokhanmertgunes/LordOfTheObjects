package CharacterSet;


public class Dragon extends Monster {
    private String dragonType;
    private String skinColor;

    public Dragon() {
        super();
    }

    public Dragon(String name, int age, String kingdom, int health, int damage, String origin, String dragonType, String skinColor) {
        super(name, age, kingdom, health, damage, origin);
        this.dragonType = dragonType;
        this.skinColor = skinColor;
    }

    // Getters & Setters
    public String getDragonType() {
        return this.dragonType;
    }

    public void setDragonType(String dragonType) {
        this.dragonType = dragonType;
    }

    public String getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }


    // Display Output
    @Override
    public String toString() {
        return "\nDragon" + super.toString() + "\nDragon Type : " + dragonType + "\nSkin Color : " + skinColor;
    }

	public String makeWarCry() {
		return "FUUUAAAAA";
	}

	@Override
	public int compareTo(Character o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}

	@Override
	public void calcDamage(int damage) {
		
		this.health -= damage;
		if(this.health < 0)
			this.health = 0;
	}

}