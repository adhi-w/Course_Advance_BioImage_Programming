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

import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import java.awt.Rectangle;

public class Roi_Demo implements PlugInFilter {
	boolean showMask = true;

	public int setup(String arg, ImagePlus imp) {
		return DOES_RGB;
	}

	public void run(ImageProcessor ip) {
		Rectangle roi = ip.getRoi();
		ImageProcessor mask = ip.getMask();
		boolean hasMask = (mask != null);
		if (hasMask && showMask) {
			(new ImagePlus("The Mask", mask)).show();
		}

		// ROI corner coordinates: 
		int rLeft = roi.x;
		int rTop = roi.y;
		int rRight = rLeft + roi.width;
		int rBottom = rTop + roi.height;

		// process all pixels inside the ROI
		for (int v = rTop; v < rBottom; v++) {
			for (int u = rLeft; u < rRight; u++) {
				if (!hasMask || mask.getPixel(u - rLeft, v - rTop) > 0) {
					int p = ip.getPixel(u, v);
					ip.putPixel(u, v, ~p);
				}

			}
		}
	}
}
