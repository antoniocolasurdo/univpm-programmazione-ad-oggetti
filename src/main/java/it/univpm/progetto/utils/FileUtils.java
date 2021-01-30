package it.univpm.progetto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {

    /**
    * Logger utilizzato per visualizzare e memorizzare i messaggi di sistema dell'applicazione e per intercettare i messaggi generati dalle eccezioni
    */
	private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

	/**
    * Funzione di verifica se il file contenente gli eventi di Ticket Master esiste o meno
    */
    public static boolean fileExist() {
    	File file = new File(Costanti.RESOURCE_PATH + Costanti.RESOURCE_FILENAME);
    	
    	return file.exists();
    }
    
    /**
    * Funzione di salvataggio del file all'interno della struttura del progetto
    */
	public static byte[] loadFile() throws MalformedURLException, IOException {
		File file = new File(Costanti.RESOURCE_PATH + Costanti.RESOURCE_FILENAME);
		byte[] contentBytes = null;

		InputStream in = new FileInputStream(file);
		try {
			contentBytes = in.readAllBytes();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
		    in.close();
		}
		
		return contentBytes;
	}

	/**
    * Funzione di salvataggio del file all'interno della struttura del progetto
    */
	public static String saveFile(byte[] bytes) throws MalformedURLException, IOException {
		File file = new File(Costanti.RESOURCE_PATH + Costanti.RESOURCE_FILENAME);
		    
		OutputStream out = new FileOutputStream(file);
		try {
		    out.write(bytes);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
		    out.close();
		}
		
		return file.getName();
	}
}