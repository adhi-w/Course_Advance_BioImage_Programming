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
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;

public class Direct_Pixel_Access implements PlugInFilter {

	public int setup(String arg, ImagePlus img) {
		return DOES_8G; 	// this plugin accepts 8-bit grayscale images
	}

	public void run(ImageProcessor ip) {
		if (!(ip instanceof ByteProcessor)) return;
		if (!(ip.getPixels() instanceof byte[])) return;
		byte[] pixels = (byte[]) ip.getPixels();
		int w = ip.getWidth();
		int h = ip.getHeight();

		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				int p = 0xFF & pixels[v * w + u]; 
				p = p + 1;
				pixels[v * w + u] = (byte) (0xFF & p); 
			}
		}
	}

}
