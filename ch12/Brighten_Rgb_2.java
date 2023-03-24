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
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;

public class Brighten_Rgb_2 implements PlugInFilter {
	static final int R = 0, G = 1, B = 2;	// component indices

	public void run(ImageProcessor ip) {
		//make sure image is of type ColorProcessor
		ColorProcessor cp = (ColorProcessor) ip; 
		int[] RGB = new int[3];

		for (int v = 0; v < cp.getHeight(); v++) {
			for (int u = 0; u < cp.getWidth(); u++) {
				cp.getPixel(u, v, RGB); 
				RGB[R] = Math.min(RGB[R]+10, 255);  //add 10, limit to 255
				RGB[G] = Math.min(RGB[G]+10, 255);
				RGB[B] = Math.min(RGB[B]+10, 255);
				cp.putPixel(u, v, RGB); 
			}
		}
	}

	public int setup(String arg, ImagePlus imp) {
		return DOES_RGB;	// this plugin works on RGB images 
	}
}
