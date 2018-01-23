package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Japan extends BasicGameState{
	
	
	Animation Mirza, movingUp, movingDown, movingLeft, movingRight;
	Image stage2;
	
	boolean quit = false;
	int[]duration = {200, 200}; //animation duration in fps
	float MirzaPositionX = -537;
	float MirzaPositionY = -137;
	float shiftX = 512; //da se spawna na sredini mape 850 / 550
	float shiftY = 384; //lik ce biti na sredini a svijet ce se pomjerati, kao mario
	// tako da imas osjecaj da se lik pomjera
//512 384
	public Japan(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		stage2 = new Image("res/testEnvironment.png");
		Image[] walkup = {new Image("res/Mirza back.png"), new Image("res/Mirza back.png")}; //kad ide gore prikazi mu ledja
		Image[] walkdown = {new Image("res/Mirza front.png"), new Image("res/Mirza front.png")}; //ide dole prikazi naprijed
		Image[] walkleft = {new Image("res/Mirza left.png"), new Image("res/Mirza left.png")};
		Image[] walkright = {new Image("res/Mirza right.png"), new Image("res/Mirza right.png")};
	
	movingUp = new Animation(walkup, duration, false); //animacija traje oko pola sekunde
	movingDown = new Animation(walkdown, duration, false);
	movingLeft = new Animation(walkleft, duration, false);
	movingRight = new Animation(walkright, duration, false);
	
	Mirza = movingLeft; //po defaultu kada se pokrene mapa lik ce gledati prema lijevo

	
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		stage2.draw(MirzaPositionX, MirzaPositionY);	
		Mirza.draw(shiftX, shiftY);
		g.drawString("Mirza's X position" + MirzaPositionX + "\nMirza's Y position" + MirzaPositionY, 400, 20);
	
	    //press ESC, menu opens. Let's create it
		if (quit==true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit Game (Q)", 250, 200);
			if (quit==false) {
				g.clear();
			}
		}

	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		    Input input = gc.getInput();
		    
		    if (input.isKeyDown(Input.KEY_UP)) {
				Mirza = movingUp; //ovo mjenja sliku da vidim ledja
				MirzaPositionY += delta *.1f; //ovo pravi pokret
		/*		if ((MirzaPositionX > -122 & MirzaPositionX < -23) & (MirzaPositionY > 160 & MirzaPositionY < 178)) {
					MirzaPositionY -= delta * .1f;
				}
				if ((MirzaPositionX < -243 & MirzaPositionX > -694) & MirzaPositionY > -38) {
					MirzaPositionY -= delta * .1f;
				}
			    if ((MirzaPositionX < 170 & MirzaPositionX > -243) & MirzaPositionY > 305) {
			    	MirzaPositionY -= delta * .1f;
				}
			    if ((MirzaPositionX < 442 & MirzaPositionX > 170) & MirzaPositionY > 164) {
			    	MirzaPositionY -= delta * .1f;					
				} */
			}
		    
		    if (input.isKeyDown(Input.KEY_DOWN)) {
				Mirza = movingDown; //ovo mjenja sliku da vidim ledja
				MirzaPositionY -= delta *.1f; //ovo pravi pokret
		/*	    if ((MirzaPositionX < -125 & MirzaPositionX > -688) & MirzaPositionY < -174) {
			    	MirzaPositionY += delta * .1f;
				}
			    if (MirzaPositionY < 27 & (MirzaPositionX < 442 & MirzaPositionX > 40)) {
			    	MirzaPositionY += delta * .1f; 
				}
			    if (MirzaPositionY < 27 & (MirzaPositionX >-122 & MirzaPositionX < 23)) {
			    	MirzaPositionY += delta * .1f;
				}
			    if ((MirzaPositionY < 178 & MirzaPositionY > 167) & (MirzaPositionX > -122 & MirzaPositionX < 42)) {
			    	MirzaPositionY += delta * .1f;
				} */
			}
		    
		      if (input.isKeyDown(Input.KEY_LEFT)) {
				Mirza = movingLeft; //ovo mjenja sliku da vidim ledja
				MirzaPositionX += delta *.1f; //ovo pravi pokret
		/*		
				if (MirzaPositionX < -158 & MirzaPositionX > -468 & MirzaPositionY < 398 & MirzaPositionY > 131) {
					MirzaPositionX -= delta *.1f; 
				} */
				
				while (MirzaPositionX < -158 & MirzaPositionX < -468 & MirzaPositionY > 131 & MirzaPositionY < 398 ) {
				    	MirzaPositionX -= delta *.1f; 
				    } 
				
		//		if (MirzaPositionX > -125 & (MirzaPositionY >-185 & MirzaPositionY <21)) {
		//			MirzaPositionX -= delta *.1f; //INVERT IT
		//		}
		//		if ((MirzaPositionX < 8 & MirzaPositionX > -23) & (MirzaPositionY < 160 & MirzaPositionY > 27)) {
		//			MirzaPositionX -= delta *.1f;
		//		}
		//		if ((MirzaPositionX > -25 & MirzaPositionX < 9) & (MirzaPositionY < 178 & MirzaPositionY > 27)) {
		//			MirzaPositionX -= delta *.1f;
		//		}
		//		if ((MirzaPositionY < 178 & MirzaPositionY > 160) & (MirzaPositionX > -130 & MirzaPositionX < 44) ) {
		//			MirzaPositionX -= delta *.1f;
		//		}
		//	    if ((MirzaPositionY > 164 & MirzaPositionY < 305) & MirzaPositionX > 170) {
		//	    	MirzaPositionX -= delta *.1f;	
		//		}
		//	    if (MirzaPositionX > 378 & MirzaPositionX < 380){
		//		  	 sbg.enterState(1); /** Enters testEnvironment */
		//	  }
			    
			}
		    
		    if (input.isKeyDown(Input.KEY_RIGHT)) {
				Mirza = movingRight; //ovo mjenja sliku da vidim ledja
				MirzaPositionX -= delta *.1f; //ovo pravi pokret
		/*		if ((MirzaPositionX > 8 & MirzaPositionX < 44)  & (MirzaPositionY < 178 & MirzaPositionX > 27)) {
					MirzaPositionX += delta *.1f;
				}
				if ((MirzaPositionY > -38 & MirzaPositionY < 305) & (MirzaPositionX < -243)) {
					MirzaPositionX += delta *.1f; //46
				} */
			
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
		    


		/*  if ((MirzaPositionX > -490 & MirzaPositionX < -624) && (MirzaPositionY > -1048 && MirzaPositionX < 1005)) {
			 sbg.enterState(2); 
		  }
	*/	  
	}
	
	public int getID() {
		return 2;
	}
	
}
