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

public class Plugin_1 implements PlugInFilter {
	ImagePlus im;
	public static final String HistKey = "HISTOGRAM"; 
	
	public int setup(String arg, ImagePlus im) {
		this.im = im;
		return DOES_ALL + NO_CHANGES;}
		
	public void run(ImageProcessor ip) {
		int[] hist = ip.getHistogram();
		// add histogram to image properties:
		im.setProperty(HistKey, hist); 
	}
}