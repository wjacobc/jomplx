/**
 * Object representing the main LC-3 computer. Has registers, memory,
 * condition code, and other shared resources.
 */
public class Computer {
    private static final int maxMemory = 65536;
    private static short[] registers = new short[8];
    private static Command[] memory = new Command[maxMemory];
    private static short pc;
    private static Cond cc;

    /**
     * Method to set a particular register - requires converting the register
     * to an int first to index into the array and handle two's complement
     * @param register - the register to be changed
     * @param value - the short value you're setting the register to
     */
    public static void setRegister(int register, short value) {
        registers[register] = value;
    }

    /**
     * Method to set a memory location - also requires converting memory
     * location to an int
     * @param memoryLocation - the memory location we are setting
     * @param value - the short value you're setting the memory location to
     */
    public static void setMemory(int memoryLocation, short value) {
        memory[memoryLocation] = Command.parseCommand(value);
    }

    /**
     * Method to set a memory location, but takes in a command, not a value
     * @param memoryLocation - the memory location we are setting
     * @param com - the Command object you're setting the memory location to
     */
    public static void setMemory(int memoryLocation, Command com) {
        memory[memoryLocation] = com;
    }

    /**
     * Returns the value of a memory location
     * @param memoryLocation - the location in memory to get
     * @return the short value at that location
     */
    public static Command getMemory(int memoryLocation) {
        return memory[memoryLocation];
    }

    /**
     * Returns the value of a register
     * @param register - the register to get
     * @return the short value at that location
     */
    public static short getRegister(int register) {
        return registers[register];
    }

    /**
     * Sets the computer's condition code
     * @param newCC - the new condition code value
     */
    public static void setCC(Cond newCC) {
        cc = newCC;
    }

    /**
     * Returns the condition code of the computer, as a Cond enum value
     * @return the value of the computer's condition code
     */
    public static Cond getCC() {
        return cc;
    }

}
