package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class testEnvironment extends BasicGameState{
	
	
	Animation Mirza, movingUp, movingDown, movingLeft, movingRight;
	Image testStage;
	
	boolean quit = false;
	int[]duration = {200, 200}; //animation duration in fps
	float MirzaPositionX = 0;
	float MirzaPositionY = 0;
	float shiftX = MirzaPositionX + 512; //da se spawna na sredini mape
	float shiftY = MirzaPositionY + 384; //lik ce biti na sredini a svijet ce se pomjerati, kao mario
	// tako da imas osjecaj da se lik pomjera
//512 384
	public testEnvironment(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		testStage = new Image("res/testEnvironment.png");
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
		testStage.draw(MirzaPositionX, MirzaPositionY);	
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
				
			}
		    
		    if (input.isKeyDown(Input.KEY_DOWN)) {
				Mirza = movingDown; //ovo mjenja sliku da vidim ledja
				MirzaPositionY -= delta *.1f; //ovo pravi pokret
			  
			}
		    
		    if (input.isKeyDown(Input.KEY_LEFT)) {
				Mirza = movingLeft; //ovo mjenja sliku da vidim ledja
				MirzaPositionX += delta *.1f; //ovo pravi pokret
			
				
			}
		    
		    if (input.isKeyDown(Input.KEY_RIGHT)) {
				Mirza = movingRight; //ovo mjenja sliku da vidim ledja
				MirzaPositionX -= delta *.1f; //ovo pravi pokret
				
			
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
