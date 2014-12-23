package com.asuscomm.hamsterdancer.bots.screeneventor.views.fx;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import org.apache.commons.lang3.StringUtils;

/**
 * @author MarMer
 * @since 21.12.2014
 */
public class Spinner extends HBox implements Initializable {
	@FXML
	private TextField textField;

	public Spinner() {
		final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"Spinner.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
		} catch (final IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	private final LongProperty longValue = new SimpleLongProperty(this,
			"value", 0L);

	public LongProperty valueProperty() {
		return longValue;
	}

	public Long getValue() {
		return longValue.getValue();
	}

	public void setValue(final Long value) {
		longValue.set(value);
	}

	@FXML
	public void increment() {
		longValue.set(longValue.get() + 1);
	}

	@FXML
	public void decrement() {
		longValue.set(longValue.get() - 1);
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		final String nonNumbers = "[^0-9]";

		textField.textProperty().addListener(
				(observable, oldValue, newValue) -> {
					if (StringUtils.isBlank(newValue)) {
						((StringProperty) observable).set("0");
					} else if (newValue.contains(nonNumbers)) {
						((StringProperty) observable).set(newValue.replaceAll(
								nonNumbers, ""));
					} else {
						try {
							longValue.set(Long.parseLong(newValue));
						} catch (final NumberFormatException e) {
							if (newValue.startsWith("-")) {
								((StringProperty) observable).set(new Long(
										Long.MAX_VALUE).toString());
							} else {
								((StringProperty) observable).set(new Long(
										Long.MIN_VALUE).toString());
							}
						}
					}

				});

		longValue.addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				((LongProperty) observable).set(0);
			} else if (!Objects.equals(oldValue, newValue)) {
				textField.setText(newValue.toString());
			}
		});

		longValue.setValue(0);
	}
}