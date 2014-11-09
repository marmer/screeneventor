package com.asuscomm.hamsterdancer.bots.screeneventor.views;

import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;

import javax.swing.JComboBox;


/**
 * <p>An item used to display a not instantiated Object in a {@link JComboBox} or other fitting
 * views.</p>
 *
 * @author MarMer
 * @since  04.11.2014
 */
public class ObjectFactoryComboboxItem<T> {
	private final Class<T> itemClass;
	private final String description;

	/**
	 * Creates a new ActionListView object.
	 *
	 * @param clazz       Class related to the item.
	 * @param description Description used to display
	 */
	public ObjectFactoryComboboxItem(final Class<T> clazz, final String description) {
		this.itemClass = clazz;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * Creates an {@link ObjectFactoryComboboxItem}.
	 *
	 * @param  <A>         Generic type the action is related to.
	 * @param  actionType  Class of the action type.
	 * @param  description Description as shown within combo boxes.
	 *
	 * @return The created {@link ObjectFactoryComboboxItem}.
	 */
	public static <A> ObjectFactoryComboboxItem<A> createItem(final Class<A> actionType,
		final String description) {
		return new ObjectFactoryComboboxItem<A>(actionType, description);
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
