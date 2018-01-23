package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "Prowler early demo";
    public static final int menu = 0;
    public static final int play = 1;
    public static final int japan = 2;

    
    
    public Game(String gamename) {
    	super(gamename); 
    	this.addState(new Menu(menu));
    	this.addState(new Play(play));
    	this.addState(new Japan(japan));

    }
    
    public void initStatesList(GameContainer gc) throws SlickException{ //inicijaliziramo ekrane
    	this.getState(menu).init(gc, this); 
    	this.getState(play).init(gc, this);
    	this.getState(japan).init(gc, this);  
    	this.enterState(menu); 
    }

	public static void main(String[] args) {
		
		AppGameContainer appgc; 
		try { 
			appgc = new AppGameContainer(new Game(gamename)); 
			appgc.setDisplayMode(1024, 768, false); 
			appgc.start();
		}catch(SlickException e) {
			e.printStackTrace();
		}
		
	

	}

}
