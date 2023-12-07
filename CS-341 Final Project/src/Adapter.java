import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Adapter extends Type_D_GameObject {
	
	public Adapter(Type_B_GameObject objectB) {
		super(objectB.getX(), objectB.getY());
		setDirection(Direction.NONE);
		
		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_B_Up.png"));
		imageList.add(new ImageIcon("images/Type_B_Down.png"));
		imageList.add(new ImageIcon("images/Type_B_Left.png"));
		imageList.add(new ImageIcon("images/Type_B_Right.png"));
	}
	
	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		int iconHeight = icon.getIconHeight();
		int iconWidth = icon.getIconWidth();
		int canvasHeight = (int) c.getSize().getHeight();
		int canvasWidth = (int) c.getSize().getWidth();

		//D object passive movement
		if (highlighted == false) {
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.RIGHT);
				}
				break;
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
					setDirection(Direction.DOWN);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.LEFT);
				}
				break;
			case Direction.LEFT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
					setDirection(Direction.UP);
				}
				break;
			default:
				setDirection(Direction.NONE);
			}
		} 
		
		//D object active movement
		else {
			switch (getDirection()) {
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
			case Direction.LEFT:
				setX(getX() - getVelocity());
				if (getX() < 0) {
					setX(0);
				}
				break;
			case Direction.RIGHT:
				setX(getX() + getVelocity());
				if (getX() + iconWidth > canvasWidth) {
					setX((int) (canvasWidth - iconWidth));
				}
				break;
			default:
				break;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		//stop movement if active object is activated
		if (e.getKeyCode() == KeyEvent.VK_TAB && highlighted == true) {
			setDirection(Direction.NONE);
		}

		//stop movement if object is active and no arrow keys are pressed
		else if ((e.getKeyCode() != KeyEvent.VK_TAB && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN &&
				e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_LEFT) && highlighted == true) {
			setDirection(Direction.NONE);
		}	

		//default movement if object is not active
		else if (getDirection() == Direction.NONE && highlighted == false) {
			if (currentImage == 0) {
				setDirection(Direction.UP);
			} 
			else if (currentImage == 1) {
				setDirection(Direction.DOWN);
			} 
			else if (currentImage == 2) {
				setDirection(Direction.LEFT);
			} 
			else {
				setDirection(Direction.RIGHT);
			}
		}
	}
}
