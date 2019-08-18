package com.jda.appmc.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.jda.appmc.services.exceptions.FileException;

@Component
public class LocalService {

	private Logger LOG = LoggerFactory.getLogger(LocalService.class);

	@Value("${contato.disco.raiz}")
	private String raiz;

	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;


	public URI uploadFile(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFile(is, fileName, contentType,multipartFile);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}

	public URI uploadFile(InputStream is, String fileName, String contentType, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz);
		Path arquivoPath = diretorioPath.resolve(fileName);
		try {
			LOG.info("Iniciando upload");
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			LOG.info("Upload finalizado");
			return arquivoPath.toUri();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
