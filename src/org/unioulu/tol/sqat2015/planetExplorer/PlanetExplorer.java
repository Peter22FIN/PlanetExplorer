package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	
	private int x;
	private int y;
	private String[] obstacleX;
	private String[] obstacleY;
	private boolean isObstacles=true;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		
		this.x=x;
		this.y=y;
		int j=0;
		int k=0;
		String obstacle = "";

		if (obstacles.equals("")) {
			isObstacles=false;
		}
		else {
			for (int i = 0; i < obstacles.length();i++) {
				char o = obstacles.charAt(i);
				if (j==0 && o==40) j=1;
				else {
					if (o==44) {
					if (obstacles.equals("")){}
					else obstacleX[k] = obstacle;
					obstacle = "";
					}
					else if (o==41 || i+1==obstacles.length()) {
					if (obstacles.equals("")){}
					else obstacleY[k] = obstacle;
					obstacle = "";
					k++;
					j=0;
					}
					else {
						obstacle = obstacle + o;
					}
				}
			}	
		}
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */
		
		int pos_x=0;
		int pos_y=0;
		char facing=78;
		String location = pos_x + "," + pos_y + "," + facing;
		int collision=0;
		
		for (int i = 0; i < command.length();i++) {
			char c = command.charAt(i);
			if (c==102) { //forward
				if (facing == 78) pos_y++; //NORTH
				else if (facing == 83) pos_y--; //SOUTH
				else if (facing == 69) pos_x++; //EAST
				else if (facing == 87) pos_x--; //WEST
			}
			else if (c==98) { //backward
				if (facing == 78) pos_y--; //NORTH
				else if (facing == 83) pos_y++; //SOUTH
				else if (facing == 69) pos_x--; //EAST
				else if (facing == 87) pos_x++; //WEST
			}
			else if (c==114) { //right
				if (facing == 78) facing = 69; //NORTH -> EAST
				else if (facing == 83) facing = 87; //SOUTH -> WEST
				else if (facing == 69) facing = 83; //EAST -> SOUTH
				else if (facing == 87) facing = 78; //WEST -> NORTH
			}
			else if (c==114) { //right
				if (facing == 78) facing = 87; //NORTH -> WEST
				else if (facing == 83) facing = 69; //SOUTH -> EAST
				else if (facing == 69) facing = 78; //EAST -> NORTH
				else if (facing == 87) facing = 83; //WEST -> SOUTH
			}
			/*if (isObstacles) {
				for (int k = 0; k < obstacleX.length;k++) {
					if (pos_x == Integer.parseInt(obstacleX[k]) || pos_y == Integer.parseInt(obstacleY[k])) collision=1;
				}
			}*/
			if (pos_x>=0 && pos_x<=x && pos_y>=0 && pos_y<=y & collision == 0) location = pos_x + "," + pos_y + "," + facing;
			collision = 0;
		}
		
		return location;
	}
}
