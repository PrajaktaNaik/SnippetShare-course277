package com.cmpe275.snippetshare.Manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.cmpe275.snippetshare.DAO.SnippetDAO;
import com.cmpe275.snippetshare.DAO.SnippetImagesDAO;
import com.cmpe275.snippetshare.Model.SnippetImages;

public class SnippetImagesManager {

	public static List<SnippetImages> getAllSnippetImages(List<Long> imageIds){
		return SnippetImagesDAO.getSnippetImages(imageIds);
	}
	
	public static void addSnippetImages(long snippetId) throws Exception{
		String filename = "C://Users//harshit//Downloads//2323.jpg";
        FileInputStream f = new FileInputStream(new File(filename));

        byte[] imageData = new byte[f.available()];
        f.read(imageData);
        f.close();
        
		SnippetImages image=new SnippetImages();
		image.setImageId(snippetId);
		image.setImage(imageData);
		SnippetImagesDAO.addImage(image);
	}
}
