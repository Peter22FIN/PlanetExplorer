package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 111
// Finish time: 2 hours
public class PlanetExplorer {
	
	private int x;
	private int y;
	private int[] obstacleX;
	private int[] obstacleY;
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
		obstacleX = new int[10];
		obstacleY = new int[10];

		if (obstacles.equals("")) {
			isObstacles=false;
		}
		else {
			for (int i = 0; i < obstacles.length();i++) {
				char o = obstacles.charAt(i);
				if (j==0 && o==40) j=1;
				else {
					if (o==44) {
					obstacleX[k] = Integer.parseInt(obstacle);
					obstacle = "";
					}
					else if (o==41 || i+1==obstacles.length()) {
					obstacleY[k] = Integer.parseInt(obstacle);
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
		int new_x=pos_x;
		int new_y=pos_y;
		char facing=78;
		String location = pos_x + "," + pos_y + "," + facing;
		int collision=0;
		
		for (int i = 0; i < command.length();i++) {
			char c = command.charAt(i);
			if (c==102) { //forward
				if (facing == 78) new_y++; //NORTH
				else if (facing == 83) new_y--; //SOUTH
				else if (facing == 69) new_x++; //EAST
				else if (facing == 87) new_x--; //WEST
			}
			else if (c==98) { //backward
				if (facing == 78) new_y--; //NORTH
				else if (facing == 83) new_y++; //SOUTH
				else if (facing == 69) new_x--; //EAST
				else if (facing == 87) new_x++; //WEST
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
			if (isObstacles) {
				for (int k = 0; k < obstacleX.length;k++) {
					if (new_x == obstacleX[k] && new_y == obstacleY[k]) collision=1;
				}
			}
			if (new_x>=0 && new_x<=x && new_y>=0 && new_y<=y && collision == 0){
				pos_x=new_x;
				pos_y=new_y;
				location = pos_x + "," + pos_y + "," + facing;
			}
			else {
			new_x=pos_x;
			new_y=pos_x;
			}
			collision = 0;
		}
		
		return location;
	}
}
