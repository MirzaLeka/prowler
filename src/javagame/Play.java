package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	
	Animation Mirza, movingUp, movingDown, movingLeft, movingRight;
	Image Land;
	boolean quit = false;
	int[]duration = {200, 200}; //animation duration in fps
	float MirzaPositionX = 0;
	float MirzaPositionY = 0;
	float shiftX = MirzaPositionX + 512; //da se spawna na sredini mape
	float shiftY = MirzaPositionY + 384; //lik ce biti na sredini a svijet ce se pomjerati, kao mario
	// tako da imas osjecaj da se lik pomjera
//512 384
	
	boolean forestTalk = false;
	boolean senate = false;
	
	public Play(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		Land = new Image("res/1stCharacter.png");
		Image[] walkup = {new Image("res/Mirza back.png"), new Image("res/Mirza back.png")}; //kad ide gore prikazi mu ledja
		Image[] walkdown = {new Image("res/Mirza front.png"), new Image("res/Mirza front.png")}; //ide dole prikazi naprijed
		Image[] walkleft = {new Image("res/Mirza left.png"), new Image("res/Mirza left.png")};
		Image[] walkright = {new Image("res/Mirza right.png"), new Image("res/Mirza right.png")};
	
	movingUp = new Animation(walkup, duration, false); //animacija traje oko pola sekunde
	movingDown = new Animation(walkdown, duration, false);
	movingLeft = new Animation(walkleft, duration, false);
	movingRight = new Animation(walkright, duration, false);
	
	Mirza = movingDown; //po defaultu kada se pokrene igra lik ce gledati prema dole

	
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		Land.draw(MirzaPositionX, MirzaPositionY);	
		Mirza.draw(shiftX, shiftY);
		g.drawString("Mirza's X position " + MirzaPositionX + "\nMirza's Y position " + MirzaPositionY, 400, 20);
	
	    //press ESC, menu opens. Let's create it
		if (quit==true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
			if (quit==false) {
				g.clear();
			}
		}

		if (forestTalk == true) {
			g.drawString("Hey Mate!", 430, 400);
		}
		
		if (senate == true) {
			g.drawString("Mirza: Do you like your in game appearance?", 430, 360);
			g.drawString("Ermin: Bro, you are such a catfish.", 430, 380);
		}
		
	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		    Input input = gc.getInput();
		    
		    if (input.isKeyDown(Input.KEY_UP)) {
				Mirza = movingUp; //ovo mijenja sliku da vidim ledja
				MirzaPositionY += delta *.1f; //ovo pravi pokret
			} 
		    
		    if (input.isKeyDown(Input.KEY_DOWN)) {
				Mirza = movingDown; 
				MirzaPositionY -= delta *.1f; 
				
		/*		for (MirzaPositionX = -550; MirzaPositionX <= -502; MirzaPositionX++) {
					
				} */
				
				// if  x i y max pa unutra if x i y min Do 
				
	/*		if ((MirzaPositionX >= -550 & MirzaPositionX <= -502) & (MirzaPositionY <= -559 & MirzaPositionY >= -577)) {
					
					MirzaPositionY += delta * .1f;
				} */
				
			/*	for(MirzaPositionX = -550; MirzaPositionX <= -502; MirzaPositionX++) {
					
					for (MirzaPositionY = -559; MirzaPositionY >= -577; MirzaPositionY++) {
						
						MirzaPositionY += delta * .1f;
						
					}
						MirzaPositionY += delta * .1f;
				} */
				
				//Azija, desni toranj, suma, planina
				
				/*
				 * NESTED LOOP
				 *  i = koordinate za x
				 *  i ide od npr -555 do -520
				 *  
				 *  j = koordinate za y
				 *  j ide od npr -598 do -421
			    */
				
			/*	if ((MirzaPositionX > -550 & MirzaPositionX < -537) & (MirzaPositionY < -559 & MirzaPositionY > -562)) {
					MirzaPositionY += delta * .1f;
				}
				if ((MirzaPositionX > -537 & MirzaPositionX < -520) & (MirzaPositionY < -562 & MirzaPositionY > -571)) {
					MirzaPositionY += delta * .1f;
				}
				if ((MirzaPositionX > -520 & MirzaPositionX < -510) & (MirzaPositionY < -571 & MirzaPositionY > -576)) {
					MirzaPositionY += delta * .1f;
				}
				if ((MirzaPositionX > -510 & MirzaPositionX < -502) & (MirzaPositionY < -576 & MirzaPositionY > -578)) {
					MirzaPositionY += delta * .1f;
				} */
				
			}
		    
		    if (input.isKeyDown(Input.KEY_LEFT)) {
				Mirza = movingLeft; 
				MirzaPositionX += delta *.1f;
			}
		    
		    if (input.isKeyDown(Input.KEY_RIGHT)) {
				Mirza = movingRight; 
				MirzaPositionX -= delta *.1f; 
				if ((MirzaPositionX < -550 & MirzaPositionX > -562)  & (MirzaPositionY < -506 & MirzaPositionY > -561)) {
					MirzaPositionX += delta *.1f;
			}
		          }
		    
		    
				
		    //escape key
		    if (input.isKeyDown(Input.KEY_ESCAPE)) {
		    	quit = true;
		    }
		    //when the menu is up
		    if (quit==true) {
		    	 if (input.isKeyDown(Input.KEY_R)) {
		    	   quit = false;        }
		    	 if (input.isKeyDown(Input.KEY_M)) {
		    	    sbg.enterState(0);   }
		    	 if (input.isKeyDown(Input.KEY_Q)) {
		 		    	System.exit(0);		    }
			}

		    if ((MirzaPositionX < -490 & MirzaPositionX > -624) & (MirzaPositionY < -1005 &  MirzaPositionY > -1048)){
			  	 sbg.enterState(2); /** Enters Japan */
		  }
		    
		  
		   if ((MirzaPositionX < - 573 & MirzaPositionX > -832) & (MirzaPositionY < - 570 & MirzaPositionY > -696)) {
			if (input.isKeyPressed(input.KEY_Q)) {
				forestTalk = true;
			}
		} 
		 
			if (forestTalk == true) {
				if (input.isKeyDown(input.KEY_E)) {
					forestTalk = false;
				}
			}
			
			
			 if ((MirzaPositionX < - 13 & MirzaPositionX > -369) & (MirzaPositionY < -718 & MirzaPositionY > -857)) {
					if (input.isKeyPressed(input.KEY_Q)) {
						senate = true;
					}
				} 
				 
					if (senate == true) {
						if (input.isKeyDown(input.KEY_E)) {
							senate = false;
						}
					}
				
			
		   
	}
	
	
	// if ((MirzaPositionX < -490 & MirzaPositionY > -1048) & (MirzaPositionX > -624 &  MirzaPositionX < -1005)){
	//if ((MirzaPositionX < -490 & MirzaPositionX < -1005) & (MirzaPositionX > -624 & MirzaPositionY > -1048)){
	public int getID() {
		return 1;
	}
	
}
