package de.elinja.whiteboard.numberproducer;

import java.util.function.Consumer;

public interface WhiteboardAccess<S> {

	void forAllServices(Consumer<S> func);
}
