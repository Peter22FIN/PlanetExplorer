package org.unioulu.tol.sqat2015.planetExplorer.tests;

import static org.junit.Assert.*;
import org.unioulu.tol.sqat2015.planetExplorer.*;
import org.junit.Test;

public class TestPlanetExplorer {

	@Test
	public void testCommandForwardVehicleGoesNorth() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		assertEquals("0,1,N", explorer.executeCommand("f"));
	}
	
	@Test
	public void testCommandRightVehicleTurnsEast() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		assertEquals("0,0,E", explorer.executeCommand("r"));
	}
	
	@Test
	public void testCommandFFRFreturns02E() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		assertEquals("1,2,E", explorer.executeCommand("ffrf"));
	}
	
	@Test
	public void testCommandVehicleCantGoOverPlanet() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"");
		assertEquals("0,3,N", explorer.executeCommand("ffff"));
	}
	
	@Test
	public void testCommandFwithObstacleReturns00N() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"(0,1)");
		assertEquals("0,0,N", explorer.executeCommand("f"));
	}
	
	@Test
	public void testCommandFFRFwithObstacleReturns00N() {
		PlanetExplorer explorer = new PlanetExplorer(3,3,"(0,2)");
		assertEquals("0,1,N", explorer.executeCommand("fff"));
	}
}
