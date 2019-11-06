package business;

import enums.ActionDirection;
import enums.CompassDirection;
import utils.CompassUtils;

public class Rover {
	
	private int x, y;
	private int[] gridSize;
	private CompassDirection facingDirection,finalFacingDirection;
	private ActionDirection[] instructions;

	public void move(CompassDirection facingDirection) {
		switch (facingDirection) {
		case N:
			y++;
			break;
		case S:
			y--;
			break;
		case E:
			x++;
			break;
		case W:
			x++;
			break;

		}
	}

	public void checkThenExecuteMove(ActionDirection[] instructions) {
		for (ActionDirection inst : instructions) {
			switch (inst) {
			case M:
				move(facingDirection);
				if(x>gridSize[0] || y>gridSize[1]) throw new IndexOutOfBoundsException();
				break;
			case R:
				facingDirection = CompassUtils.getNextCompassDirectionEnumOf(facingDirection);
				break;
			case L:
				facingDirection = CompassUtils.getPreviousCompassDirectionEnumOf(facingDirection);
			default:
				break;
			}
		}
		finalFacingDirection = facingDirection;
	}


	public int[] getFinalPosition() {
		checkThenExecuteMove(instructions);
		return new int[] { x, y };
	}


	Rover(int[] coordinates, ActionDirection[] instructions, CompassDirection facingDirection, int[] gridSize) {
		x = coordinates[0];
		y = coordinates[1];
		this.instructions = instructions;
		this.facingDirection = facingDirection;
		this.gridSize = gridSize;
	}

	public CompassDirection getFinalFacingDirection() {
		return this.finalFacingDirection;
	}
}
