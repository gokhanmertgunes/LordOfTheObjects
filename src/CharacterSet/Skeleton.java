package CharacterSet;

public class Skeleton extends Monster{
    private String skeletonType;


    public Skeleton() {
        super();
    }

    public Skeleton(String name, int age, String kingdom, int health, int damage, String origin, String skeletonType) {
        super(name, age, kingdom, health, damage, origin);
        this.skeletonType = skeletonType;
    }


    // Getters & Setters
    public String getSkeletonType() {
        return this.skeletonType;
    }

    public void setSkeletonType(String skeletonType) {
        this.skeletonType = skeletonType;
    }


    // Display Output
    @Override
    public String toString() {
        return "\nSkeleton" + super.toString() + "\nSkeleton Type : " + skeletonType;
    }

	
	public String makeWarCry() {
		return "Crack Crack";
	}

	@Override
	public void calcDamage(int damage) {
		this.health -= damage;
		if(this.health < 0)
			this.health = 0;
	}
	
	@Override
	public int compareTo(Character o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}

}