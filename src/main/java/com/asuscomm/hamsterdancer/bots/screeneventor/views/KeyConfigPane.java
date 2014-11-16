package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput.KeyCombinationListener;
import com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput.KeyCombinationRecorder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

	private int elementCounter = 0;

	/** Creates a new KeyConfigPane object. */
	public KeyConfigPane() {
		final GridBagLayout gbl_controlsPane = new GridBagLayout();
		gbl_controlsPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		this.setLayout(gbl_controlsPane);
	}

	/**
	 * Adds an action in form of a {@link KeyCombinationListener} to prepare it for being able to
	 * get configured for execution at key combinations.
	 *
	 * @param label           Label of the action
	 * @param action          Actions to be performed when key combination was configured and hit.
	 * @param defaultKeyCombi TODO: doc
	 */
	public void addKeyCombi(final String label,
		final KeyCombinationListener action,
		final int... defaultKeyCombi) {
		final JLabel lblDesctiption = new JLabel(label);
		final GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = elementCounter;
		this.add(lblDesctiption, gbc_lblDescription);

		final JTextField txtKeyCombination = new JTextField();
		final KeyCombinationRecorder keyRecorder = new KeyCombinationRecorder(txtKeyCombination);

		final GridBagConstraints gbc_txtKeyCombination = new GridBagConstraints();
		gbc_txtKeyCombination.weightx = 2.0;
		gbc_txtKeyCombination.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeyCombination.insets = new Insets(0, 0, 5, 5);
		gbc_txtKeyCombination.gridx = 1;
		gbc_txtKeyCombination.gridy = elementCounter;
		this.add(txtKeyCombination, gbc_txtKeyCombination);
		txtKeyCombination.setColumns(10);

		final JButton btnAssign = new JButton("Assign");

		final GridBagConstraints gbc_btnAssign = new GridBagConstraints();
		gbc_btnAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssign.insets = new Insets(0, 0, 5, 5);
		gbc_btnAssign.gridx = 2;
		gbc_btnAssign.gridy = elementCounter;
		this.add(btnAssign, gbc_btnAssign);

		final JButton btnClear = new JButton("Clear");

		final GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClear.insets = new Insets(0, 0, 5, 0);
		gbc_btnClear.gridx = 3;
		gbc_btnClear.gridy = elementCounter;
		this.add(btnClear, gbc_btnClear);

		elementCounter++;
	}
}
