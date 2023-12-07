import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_C_GameObject extends GameObject implements KeyListener {

	public Type_C_GameObject(int x, int y) {
		super(x, y);
		setDirection(Direction.RIGHT);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_C_Left.png"));
		imageList.add(new ImageIcon("images/Type_C_Right.png"));
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconWidth = icon.getIconWidth();
		int canvasWidth = (int) c.getSize().getWidth();
		
		//moves right and left across the canvas when not active
		if (highlighted == false) {
			if (getDirection() == Direction.LEFT) {
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.RIGHT);
				}
			} 
			else if (getDirection() == Direction.RIGHT){
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.LEFT);
				}
			} 
			else {
				setDirection(Direction.NONE);
			}
		} 
		//movement if active
		else {
			switch (getDirection()) {
				case Direction.RIGHT:
					setX(getX() + getVelocity());
					if (getX() + iconWidth > canvasWidth) {
						setX((int) (canvasWidth - iconWidth));
					}
					break;
				case Direction.LEFT:
					setX(getX() - getVelocity());
					if (getX() < 0) {
						setX(0);
					}
					break;
				default:
					break;
			}
		}
	}
	
	public void setImage() {
		switch (getDirection()) {
	      case Direction.LEFT:
	        currentImage = 0;
	        break;
	      case Direction.RIGHT:
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
					setDirection(Direction.LEFT);
			} 
			else {
				setDirection(Direction.RIGHT);
			}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if (highlighted) {
		    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		        setDirection(Direction.RIGHT);
		    }
		    else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        setDirection(Direction.LEFT);
		    }
		}
	}
}
