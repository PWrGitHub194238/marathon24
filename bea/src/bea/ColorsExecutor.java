package bea;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ColorsExecutor {

	private String pathToColors;
	
	public ColorsExecutor(String pathToColors) {
		this.pathToColors = pathToColors;
	}
	
	public Map<Integer, Colors> getColors() {
		
		BufferedImage img;
		
		System.out.println(pathToColors);
		
		try {
			img = ImageIO.read(new File(pathToColors));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		int[][] image = convertTo2DWithoutUsingGetRGB(img);
		
		Colors[] colors = new Colors[] {Colors.BLUE, Colors.GREEN, Colors.YELLOW, Colors.RED, Colors.AZURE , Colors.BLACK, Colors.ORANGE};
		int colCount = 0;
		
		Map<Integer, Colors> map = new HashMap<>();
		
		for (int x=0 ; x< image.length ; x++) {
			for (int y=0 ; y< image[x].length ; y++) {
				if ((image[x][y] & 0xffffff) == 0xffffff) {
					continue;
				}
					
				System.out.println("1");
				removeFromPattern(image, map, x, y, colors[colCount]);
				
			}
		}
		
		return map;
	}
	
	private void removeFromPattern(int[][] image, Map<Integer, Colors> map, int x, int y, Colors color) {
		if ((image[x][y] & 0xffffff) == 0xffffff) {
			return;
		} else {
			map.put(image[x][y], color);
			image[x][y] = 0xffffffff;
			
			if (x < image.length-1 && (image[x+1][y] & 0xffffff) != 0xffffff) {
				removeFromPattern(image, map, x+1, y, color);
			}
			if (x > 0 && (image[x-1][y] & 0xffffff) != 0xffffff)
				removeFromPattern(image, map, x-1, y, color);
			if (y < image[x].length-1 && (image[x][y+1] & 0xffffff) != 0xffffff)
				removeFromPattern(image, map, x, y+1, color);
			if (y > 0 && (image[x][y-1] & 0xffffff) != 0xffffff)
				removeFromPattern(image, map, x, y-1, color);
		}
		
	}
	
	
	private int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

	      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();

	      int[][] result = new int[height][width];
	         final int pixelLength = 3;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += -16777216; // 255 alpha
	            argb += ((int) pixels[pixel] & 0xff); // blue
	            argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }

	      return result;
	   }

}
