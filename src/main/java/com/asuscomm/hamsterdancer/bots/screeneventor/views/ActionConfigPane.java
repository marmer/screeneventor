package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;
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
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Circle;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Rectangle;

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
	private final JComboBox<ObjectFactoryComboboxItem<? extends Action>> actionChooserComboBox;
	private final JSpinner x1Spinner;
	private final JSpinner y1Spinner;
	private final JSpinner radiusSpinner;
	private final JSpinner preDelaySpinner;
	private final JSpinner interDelaySpinner;
	private final JSpinner x2Spinner;
	private final JSpinner y2Spinner;
	private final JCheckBox chckbxResetCursor;
	private final JTextField txtComment;

	private transient Action action;
	private final JLabel lblArea;
	private final JComboBox<ObjectFactoryComboboxItem<? extends Area>> areaChooserComboBox;

	/** Create the panel. */
	public ActionConfigPane() {
		final GridBagLayout gbl_actionPane = new GridBagLayout();
		gbl_actionPane.columnWidths = new int[] { 75, 0, 75, 75, 75, 75 };
		gbl_actionPane.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 1.0, 1.0 };
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

		actionChooserComboBox = new JComboBox<ObjectFactoryComboboxItem<? extends Action>>();
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

		x1Spinner = new JSpinner();
		x1Spinner.setModel(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_x1Spinner = new GridBagConstraints();
		gbc_x1Spinner.insets = new Insets(0, 0, 5, 5);
		gbc_x1Spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_x1Spinner.gridx = 2;
		gbc_x1Spinner.gridy = 1;
		this.add(x1Spinner, gbc_x1Spinner);

		y1Spinner = new JSpinner();
		y1Spinner.setModel(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_y1Spinner = new GridBagConstraints();
		gbc_y1Spinner.insets = new Insets(0, 0, 5, 5);
		gbc_y1Spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_y1Spinner.gridx = 3;
		gbc_y1Spinner.gridy = 1;
		this.add(y1Spinner, gbc_y1Spinner);

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

		x2Spinner = new JSpinner();
		x2Spinner.setModel(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_x2Spinner = new GridBagConstraints();
		gbc_x2Spinner.insets = new Insets(0, 0, 5, 5);
		gbc_x2Spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_x2Spinner.gridx = 2;
		gbc_x2Spinner.gridy = 2;
		this.add(x2Spinner, gbc_x2Spinner);

		y2Spinner = new JSpinner();
		y2Spinner.setModel(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_y2Spinner = new GridBagConstraints();
		gbc_y2Spinner.insets = new Insets(0, 0, 5, 5);
		gbc_y2Spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_y2Spinner.gridx = 3;
		gbc_y2Spinner.gridy = 2;
		this.add(y2Spinner, gbc_y2Spinner);

		final JLabel lblComment = new JLabel("Comment");
		final GridBagConstraints gbc_lblComment = new GridBagConstraints();
		gbc_lblComment.gridwidth = 2;
		gbc_lblComment.insets = new Insets(0, 0, 5, 0);
		gbc_lblComment.gridx = 4;
		gbc_lblComment.gridy = 2;
		this.add(lblComment, gbc_lblComment);

		areaChooserComboBox = new JComboBox<ObjectFactoryComboboxItem<? extends Area>>();

		final GridBagConstraints gbc_areaChooserComboBox = new GridBagConstraints();
		gbc_areaChooserComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_areaChooserComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_areaChooserComboBox.gridx = 0;
		gbc_areaChooserComboBox.gridy = 3;
		add(areaChooserComboBox, gbc_areaChooserComboBox);

		populateWithAreas(areaChooserComboBox);

		radiusSpinner = new JSpinner();
		radiusSpinner.setModel(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_radiusSpinner = new GridBagConstraints();
		gbc_radiusSpinner.insets = new Insets(0, 0, 0, 5);
		gbc_radiusSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_radiusSpinner.gridx = 2;
		gbc_radiusSpinner.gridy = 3;
		this.add(radiusSpinner, gbc_radiusSpinner);

		final JLabel lblRadius = new JLabel("Radius");
		final GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.anchor = GridBagConstraints.EAST;
		gbc_lblRadius.insets = new Insets(0, 0, 0, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 3;
		this.add(lblRadius, gbc_lblRadius);
		lblRadius.setLabelFor(radiusSpinner);

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

	private void populateWithAreas(
		final JComboBox<ObjectFactoryComboboxItem<? extends Area>> comboBox) {
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(Point.class, "Single Point"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(Rectangle.class, "Rectangle Area"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(Circle.class, "Circle Area"));
	}

	private void populateWithActions(
		final JComboBox<ObjectFactoryComboboxItem<? extends Action>> comboBox) {
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Mouse Left Click"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				LeftPressAction.class,
				"Mouse Left Press"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				LeftReleaseAction.class,
				"Mouse Left Release"));

		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				RightClickAction.class,
				"Mouse Right Click"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				RightPressAction.class,
				"Mouse Right Press"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				RightReleaseAction.class,
				"Mouse Right Release"));

		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				MiddleClickAction.class,
				"Mouse Middle Click"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				MiddlePressAction.class,
				"Mouse Middle Press"));
		comboBox.addItem(ObjectFactoryComboboxItem.createItem(
				MiddleReleaseAction.class,
				"Mouse Middle Release"));
	}

	public synchronized Action getAction() {
		if (!actionSetForUpdate()) {
			prepareCleanAction();
		}

		populateAction();

		return getAndResetAction();
	}

	private Action getAndResetAction() {
		final Action populatedAction = action;
		action = null;

		return populatedAction;
	}

	private void populateAction() {
		populateWithArea();
		populateWithCursorReset();
		populateWithComment();
		populateWithPreDelay();
		populateWithInterDelay();
	}

	private void populateWithInterDelay() {
		action.setInterDelay((Integer) interDelaySpinner.getValue());
	}

	private void populateWithPreDelay() {
		action.setPreDelay((Integer) preDelaySpinner.getValue());
	}

	private void populateWithComment() {
		action.setComment(txtComment.getText());
	}

	private void populateWithCursorReset() {
		action.setCursorBack(chckbxResetCursor.isSelected());
	}

	private void populateWithArea() {
		final Class<? extends Area> areaClass = getAreaClass();

		if (areaClass == Point.class) {
			action.setArea(getPoint1());
		} else if (areaClass == Circle.class) {
			action.setArea(getCircle());
		} else if (areaClass == Rectangle.class) {
			action.setArea(getRectangle());
		} else {
			throw new ScreenevatorException("Someone forgot to implement the area handing here");
		}
	}

	private Point getPoint1() {
		return getPoint(x1Spinner, y1Spinner);
	}

	private Point getPoint2() {
		return getPoint(x2Spinner, y2Spinner);
	}

	private Rectangle getRectangle() {
		return new Rectangle(getPoint1(), getPoint2());
	}

	private Circle getCircle() {
		return new Circle(getPoint1(), getRatius());
	}

	private Integer getRatius() {
		return (Integer) radiusSpinner.getValue();
	}

	private Point getPoint(final JSpinner xSpinner, final JSpinner ySpinner) {
		return new Point((Integer) xSpinner.getValue(), (Integer) ySpinner.getValue());
	}

	private Class<? extends Area> getAreaClass() {
		final ObjectFactoryComboboxItem<? extends Area> areaItem = areaChooserComboBox.getItemAt(
				areaChooserComboBox.getSelectedIndex());
		final Class<? extends Area> areaClass = areaItem.getObjectClass();

		return areaClass;
	}

	private void prepareCleanAction() {
		final ObjectFactoryComboboxItem<? extends Action> actionItem =
			actionChooserComboBox.getItemAt(actionChooserComboBox.getSelectedIndex());
		action = actionItem.createInstance();
	}

	private boolean actionSetForUpdate() {
		return action != null;
	}
}
