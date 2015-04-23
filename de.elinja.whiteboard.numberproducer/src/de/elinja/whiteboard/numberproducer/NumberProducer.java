package de.elinja.whiteboard.numberproducer;

import de.elinja.whiteboard.api.NumberPrinter;

public class NumberProducer {

	private void printNumberOnPrinters(long number,
			WhiteboardAccess<NumberPrinter> whiteboardAccess) {

		whiteboardAccess.forAllServices((srv) -> {
			System.out.println(srv.getLabel() + " => "
					+ srv.printNumber(number));
		});
	}

	public void provideNumbers(WhiteboardAccess<NumberPrinter> whiteboardAccess) {
		long number = 4711;
		System.out.println("Sending no. " + number + " to printers:");
		System.out.println();
		printNumberOnPrinters(number, whiteboardAccess);
	}
}
