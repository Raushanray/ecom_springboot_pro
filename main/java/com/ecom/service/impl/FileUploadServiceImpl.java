package com.ecom.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {

		//get original name of file
		//abc.png
		//sfdsgsag.png
		
		String originalFilename = file.getOriginalFilename();
		
		//generate new name product image
		String randomNameId = UUID.randomUUID().toString();

		String randomNameWithExtension = randomNameId.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));
		String fullPath = path + File.separator + randomNameWithExtension;
		
		File folderFile = new File(path);
		
		if(!folderFile.exists()) {
			folderFile.mkdirs();
		}
		Files.copy(file.getInputStream(), Paths.get(fullPath));
		
		return randomNameWithExtension;
	}

	@Override
	public InputStream getResource(String path) throws FileNotFoundException {

		InputStream is = new FileInputStream(path);
		return is;
	}

	@Override
	public void deleteFile(String path) {

		
	}

}
