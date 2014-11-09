package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;
import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
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
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane;
	private final JTable actionsTable;
	private final JTextField txtGetcursor;
	private final JTextField txtGetandaddcursor;
	private final JTextField txtStartStopScript;
	private final ActionsScript actionsScript;
	private final JSpinner iterationSpinner;
	private final JButton btnAdd;
	private final JButton btnUpdate;
	private final JButton btnMoveUp;
	private final JButton btnMoveDown;
	private final ActionTableModel actionTableModel;
	private final ActionConfigPane actionsPane;

	/** Create the frame. */
	public MainFrame() {
		setTitle("Screenevator - Let us play your games");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 650);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		actionsPane = new ActionConfigPane();
		actionsPane.setBorder(new TitledBorder(
				null,
				"Action",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		contentPane.add(actionsPane, BorderLayout.NORTH);

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

		actionsScript = new ActionsScript();

		final JScrollPane actionsScrollPane = new JScrollPane();
		scriptPane.add(actionsScrollPane, BorderLayout.CENTER);
		actionsTable = new JTable();
		actionTableModel = new ActionTableModel(actionsScript);
		actionsTable.setModel(actionTableModel);
		actionsScrollPane.setViewportView(actionsTable);

		final JPanel scriptControlPane = new JPanel();
		scriptPane.add(scriptControlPane, BorderLayout.EAST);

		final GridBagLayout gbl_scriptControlPane = new GridBagLayout();
		gbl_scriptControlPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_scriptControlPane.rowWeights =
			new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		scriptControlPane.setLayout(gbl_scriptControlPane);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {
					actionsScript.add(actionsPane.getAction());
					actionsTable.revalidate();
				}
			});

		final JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(final ActionEvent arg0) {}
			});

		final GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 0);
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.gridwidth = 2;
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 0;
		scriptControlPane.add(btnStart, gbc_btnStart);

		final GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		scriptControlPane.add(btnAdd, gbc_btnAdd);

		btnUpdate = new JButton("Update");

		final GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 0);
		gbc_btnUpdate.gridwidth = 2;
		gbc_btnUpdate.fill = GridBagConstraints.BOTH;
		gbc_btnUpdate.gridx = 0;
		gbc_btnUpdate.gridy = 2;
		scriptControlPane.add(btnUpdate, gbc_btnUpdate);

		btnMoveUp = new JButton("Move Up");

		final GridBagConstraints gbc_btnMoveUp = new GridBagConstraints();
		gbc_btnMoveUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveUp.gridwidth = 2;
		gbc_btnMoveUp.fill = GridBagConstraints.BOTH;
		gbc_btnMoveUp.gridx = 0;
		gbc_btnMoveUp.gridy = 3;
		scriptControlPane.add(btnMoveUp, gbc_btnMoveUp);

		btnMoveDown = new JButton("Move Down");

		final GridBagConstraints gbc_btnMoveDown = new GridBagConstraints();
		gbc_btnMoveDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnMoveDown.gridwidth = 2;
		gbc_btnMoveDown.fill = GridBagConstraints.BOTH;
		gbc_btnMoveDown.gridx = 0;
		gbc_btnMoveDown.gridy = 4;
		scriptControlPane.add(btnMoveDown, gbc_btnMoveDown);

		final JButton btnRemove = new JButton("Remove");
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

		final JLabel lblMaxIterations = new JLabel("Max Execution Time");
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

		final JSpinner hourSpinner = new JSpinner();
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

		final JSpinner minSpinner = new JSpinner();
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

		final JSpinner secondSpinner = new JSpinner();
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
		gbc_lblMs.insets = new Insets(0, 0, 0, 5);
		gbc_lblMs.gridx = 0;
		gbc_lblMs.gridy = 13;
		scriptControlPane.add(lblMs, gbc_lblMs);

		final JSpinner msSpinner = new JSpinner();
		lblMs.setLabelFor(msSpinner);
		msSpinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

		final GridBagConstraints gbc_msSpinner = new GridBagConstraints();
		gbc_msSpinner.weightx = 1.0;
		gbc_msSpinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_msSpinner.gridx = 1;
		gbc_msSpinner.gridy = 13;
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
		gbl_controlsPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		gbl_controlsPane.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		controlsPane.setLayout(gbl_controlsPane);

		final JLabel lblGetAndAddMousePosition = new JLabel("Get Mouse Position & Add Action");
		final GridBagConstraints gbc_lblGetAndAddMousePosition = new GridBagConstraints();
		gbc_lblGetAndAddMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetAndAddMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetAndAddMousePosition.gridx = 0;
		gbc_lblGetAndAddMousePosition.gridy = 0;
		controlsPane.add(lblGetAndAddMousePosition, gbc_lblGetAndAddMousePosition);

		txtGetandaddcursor = new JTextField();

		final GridBagConstraints gbc_txtGetandaddcursor = new GridBagConstraints();
		gbc_txtGetandaddcursor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGetandaddcursor.insets = new Insets(0, 0, 5, 5);
		gbc_txtGetandaddcursor.gridx = 1;
		gbc_txtGetandaddcursor.gridy = 0;
		controlsPane.add(txtGetandaddcursor, gbc_txtGetandaddcursor);
		txtGetandaddcursor.setColumns(10);

		final JButton btnGetAndAddCursorAssign = new JButton("Assign");
		final GridBagConstraints gbc_btnGetAndAddCursorAssign = new GridBagConstraints();
		gbc_btnGetAndAddCursorAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetAndAddCursorAssign.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetAndAddCursorAssign.gridx = 2;
		gbc_btnGetAndAddCursorAssign.gridy = 0;
		controlsPane.add(btnGetAndAddCursorAssign, gbc_btnGetAndAddCursorAssign);

		final JButton btnGetAndAddCursorClear = new JButton("Clear");
		final GridBagConstraints gbc_btnGetAndAddCursorClear = new GridBagConstraints();
		gbc_btnGetAndAddCursorClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetAndAddCursorClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetAndAddCursorClear.gridx = 3;
		gbc_btnGetAndAddCursorClear.gridy = 0;
		controlsPane.add(btnGetAndAddCursorClear, gbc_btnGetAndAddCursorClear);

		final Component controlsGlueRight = Box.createGlue();
		final GridBagConstraints gbc_controlsGlueRight = new GridBagConstraints();
		gbc_controlsGlueRight.weightx = 1.0;
		gbc_controlsGlueRight.gridheight = 3;
		gbc_controlsGlueRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_controlsGlueRight.insets = new Insets(0, 0, 5, 0);
		gbc_controlsGlueRight.gridx = 4;
		gbc_controlsGlueRight.gridy = 0;
		controlsPane.add(controlsGlueRight, gbc_controlsGlueRight);

		final JLabel lblGetMousePosition = new JLabel("Get Mouse Position");
		final GridBagConstraints gbc_lblGetMousePosition = new GridBagConstraints();
		gbc_lblGetMousePosition.anchor = GridBagConstraints.EAST;
		gbc_lblGetMousePosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblGetMousePosition.gridx = 0;
		gbc_lblGetMousePosition.gridy = 1;
		controlsPane.add(lblGetMousePosition, gbc_lblGetMousePosition);

		txtGetcursor = new JTextField();

		final GridBagConstraints gbc_txtGetcursor = new GridBagConstraints();
		gbc_txtGetcursor.insets = new Insets(0, 0, 5, 5);
		gbc_txtGetcursor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGetcursor.gridx = 1;
		gbc_txtGetcursor.gridy = 1;
		controlsPane.add(txtGetcursor, gbc_txtGetcursor);
		txtGetcursor.setColumns(10);

		final JButton btnGetCursorAssign = new JButton("Assign");
		final GridBagConstraints gbc_btnGetCursorAssign = new GridBagConstraints();
		gbc_btnGetCursorAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetCursorAssign.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetCursorAssign.gridx = 2;
		gbc_btnGetCursorAssign.gridy = 1;
		controlsPane.add(btnGetCursorAssign, gbc_btnGetCursorAssign);

		final JButton btnGetCursorClear = new JButton("Clear");
		final GridBagConstraints gbc_btnGetCursorClear = new GridBagConstraints();
		gbc_btnGetCursorClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGetCursorClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnGetCursorClear.gridx = 3;
		gbc_btnGetCursorClear.gridy = 1;
		controlsPane.add(btnGetCursorClear, gbc_btnGetCursorClear);

		final JLabel lblStartStopScript = new JLabel("Start/Stop Script");
		final GridBagConstraints gbc_lblStartStopScript = new GridBagConstraints();
		gbc_lblStartStopScript.anchor = GridBagConstraints.EAST;
		gbc_lblStartStopScript.insets = new Insets(0, 0, 0, 5);
		gbc_lblStartStopScript.gridx = 0;
		gbc_lblStartStopScript.gridy = 2;
		controlsPane.add(lblStartStopScript, gbc_lblStartStopScript);

		txtStartStopScript = new JTextField();

		final GridBagConstraints gbc_txtStartStopScript = new GridBagConstraints();
		gbc_txtStartStopScript.insets = new Insets(0, 0, 0, 5);
		gbc_txtStartStopScript.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStartStopScript.gridx = 1;
		gbc_txtStartStopScript.gridy = 2;
		controlsPane.add(txtStartStopScript, gbc_txtStartStopScript);
		txtStartStopScript.setColumns(10);

		final JButton btnStartStopScriptAssign = new JButton("Assign");
		final GridBagConstraints gbc_btnStartStopScriptAssign = new GridBagConstraints();
		gbc_btnStartStopScriptAssign.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartStopScriptAssign.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartStopScriptAssign.gridx = 2;
		gbc_btnStartStopScriptAssign.gridy = 2;
		controlsPane.add(btnStartStopScriptAssign, gbc_btnStartStopScriptAssign);

		final JButton btnStartStopScriptClear = new JButton("Clear");
		final GridBagConstraints gbc_btnStartStopScriptClear = new GridBagConstraints();
		gbc_btnStartStopScriptClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnStartStopScriptClear.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartStopScriptClear.gridx = 3;
		gbc_btnStartStopScriptClear.gridy = 2;
		controlsPane.add(btnStartStopScriptClear, gbc_btnStartStopScriptClear);
	}

	/**
	 * Launch the application.
	 *
	 * @param args args
	 */
	public static void main(final String[] args) {
		setLookAndFeel();

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
