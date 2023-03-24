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

package color;

import ij.process.ByteProcessor;
import ij.process.ColorProcessor;

public interface ColorQuantizer {
	public abstract ByteProcessor quantizeImage(ColorProcessor cp);
	public abstract int[] quantizeImage(int[] origPixels);
	public abstract int countQuantizedColors();

}