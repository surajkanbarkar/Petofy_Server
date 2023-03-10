package com.petofy.Services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
	public void init();
	
	public void save(MultipartFile file, String dirName);
	
	public Resource load(String dirName, String filename);
	
	public boolean delete(String dirName, String filename);
	
	public void deleteAll();
	
	public Stream<Path> loadAll();
}
