/**
 * Object representing the most generic kind of command held in the memory of
 * the LC-3. All actionable commands (e.g. ADD, LDR, NOT) extend Command, but
 * Command can be instantiated in the case of malformed commands.
 */
public class Command {
        protected short bytes;
        protected Op opcode;
        protected String label;
        protected String comment;

        /**
         * Generic constructor for a Command object. Sets the short bytes value
         * and the provided opcode enum.
         * @param bytes the numeric value of the command
         * @param op the opcode of the command
         */
        public Command(short bytes, Op op) {
                this.bytes = bytes;
                this.opcode = op;
        }

        /**
         * Method itended to be overwritten by subclasses, so that the computer
         * memory can be iterated over. If a Command object has this called on it,
         * that means that it's a malformed operation, so we throw an exception.
         */
        public void execute() {
                throw new UnsupportedOperationException();
        }

        /**
         * Static helper method that takes a short and returns a command object.
         * @param com the short representation of the machine code passed in
         * @return a Command object representation
         */
        public static Command parseCommand(short com) {
                Op op = parseOpcode(com);
                return new Command(com, op);
        }

        @Override
        public String toString() {
                String byteString = String.format("%1$" + 16 + "s", Integer.toBinaryString((int) bytes)).replace(' ', '0');
                return opcode.name() + ": " + byteString;
        }

        /**
         * Static helper method that returns the Op enum representation of a command's short value passed in.
         * @param com the short value of the command
         * @return an Op enum representing the type of command
         */
        public static Op parseOpcode(short com) {
                if (com > 15) {
                        com = (short) ((int) com >>> 12);
                }
                if (com > 15 || com < 0) {
                        return Op.NOP;
                }
                switch ((int) com) {
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
                                return Op.NOP;
                        case 9:
                                return Op.NOT;
                        case 10:
                                return Op.LDI;
                        case 11:
                                return Op.STI;
                        case 12:
                                return Op.JMP;
                        case 13:
                                return Op.NOP;
                        case 14:
                                return Op.LEA;
                        case 15:
                                return Op.TRAP;
                }

                return Op.NOP;
        }
}
