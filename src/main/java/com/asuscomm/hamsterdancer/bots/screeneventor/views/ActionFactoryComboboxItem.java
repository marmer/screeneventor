package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;


/**
 * An item used to display a not instantiated {@link Action} in a {@link JComboBox} or other fitting
 * views.
 *
 * @author MarMer
 * @since  2014-11-04
 */
/**
 * TODO: doc
 *
 * @author MarMer
 * @since  04.11.2014
 */
public class ActionFactoryComboboxItem<T extends Action> {
	private final Class<T> itemClass;
	private final String description;

	/**
	 * Creates a new ActionListView object.
	 *
	 * @param clazz       Class related to the item.
	 * @param description Description used to display
	 */
	public ActionFactoryComboboxItem(final Class<T> clazz, final String description) {
		this.itemClass = clazz;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * Creates an instance of an action.
	 *
	 * @return An instance of the related Action.
	 *
	 * @throws ScreenevatorException Thrown if something goes wrong with the initialization.
	 */
	public T createAction() {
		try {
			return itemClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ScreenevatorException("Not able to create action of class: " + itemClass, e);
		}
	}

	public Class<T> getActionClass() {
		return this.itemClass;
	}

	@Override
	public String toString() {
		return getDescription();
	}
}
