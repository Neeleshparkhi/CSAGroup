package com.csagroup.Utilities;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageHandler {

	public static void downloadImageFromURL(String urlStr, String writeIntoDir) throws IOException {
		URL url = new URL(urlStr);
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		FileOutputStream fos = new FileOutputStream(writeIntoDir);
		fos.write(response);
		fos.close();
	}

	public static boolean compareImages(String baseImage, String compareImage) {
		File fileA = new File(baseImage);
		File fileB = new File(compareImage);
		try {
			BufferedImage biA = ImageIO.read(fileA);
			DataBuffer dbA = biA.getData().getDataBuffer();
			int sizeA = dbA.getSize();
			BufferedImage biB = ImageIO.read(fileB);
			DataBuffer dbB = biB.getData().getDataBuffer();
			int sizeB = dbB.getSize();
			if (sizeA == sizeB) {
				for (int i = 0; i < sizeA; i++) {
					if (dbA.getElem(i) != dbB.getElem(i)) {
						return false;
					}
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failed to compare image files ...");
			return false;
		}
	}

}
