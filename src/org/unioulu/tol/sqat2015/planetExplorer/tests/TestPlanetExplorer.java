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
}
