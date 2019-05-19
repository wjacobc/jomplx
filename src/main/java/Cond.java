public enum Cond {
	NEGATIVE, ZERO, POSITIVE;

	public static Cond parseCC(short value) {
		if (value < 0) {
			return Cond.NEGATIVE;
		} else if (value == 0) {
			return Cond.ZERO;
		} else {
			return Cond.POSITIVE;
		}
	}


}