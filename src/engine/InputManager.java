package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Manages keyboard input for the provided screen.
 * 
 * @author <a href="mailto:RobertoIA1987@gmail.com">Roberto Izquierdo Amo</a>
 * 
 */
public final class InputManager implements KeyListener {

	/** Number of recognised keys. */
	private static final int NUM_KEYS = 256;
	/** Array with the jeys marked as pressed or not. */
	private static boolean[] keys;
	/** Singleton instance of the class. */
	private static InputManager instance;

	/**
	 * Private constructor.
	 */
	private InputManager() {
		keys = new boolean[NUM_KEYS];
	}

	/**
	 * Returns shared instance of InputManager.
	 * 
	 * @return Shared instance of InputManager.
	 */
	protected static InputManager getInstance() {
		if (instance == null)
			instance = new InputManager();
		return instance;
	}

	/**
	 * Returns true if the provided key is currently pressed.
	 * 
	 * @param keyCode
	 *            Key number to check.
	 * @return Key state.
	 */
	public boolean isKeyDown(final int keyCode) {
		return keys[keyCode];
	}

	/**
	 * Changes the state of the key to pressed.
	 * 
	 * @param key
	 *            Key pressed.
	 */
	@Override
	public void keyPressed(final KeyEvent key) {
		if (key.getKeyCode() >= 0 && key.getKeyCode() < NUM_KEYS)
			keys[key.getKeyCode()] = true;
	}

	/**
	 * Changes the state of the key to not pressed.
	 * 
	 * @param key
	 *            Key released.
	 */
	@Override
	public void keyReleased(final KeyEvent key) {
		if (key.getKeyCode() >= 0 && key.getKeyCode() < NUM_KEYS)
			keys[key.getKeyCode()] = false;
	}

	/**
	 * Does nothing.
	 * 
	 * @param key
	 *            Key typed.
	 */
	@Override
	public void keyTyped(final KeyEvent key) {

	}

	// p1 input（WASD + SPACE）
	public boolean p1Right() { return isKeyDown(KeyEvent.VK_D); }
	public boolean p1Left()  { return isKeyDown(KeyEvent.VK_A); }
	public boolean p1Up()    { return isKeyDown(KeyEvent.VK_W); }
	public boolean p1Down()  { return isKeyDown(KeyEvent.VK_S); }
	public boolean p1Fire()  { return isKeyDown(KeyEvent.VK_SPACE); }

	// p2 input（方向键 + ENTER）
	public boolean p2Right() { return isKeyDown(KeyEvent.VK_RIGHT); }
	public boolean p2Left()  { return isKeyDown(KeyEvent.VK_LEFT); }
	public boolean p2Up()    { return isKeyDown(KeyEvent.VK_UP); }
	public boolean p2Down()  { return isKeyDown(KeyEvent.VK_DOWN); }
	public boolean p2Fire()  { return isKeyDown(KeyEvent.VK_ENTER); }

}