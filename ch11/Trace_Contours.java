/**
 * This sample code is made available as part of the book "Digital Image
 * Processing - An Algorithmic Introduction using Java" by Wilhelm Burger
 * and Mark J. Burge, Copyright (C) 2005-2008 Springer-Verlag Berlin, 
 * Heidelberg, New York.
 * Note that this code comes with absolutely no warranty of any kind.
 * See http://www.imagingbook.com for details and licensing conditions.
 * 
 * Date: 2015/01/27
 */

import java.util.List;
import regions.BinaryRegion;
import regions.RegionLabeling;
import contours.Contour;
import contours.ContourOverlay;
import contours.ContourTracer;
import ij.IJ;
import ij.ImagePlus;
import ij.gui.ImageWindow;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/*
This plugin implements the combined contour tracing and 
component labeling algorithm as described in  Chang, Chun-Jen: 
``A Component-Labeling Algorithm Using Contour Tracing 
Technique'', Proc. ICDAR03, p. 741-75, IEEE Comp. Soc., 2003.
It uses the ContourTracer class to create lists of points 
representing the internal and external contours of each region in
the binary image.  Instead of drawing directly into the image, 
we make use of ImageJ's \Class{ImageCanvas} to draw the contours 
in a separate layer on top of the image.  Illustrates how to use 
the Java2D API to draw the polygons and scale and transform them 
to match ImageJ's zooming.  
*/

public class Trace_Contours implements PlugInFilter {
	
	ImagePlus origImage = null;
	String origTitle = null;
	static boolean verbose = true;
	
	public int setup(String arg, ImagePlus im) { 
    	origImage = im;
		origTitle = im.getTitle();
		RegionLabeling.setVerbose(verbose);
		return DOES_8G + NO_CHANGES; 
	}
	
	public void run(ImageProcessor ip) {
		ImageProcessor ip2 = ip.duplicate();
		//  label regions and trace contours
		ContourTracer tracer = new ContourTracer(ip2);
		
		// extract contours and regions
		List<Contour> outerContours = tracer.getOuterContours();
		List<Contour> innerContours = tracer.getInnerContours();
		List<BinaryRegion> regions = tracer.getRegions();
		if (verbose) printRegions(regions);

		// change lookup-table to show gray regions
		ip2.setMinAndMax(0,512);
		// create an image with overlay to show the contours
		ImagePlus im2 = new ImagePlus("Contours of " + origTitle, ip2);
		ContourOverlay cc = new ContourOverlay(im2, outerContours, innerContours);
		new ImageWindow(im2, cc);
	}
	
	void printRegions(List<BinaryRegion> regions) {
		for (BinaryRegion r: regions) {
			IJ.write("" + r);
		}
	}
}