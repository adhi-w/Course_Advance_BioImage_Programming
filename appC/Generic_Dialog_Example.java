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
import ij.gui.GenericDialog;
import ij.gui.NewImage;
import ij.plugin.PlugIn;

public class Generic_Dialog_Example implements PlugIn {
	static String title = "Untitled";
	static int width = 512;
	static int height = 512;

	public void run(String arg) {
		
		GenericDialog gd = new GenericDialog("New Image");
		gd.addStringField("Title:", title);
		gd.addNumericField("Width:", width, 0);
		gd.addNumericField("Height:", height, 0);
		gd.showDialog();
		
		if (gd.wasCanceled())
			return;
		
		title = gd.getNextString();
		width = (int) gd.getNextNumber();
		height = (int) gd.getNextNumber();

		ImagePlus imp = NewImage.createByteImage(title, width, height, 1,
				NewImage.FILL_WHITE);
		imp.show();
	}
}