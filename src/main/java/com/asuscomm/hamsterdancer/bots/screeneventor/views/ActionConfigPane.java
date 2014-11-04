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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;


/**
 * Pane to config actions.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class ActionConfigPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final JTextField txtY;
	private final JTextField txtX;
	private final JTextField txtKeys;
	private final JTextField txtComment;

	/** Create the panel. */
	public ActionConfigPane() {
		setBorder(new TitledBorder(
				null,
				"Action Definitions",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		final JPanel ActionConfigPanel = new JPanel();
		add(ActionConfigPanel);

		final GridBagLayout gbl_ActionConfigPanel = new GridBagLayout();
		gbl_ActionConfigPanel.columnWidths =
			new int[] {
				0, 100, 0, 100, 40,
				100,
				0, 0
			};
		gbl_ActionConfigPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_ActionConfigPanel.columnWeights =
			new double[] {
				0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE
			};
		gbl_ActionConfigPanel.rowWeights =
			new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		ActionConfigPanel.setLayout(gbl_ActionConfigPanel);

		final JLabel lblX = new JLabel("X-Coordinate");
		final GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.anchor = GridBagConstraints.EAST;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 0;
		gbc_lblX.gridy = 1;
		ActionConfigPanel.add(lblX, gbc_lblX);

		txtX = new JTextField();

		final GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 1;
		gbc_txtX.gridy = 1;
		ActionConfigPanel.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		final JLabel lblY = new JLabel("Y-Coordinate");
		final GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 2;
		gbc_lblY.gridy = 1;
		ActionConfigPanel.add(lblY, gbc_lblY);

		txtY = new JTextField();

		final GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 3;
		gbc_txtY.gridy = 1;
		ActionConfigPanel.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		final JLabel lblRepeatCount = new JLabel("Repeat Count");
		final GridBagConstraints gbc_lblRepeatCount = new GridBagConstraints();
		gbc_lblRepeatCount.gridwidth = 2;
		gbc_lblRepeatCount.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepeatCount.gridx = 4;
		gbc_lblRepeatCount.gridy = 1;
		ActionConfigPanel.add(lblRepeatCount, gbc_lblRepeatCount);

		final JCheckBox chckbxSetCursorBack = new JCheckBox("Set cursor back");
		final GridBagConstraints gbc_chckbxSetCursorBack = new GridBagConstraints();
		gbc_chckbxSetCursorBack.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSetCursorBack.gridwidth = 2;
		gbc_chckbxSetCursorBack.gridx = 0;
		gbc_chckbxSetCursorBack.gridy = 2;
		ActionConfigPanel.add(chckbxSetCursorBack, gbc_chckbxSetCursorBack);

		final JCheckBox chckbxNoCoordinates = new JCheckBox("Perform without Movement");
		final GridBagConstraints gbc_chckbxNoCoordinates = new GridBagConstraints();
		gbc_chckbxNoCoordinates.gridwidth = 2;
		gbc_chckbxNoCoordinates.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNoCoordinates.gridx = 2;
		gbc_chckbxNoCoordinates.gridy = 2;
		ActionConfigPanel.add(chckbxNoCoordinates, gbc_chckbxNoCoordinates);

		final JSpinner repeatCountSpinner = new JSpinner();
		final GridBagConstraints gbc_repeatCountSpinner = new GridBagConstraints();
		gbc_repeatCountSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatCountSpinner.gridwidth = 2;
		gbc_repeatCountSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_repeatCountSpinner.gridx = 4;
		gbc_repeatCountSpinner.gridy = 2;
		ActionConfigPanel.add(repeatCountSpinner, gbc_repeatCountSpinner);
		repeatCountSpinner.setModel(new SpinnerNumberModel(
				new Integer(0),
				new Integer(0),
				null,
				new Integer(1)));

		final JLabel lblRepeatTime = new JLabel("Repeat Time");
		final GridBagConstraints gbc_lblRepeatTime = new GridBagConstraints();
		gbc_lblRepeatTime.gridwidth = 2;
		gbc_lblRepeatTime.insets = new Insets(0, 0, 5, 5);
		gbc_lblRepeatTime.gridx = 4;
		gbc_lblRepeatTime.gridy = 3;
		ActionConfigPanel.add(lblRepeatTime, gbc_lblRepeatTime);

		final JLabel lblInterdalayInMs = new JLabel("Inter-Dalay in ms");
		final GridBagConstraints gbc_lblInterdalayInMs = new GridBagConstraints();
		gbc_lblInterdalayInMs.anchor = GridBagConstraints.EAST;
		gbc_lblInterdalayInMs.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterdalayInMs.gridx = 2;
		gbc_lblInterdalayInMs.gridy = 4;
		ActionConfigPanel.add(lblInterdalayInMs, gbc_lblInterdalayInMs);

		final JSpinner spinner = new JSpinner();
		final GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 3;
		gbc_spinner.gridy = 4;
		ActionConfigPanel.add(spinner, gbc_spinner);

		final JLabel lblAction = new JLabel("Action");
		final GridBagConstraints gbc_lblAction = new GridBagConstraints();
		gbc_lblAction.anchor = GridBagConstraints.EAST;
		gbc_lblAction.insets = new Insets(0, 0, 5, 5);
		gbc_lblAction.gridx = 0;
		gbc_lblAction.gridy = 3;
		ActionConfigPanel.add(lblAction, gbc_lblAction);

		final JComboBox<ActionFactoryComboboxItem<? extends Action>> comboBox =
			new JComboBox<ActionFactoryComboboxItem<? extends Action>>();
		addActionItems(comboBox);

		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		ActionConfigPanel.add(comboBox, gbc_comboBox);

		final JLabel lblKeys = new JLabel("Keys");
		final GridBagConstraints gbc_lblKeys = new GridBagConstraints();
		gbc_lblKeys.anchor = GridBagConstraints.EAST;
		gbc_lblKeys.insets = new Insets(0, 0, 5, 5);
		gbc_lblKeys.gridx = 2;
		gbc_lblKeys.gridy = 3;
		ActionConfigPanel.add(lblKeys, gbc_lblKeys);

		txtKeys = new JTextField();

		final GridBagConstraints gbc_txtKeys = new GridBagConstraints();
		gbc_txtKeys.insets = new Insets(0, 0, 5, 5);
		gbc_txtKeys.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeys.gridx = 3;
		gbc_txtKeys.gridy = 3;
		ActionConfigPanel.add(txtKeys, gbc_txtKeys);
		txtKeys.setColumns(10);

		final JLabel lblHours = new JLabel("h");
		final GridBagConstraints gbc_lblHours = new GridBagConstraints();
		gbc_lblHours.insets = new Insets(0, 0, 5, 5);
		gbc_lblHours.gridx = 4;
		gbc_lblHours.gridy = 4;
		ActionConfigPanel.add(lblHours, gbc_lblHours);

		final JSpinner hourSpinner = new JSpinner();
		final GridBagConstraints gbc_hourSpinner = new GridBagConstraints();
		gbc_hourSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_hourSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_hourSpinner.gridx = 5;
		gbc_hourSpinner.gridy = 4;
		ActionConfigPanel.add(hourSpinner, gbc_hourSpinner);
		hourSpinner.setModel(new SpinnerNumberModel(
				new Integer(0),
				new Integer(0),
				null,
				new Integer(1)));

		final JLabel lblMinutes = new JLabel("min");
		final GridBagConstraints gbc_lblMinutes = new GridBagConstraints();
		gbc_lblMinutes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinutes.gridx = 4;
		gbc_lblMinutes.gridy = 5;
		ActionConfigPanel.add(lblMinutes, gbc_lblMinutes);

		final JLabel lblDalayInMs = new JLabel("Pre-Dalay in ms");
		final GridBagConstraints gbc_lblDalayInMs = new GridBagConstraints();
		gbc_lblDalayInMs.anchor = GridBagConstraints.EAST;
		gbc_lblDalayInMs.insets = new Insets(0, 0, 5, 5);
		gbc_lblDalayInMs.gridx = 0;
		gbc_lblDalayInMs.gridy = 4;
		ActionConfigPanel.add(lblDalayInMs, gbc_lblDalayInMs);

		final JSpinner delaySpinner = new JSpinner();
		final GridBagConstraints gbc_delaySpinner = new GridBagConstraints();
		gbc_delaySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_delaySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_delaySpinner.gridx = 1;
		gbc_delaySpinner.gridy = 4;
		ActionConfigPanel.add(delaySpinner, gbc_delaySpinner);

		final JSpinner minuteSpinner = new JSpinner();
		final GridBagConstraints gbc_minuteSpinner = new GridBagConstraints();
		gbc_minuteSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_minuteSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_minuteSpinner.gridx = 5;
		gbc_minuteSpinner.gridy = 5;
		ActionConfigPanel.add(minuteSpinner, gbc_minuteSpinner);
		minuteSpinner.setModel(new SpinnerNumberModel(
				new Integer(0),
				new Integer(0),
				null,
				new Integer(1)));

		final JLabel lblSeconds = new JLabel("s");
		final GridBagConstraints gbc_lblSeconds = new GridBagConstraints();
		gbc_lblSeconds.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeconds.gridx = 4;
		gbc_lblSeconds.gridy = 6;
		ActionConfigPanel.add(lblSeconds, gbc_lblSeconds);

		final JLabel lblComment = new JLabel("Comment");
		final GridBagConstraints gbc_lblComment = new GridBagConstraints();
		gbc_lblComment.anchor = GridBagConstraints.EAST;
		gbc_lblComment.insets = new Insets(0, 0, 5, 5);
		gbc_lblComment.gridx = 0;
		gbc_lblComment.gridy = 5;
		ActionConfigPanel.add(lblComment, gbc_lblComment);

		txtComment = new JTextField();
		txtComment.setText("Comment");

		final GridBagConstraints gbc_txtComment = new GridBagConstraints();
		gbc_txtComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComment.insets = new Insets(0, 0, 5, 5);
		gbc_txtComment.gridwidth = 3;
		gbc_txtComment.gridx = 1;
		gbc_txtComment.gridy = 5;
		ActionConfigPanel.add(txtComment, gbc_txtComment);
		txtComment.setColumns(10);

		final JSpinner secondSpinner = new JSpinner();
		final GridBagConstraints gbc_secondSpinner = new GridBagConstraints();
		gbc_secondSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_secondSpinner.gridx = 5;
		gbc_secondSpinner.gridy = 6;
		ActionConfigPanel.add(secondSpinner, gbc_secondSpinner);
		secondSpinner.setModel(new SpinnerNumberModel(
				new Integer(0),
				new Integer(0),
				null,
				new Integer(1)));

		final JButton btnAdd = new JButton("Add");
		final GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 6;
		ActionConfigPanel.add(btnAdd, gbc_btnAdd);

		final JButton btnUpdate = new JButton("Update");
		final GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.gridx = 2;
		gbc_btnUpdate.gridy = 6;
		ActionConfigPanel.add(btnUpdate, gbc_btnUpdate);
	}

	/**
	 * TODO: doc
	 *
	 * @param comboBox TODO: doc
	 */
	protected void addActionItems(
		final JComboBox<ActionFactoryComboboxItem<? extends Action>> comboBox) {
		comboBox.addItem(new ActionFactoryComboboxItem<LeftClickAction>(
				LeftClickAction.class,
				"Mouse Left Click"));
		comboBox.addItem(new ActionFactoryComboboxItem<LeftPressAction>(
				LeftPressAction.class,
				"Mouse Left Press"));
		comboBox.addItem(new ActionFactoryComboboxItem<LeftReleaseAction>(
				LeftReleaseAction.class,
				"Mouse Left Release"));

		comboBox.addItem(new ActionFactoryComboboxItem<RightClickAction>(
				RightClickAction.class,
				"Mouse Right Click"));
		comboBox.addItem(new ActionFactoryComboboxItem<RightPressAction>(
				RightPressAction.class,
				"Mouse Right Press"));
		comboBox.addItem(new ActionFactoryComboboxItem<RightReleaseAction>(
				RightReleaseAction.class,
				"Mouse Right Release"));

		comboBox.addItem(new ActionFactoryComboboxItem<MiddleClickAction>(
				MiddleClickAction.class,
				"Mouse Middle Click"));
		comboBox.addItem(new ActionFactoryComboboxItem<MiddlePressAction>(
				MiddlePressAction.class,
				"Mouse Middle Press"));
		comboBox.addItem(new ActionFactoryComboboxItem<MiddleReleaseAction>(
				MiddleReleaseAction.class,
				"Mouse Middle Release"));
	}
}
