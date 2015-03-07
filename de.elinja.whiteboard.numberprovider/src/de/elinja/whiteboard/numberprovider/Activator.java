package de.elinja.whiteboard.numberprovider;

import java.util.Collection;
import java.util.Collections;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@FunctionalInterface
	static interface FunctionToExecuteOnService<T> {
		void exec(T srv);
	}

	/**
	 * Executes the passed function {@code func} for each registered service
	 * that implements the interface {@code serviceInterface}.
	 * 
	 * @param serviceInterface
	 *            the interface to be implemented by the services to call
	 * @param func
	 *            the closure to be called for this service (receives the
	 *            service as argument)
	 */
	static public <T> void forAllServicesWithInterface(Class<T> serviceInterface,
			FunctionToExecuteOnService<T> func) {

		for (ServiceReference<T> ref : getServiceRefs(serviceInterface)) {
			callFuncForService(ref, func);
		}
	}

	private static <T> void callFuncForService(ServiceReference<T> ref,
			FunctionToExecuteOnService<T> func) {

		T srv = getContext().getService(ref);
		if (srv != null) {
			func.exec(srv);
		}
	}

	private static <T> Collection<ServiceReference<T>> getServiceRefs(
			Class<T> clazz) {

		try {
			return getContext().getServiceReferences(clazz, null);
		} catch (InvalidSyntaxException e) {
			// can't happen since we don't pass a filter
			return Collections.emptyList();
		}
	}


	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;

		// In a real OSGi application the number provider
		// should run in an own thread.
		NumberProvider numberProvider = new NumberProvider();
		numberProvider.provideNumbers();
		
		// Stop the OSGi framework by stopping the framework bundle.
		// This should of course not be done in a real application.
		bundleContext.getBundle(0).stop();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Done.");
	}

}
