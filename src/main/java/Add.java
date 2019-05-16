public class Add extends Command {
	
	private int dr;
	private int sr1;
	private boolean usingImm;
	private int sr2;
	private int imm5;

	public Add(short value, Op opcode, int dr, int sr1, boolean usingImm, 
				int sr2, int imm5) {
		super(value, opcode);
		this.dr = dr;
		this.sr1 = sr1;
		this.usingImm = usingImm;
		this.sr2 = sr2;
		this.imm5 = imm5;
	}

	public static Add parseAddCommand(short value) {
		Op opcode = Op.ADD;
		int dr = ((int) value >> 9) & 7;
		int sr1 = ((int) value >> 6) & 7;
		
		int imm5Indicator = ((int) value >> 5) & 1;
		if (imm5Indicator == 1) {
			int imm5 = ((int) value) & 31;
			return new Add(value, opcode, dr, sr1, true, 0, imm5);
		} else {
			int sr2 = ((int) value) & 7;
			return new Add(value, opcode, dr, sr1, false, sr2, 0);
		}

	}
}