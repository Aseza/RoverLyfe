package business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import enums.ActionDirection;
import enums.CompassDirection;
import exceptions.InconsistentInfoException;

public class RoverFileReader {
	List<Rover> roversList;

	public RoverFileReader() {
		roversList = new ArrayList<Rover>();
	}
	public List<Rover> readRovers(String name) {
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(name));
			
			if (lines.size() % 2 == 0)
				throw new InconsistentInfoException();
			
			int[] gridSize = readPositionCoordinates(lines.get(0));
			
			for (int i = 0, j = 1; i < lines.size() - 1; i += 2, j += 2) {
				roversList.add(
						new Rover(readPositionCoordinates(lines.get(i + 1)), 
						readInstructions(lines.get(j + 1)),
						readFirstPositionFacingDirection(lines.get(j)),
						gridSize));

			}
			return roversList;

		} catch (InconsistentInfoException e) {
			System.err.println("File instructions are inconsistent");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO EXCEPTION, plz check file path");
		}

		return roversList;

	}


	public int[] readPositionCoordinates(String line) throws InconsistentInfoException {
		int xCoordinate = Integer.parseInt(line.split(" ")[0]);
		int yCoordinate = Integer.parseInt(line.split(" ")[1]);
		return new int[] { xCoordinate, yCoordinate };

	}

	public CompassDirection readFirstPositionFacingDirection(String line) {
		return CompassDirection.valueOf(line.split(" ")[2]);

	}

	public ActionDirection[] readInstructions(String line) throws InconsistentInfoException {
		ActionDirection[] instructions = new ActionDirection[line.length()];
		for (int i = 0; i < line.length(); i++) {
			instructions[i] = ActionDirection.valueOf(Character.toString(line.charAt(i)));
		}
		return instructions;

	}
	


}
