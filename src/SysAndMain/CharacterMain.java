package SysAndMain;

import java.util.ArrayList;

import GUI.MainFrame;

public class CharacterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterSys.getWeapons();
		CharacterSys.readCharacter();
		
		 MainFrame main = new MainFrame();
		 main.setVisible(true);
	}
}
