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

public class Plugin_2 implements PlugInFilter {
	ImagePlus im;
	
	public int setup(String arg, ImagePlus im) {
		this.im = im;
		return DOES_ALL;}

	public void run(ImageProcessor ip) {
		String key = Plugin_1.HistKey;	/*\label{prog:PropertiesExample03}*/
		int[] hist = (int[]) im.getProperty(key); /*\label{prog:PropertiesExample04}*/
		if (hist == null){
			IJ.error("This image has no histogram");
		}
		else {
			// process histogram ...
		}
	}
}