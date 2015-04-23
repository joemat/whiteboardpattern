package de.elinja.whiteboard.printer.bin;

import org.osgi.service.component.annotations.Component;

import de.elinja.whiteboard.api.NumberPrinter;

@Component
public class BinPrinter implements NumberPrinter{

	@Override
	public String printNumber(long value) {
		return Long.toBinaryString(value);
	}

	@Override
	public String getLabel() {
		return "Bin" ;
	}

}
