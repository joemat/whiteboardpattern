package de.elinja.whiteboard.api;

/**
 * This is the interface to be implemented by the consumers.
 */
public interface NumberPrinter {

	String printNumber(long value);
	String getLabel();
}
