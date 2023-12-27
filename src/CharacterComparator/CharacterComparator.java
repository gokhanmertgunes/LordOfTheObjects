package CharacterComparator;

import java.util.Comparator;
import CharacterSet.Character;

public class CharacterComparator implements Comparator<Character>{

	@Override
	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		if(o2.getHealth() == o1.getHealth())
			return 1;
		return o2.getHealth() - o1.getHealth(); //descending order
	}

}
