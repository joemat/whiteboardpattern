package de.elinja.whiteboard.numberprovider;

import de.elinja.whiteboard.api.NumberPrinter;
import de.elinja.whiteboard.numberprovider.Activator.FunctionToExecuteOnService;

public class NumberProvider {

	private void printNumberOnPrinters(long number) {

		FunctionToExecuteOnService<NumberPrinter> functionToExecuteOnServices = (
				srv) -> {
			System.out.println(srv.getLabel() + " => "
					+ srv.printNumber(number));
		};

		// run the closure on all registeres NumberPrinter services
		Activator.forAllServicesWithInterface(NumberPrinter.class,
				functionToExecuteOnServices);
	}

	public void provideNumbers() {
		long number = 4711;
		System.out.println("Sending no. " + number + " to printers:");
		System.out.println();
		printNumberOnPrinters(number);
	}
}
