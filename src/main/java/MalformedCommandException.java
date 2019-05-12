/**
 * Exception to be thrown by the computer emulation when a command is invalid
 */
public class MalformedCommandException extends RuntimeException {
	
	/**
	 * Exception constructor that can display both the memory location and a
	 * custom message.
	 * @param mem the integer value representing the memory location where the
	 *			  malformed command was located
	 * @param message the String representing the custom message
	 */
	public MalformedCommandException(int mem, String message) {
		super(message + " at memory location " + Integer.toHexString(mem));
	}
	
	/**
	 * Exception constructor that can display a memory location
	 * @param mem the integer value representing the memory location where the
	 *				malformed command was located
	 */
	public MalformedCommandException(int mem) {
		super("Malformed command at memory location " + Integer.toHexString(mem));
	}

	/**
	 * Basic exception constructor that displays no additional information.
	 */
	public MalformedCommandException() {
		super("Malformed command.");
	}
}