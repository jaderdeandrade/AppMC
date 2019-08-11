package com.jda.appmc.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;



@Component
public class LocalService {



	@Value("${contato.disco.raiz}")
	private String raiz;

	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;

	public void uploadFile(MultipartFile multipartFile) {
		this.uploadFile(this.diretorioFotos, multipartFile);
	}

	public void uploadFile(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
	}

}
