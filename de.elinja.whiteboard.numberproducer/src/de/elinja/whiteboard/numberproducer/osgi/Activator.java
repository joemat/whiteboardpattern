package de.elinja.whiteboard.numberproducer.osgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.elinja.whiteboard.api.NumberPrinter;
import de.elinja.whiteboard.numberproducer.NumberProducer;

public class Activator implements BundleActivator {

	private static DecoratedServiceTracker<NumberPrinter> serviceTracker = null;

	public void start(BundleContext bundleContext) throws Exception {
		serviceTracker = new DecoratedServiceTracker<NumberPrinter>(bundleContext, NumberPrinter.class);
		serviceTracker.open();
		
		// In a real OSGi application the number provider
		// should run in an own thread.
		startNumberProviding();
		
		// Stop the OSGi framework by stopping the framework bundle.
		// This should of course not be done in a real application.
		bundleContext.getBundle(0).stop();
	}

	private void startNumberProviding() {
		NumberProducer numberProvider = new NumberProducer();
		numberProvider.provideNumbers(serviceTracker);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Done.");
		serviceTracker.close();
	}

}
