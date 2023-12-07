import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {

	public Type_A_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.UP);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();
	
		//moves up and down across the canvas when not active
		if (highlighted == false) {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
				}
			} 
			else if (getDirection() == Direction.DOWN){
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
				}
			} 
			else {
				setDirection(Direction.NONE);
			}

		} 
		else {
			switch(getDirection()) {
				case Direction.UP:
					setY(getY() - getVelocity());
					if (getY() < 0) {
						setY(0);
					}
					break;
				case Direction.DOWN:
					setY(getY() + getVelocity());
					if (getY() + iconHeight > canvasHeight) {
						setY((int) (canvasHeight - iconHeight));
					}
					break;
				default:
					break;
			}
		}
	}
	
	public void setImage() {
	    switch (getDirection()) {
	      case Direction.DOWN:
	        currentImage = 0;
	        break;
	      case Direction.UP:
	        currentImage = 1;
	        break;
	    }
	}
	
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_TAB && highlighted == true) {
			setDirection(Direction.NONE);
	    } 
		if (e.getKeyCode() == KeyEvent.VK_TAB && highlighted == true) {
			setDirection(Direction.NONE);
		}
			
		else if (highlighted == false && getDirection() == Direction.NONE) {
			if (currentImage == 0) {
				setDirection(Direction.DOWN);
			} 
			else {
				setDirection(Direction.UP);
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (highlighted) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			    
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
		}
	}
}
