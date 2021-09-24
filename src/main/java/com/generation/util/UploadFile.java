package com.generation.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



public class UploadFile{

	public static String upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part filePart = request.getPart("file");
		
		if(filePart.getSubmittedFileName().endsWith(".jpg") || filePart.getSubmittedFileName().endsWith(".png")){

		    InputStream fileInputStream = filePart.getInputStream();
		    File fileToSave = new File("C:\\Users\\scart\\eclipse-workspace\\Blog\\img\\" + filePart.getSubmittedFileName());
			Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			String fileUrl = "http://localhost:8080/img/" + filePart.getSubmittedFileName();			
			return fileUrl;
		}
		return "";

	}
}
