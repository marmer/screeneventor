package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.LeftClickAction;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class MainFrame extends JFrame {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private JTable actionsTable;
	private JTextField txtX;
	private JTextField txtX2;
	private JTextField txtY;
	private JTextField txtY2;
	private JTextField txtRadius;
	private JTextField txtComment;

	/** Create the frame. */
	public MainFrame() {
		setTitle("Screenevator - Let us play your games");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JPanel actionPane = new JPanel();
		actionPane.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"Action",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(actionPane, BorderLayout.NORTH);

		final GridBagLayout gbl_actionPane = new GridBagLayout();
		gbl_actionPane.columnWeights =
			new double[] {
				1.0, 0.0, 1.0, 1.0,
				1.0, 1.0, 1.0
			};
		gbl_actionPane.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		actionPane.setLayout(gbl_actionPane);

		final JLabel lblAction = new JLabel("Action");
		final GridBagConstraints gbc_lblAction = new GridBagConstraints();
		gbc_lblAction.insets = new Insets(0, 0, 5, 5);
		gbc_lblAction.gridx = 0;
		gbc_lblAction.gridy = 0;
		actionPane.add(lblAction, gbc_lblAction);

		final JLabel lblX = new JLabel("X");
		final GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 2;
		gbc_lblX.gridy = 0;
		actionPane.add(lblX, gbc_lblX);

		final JLabel lblY = new JLabel("Y");
		final GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 3;
		gbc_lblY.gridy = 0;
		actionPane.add(lblY, gbc_lblY);

		final JLabel lblRadius = new JLabel("Radius");
		final GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 4;
		gbc_lblRadius.gridy = 0;
		actionPane.add(lblRadius, gbc_lblRadius);

		final JLabel lblPredelayInMs = new JLabel("Pre-Delay in ms");
		final GridBagConstraints gbc_lblPredelayInMs = new GridBagConstraints();
		gbc_lblPredelayInMs.insets = new Insets(0, 0, 5, 5);
		gbc_lblPredelayInMs.gridx = 5;
		gbc_lblPredelayInMs.gridy = 0;
		actionPane.add(lblPredelayInMs, gbc_lblPredelayInMs);

		final JLabel lblInterdelayInMs = new JLabel("Inter-Delay in ms");
		final GridBagConstraints gbc_lblInterdelayInMs = new GridBagConstraints();
		gbc_lblInterdelayInMs.insets = new Insets(0, 0, 5, 0);
		gbc_lblInterdelayInMs.gridx = 6;
		gbc_lblInterdelayInMs.gridy = 0;
		actionPane.add(lblInterdelayInMs, gbc_lblInterdelayInMs);

		final JComboBox<ActionFactoryComboboxItem<? extends Action>> comboBox =
			new JComboBox<ActionFactoryComboboxItem<? extends Action>>();
		lblAction.setLabelFor(comboBox);
		populateWithActions(comboBox);

		final GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		actionPane.add(comboBox, gbc_comboBox);

		final JLabel lblStart = new JLabel("Start");
		final GridBagConstraints gbc_lblStart = new GridBagConstraints();
		gbc_lblStart.anchor = GridBagConstraints.EAST;
		gbc_lblStart.insets = new Insets(0, 0, 5, 5);
		gbc_lblStart.gridx = 1;
		gbc_lblStart.gridy = 1;
		actionPane.add(lblStart, gbc_lblStart);

		txtX = new JTextField();

		final GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 2;
		gbc_txtX.gridy = 1;
		actionPane.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		txtY = new JTextField();

		final GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 3;
		gbc_txtY.gridy = 1;
		actionPane.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		txtRadius = new JTextField();
		lblRadius.setLabelFor(txtRadius);

		final GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 5);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 4;
		gbc_txtRadius.gridy = 1;
		actionPane.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);

		final JSpinner preDelaySpinner = new JSpinner();
		preDelaySpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));
		lblPredelayInMs.setLabelFor(preDelaySpinner);

		final GridBagConstraints gbc_preDelaySpinner = new GridBagConstraints();
		gbc_preDelaySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_preDelaySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_preDelaySpinner.gridx = 5;
		gbc_preDelaySpinner.gridy = 1;
		actionPane.add(preDelaySpinner, gbc_preDelaySpinner);

		final JSpinner interDelaySpinner = new JSpinner();
		interDelaySpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));
		lblInterdelayInMs.setLabelFor(interDelaySpinner);

		final GridBagConstraints gbc_interDelaySpinner = new GridBagConstraints();
		gbc_interDelaySpinner.insets = new Insets(0, 0, 5, 0);
		gbc_interDelaySpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_interDelaySpinner.gridx = 6;
		gbc_interDelaySpinner.gridy = 1;
		actionPane.add(interDelaySpinner, gbc_interDelaySpinner);

		final JLabel lblEnd = new JLabel("End");
		final GridBagConstraints gbc_lblEnd = new GridBagConstraints();
		gbc_lblEnd.anchor = GridBagConstraints.EAST;
		gbc_lblEnd.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnd.gridx = 1;
		gbc_lblEnd.gridy = 2;
		actionPane.add(lblEnd, gbc_lblEnd);

		txtX2 = new JTextField();

		final GridBagConstraints gbc_txtX2 = new GridBagConstraints();
		gbc_txtX2.insets = new Insets(0, 0, 0, 5);
		gbc_txtX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX2.gridx = 2;
		gbc_txtX2.gridy = 2;
		actionPane.add(txtX2, gbc_txtX2);
		txtX2.setColumns(10);

		txtY2 = new JTextField();

		final GridBagConstraints gbc_txtY2 = new GridBagConstraints();
		gbc_txtY2.insets = new Insets(0, 0, 0, 5);
		gbc_txtY2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY2.gridx = 3;
		gbc_txtY2.gridy = 2;
		actionPane.add(txtY2, gbc_txtY2);
		txtY2.setColumns(10);

		final JCheckBox chckbxResetCursor = new JCheckBox("reset Cursor");
		final GridBagConstraints gbc_chckbxResetCursor = new GridBagConstraints();
		gbc_chckbxResetCursor.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxResetCursor.gridx = 4;
		gbc_chckbxResetCursor.gridy = 2;
		actionPane.add(chckbxResetCursor, gbc_chckbxResetCursor);

		final JLabel lblComment = new JLabel("Comment");
		final GridBagConstraints gbc_lblComment = new GridBagConstraints();
		gbc_lblComment.anchor = GridBagConstraints.EAST;
		gbc_lblComment.insets = new Insets(0, 0, 0, 5);
		gbc_lblComment.gridx = 5;
		gbc_lblComment.gridy = 2;
		actionPane.add(lblComment, gbc_lblComment);

		txtComment = new JTextField();
		lblComment.setLabelFor(txtComment);

		final GridBagConstraints gbc_txtComment = new GridBagConstraints();
		gbc_txtComment.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComment.gridx = 6;
		gbc_txtComment.gridy = 2;
		actionPane.add(txtComment, gbc_txtComment);
		txtComment.setColumns(10);

		final JPanel scriptPane = new JPanel();
		scriptPane.setBorder(new TitledBorder(
				null,
				"Script",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(scriptPane, BorderLayout.CENTER);
		scriptPane.setLayout(new BorderLayout(5, 5));

		final JScrollPane actionsScrollPane = new JScrollPane();
		scriptPane.add(actionsScrollPane, BorderLayout.CENTER);
		actionsTable = new JTable();
		actionsTable.setModel(new DefaultTableModel(
				new Object[][] {
					{ null, null, null, null, null, null, null, null, null, null },
				},
				new String[] {
					"Type", "Area", "X1", "Y1", "X2", "Y2", "R", "Pre Delay", "Inter Delay",
					"Reset Cursor"
				}) {
				/** serialVersionUID. */
				private static final long serialVersionUID = 1L;

				Class[] columnTypes =
					new Class[] {
						String.class, String.class, Integer.class, Integer.class, Integer.class,
						Integer.class, Integer.class, Integer.class, Integer.class, Boolean.class
					};

				@Override
				public Class getColumnClass(final int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables =
					new boolean[] {
						false, false, false, false, false, false, false, false, false, false
					};

				@Override
				public boolean isCellEditable(final int row, final int column) {
					return columnEditables[column];
				}
			});
		actionsTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		actionsTable.getColumnModel().getColumn(3).setPreferredWidth(35);
		actionsTable.getColumnModel().getColumn(4).setPreferredWidth(35);
		actionsTable.getColumnModel().getColumn(5).setPreferredWidth(35);
		actionsTable.getColumnModel().getColumn(6).setPreferredWidth(35);
		actionsTable.getColumnModel().getColumn(7).setPreferredWidth(65);
		actionsTable.getColumnModel().getColumn(8).setPreferredWidth(65);
		actionsScrollPane.setViewportView(actionsTable);

		final JPanel scriptControlPane = new JPanel();
		scriptPane.add(scriptControlPane, BorderLayout.EAST);

		final GridBagLayout gbl_scriptControlPane = new GridBagLayout();
		gbl_scriptControlPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_scriptControlPane.rowWeights =
			new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		scriptControlPane.setLayout(gbl_scriptControlPane);

		final JButton btnAdd = new JButton("Add");
		final GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		scriptControlPane.add(btnAdd, gbc_btnAdd);

		final JButton btnUpdate = new JButton("Update");
		final GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.fill = GridBagConstraints.BOTH;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 1;
		scriptControlPane.add(btnUpdate, gbc_btnUpdate);

		final JButton btnMoveUp = new JButton("Move Up");
		final GridBagConstraints gbc_btnMoveUp = new GridBagConstraints();
		gbc_btnMoveUp.gridwidth = 2;
		gbc_btnMoveUp.fill = GridBagConstraints.BOTH;
		gbc_btnMoveUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveUp.gridx = 0;
		gbc_btnMoveUp.gridy = 2;
		scriptControlPane.add(btnMoveUp, gbc_btnMoveUp);

		final JButton btnMoveDown = new JButton("Move Down");
		final GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.gridwidth = 2;
		gbc_btnMoveDown.fill = GridBagConstraints.BOTH;
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveDown.gridx = 0;
		gbc_btnMoveDown.gridy = 3;
		scriptControlPane.add(btnMoveDown, gbc_btnMoveDown);

		final JButton btnRemove = new JButton("Remove");
		final GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.gridwidth = 2;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 4;
		scriptControlPane.add(btnRemove, gbc_btnRemove);

		final Component glue = Box.createGlue();
		final GridBagConstraints gbc_glue = new GridBagConstraints();
		gbc_glue.weighty = 1.0;
		gbc_glue.weightx = 1.0;
		gbc_glue.fill = GridBagConstraints.BOTH;
		gbc_glue.gridwidth = 2;
		gbc_glue.insets = new Insets(0, 0, 5, 0);
		gbc_glue.gridx = 0;
		gbc_glue.gridy = 5;
		scriptControlPane.add(glue, gbc_glue);

		final JLabel lblMaxIterations = new JLabel("Max Execution Time");
		final GridBagConstraints gbc_lblMaxIterations = new GridBagConstraints();
		gbc_lblMaxIterations.gridwidth = 2;
		gbc_lblMaxIterations.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxIterations.gridx = 0;
		gbc_lblMaxIterations.gridy = 6;
		scriptControlPane.add(lblMaxIterations, gbc_lblMaxIterations);

		final JSpinner iterationSpinner = new JSpinner();
		iterationSpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));
		lblMaxIterations.setLabelFor(iterationSpinner);

		final GridBagConstraints gbc_iterationSpinner = new GridBagConstraints();
		gbc_iterationSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_iterationSpinner.gridwidth = 2;
		gbc_iterationSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_iterationSpinner.gridx = 0;
		gbc_iterationSpinner.gridy = 7;
		scriptControlPane.add(iterationSpinner, gbc_iterationSpinner);

		final JLabel lblMaxRepeatDuration = new JLabel("Max Execution Time");
		final GridBagConstraints gbc_lblMaxRepeatDuration = new GridBagConstraints();
		gbc_lblMaxRepeatDuration.ipady = 5;
		gbc_lblMaxRepeatDuration.ipadx = 5;
		gbc_lblMaxRepeatDuration.weightx = 1.0;
		gbc_lblMaxRepeatDuration.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaxRepeatDuration.gridwidth = 2;
		gbc_lblMaxRepeatDuration.gridx = 0;
		gbc_lblMaxRepeatDuration.gridy = 8;
		scriptControlPane.add(lblMaxRepeatDuration, gbc_lblMaxRepeatDuration);

		final JLabel lblH = new JLabel("h");
		lblH.setLabelFor(lblH);

		final GridBagConstraints gbc_lblH = new GridBagConstraints();
		gbc_lblH.insets = new Insets(0, 0, 5, 5);
		gbc_lblH.gridx = 0;
		gbc_lblH.gridy = 9;
		scriptControlPane.add(lblH, gbc_lblH);

		final JSpinner hourSpinner = new JSpinner();
		hourSpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));

		final GridBagConstraints gbc_hourSpinner = new GridBagConstraints();
		gbc_hourSpinner.weightx = 1.0;
		gbc_hourSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_hourSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_hourSpinner.gridx = 1;
		gbc_hourSpinner.gridy = 9;
		scriptControlPane.add(hourSpinner, gbc_hourSpinner);

		final JLabel lblMin = new JLabel("min");
		lblMin.setLabelFor(lblMin);

		final GridBagConstraints gbc_lblMin = new GridBagConstraints();
		gbc_lblMin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMin.gridx = 0;
		gbc_lblMin.gridy = 10;
		scriptControlPane.add(lblMin, gbc_lblMin);

		final JSpinner minSpinner = new JSpinner();
		minSpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));

		final GridBagConstraints gbc_minSpinner = new GridBagConstraints();
		gbc_minSpinner.weightx = 1.0;
		gbc_minSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_minSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_minSpinner.gridx = 1;
		gbc_minSpinner.gridy = 10;
		scriptControlPane.add(minSpinner, gbc_minSpinner);

		final JLabel lblS = new JLabel("s");
		final GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.gridx = 0;
		gbc_lblS.gridy = 11;
		scriptControlPane.add(lblS, gbc_lblS);

		final JSpinner secondSpinner = new JSpinner();
		secondSpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));
		lblS.setLabelFor(secondSpinner);

		final GridBagConstraints gbc_secondSpinner = new GridBagConstraints();
		gbc_secondSpinner.weightx = 1.0;
		gbc_secondSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondSpinner.insets = new Insets(0, 0, 5, 0);
		gbc_secondSpinner.gridx = 1;
		gbc_secondSpinner.gridy = 11;
		scriptControlPane.add(secondSpinner, gbc_secondSpinner);

		final JLabel lblMs = new JLabel("ms");
		final GridBagConstraints gbc_lblMs = new GridBagConstraints();
		gbc_lblMs.insets = new Insets(0, 0, 0, 5);
		gbc_lblMs.gridx = 0;
		gbc_lblMs.gridy = 12;
		scriptControlPane.add(lblMs, gbc_lblMs);

		final JSpinner msSpinner = new JSpinner();
		lblMs.setLabelFor(msSpinner);
		msSpinner.setModel(new SpinnerNumberModel(0, 0, 42, 1));

		final GridBagConstraints gbc_msSpinner = new GridBagConstraints();
		gbc_msSpinner.weightx = 1.0;
		gbc_msSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_msSpinner.gridx = 1;
		gbc_msSpinner.gridy = 12;
		scriptControlPane.add(msSpinner, gbc_msSpinner);

		final JPanel controlsPane = new JPanel();
		controlsPane.setBorder(new TitledBorder(
				UIManager.getBorder("TitledBorder.border"),
				"Controls",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(controlsPane, BorderLayout.SOUTH);

		final GridBagLayout gbl_controlsPane = new GridBagLayout();
		gbl_controlsPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_controlsPane.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		controlsPane.setLayout(gbl_controlsPane);

		final JLabel lblGetAndAddMousePosition = new JLabel("Get Mouse Position & Add Action");
		final GridBagConstraints gbc_lblGetAndAddMousePosition = new GridBagConstraints();
		gbc_lblGetAndAddMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetAndAddMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetAndAddMousePosition.gridx = 0;
		gbc_lblGetAndAddMousePosition.gridy = 0;
		controlsPane.add(lblGetAndAddMousePosition, gbc_lblGetAndAddMousePosition);

		final JCheckBox chckbxGetAndAddCtrl = new JCheckBox("Ctrl");
		final GridBagConstraints gbc_chckbxGetAndAddCtrl = new GridBagConstraints();
		gbc_chckbxGetAndAddCtrl.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetAndAddCtrl.gridx = 1;
		gbc_chckbxGetAndAddCtrl.gridy = 0;
		controlsPane.add(chckbxGetAndAddCtrl, gbc_chckbxGetAndAddCtrl);

		final JCheckBox chckbxGetAndAddAlt = new JCheckBox("Alt");
		final GridBagConstraints gbc_chckbxGetAndAddAlt = new GridBagConstraints();
		gbc_chckbxGetAndAddAlt.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetAndAddAlt.gridx = 2;
		gbc_chckbxGetAndAddAlt.gridy = 0;
		controlsPane.add(chckbxGetAndAddAlt, gbc_chckbxGetAndAddAlt);

		final JCheckBox chckbxGetAndAddShift = new JCheckBox("Shift");
		final GridBagConstraints gbc_chckbxGetAndAddShift = new GridBagConstraints();
		gbc_chckbxGetAndAddShift.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetAndAddShift.gridx = 3;
		gbc_chckbxGetAndAddShift.gridy = 0;
		controlsPane.add(chckbxGetAndAddShift, gbc_chckbxGetAndAddShift);

		final JComboBox getAndAddKeyCombo = new JComboBox();
		final GridBagConstraints gbc_getAndAddKeyCombo = new GridBagConstraints();
		gbc_getAndAddKeyCombo.insets = new Insets(0, 0, 5, 0);
		gbc_getAndAddKeyCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_getAndAddKeyCombo.gridx = 4;
		gbc_getAndAddKeyCombo.gridy = 0;
		controlsPane.add(getAndAddKeyCombo, gbc_getAndAddKeyCombo);

		final JLabel lblGetMousePosition = new JLabel("Get Mouse Position");
		final GridBagConstraints gbc_lblGetMousePosition = new GridBagConstraints();
		gbc_lblGetMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetMousePosition.gridx = 0;
		gbc_lblGetMousePosition.gridy = 1;
		controlsPane.add(lblGetMousePosition, gbc_lblGetMousePosition);

		final JCheckBox chckbxGetCtrl = new JCheckBox("Ctrl");
		final GridBagConstraints gbc_chckbxGetCtrl = new GridBagConstraints();
		gbc_chckbxGetCtrl.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetCtrl.gridx = 1;
		gbc_chckbxGetCtrl.gridy = 1;
		controlsPane.add(chckbxGetCtrl, gbc_chckbxGetCtrl);

		final JCheckBox chckbxGetAlt = new JCheckBox("Alt");
		final GridBagConstraints gbc_chckbxGetAlt = new GridBagConstraints();
		gbc_chckbxGetAlt.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetAlt.gridx = 2;
		gbc_chckbxGetAlt.gridy = 1;
		controlsPane.add(chckbxGetAlt, gbc_chckbxGetAlt);

		final JCheckBox chckbxGetShift = new JCheckBox("Shift");
		final GridBagConstraints gbc_chckbxGetShift = new GridBagConstraints();
		gbc_chckbxGetShift.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxGetShift.gridx = 3;
		gbc_chckbxGetShift.gridy = 1;
		controlsPane.add(chckbxGetShift, gbc_chckbxGetShift);

		final JComboBox getKeyCombo = new JComboBox();
		final GridBagConstraints gbc_getKeyCombo = new GridBagConstraints();
		gbc_getKeyCombo.insets = new Insets(0, 0, 5, 0);
		gbc_getKeyCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_getKeyCombo.gridx = 4;
		gbc_getKeyCombo.gridy = 1;
		controlsPane.add(getKeyCombo, gbc_getKeyCombo);

		final JLabel lblStartStopScript = new JLabel("Start/Stop Script");
		final GridBagConstraints gbc_lblStartStopScript = new GridBagConstraints();
		gbc_lblStartStopScript.anchor = GridBagConstraints.EAST;
		gbc_lblStartStopScript.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartStopScript.gridx = 0;
		gbc_lblStartStopScript.gridy = 2;
		controlsPane.add(lblStartStopScript, gbc_lblStartStopScript);

		final JCheckBox chckbxStartStopScriptCtrl = new JCheckBox("Ctrl");
		final GridBagConstraints gbc_chckbxStartStopScriptCtrl = new GridBagConstraints();
		gbc_chckbxStartStopScriptCtrl.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxStartStopScriptCtrl.gridx = 1;
		gbc_chckbxStartStopScriptCtrl.gridy = 2;
		controlsPane.add(chckbxStartStopScriptCtrl, gbc_chckbxStartStopScriptCtrl);

		final JCheckBox chckbxStartStopScriptCAkt = new JCheckBox("Alt");
		final GridBagConstraints gbc_chckbxStartStopScriptCAkt = new GridBagConstraints();
		gbc_chckbxStartStopScriptCAkt.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxStartStopScriptCAkt.gridx = 2;
		gbc_chckbxStartStopScriptCAkt.gridy = 2;
		controlsPane.add(chckbxStartStopScriptCAkt, gbc_chckbxStartStopScriptCAkt);

		final JCheckBox chckbxStartStopScriptShift = new JCheckBox("Shift");
		final GridBagConstraints gbc_chckbxStartStopScriptShift = new GridBagConstraints();
		gbc_chckbxStartStopScriptShift.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxStartStopScriptShift.gridx = 3;
		gbc_chckbxStartStopScriptShift.gridy = 2;
		controlsPane.add(chckbxStartStopScriptShift, gbc_chckbxStartStopScriptShift);

		final JComboBox startStopKeyCombo = new JComboBox();
		final GridBagConstraints gbc_startStopKeyCombo = new GridBagConstraints();
		gbc_startStopKeyCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_startStopKeyCombo.gridx = 4;
		gbc_startStopKeyCombo.gridy = 2;
		controlsPane.add(startStopKeyCombo, gbc_startStopKeyCombo);
	}

	private void populateWithActions(
		final JComboBox<ActionFactoryComboboxItem<? extends Action>> comboBox) {
		comboBox.addItem(ActionFactoryComboboxItem.createItem(LeftClickAction.class, "Left Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(LeftClickAction.class, "Left Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Left Release"));

		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Right Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Right Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Right Release"));

		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Middle Click"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Middle Press"));
		comboBox.addItem(ActionFactoryComboboxItem.createItem(
				LeftClickAction.class,
				"Middle Release"));
	}

	/**
	 * Launch the application.
	 *
	 * @param args TODO: doc
	 */
	public static void main(final String[] args) {
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
}
