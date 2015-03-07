package de.elinja.whiteboard.printer.hex;

import org.osgi.service.component.annotations.Component;

import de.elinja.whiteboard.api.NumberPrinter;

@Component
public class HexPrinter implements NumberPrinter {

	@Override
	public String printNumber(long value) {
		return Long.toHexString(value);
	}

	@Override
	public String getLabel() {
		return "Hex";
	}

}
