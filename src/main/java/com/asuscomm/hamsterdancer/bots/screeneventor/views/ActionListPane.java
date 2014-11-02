package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class ActionListPane extends JPanel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Create the panel. */
	public ActionListPane() {
		setBorder(new TitledBorder(
				new TitledBorder(
					UIManager.getBorder("TitledBorder.border"),
					"Actions",
					TitledBorder.LEADING,
					TitledBorder.TOP,
					null,
					null),
				"Action Script",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				null));
		setLayout(new BorderLayout(0, 0));
	}
}
