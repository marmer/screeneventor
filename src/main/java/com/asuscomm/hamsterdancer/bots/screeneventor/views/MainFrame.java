package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;
import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;
import com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput.KeyCombinationListener;

import org.apache.commons.lang3.SerializationException;
import org.apache.commons.lang3.SerializationUtils;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;


/**
 * Main Window.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class MainFrame extends JFrame {
	/** Name of the save file. */
	private static final String SAVE_FILE_NAME = "saveFile";

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	static {
		final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		LogManager.getLogManager().reset();
		logger.setLevel(Level.OFF);
	}

	private final JPanel contentPane;

	private final ActionConfigPane actionsPane;

	private final ActionsScript actionsScript;

	private final KeyConfigPane controlsPane;

	private final ActionScriptPane scriptPane;

	/** Create the frame. */
	public MainFrame() {
		addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(final WindowEvent e) {
					storeActionsScript();
				}
			});
		setTitle("Screenevator - Let us play your games");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 675);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		actionsScript = loadActionsScript();

		actionsPane = new ActionConfigPane();
		actionsPane.setBorder(new TitledBorder(
				null,
				"Action",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(actionsPane, BorderLayout.NORTH);

		scriptPane = new ActionScriptPane(actionsScript, actionsPane);
		scriptPane.setBorder(new TitledBorder(
				null,
				"Script",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(scriptPane, BorderLayout.CENTER);

		final JPanel southPane = new JPanel();
		contentPane.add(southPane, BorderLayout.SOUTH);
		southPane.setLayout(new BorderLayout(0, 0));

		controlsPane = new KeyConfigPane();
		controlsPane.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"Controls",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		controlsPane.addKeyCombi("Get Mouse Position & Add Action", new KeyCombinationListener() {
				@Override
				public void keyCombinationReleased(final Integer... keys) {
					// TODO Auto-generated method stub
				}

				@Override
				public void keyCombinationPressed(final Integer... keys) {
					// TODO Auto-generated method stub
				}
			} /*,
               *NativeKeyEvent.VC_F7*/
			);
		controlsPane.addKeyCombi(
			"Get Mouse Position",
			new KeyCombinationListener() {
				@Override
				public void keyCombinationPressed(final Integer... keys) {
					// TODO Auto-generated method stub
				}

				@Override
				public void keyCombinationReleased(final Integer... keys) {
					// TODO Auto-generated method stub
				}
			},
			NativeKeyEvent.VC_F6);
		controlsPane.addKeyCombi(
			"Start/Stop Script",
			new KeyCombinationListener() {
				@Override
				public void keyCombinationPressed(final Integer... keys) {
					// TODO Auto-generated method stub
				}

				@Override
				public void keyCombinationReleased(final Integer... keys) {
					// TODO Auto-generated method stub
				}
			},
			NativeKeyEvent.VC_F8,
			NativeKeyEvent.VC_CONTROL_L);
		southPane.add(controlsPane);

		final JPanel statusPane = new StatusPane(actionsScript);
		final GridBagLayout gridBagLayout = (GridBagLayout) statusPane.getLayout();
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		southPane.add(statusPane, BorderLayout.SOUTH);
	}

	private ActionsScript loadActionsScript() {
		if (Files.exists(Paths.get(SAVE_FILE_NAME))) {
			try {
				return (ActionsScript) SerializationUtils.deserialize(new FileInputStream(
							SAVE_FILE_NAME));
			} catch (FileNotFoundException | IllegalArgumentException | SerializationException |
					SecurityException e) {
				// maybe file is not readable or does not exist
			}
		}

		return new ActionsScript();
	}

	private void storeActionsScript() {
		try {
			SerializationUtils.serialize(actionsScript, new FileOutputStream(SAVE_FILE_NAME));
		} catch (final FileNotFoundException | IllegalArgumentException | SerializationException |
				SecurityException e1) {
			// no need to handle. It's just not possible to save the script
		}

		// TODO provide a better way to save the states and save states
	}

	/**
	 * Launch the application.
	 *
	 * @param args args
	 */
	public static void main(final String[] args) {
		setLookAndFeel();
		registerNativeKeyHook();

		EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						final MainFrame frame = new MainFrame();
						frame.setVisible(true);
					} catch (final Exception e) {
						e.printStackTrace();
					}
				}
			});
	}

	private static void registerNativeKeyHook() {
		try {
			if (!GlobalScreen.isNativeHookRegistered()) {
				GlobalScreen.registerNativeHook();
			}
		} catch (final NativeHookException ex) {
			throw new ScreenevatorException("There was a problem registering the native hook.", ex);
		}
	}

	private static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
				UnsupportedLookAndFeelException e) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
					UnsupportedLookAndFeelException e1) {
				throw new ScreenevatorException(
					"Not able to set a look and feel. Neither the native one nor the cross plattform one.");
			}
		}
	}
}
