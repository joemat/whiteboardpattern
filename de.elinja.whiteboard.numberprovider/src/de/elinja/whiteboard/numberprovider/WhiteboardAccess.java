package de.elinja.whiteboard.numberprovider;

import java.util.function.Consumer;

public interface WhiteboardAccess<S> {

	void forAllServices(Consumer<S> func);
}
