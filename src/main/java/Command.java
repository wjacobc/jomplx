public class Command {
	private short bytes;
	private Op opcode;


	public Command(short bytes, Op op) {
		this.bytes = bytes;
		this.opcode = op;
	}

	/**
	 * Static helper method that takes a short and returns a command object.
	 * @param com the short representation of the machine code command passed in
	 * @return a Command object representation
	 */
	public static Command parseCommand(short com) {
		short opcode = (short) ((int) com >>> 12);
		Op op = parseOpcode(opcode);
		return new Command(com, op);
	}

	@Override
	public String toString() {
		String byteString = String.format("%1$" + 16 + "s", Integer.toBinaryString((int) bytes)).replace(' ', '0');
		return opcode.name() + ": " + byteString;
	}

	public static Op parseOpcode(short opcode) {
		switch ((int) opcode) {
			case 0:
				return Op.BR;
			case 1:
				return Op.ADD;
			case 2:
				return Op.LD;
			case 3:
				return Op.ST;
			case 4:
				return Op.JSR;
			case 5:
				return Op.AND;
			case 6:
				return Op.LDR;
			case 7:
				return Op.STR;
			case 8:
				throw new MalformedCommandException();
			case 9:
				return Op.NOT;
			case 10:
				return Op.LDI;
			case 11:
				return Op.STI;
			case 12:
				return Op.JMP;
			case 13:
				throw new MalformedCommandException();
			case 14:
				return Op.LEA;
			case 15:
				return Op.TRAP;
		}

		return null;
	}
}