package SysAndMain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

import CharacterComparator.CharacterComparator;
import CharacterSet.Character;
import CharacterSet.Dragon;
import CharacterSet.Monster;
import CharacterSet.Hero;
import CharacterSet.Skeleton;
import HasARelationship.Weapon;

public class CharacterSys {
	private static ArrayList<Weapon> allWeapons = new ArrayList<Weapon>();
	private static HashSet<Character> characters = new HashSet<Character>();
	
	private static ArrayList<Character> battleField = new ArrayList<Character>();
	
	public static void getWeapons() {
    	File f = new File("Weapons.txt");
    	try {
    		Scanner sc = new Scanner(f);
    		String type;
    		int damage;
    		
    		while(sc.hasNext()) {
    			type = sc.next();
    			damage = sc.nextInt();
    			
    			allWeapons.add(new Weapon(type,damage));
    		}
    		sc.close();
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    }
	
	public static boolean addHero(String name, int age, String kingdom, int health, int damage, String heroType) {
		if(search(name) != null)
			return false;
		ArrayList<String> ar = new ArrayList<String>();
		for(Character c: characters)
			if(c instanceof Hero)
				ar.add(c.getName());
		characters.add(new Hero( name,  age,  kingdom,  health,  damage,  allWeapons.get((int)Math.random() * allWeapons.size()),  heroType));
		
		for(int i = 0;i < ar.size();i++)
			removeCharacter(ar.get(i));
		return true;
	}
	
	public static boolean readCharacter() {
		File f = new File("Characters.txt");
		Scanner inp = null;
		
		String choice, type, name, kingdom, origin, herotype,dragonType, skeletonType, skinColor;
		int age, health, damage;
		boolean flag = false;
		
		
		
		try {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(f);

			
			while(s.hasNext()) {
				type = s.next();
				name = s.next();
				age = s.nextInt();
				kingdom = s.next();
				health = s.nextInt();
				damage = s.nextInt();
				if(type.equalsIgnoreCase("Dragon")) {
					origin = s.next();
					dragonType = s.next();
					skinColor = s.next();
					characters.add(new Dragon( name,  age,  kingdom,  health,  damage,  origin,  dragonType,  skinColor));
				
				}
				else if(type.equalsIgnoreCase("Hero")) {
					herotype = s.next();
					if(!flag)
						characters.add(new Hero( name,  age,  kingdom,  health,  damage,  allWeapons.get((int)Math.random() * allWeapons.size()),  herotype));
				}
				else if(type.equalsIgnoreCase("Skeleton")){ 
					origin = s.next();
					skeletonType = s.next();
					characters.add(new Skeleton( name,  age,  kingdom,  health,  damage,  origin,  skeletonType));
				}
				else {
					return false;
				}
			}
			
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public static String displayByName() {
		TreeSet<Character> characterts = new TreeSet<Character>();
		characterts.addAll(battleField);
		
		String output = "";
		for(Character c:characterts)
			output += c.toString() + "\n" + "-------------" + "\n";
		return output;
	}
	
	public static String displayByHealth() {
		TreeSet<Character> characterts = new TreeSet<Character>(new CharacterComparator());
		characterts.addAll(battleField);
		
		String output = "";
		for(Character c:characterts)
			output += c.toString() + "\n" + "-------------" + "\n";
		return output;
	}
	
	public static boolean removeCharacter(String name) {
		for(Character c:characters) 
			if(c.getName().equalsIgnoreCase(name)) {
				characters.remove(c);
				return true;
			}
		return false;
	}
	
	public static Character search(String name) {
		for(Character c:characters) 
			if(c.getName().equalsIgnoreCase(name)) {
				return c;
			}
		return null;
	}

	public static void calcHeroesDamagesByTheirWeapons() {
		for(Character c:characters)
			if(c instanceof Hero)
				((Hero) c).calcHeroesNewDamage();
	}
	
	public static String[] getCharacterNames() {
		String[] out = new String[characters.size()];
		int i = 0;
		
		for(Character c:characters) {
			out[i] = c.getName();
			System.out.println(out[i]);
			i++;
			
	}
		return out;
	}
	
	public static String[] getEnemyNames() {
		int i = 0;
		for(Character c:characters) 
			if(!(c instanceof Hero)) {
				i++;
		}
		
		String[] out = new String[i];
		i = 0;
		
		for(Character c:characters) 
			if(!(c instanceof Hero)) {
				out[i] = c.getName();
				i++;
		}
	
		return out;
	}

	public static boolean createBattleField() {
		if(characters.isEmpty())
			return false;
		//Before creating the field, heroes should get their weapons
		calcHeroesDamagesByTheirWeapons();
		
		ArrayList<String> st = new ArrayList<String>();
		st.add("Dragon");
		st.add("Hero");
		for(int i = 0;i <= Math.floor(Math.random() * 2);i++)
		st.add("Skeleton");
		
		
		int rand = (int) Math.floor(Math.random() * characters.size());
		ArrayList<Character> ch = new ArrayList<Character>();
		ch.addAll(characters);
				
		while(st.size() != 0) {
				if (ch.get(rand) instanceof Dragon && st.indexOf("Dragon") != -1 ) {
					st.remove(st.indexOf("Dragon"));
					battleField.add(ch.get(rand));
				}
				else if (ch.get(rand) instanceof Hero && st.indexOf("Hero") != -1 ) {
					st.remove(st.indexOf("Hero"));
					battleField.add(ch.get(rand));
				}
				else if (ch.get(rand) instanceof Skeleton && st.indexOf("Skeleton") != -1 ) {
					st.remove(st.indexOf("Skeleton"));
					battleField.add(ch.get(rand));
				}
				ch.remove(ch.get(rand));
				rand = (int) Math.floor(Math.random() * ch.size());
		}
		return true;
	}
	
	public static ArrayList<Character> getBattleFieldCharacters() {
		return battleField;
	}
	
	public static String displayBattleFieldCharacters()  {
		String output = "";
		
		for(Character c:battleField)
			output+= c.toString() + "\n" + "----------" + "\n";
		
		return output;
	}
	
	public static ArrayList<String> startWar() {
		ArrayList<String> output = new ArrayList<String>();
		boolean gameContinue = true;
		ArrayList<Character> war = new ArrayList<Character>();
		war.addAll(battleField);
		Character superman = null, monster = null;
		
		for(int i = 0;i < war.size();i++)
			if(war.get(i) instanceof Hero) {
				superman = war.get(i);
				war.remove(superman);
				
			}
				
		while(gameContinue) {
			if(war.size() == 0) {
				gameContinue = false;
				output.add("Heroes win!");
				war.add(superman);
				break;
			}
			for(int i = 0;i < war.size();i++) {
				monster = war.get(i);
				superman.calcDamage(monster.getDamage());
				if(superman.isDead()) {
					output.add(monster.getName() + " killed " + superman.getName() + "!");
					gameContinue = false;
					output.add("Monsters win!");
					break;
				}
				else
					output.add(monster.getName() + "(" + ((Monster) monster).makeWarCry() + ")" + " gave " + monster.getDamage() + " to " + superman.getName() + "!");
				
				
			}
			if(!superman.isDead()) {
			monster = war.get((int)Math.floor(Math.random() * war.size()));
			monster.calcDamage(superman.getDamage());
			if(monster.isDead()) {
				output.add(superman.getName() + " killed " + monster.getName());
				((Hero)superman).setNumOfMonsterKill(((Hero)superman).getNumOfMonsterKill() + 1);
				war.remove(monster);
			}
			else
				output.add(superman.getName() + " gave " + superman.getDamage() + " to " + monster.getName() + "!");

			}
		}
		return output;
	}
	
	
}
