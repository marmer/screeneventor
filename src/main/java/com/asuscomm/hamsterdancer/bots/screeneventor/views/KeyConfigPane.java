package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class KeyConfigPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final JTextField txtAddMousePosition;
	private final JTextField txtStartStop;
	private final JTextField txtGetMousePosition;

	/** Create the panel. */
	public KeyConfigPane() {
		setBorder(new TitledBorder(
				null,
				"Keys",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		setLayout(new GridLayout(3, 4, 0, 0));

		final JLabel lblAddMousePosition = new JLabel("Get and add mouse position");
		add(lblAddMousePosition);

		txtAddMousePosition = new JTextField();
		add(txtAddMousePosition);
		txtAddMousePosition.setColumns(10);

		final JButton btnAssignAddMouse = new JButton("Assign");
		add(btnAssignAddMouse);

		final JButton btnClearAddMouse = new JButton("Clear");
		add(btnClearAddMouse);

		final JLabel lblGetMousePosition = new JLabel("Get mouse position");
		add(lblGetMousePosition);

		txtGetMousePosition = new JTextField();
		txtGetMousePosition.setColumns(10);
		add(txtGetMousePosition);

		final JButton btnAssignGetMouse = new JButton("Assign");
		add(btnAssignGetMouse);

		final JButton btnClearGetMouse = new JButton("Clear");
		add(btnClearGetMouse);

		final JLabel lblStartStop = new JLabel("Start/Stop");
		add(lblStartStop);

		txtStartStop = new JTextField();
		add(txtStartStop);
		txtStartStop.setColumns(10);

		final JButton btnAssignStartStop = new JButton("Assign");
		add(btnAssignStartStop);

		final JButton btnClearStartStop = new JButton("Clear");
		add(btnClearStartStop);
	}
}
