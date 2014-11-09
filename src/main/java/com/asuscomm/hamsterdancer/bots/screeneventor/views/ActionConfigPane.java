package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.LeftClickAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.LeftPressAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.LeftReleaseAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.MiddleClickAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.MiddlePressAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.MiddleReleaseAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.RightClickAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.RightPressAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.RightReleaseAction;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


/**
 * Pane to config actions.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class ActionConfigPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final JComboBox<ActionFactoryComboboxItem<? extends Action>> actionChooserComboBox;
	private final JTextField txtX1;
	private final JTextField txtY1;
	private final JTextField txtRadius;
	private final JSpinner preDelaySpinner;
	private final JSpinner interDelaySpinner;
	private final JTextField txtX2;
	private final JTextField txtY2;
	private final JCheckBox chckbxResetCursor;
	private final JTextField txtComment;

	private transient Action currentActionInstance;
	private final JLabel lblArea;

	/** Create the panel. */
	public ActionConfigPane() {
		final GridBagLayout gbl_actionPane = new GridBagLayout();
		gbl_actionPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_actionPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		this.setLayout(gbl_actionPane);

		final JLabel lblAction = new JLabel("Action");
		final GridBagConstraints gbc_lblAction = new GridBagConstraints();
		gbc_lblAction.insets = new Insets(0, 0, 5, 5);
		gbc_lblAction.gridx = 0;
		gbc_lblAction.gridy = 0;
		this.add(lblAction, gbc_lblAction);

		final JLabel lblX = new JLabel("X");
		final GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 2;
		gbc_lblX.gridy = 0;
		this.add(lblX, gbc_lblX);

		final JLabel lblY = new JLabel("Y");
		final GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 3;
		gbc_lblY.gridy = 0;
		this.add(lblY, gbc_lblY);

		final JLabel lblPredelayInMs = new JLabel("Pre-Delay in ms");
		final GridBagConstraints gbc_lblPredelayInMs = new GridBagConstraints();
		gbc_lblPredelayInMs.insets = new Insets(0, 0, 5, 5);
		gbc_lblPredelayInMs.gridx = 4;
		gbc_lblPredelayInMs.gridy = 0;
		this.add(lblPredelayInMs, gbc_lblPredelayInMs);

		final JLabel lblInterdelayInMs = new JLabel("Inter-Delay in ms");
		final GridBagConstraints gbc_lblInterdelayInMs = new GridBagConstraints();
		gbc_lblInterdelayInMs.insets = new Insets(0, 0, 5, 0);
		gbc_lblInterdelayInMs.gridx = 5;
		gbc_lblInterdelayInMs.gridy = 0;
		this.add(lblInterdelayInMs, gbc_lblInterdelayInMs);

		actionChooserComboBox = new JComboBox<ActionFactoryComboboxItem<? extends Action>>();
		lblAction.setLabelFor(actionChooserComboBox);
		populateWithActions(actionChooserComboBox);

		final GridBagConstraints gbc_actionChooserComboBox = new GridBagConstraints();
		gbc_actionChooserComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_actionChooserComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_actionChooserComboBox.gridx = 0;
		gbc_actionChooserComboBox.gridy = 1;
		this.add(actionChooserComboBox, gbc_actionChooserComboBox);

		final JLabel lblStart = new JLabel("Start");
		final GridBagConstraints gbc_lblStart = new GridBagConstraints();
		gbc_lblStart.anchor = GridBagConstraints.EAST;
		gbc_lblStart.insets = new Insets(0, 0, 5, 5);
		gbc_lblStart.gridx = 1;
		gbc_lblStart.gridy = 1;
		this.add(lblStart, gbc_lblStart);

		txtX1 = new JTextField();

		final GridBagConstraints gbc_txtX1 = new GridBagConstraints();
		gbc_txtX1.insets = new Insets(0, 0, 5, 5);
		gbc_txtX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX1.gridx = 2;
		gbc_txtX1.gridy = 1;
		this.add(txtX1, gbc_txtX1);
		txtX1.setColumns(10);

		txtY1 = new JTextField();

		final GridBagConstraints gbc_txtY1 = new GridBagConstraints();
		gbc_txtY1.insets = new Insets(0, 0, 5, 5);
		gbc_txtY1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY1.gridx = 3;
		gbc_txtY1.gridy = 1;
		this.add(txtY1, gbc_txtY1);
		txtY1.setColumns(10);

		preDelaySpinner = new JSpinner();
		preDelaySpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		lblPredelayInMs.setLabelFor(preDelaySpinner);

		final GridBagConstraints gbc_preDelaySpinner = new GridBagConstraints();
		gbc_preDelaySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_preDelaySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_preDelaySpinner.gridx = 4;
		gbc_preDelaySpinner.gridy = 1;
		this.add(preDelaySpinner, gbc_preDelaySpinner);

		interDelaySpinner = new JSpinner();
		interDelaySpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		lblInterdelayInMs.setLabelFor(interDelaySpinner);

		final GridBagConstraints gbc_interDelaySpinner = new GridBagConstraints();
		gbc_interDelaySpinner.insets = new Insets(0, 0, 5, 0);
		gbc_interDelaySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_interDelaySpinner.gridx = 5;
		gbc_interDelaySpinner.gridy = 1;
		this.add(interDelaySpinner, gbc_interDelaySpinner);

		lblArea = new JLabel("Area");

		final GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 0;
		gbc_lblArea.gridy = 2;
		add(lblArea, gbc_lblArea);

		final JLabel lblEnd = new JLabel("End");
		final GridBagConstraints gbc_lblEnd = new GridBagConstraints();
		gbc_lblEnd.anchor = GridBagConstraints.EAST;
		gbc_lblEnd.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnd.gridx = 1;
		gbc_lblEnd.gridy = 2;
		this.add(lblEnd, gbc_lblEnd);

		txtX2 = new JTextField();

		final GridBagConstraints gbc_txtX2 = new GridBagConstraints();
		gbc_txtX2.insets = new Insets(0, 0, 5, 5);
		gbc_txtX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX2.gridx = 2;
		gbc_txtX2.gridy = 2;
		this.add(txtX2, gbc_txtX2);
		txtX2.setColumns(10);

		txtY2 = new JTextField();

		final GridBagConstraints gbc_txtY2 = new GridBagConstraints();
		gbc_txtY2.insets = new Insets(0, 0, 5, 5);
		gbc_txtY2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY2.gridx = 3;
		gbc_txtY2.gridy = 2;
		this.add(txtY2, gbc_txtY2);
		txtY2.setColumns(10);

		final JLabel lblComment = new JLabel("Comment");
		final GridBagConstraints gbc_lblComment = new GridBagConstraints();
		gbc_lblComment.gridwidth = 2;
		gbc_lblComment.insets = new Insets(0, 0, 5, 0);
		gbc_lblComment.gridx = 4;
		gbc_lblComment.gridy = 2;
		this.add(lblComment, gbc_lblComment);

		final JComboBox<ActionFactoryComboboxItem<? extends Action>> areaChooserComboBox =
			new JComboBox();
		final GridBagConstraints gbc_areaChooserComboBox = new GridBagConstraints();
		gbc_areaChooserComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_areaChooserComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaChooserComboBox.gridx = 0;
		gbc_areaChooserComboBox.gridy = 3;
		add(areaChooserComboBox, gbc_areaChooserComboBox);

		txtRadius = new JTextField();

		final GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 0, 5);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 2;
		gbc_txtRadius.gridy = 3;
		this.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);

		final JLabel lblRadius = new JLabel("Radius");
		final GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 3;
		this.add(lblRadius, gbc_lblRadius);
		lblRadius.setLabelFor(txtRadius);

		chckbxResetCursor = new JCheckBox("reset Cursor");

		final GridBagConstraints gbc_chckbxResetCursor = new GridBagConstraints();
		gbc_chckbxResetCursor.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxResetCursor.gridx = 3;
		gbc_chckbxResetCursor.gridy = 3;
		this.add(chckbxResetCursor, gbc_chckbxResetCursor);

		txtComment = new JTextField();
		lblComment.setLabelFor(txtComment);

		final GridBagConstraints gbc_txtComment = new GridBagConstraints();
		gbc_txtComment.gridwidth = 2;
		gbc_txtComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComment.gridx = 4;
		gbc_txtComment.gridy = 3;
		this.add(txtComment, gbc_txtComment);
		txtComment.setColumns(10);
	}

	private void populateWithActions(
		final JComboBox<ActionFactoryComboboxItem<? extends Action>> comboBox) {
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Mouse Left Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftPressAction.class,
				"Mouse Left Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftReleaseAction.class,
				"Mouse Left Release"));

		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				RightClickAction.class,
				"Mouse Right Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				RightPressAction.class,
				"Mouse Right Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				RightReleaseAction.class,
				"Mouse Right Release"));

		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				MiddleClickAction.class,
				"Mouse Middle Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				MiddlePressAction.class,
				"Mouse Middle Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				MiddleReleaseAction.class,
				"Mouse Middle Release"));
	}

	public Action getAction() {
		final ActionFactoryComboboxItem<? extends Action> cleanAction =
			actionChooserComboBox.getItemAt(actionChooserComboBox.getSelectedIndex());

		return null;
	}
}
