package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;
import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;

import javax.swing.table.AbstractTableModel;


/**
 * Table model used to represent {@link ActionsScript}s.
 *
 * @author MarMer
 * @since  2014-11-09
 */
final class ActionTableModel extends AbstractTableModel {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private final ActionsScript actionsScript;

	/**
	 * Creates a new ActionTableModel object.
	 *
	 * @param actionsScript The data source.
	 */
	public ActionTableModel(final ActionsScript actionsScript) {
		this.actionsScript = actionsScript;
	}

	@Override
	public Class<?> getColumnClass(final int columnIndex) {
		return ActionTableModelColumns.values()[columnIndex].getType();
	}

	@Override
	public boolean isCellEditable(final int row, final int column) {
		return ActionTableModelColumns.values()[column].isEditable();
	}

	@Override
	public int getColumnCount() {
		return ActionTableModelColumns.values().length;
	}

	@Override
	public String getColumnName(final int columnId) {
		return ActionTableModelColumns.values()[columnId].getName();
	}

	@Override
	public int getRowCount() {
		return actionsScript.size();
	}

	@Override
	public Object getValueAt(final int row, final int column) {
		final Action action = actionsScript.get(row);

		switch (ActionTableModelColumns.values()[column]) {
		case TYPE:
			return action.getTypeName();

		case AREA:

			final Area area = action.getArea();

			return (area == null) ? null : area.toString();

		case PRE_DELAY:
			return action.getPreDelay();

		case INTER_DELAY:
			return action.getInterDelay();

		case RESET_CURSOR:
			return action.isCursorBack();

		case COMMENT:
			return action.getComment();

		default:
			throw new ScreenevatorException("Inconsistent Model in Class " +
				ActionTableModel.class);
		}
	}

	@Override
	public void setValueAt(final Object newValue, final int row, final int column) {
		final Action action = actionsScript.get(row);
		final ActionTableModelColumns columnDefinition = ActionTableModelColumns.values()[column];

		switch (columnDefinition) {
		case TYPE:
			throw new ScreenevatorException("Impossible to change the type yet");

		case AREA:
			action.setArea((Area) newValue);
			break;

		case PRE_DELAY:
			action.setPreDelay((Integer) newValue);
			break;

		case INTER_DELAY:
			action.setInterDelay((Integer) newValue);
			break;

		case RESET_CURSOR:
			action.setCursorBack((Boolean) newValue);
			break;

		case COMMENT:
			action.setComment((String) newValue);
			break;

		default:
			throw new ScreenevatorException("Inconsistent Model in Class " +
				ActionTableModel.class);
		}
	}
}
