package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;

import javax.swing.table.TableModel;


/**
 * Column definitions of Actions used in {@link TableModel}s.
 *
 * @author MarMer
 * @since  2014-11-09
 */
enum ActionTableModelColumns {
	TYPE("Type", String.class, false), AREA("Area", Area.class, false),
	PRE_DELAY("Pre-Delay", Integer.class, true), INTER_DELAY("Inter-Delay", Integer.class, true),
	RESET_CURSOR("Reset Cursor", Boolean.class, true);

	private String columnName;
	private Class<?> type;
	private boolean editable;

	private ActionTableModelColumns(final String columnName,
		final Class<?> type,
		final boolean editable) {
		this.columnName = columnName;
		this.type = type;
		this.editable = editable;
	}

	public String getName() {
		return columnName;
	}

	public Class<?> getType() {
		return type;
	}

	public boolean isEditable() {
		return editable;
	}

	public static ActionTableModelColumns getColumn(final int columnIndex) {
		return values()[columnIndex];
	}
}
