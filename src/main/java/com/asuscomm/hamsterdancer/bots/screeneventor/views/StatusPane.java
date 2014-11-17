package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;


/**
 * Pane used to show a status.
 *
 * @author MarMer
 * @since  2014-11-15
 */
public class StatusPane extends JPanel {
	private static final String TIME_LEFT_TEXT = "Time left: ";
	private static final String ITERATIONS_LEFT_TEXT = "Iterations left: ";
	private static final String CURSOR_POSITION_TEXT = "Cursor Position: ";

	private static final int REFRESH_DELAY = 40;

	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	private final ActionsScript actionScript;
	private final JLabel lblTimeLeft;
	private final JLabel lblIterationsLeft;
	private final JLabel lblCursorPosition;

	/**
	 * Creates a new StatusPane object.
	 *
	 * @param actionsScript Script to show the status for.
	 */
	public StatusPane(final ActionsScript actionsScript) {
		final GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		final JPanel cursorPanel = new JPanel();
		cursorPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		final GridBagConstraints gbc_cursorPanel = new GridBagConstraints();
		gbc_cursorPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_cursorPanel.insets = new Insets(0, 0, 0, 5);
		gbc_cursorPanel.gridx = 0;
		gbc_cursorPanel.gridy = 0;
		add(cursorPanel, gbc_cursorPanel);

		final GridBagLayout gbl_cursorPanel = new GridBagLayout();
		gbl_cursorPanel.columnWidths = new int[] { 0, 0 };
		gbl_cursorPanel.rowHeights = new int[] { 0, 0 };
		gbl_cursorPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_cursorPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		cursorPanel.setLayout(gbl_cursorPanel);

		lblCursorPosition = new JLabel(CURSOR_POSITION_TEXT);

		final GridBagConstraints gbc_lblCursorPosition = new GridBagConstraints();
		gbc_lblCursorPosition.anchor = GridBagConstraints.WEST;
		gbc_lblCursorPosition.gridx = 0;
		gbc_lblCursorPosition.gridy = 0;
		cursorPanel.add(lblCursorPosition, gbc_lblCursorPosition);

		final JPanel iterationsPanel = new JPanel();
		iterationsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		final GridBagConstraints gbc_iterationsPanel = new GridBagConstraints();
		gbc_iterationsPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_iterationsPanel.insets = new Insets(0, 0, 0, 5);
		gbc_iterationsPanel.gridx = 1;
		gbc_iterationsPanel.gridy = 0;
		add(iterationsPanel, gbc_iterationsPanel);

		final GridBagLayout gbl_iterationsPanel = new GridBagLayout();
		gbl_iterationsPanel.columnWidths = new int[] { 0, 0 };
		gbl_iterationsPanel.rowHeights = new int[] { 0, 0 };
		gbl_iterationsPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_iterationsPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		iterationsPanel.setLayout(gbl_iterationsPanel);

		lblIterationsLeft = new JLabel(ITERATIONS_LEFT_TEXT);

		final GridBagConstraints gbc_lblIterationsLeft = new GridBagConstraints();
		gbc_lblIterationsLeft.gridx = 0;
		gbc_lblIterationsLeft.gridy = 0;
		iterationsPanel.add(lblIterationsLeft, gbc_lblIterationsLeft);

		final JPanel timePanel = new JPanel();
		timePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		final GridBagConstraints gbc_timePanel = new GridBagConstraints();
		gbc_timePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_timePanel.gridx = 2;
		gbc_timePanel.gridy = 0;
		add(timePanel, gbc_timePanel);

		final GridBagLayout gbl_timePanel = new GridBagLayout();
		gbl_timePanel.columnWidths = new int[] { 0, 0 };
		gbl_timePanel.rowHeights = new int[] { 0, 0 };
		gbl_timePanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_timePanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		timePanel.setLayout(gbl_timePanel);

		lblTimeLeft = new JLabel(TIME_LEFT_TEXT);

		final GridBagConstraints gbc_lblTimeLeft = new GridBagConstraints();
		gbc_lblTimeLeft.anchor = GridBagConstraints.EAST;
		gbc_lblTimeLeft.gridx = 0;
		gbc_lblTimeLeft.gridy = 0;
		timePanel.add(lblTimeLeft, gbc_lblTimeLeft);
		actionScript = actionsScript;

		startListeningToStopConditions();
	}

	private void startListeningToStopConditions() {
		new Thread(new Runnable() {
				@Override
				public void run() {
					final StatusRefresher statusRefresher = new StatusRefresher();

					while (true) {
						SwingUtilities.invokeLater(statusRefresher);

						try {
							Thread.sleep(REFRESH_DELAY);
						} catch (final InterruptedException e) {
							return;
						}
					}
				}
			}).start();
	}

	private final class StatusRefresher implements Runnable {
		@Override
		public void run() {
			lblIterationsLeft.setText(ITERATIONS_LEFT_TEXT + actionScript.getIterationsLeft());
			lblTimeLeft.setText(TIME_LEFT_TEXT + actionScript.getTimeLeft());

			final Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
			lblCursorPosition.setText(CURSOR_POSITION_TEXT + mouseLocation.x + "," +
				mouseLocation.y);
		}
	}
}
