public class Not extends Command {
	private int dr;
	private int sr;

	/**
	 * Constructor for the Not command. Intended to be used internally by the
	 * parseNotCommand method, that's called by Command.
	 */
	public Not(short bytes, Op opcode, int dr, int sr) {
		super(bytes, opcode);
		this.dr = dr;
		this.sr = sr;
	}

	@Override
	public void execute() {
		short newValue = (short) ~Computer.getRegister(sr);
		Computer.setRegister(dr, newValue);

		Cond newCC = Cond.parseCC(newValue);

		Computer.setCC(newCC);
	}


	/**
	 * Converts a 16-bit value into a valid NOT command. Parses out source
	 * and destination registers.
	 * @param value - the 16-bit value representing the command
	 * @return valid Not command object
	 */
	public static Not parseNotCommand(short bytes) {
		Op opcode = Op.NOT;
		int dr = (int) (bytes >> 9) & 7;
		int sr = (int) (bytes >> 6) & 7;

		return new Not(bytes, opcode, dr, sr);
	}
}