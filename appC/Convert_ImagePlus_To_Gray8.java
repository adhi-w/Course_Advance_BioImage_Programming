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
import ij.process.ImageConverter;
import ij.process.ImageProcessor;

public class Convert_ImagePlus_To_Gray8 implements PlugInFilter {
	ImagePlus imp = null;

	public int setup(String arg, ImagePlus imp) {
		this.imp = imp;
		return DOES_ALL; 	// this plugin accepts any image
	}

	public void run(ImageProcessor ip) {
		ImageConverter iConv = new ImageConverter(imp);
		iConv.convertToGray8();
		ip = imp.getProcessor();	// ip is now of type ByteProcessor
		// process grayscale image ...
		ip.sharpen();
	}
}
