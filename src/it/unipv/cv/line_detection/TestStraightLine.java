package it.unipv.cv.line_detection;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import it.unipv.cv.utils.CommandLine;
import it.unipv.cv.utils.DisplayImage;
import it.unipv.cv.utils.Utility;

/**
 * Test the straight line detection
 * 
 * @author Davide Pio Lotito - Aiman Al Masoud
 * Computer Vision Project - 2022 - UniPV
 *
 */
public class TestStraightLine {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// command lines operations
//		CommandLine command = new CommandLine(args);
//		String pathname = command.name;

		// paths to a bunch of test images
		String root = "images"+File.separator+"input"+File.separator;
		String diagLines = root+"diagonal_lines.png";
		String square = root+"square.png";
		String horizontal = root+"horizontal_line_C.png";
		String sudoku =  root+"sudoku.png";
		String sudoku2 =  root+"sudoku_settimana.jpg";

		// pick a test image
		String pathname = sudoku2;
		
		//read the image and make a copy of it
//		BufferedImage image = Utility.read(pathname);
		
		BufferedImage image = Utility.read(pathname);

		//detect the lines on the image
		LineFinder lineFinder = new LineFinder();
		ArrayList<Line> lines = lineFinder.detectLines(image);
		
		//draw each line
		for(Line line : lines) {
			image = line.draw(image);
		}
		LineFinder.imageSequence.add(image);
		
		//for(int i=0; i<LineFinder.imageSequence.size(); i++) {
		//	new DisplayImage().displayOneImage(LineFinder.imageSequence.get(i), i+"");
		//}
		
		//display the image with the detected lines
		//new DisplayImage().displayOneImage(image, "detected lines");
		
		//display all the images
		new DisplayImage().displayMoreImages(LineFinder.imageSequence);
	}
}
