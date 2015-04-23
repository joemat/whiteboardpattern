Example: WhiteboardPattern with Java 8
-------------------------------------------------------------------------------

An example implementation of the whiteboard pattern with Java 8 and OSGi declarative services annotations.

You need an [Eclipse](http://www.eclipse.org) with the [Declarative Services Annotations Support Plug-In](http://marketplace.eclipse.org/content/declarative-services-annotations-support) to make the annotations work.

# Running the example

* Import the 4 projects 
 * _de.elinja.whiteboard.api_
 * _de.elinja.whiteboard.numberproducer_
 * _de.elinja.whiteboard.printer.bin_
 * _de.elinja.whiteboard.printer.hex_
 into your Eclipse workspace.
* Right-click *WhiteboardPatternExample.launch* and select *Run As WhiteboardPatternExample*

The output of the sample should be

    Sending no. 4711 to printers:
    
    Hex => 1267
    Bin => 1001001100111
    Done.

# Links

* [My description of the whiteboard pattern and this example](
http://joemat.blogspot.com/2015/04/the-whiteboard-pattern-in-java-8-world.html)
* The Whitepaper [Listeners Considered Harmful: The “Whiteboard” Pattern](http://www.osgi.org/wiki/uploads/Links/whiteboard.pdf) from the OSGi alliance
* [JavaDoc of OSGi declarative services annotation](https://osgi.org/javadoc/r5/cmpn/org/osgi/service/component/annotations/package-summary.html)
* [JavaDoc of BundleTracker](https://osgi.org/javadoc/r5/core/org/osgi/util/tracker/BundleTracker.html)
