package utils;

import enums.CompassDirection;

public class CompassUtils {
	public static CompassDirection getNextCompassDirectionEnumOf(CompassDirection facingDirection) {
		switch (facingDirection) {
		case N:
			return CompassDirection.E;
		case E:
			return CompassDirection.S;
		case S:
			return CompassDirection.W;
		case W:
			return CompassDirection.N;

		}
		return facingDirection;

	}

	public static CompassDirection getPreviousCompassDirectionEnumOf(CompassDirection facingDirection) {
		switch (facingDirection) {
		case N:
			return CompassDirection.W;
		case W:
			return CompassDirection.S;
		case S:
			return CompassDirection.E;
		case E:
			return CompassDirection.N;

		}

		return facingDirection;

	}
}
