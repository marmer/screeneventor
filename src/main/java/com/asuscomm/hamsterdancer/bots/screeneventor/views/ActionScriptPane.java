package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * Pane related to manage scripts.
 *
 * @author MarMer
 * @since  2014-11-12
 */
public class ActionScriptPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private static final int MS_PER_SEC = 1000;

	private static final int SEC_PER_MIN = 60;

	private static final int MIN_PER_HOUR = 60;

	private final JTable scriptTable;
	private final JSpinner iterationSpinner;
	private final JButton btnAdd;
	private final JButton btnInsert;
	private final JButton btnMoveUp;
	private final JButton btnMoveDown;
	private final ActionTableModel actionTableModel;
	private final JSpinner msSpinner;
	private final JSpinner secondSpinner;
	private final JSpinner minSpinner;
	private final JSpinner hourSpinner;

	private final ActionsScript actionsScript;

	private final JCheckBox chckbxPlaySoundWhenDone;

	private final ActionConfigPane actionsPane;

	/**
	 * Creates a new ActionScriptPane object.
	 *
	 * @param actionsScript Real {@link ActionsScript}.
	 * @param actionsPane   Actions pane which used to update or add new actions.
	 */
	public ActionScriptPane(final ActionsScript actionsScript, final ActionConfigPane actionsPane) {
		this.actionsScript = actionsScript;
		this.actionsPane = actionsPane;

		this.setLayout(new BorderLayout(5, 5));

		final JScrollPane actionsScrollPane = new JScrollPane();
		this.add(actionsScrollPane, BorderLayout.CENTER);
		scriptTable = new JTable();
		scriptTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(final ListSelectionEvent arg0) {
					refreshActionConfigPane();
				}

				private void refreshActionConfigPane() {
					actionsPane.setAction(actionsScript.get(scriptTable.getSelectedRow()));
				}
			});
		scriptTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		actionTableModel = new ActionTableModel(actionsScript);
		scriptTable.setModel(actionTableModel);
		actionsScrollPane.setViewportView(scriptTable);

		final JPanel scriptControlPane = new JPanel();
		this.add(scriptControlPane, BorderLayout.EAST);

		final GridBagLayout gbl_scriptControlPane = new GridBagLayout();
		gbl_scriptControlPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_scriptControlPane.rowWeights =
			new double[] {
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0
			};
		scriptControlPane.setLayout(gbl_scriptControlPane);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					addCurrentConfig();
				}
			});

		final JButton btnStartStop = new JButton("Start/Stop");
		btnStartStop.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					startStop();
				}
			});

		final GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.gridwidth = 2;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		scriptControlPane.add(btnStartStop, gbc_btnStart);

		final GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		scriptControlPane.add(btnAdd, gbc_btnAdd);

		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					final int selectedRow = scriptTable.getSelectedRow();

					if (selectedRow != -1) {
						actionsScript.add(selectedRow, actionsPane.getAction());
						scriptTable.revalidate();
					}
				}
			});

		final GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.fill = GridBagConstraints.BOTH;
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 2;
		scriptControlPane.add(btnInsert, gbc_btnUpdate);

		btnMoveUp = new JButton("Move Up");
		btnMoveUp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					final int selectedRow = scriptTable.getSelectedRow();

					if ((selectedRow > 0) && (selectedRow < actionsScript.size())) {
						final Action action = actionsScript.remove(selectedRow);
						final int newSelection = selectedRow - 1;
						actionsScript.add(newSelection, action);
						scriptTable.revalidate();
						scriptTable.getSelectionModel().setSelectionInterval(
							newSelection,
							newSelection);
					}
				}
			});

		final GridBagConstraints gbc_btnMoveUp = new GridBagConstraints();
		gbc_btnMoveUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveUp.gridwidth = 2;
		gbc_btnMoveUp.fill = GridBagConstraints.BOTH;
		gbc_btnMoveUp.gridx = 0;
		gbc_btnMoveUp.gridy = 3;
		scriptControlPane.add(btnMoveUp, gbc_btnMoveUp);

		btnMoveDown = new JButton("Move Down");
		btnMoveDown.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					final int selectedRow = scriptTable.getSelectedRow();

					if ((selectedRow >= 0) && (selectedRow < (actionsScript.size() - 1))) {
						final Action action = actionsScript.remove(selectedRow);
						final int newSelection = selectedRow + 1;
						actionsScript.add(newSelection, action);
						scriptTable.revalidate();
						scriptTable.getSelectionModel().setSelectionInterval(
							newSelection,
							newSelection);
					}
				}
			});

		final GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveDown.gridwidth = 2;
		gbc_btnMoveDown.fill = GridBagConstraints.BOTH;
		gbc_btnMoveDown.gridx = 0;
		gbc_btnMoveDown.gridy = 4;
		scriptControlPane.add(btnMoveDown, gbc_btnMoveDown);

		final JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					deleteCurrentlySelectedRow();
				}

				private void deleteCurrentlySelectedRow() {
					final int selectedRow = scriptTable.getSelectedRow();
					deleteRow(selectedRow);
					fixRowSelection(selectedRow);
				}

				private void fixRowSelection(final int selectedRow) {
					if (!actionsScript.isEmpty() && (selectedRow >= actionsScript.size())) {
						scriptTable.setRowSelectionInterval(
							actionsScript.size() - 1,
							actionsScript.size() - 1);
					}
				}

				private void deleteRow(final int selectedRow) {
					if (selectedRow < (actionsScript.size())) {
						actionsScript.remove(selectedRow);
						scriptTable.revalidate();
					}
				}
			});

		final GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.gridwidth = 2;
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 5;
		scriptControlPane.add(btnRemove, gbc_btnRemove);

		final Component glue = Box.createGlue();
		final GridBagConstraints gbc_glue = new GridBagConstraints();
		gbc_glue.weighty = 1.0;
		gbc_glue.weightx = 1.0;
		gbc_glue.fill = GridBagConstraints.BOTH;
		gbc_glue.gridwidth = 2;
		gbc_glue.insets = new Insets(0, 0, 5, 0);
		gbc_glue.gridx = 0;
		gbc_glue.gridy = 6;
		scriptControlPane.add(glue, gbc_glue);

		chckbxPlaySoundWhenDone = new JCheckBox("play sound when done");
		chckbxPlaySoundWhenDone.setSelected(true);

		final GridBagConstraints gbc_chckbxPlaySoundWhenDone = new GridBagConstraints();
		gbc_chckbxPlaySoundWhenDone.gridwidth = 2;
		gbc_chckbxPlaySoundWhenDone.gridx = 0;
		gbc_chckbxPlaySoundWhenDone.gridy = 14;
		scriptControlPane.add(chckbxPlaySoundWhenDone, gbc_chckbxPlaySoundWhenDone);

		final JLabel lblMaxIterations = new JLabel("Max Iterations");
		final GridBagConstraints gbc_lblMaxIterations = new GridBagConstraints();
		gbc_lblMaxIterations.gridwidth = 2;
		gbc_lblMaxIterations.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxIterations.gridx = 0;
		gbc_lblMaxIterations.gridy = 7;
		scriptControlPane.add(lblMaxIterations, gbc_lblMaxIterations);

		iterationSpinner = new JSpinner();
		iterationSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		lblMaxIterations.setLabelFor(iterationSpinner);

		final GridBagConstraints gbc_iterationSpinner = new GridBagConstraints();
		gbc_iterationSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_iterationSpinner.gridwidth = 2;
		gbc_iterationSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_iterationSpinner.gridx = 0;
		gbc_iterationSpinner.gridy = 8;
		scriptControlPane.add(iterationSpinner, gbc_iterationSpinner);

		final JLabel lblMaxRepeatDuration = new JLabel("Max Execution Time");
		final GridBagConstraints gbc_lblMaxRepeatDuration = new GridBagConstraints();
		gbc_lblMaxRepeatDuration.ipady = 5;
		gbc_lblMaxRepeatDuration.ipadx = 5;
		gbc_lblMaxRepeatDuration.weightx = 1.0;
		gbc_lblMaxRepeatDuration.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxRepeatDuration.gridwidth = 2;
		gbc_lblMaxRepeatDuration.gridx = 0;
		gbc_lblMaxRepeatDuration.gridy = 9;
		scriptControlPane.add(lblMaxRepeatDuration, gbc_lblMaxRepeatDuration);

		final JLabel lblH = new JLabel("h");
		lblH.setLabelFor(lblH);

		final GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 0;
		gbc_lblH.gridy = 10;
		scriptControlPane.add(lblH, gbc_lblH);

		hourSpinner = new JSpinner();
		hourSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_hourSpinner = new GridBagConstraints();
		gbc_hourSpinner.weightx = 1.0;
		gbc_hourSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_hourSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_hourSpinner.gridx = 1;
		gbc_hourSpinner.gridy = 10;
		scriptControlPane.add(hourSpinner, gbc_hourSpinner);

		final JLabel lblMin = new JLabel("min");
		lblMin.setLabelFor(lblMin);

		final GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMin.gridx = 0;
		gbc_lblMin.gridy = 11;
		scriptControlPane.add(lblMin, gbc_lblMin);

		minSpinner = new JSpinner();
		minSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_minSpinner = new GridBagConstraints();
		gbc_minSpinner.weightx = 1.0;
		gbc_minSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_minSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_minSpinner.gridx = 1;
		gbc_minSpinner.gridy = 11;
		scriptControlPane.add(minSpinner, gbc_minSpinner);

		final JLabel lblS = new JLabel("s");
		final GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 0;
		gbc_lblS.gridy = 12;
		scriptControlPane.add(lblS, gbc_lblS);

		secondSpinner = new JSpinner();
		secondSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		lblS.setLabelFor(secondSpinner);

		final GridBagConstraints gbc_secondSpinner = new GridBagConstraints();
		gbc_secondSpinner.weightx = 1.0;
		gbc_secondSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_secondSpinner.gridx = 1;
		gbc_secondSpinner.gridy = 12;
		scriptControlPane.add(secondSpinner, gbc_secondSpinner);

		final JLabel lblMs = new JLabel("ms");
		final GridBagConstraints gbc_lblMs = new GridBagConstraints();
		gbc_lblMs.insets = new Insets(0, 0, 5, 5);
		gbc_lblMs.gridx = 0;
		gbc_lblMs.gridy = 13;
		scriptControlPane.add(lblMs, gbc_lblMs);

		msSpinner = new JSpinner();
		lblMs.setLabelFor(msSpinner);
		msSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_msSpinner = new GridBagConstraints();
		gbc_msSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_msSpinner.weightx = 1.0;
		gbc_msSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_msSpinner.gridx = 1;
		gbc_msSpinner.gridy = 13;
		scriptControlPane.add(msSpinner, gbc_msSpinner);

		configureStopConditions();

		iterationSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {
					refreshStopConditions();
				}
			});
		hourSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {
					refreshStopConditions();
				}
			});
		minSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {
					refreshStopConditions();
				}
			});
		secondSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {
					refreshStopConditions();
				}
			});
		msSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(final ChangeEvent arg0) {
					refreshStopConditions();
				}
			});
	}

	private void refreshStopConditions() {
		refreshIterationStopCondition();
		refreshTimeStopCondition();
	}

	private void refreshTimeStopCondition() {
		actionsScript.setMaxExecutionTime((Integer) msSpinner.getValue() +
			(1000 *
				((Integer) secondSpinner.getValue() +
					(60 *
						((Integer) minSpinner.getValue() +
							(60 * ((Integer) hourSpinner.getValue())))))));
	}

	private void refreshIterationStopCondition() {
		actionsScript.setMaxIterations((Integer) iterationSpinner.getValue());
	}

	private void configureStopConditions() {
		iterationSpinner.setValue(actionsScript.getMaxIterations());

		final int executionTimeInMs = actionsScript.getMaxExecutionTime();

		final int HOURS_DIVISOR = MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC;
		final int hours = executionTimeInMs / HOURS_DIVISOR;
		hourSpinner.setValue(hours);

		int rest = executionTimeInMs % HOURS_DIVISOR;

		final int MINUTES_DIVISOR = SEC_PER_MIN * MS_PER_SEC;
		final int minutes = rest / MINUTES_DIVISOR;
		rest = executionTimeInMs % MINUTES_DIVISOR;
		minSpinner.setValue(minutes);

		final int SECONDS_DIVISOR = MS_PER_SEC;
		final int seconds = rest / MS_PER_SEC;
		rest %= SECONDS_DIVISOR;
		secondSpinner.setValue(seconds);
		msSpinner.setValue(rest);
	}

	/** Starts or stops the script depending on whether it's running allready. */
	public void startStop() {
		if (actionsScript.isRunning()) {
			actionsScript.stop();
		} else {
			refreshStopConditions();
			new Thread(new Runnable() {
					@Override
					public void run() {
						actionsScript.start();
						refreshStopConditions();

						if (chckbxPlaySoundWhenDone.isSelected()) {
							Toolkit.getDefaultToolkit().beep();
						}
					}
				}, "actionsscript thread").start();
		}
	}

	public boolean isRunning() {
		return actionsScript.isRunning();
	}

	/** Gets the currently configured Action and adds it to the script. */
	public synchronized void addCurrentConfig() {
		actionsScript.add(actionsPane.getAction());

		final int lastIndex = actionsScript.size() - 1;
		scriptTable.getSelectionModel().setSelectionInterval(lastIndex, lastIndex);
		scriptTable.revalidate();
	}
}
