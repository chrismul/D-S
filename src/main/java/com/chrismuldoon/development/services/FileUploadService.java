package com.chrismuldoon.development.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/file")
public class FileUploadService {
	
	/**
	 * Upload the user's selected file to the server and return the file location and
	 * success message. File gets renamed with date and time
	 * 
	 * @param input file details from upload form input on the html page
	 * @return Rest response
	 * @throws IOException
	 */
	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) throws IOException {

		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		
		List<InputPart> inputParts = uploadForm.get("uploadFile");

		for (InputPart inputPart : inputParts) {
			try {
				MultivaluedMap<String, String> header = inputPart.getHeaders();
				String fileName = getFileName(header);
				
				if(fileName.contains(".xls")){
					InputStream inputStream = inputPart.getBody(InputStream.class, null);
					
					byte[] bytes = IOUtils.toByteArray(inputStream);
					
					Date now = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat();
					dateFormat = new SimpleDateFormat("dd-MM-yyyy hh.mm.ss");
					
					writeFile(bytes, fileName.replace(".xls", " " + dateFormat.format(now) + ".xls"));
					
					java.net.URI location = new java.net.URI("http://localhost:8080/CallFailureEnterprise/admin/uploadComplete.html");
					
					return Response.temporaryRedirect(location).build();
				}
				else{
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Get filename from uploaded file
	 * 
	 * @param header
	 * @return filename
	 */
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	/**
	 * Write file being uploaded to the server directory
	 * Conversion of the xls file sheets to json files is then run by the FolderWatcher
	 * 
	 * @param content the content of the file to be uploaded and written
	 * @param filename name of the uploaded file
	 * @throws IOException
	 */
	private void writeFile(byte[] content, String filename) throws IOException {
		File file = new File("C:/Users/D15122952/Desktop/datasets/" + filename);
		if (!file.exists()) {
			System.out.println("Creating file " + file.getAbsolutePath());
			file.createNewFile();
		}
		FileOutputStream fileOutput = new FileOutputStream(file);
		fileOutput.write(content);
		fileOutput.flush();
		fileOutput.close();
	}
	
}
