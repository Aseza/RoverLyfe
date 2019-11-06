package main;

import java.util.List;

import business.Rover;
import business.RoverFileReader;
import enums.CompassDirection;
import exceptions.InconsistentInfoException;

public class Mainer {

	public static void main(String[] args) throws InconsistentInfoException {
		RoverFileReader rf = new RoverFileReader();
		
		List<Rover> roversList = rf.readRovers(args[0]);
		
		for (Rover rover : roversList) {
			int[] roverFinalPosition = rover.getFinalPosition();
			CompassDirection roverFinalFacingDirection = rover.getFinalFacingDirection();
			System.out.println(
					roverFinalPosition[0] + " " + 
					roverFinalPosition[1] + " " + 
					roverFinalFacingDirection);

		}
	}
}
