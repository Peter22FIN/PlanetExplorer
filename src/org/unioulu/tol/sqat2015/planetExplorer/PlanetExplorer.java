package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID:
// Finish time:
public class PlanetExplorer {
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
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
		
		for (int index = 0; index < command.length();index++) {
			char c = command.charAt(index);
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
			//location = pos_x + "," + pos_y + "," + facing;
		}
		
		return location;
	}
}
