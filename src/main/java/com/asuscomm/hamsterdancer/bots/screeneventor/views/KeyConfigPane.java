package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Pane used for key configuration.
 *
 * @author MarMer
 * @since  2014-11-12
 */
public class KeyConfigPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private final JTextField txtGetcursor;
	private final JTextField txtGetandaddcursor;
	private final JTextField txtStartStopScript;

	private final JButton btnGetAndAddCursorAssign;

	private final JButton btnGetAndAddCursorClear;

	private final JButton btnGetCursorAssign;

	private final JButton btnGetCursorClear;

	private final JButton btnStartStopScriptAssign;

	private final JButton btnStartStopScriptClear;

	/** Creates a new KeyConfigPane object. */
	public KeyConfigPane() {
		final GridBagLayout gbl_controlsPane = new GridBagLayout();
		gbl_controlsPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_controlsPane.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		this.setLayout(gbl_controlsPane);

		final JLabel lblGetAndAddMousePosition = new JLabel("Get Mouse Position & Add Action");
		final GridBagConstraints gbc_lblGetAndAddMousePosition = new GridBagConstraints();
		gbc_lblGetAndAddMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetAndAddMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetAndAddMousePosition.gridx = 0;
		gbc_lblGetAndAddMousePosition.gridy = 0;
		this.add(lblGetAndAddMousePosition, gbc_lblGetAndAddMousePosition);

		txtGetandaddcursor = new JTextField();

		final GridBagConstraints gbc_txtGetandaddcursor = new GridBagConstraints();
		gbc_txtGetandaddcursor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGetandaddcursor.insets = new Insets(0, 0, 5, 5);
		gbc_txtGetandaddcursor.gridx = 1;
		gbc_txtGetandaddcursor.gridy = 0;
		this.add(txtGetandaddcursor, gbc_txtGetandaddcursor);
		txtGetandaddcursor.setColumns(10);

		btnGetAndAddCursorAssign = new JButton("Assign");

		final GridBagConstraints gbc_btnGetAndAddCursorAssign = new GridBagConstraints();
		gbc_btnGetAndAddCursorAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetAndAddCursorAssign.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetAndAddCursorAssign.gridx = 2;
		gbc_btnGetAndAddCursorAssign.gridy = 0;
		this.add(btnGetAndAddCursorAssign, gbc_btnGetAndAddCursorAssign);

		btnGetAndAddCursorClear = new JButton("Clear");

		final GridBagConstraints gbc_btnGetAndAddCursorClear = new GridBagConstraints();
		gbc_btnGetAndAddCursorClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetAndAddCursorClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetAndAddCursorClear.gridx = 3;
		gbc_btnGetAndAddCursorClear.gridy = 0;
		this.add(btnGetAndAddCursorClear, gbc_btnGetAndAddCursorClear);

		final Component controlsGlueRight = Box.createGlue();
		final GridBagConstraints gbc_controlsGlueRight = new GridBagConstraints();
		gbc_controlsGlueRight.weightx = 1.0;
		gbc_controlsGlueRight.gridheight = 3;
		gbc_controlsGlueRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_controlsGlueRight.insets = new Insets(0, 0, 5, 0);
		gbc_controlsGlueRight.gridx = 4;
		gbc_controlsGlueRight.gridy = 0;
		this.add(controlsGlueRight, gbc_controlsGlueRight);

		final JLabel lblGetMousePosition = new JLabel("Get Mouse Position");
		final GridBagConstraints gbc_lblGetMousePosition = new GridBagConstraints();
		gbc_lblGetMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetMousePosition.gridx = 0;
		gbc_lblGetMousePosition.gridy = 1;
		this.add(lblGetMousePosition, gbc_lblGetMousePosition);

		txtGetcursor = new JTextField();

		final GridBagConstraints gbc_txtGetcursor = new GridBagConstraints();
		gbc_txtGetcursor.insets = new Insets(0, 0, 5, 5);
		gbc_txtGetcursor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGetcursor.gridx = 1;
		gbc_txtGetcursor.gridy = 1;
		this.add(txtGetcursor, gbc_txtGetcursor);
		txtGetcursor.setColumns(10);

		btnGetCursorAssign = new JButton("Assign");

		final GridBagConstraints gbc_btnGetCursorAssign = new GridBagConstraints();
		gbc_btnGetCursorAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetCursorAssign.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetCursorAssign.gridx = 2;
		gbc_btnGetCursorAssign.gridy = 1;
		this.add(btnGetCursorAssign, gbc_btnGetCursorAssign);

		btnGetCursorClear = new JButton("Clear");

		final GridBagConstraints gbc_btnGetCursorClear = new GridBagConstraints();
		gbc_btnGetCursorClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetCursorClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetCursorClear.gridx = 3;
		gbc_btnGetCursorClear.gridy = 1;
		this.add(btnGetCursorClear, gbc_btnGetCursorClear);

		final JLabel lblStartStopScript = new JLabel("Start/Stop Script");
		final GridBagConstraints gbc_lblStartStopScript = new GridBagConstraints();
		gbc_lblStartStopScript.anchor = GridBagConstraints.EAST;
		gbc_lblStartStopScript.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartStopScript.gridx = 0;
		gbc_lblStartStopScript.gridy = 2;
		this.add(lblStartStopScript, gbc_lblStartStopScript);

		txtStartStopScript = new JTextField();

		final GridBagConstraints gbc_txtStartStopScript = new GridBagConstraints();
		gbc_txtStartStopScript.insets = new Insets(0, 0, 0, 5);
		gbc_txtStartStopScript.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartStopScript.gridx = 1;
		gbc_txtStartStopScript.gridy = 2;
		this.add(txtStartStopScript, gbc_txtStartStopScript);
		txtStartStopScript.setColumns(10);

		btnStartStopScriptAssign = new JButton("Assign");

		final GridBagConstraints gbc_btnStartStopScriptAssign = new GridBagConstraints();
		gbc_btnStartStopScriptAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartStopScriptAssign.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartStopScriptAssign.gridx = 2;
		gbc_btnStartStopScriptAssign.gridy = 2;
		this.add(btnStartStopScriptAssign, gbc_btnStartStopScriptAssign);

		btnStartStopScriptClear = new JButton("Clear");

		final GridBagConstraints gbc_btnStartStopScriptClear = new GridBagConstraints();
		gbc_btnStartStopScriptClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartStopScriptClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartStopScriptClear.gridx = 3;
		gbc_btnStartStopScriptClear.gridy = 2;

		this.add(btnStartStopScriptClear, gbc_btnStartStopScriptClear);
	}
}
