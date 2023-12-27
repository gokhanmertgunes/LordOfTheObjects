package HasARelationship;

import java.util.ArrayList;

public class Weapon {
    public String weaponType;
    public int damageIncrease;
    
    

    public Weapon() {
    	
    }
    
    public Weapon(String weaponType, int damageIncrease) {
    	this.weaponType = weaponType;
    	this.damageIncrease = damageIncrease;
    }

    
    
    @Override
    public String toString() {
        return "\nWeapon Type : " + weaponType + "\nDamage Increase : " + damageIncrease;
    }
}