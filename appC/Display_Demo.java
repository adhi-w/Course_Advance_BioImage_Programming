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

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

public class Display_Demo implements PlugInFilter {
	ImagePlus im = null;

	public int setup(String arg, ImagePlus imp) {
		this.im = imp;		// keep reference to associated ImagePlus
		return DOES_ALL; 	// this plugin accepts any image
	}

	public void run(ImageProcessor ip) {
		for (int i = 0; i < 10; i++) {
			// modify this image:
			ip.smooth();
			ip.rotate(30);
			// redisplay this image:
			im.updateAndDraw();
			// sleep so user can watch this:
			IJ.wait(100);
		}
	}
}
