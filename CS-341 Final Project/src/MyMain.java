public class MyMain {

	public static void main(String[] args) {
		
		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT OF TYPE D
		Type_D_GameObject objectD = new Type_D_GameObject(400, 500);
		objectD.setVelocity(10);
		canvas.addGameObject(objectD);
		canvas.addKeyListener(objectD);
		
		Type_A_GameObject objectA = new Type_A_GameObject(550, 25);
		objectA.setVelocity(10);
		canvas.addGameObject(objectA);
		canvas.addKeyListener(objectA);
		
		Type_C_GameObject objectC = new Type_C_GameObject(200, 400);
		objectC.setVelocity(10);
		canvas.addGameObject(objectC);
		canvas.addKeyListener(objectC);
		
		Type_B_GameObject objectB = new Type_B_GameObject(100, 200);
		objectB.setVelocity(10);
		canvas.addGameObject(objectB);
		canvas.addKeyListener(objectB);

	}

}
