package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


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

	/** Create the frame. */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		final JPanel ActionConfig = new ActionConfigPane();
		contentPane.add(ActionConfig, BorderLayout.NORTH);

		final JPanel ActionList = new ActionListPane();
		contentPane.add(ActionList, BorderLayout.CENTER);

		final JPanel KeyConfig = new KeyConfigPane();
		contentPane.add(KeyConfig, BorderLayout.SOUTH);
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
