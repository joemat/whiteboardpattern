package de.elinja.whiteboard.numberprovider.osgi;

import java.util.function.Consumer;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import de.elinja.whiteboard.numberprovider.WhiteboardAccess;

public class DecoratedServiceTracker<S> extends ServiceTracker<S, S> implements
		WhiteboardAccess<S> {

	public DecoratedServiceTracker(BundleContext context, Class<S> clazz) {
		super(context, clazz, null);
	}

	/**
	 * Executes the passed function {@code func} for each registered service.
	 *
	 * @param func
	 *            the closure to be called for this service (receives the
	 *            service as argument)
	 */
	public void forAllServices(Consumer<S> func) {
		S[] services = getServicesAsArray();
		for (S service : services) {
			func.accept(service);
		}
	}

	private S[] getServicesAsArray() {
		@SuppressWarnings("unchecked")
		S[] services = this.getServices((S[]) new Object[0]);
		return services;
	}

}
