package javagame;

import org.newdawn.slick.*;
import org.lwjgl.input.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	
	
	private Music music;
	private Sound sound;
	
	Image PlayScreen;
	Image ExitScreen;
	
public Menu(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        PlayScreen = new Image("res/PlayScreen.png");
        ExitScreen = new Image("res/ExitScreen.png");
        
        music = new Music("res/menutheme.wav");
        music.setVolume(0.5f);
        music.loop();  
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Developed by SPY4ER", 100, 50);
        g.drawString("Controls ", 100, 100);
        g.drawString("Move: ARROWS ", 100, 120);
        g.drawString("Menu: ESCAPE ", 100, 140);
        g.drawString("Interact/Stop: Q/E ", 100, 160);
        
        g.drawString("BRIEFING:", 43, 610);
        g.drawString("Prowler, the sun is up. Time to go to work. Your mission is to locate three sleeper agents who recently", 43, 640);
        g.drawString("went rogue. Once you do so, you must send their coordinates to a game's developer. You will be rewarder",43, 660);
        g.drawString("with a cookie for each target, but beware these agents are trained to be invisible. ", 43, 680);
        g.drawString("Todays targets are Sam Fisher, Solid Snake and Agent 47. Details are on the internet.", 43, 700);
        
        PlayScreen.draw(10, -125);
        ExitScreen.draw(10, 125);
 
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
	    int posX = Mouse.getX();
	    int posY = Mouse.getY();
	    
	    //PLAY button
	    if (((posX>220) & (posX<820)) && ((posY>440) & (posY<570))) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}

	    //EXIT button
	    if (((posX>220) & (posX<820)) && ((posY>190) & (posY<320))) {
			if (Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}
	
	
	public int getID() {
		return 0; 
	}
	
}
