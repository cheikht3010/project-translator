package org.translator.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public final class TranslatorUtils {
	
    private static final Logger LOGGER_ERR_TECH = Logger.getLogger("LOGGER_ERR_TECH");
	
    private TranslatorUtils() {
        super();
    }

    /**
     * Méthode qui vérifie si un texte donné n'est pas nul et ne dépasse pas 10000 caractères.
     * 
     * @param text
     * @return
     */
    public static boolean formatTextValid(final String text) {
	    if(text == null || text.length() > 10000) {
	      	Exception exception = new Exception("Le texte est null ou trop long (10000) !");
	      	LOGGER_ERR_TECH.error("Format texte incorrect", exception);
	      	return false;
	    }
	    return true;
    }
    
    /**
     * Méthode qui vérifie qu'une clé API donnée n'est pas nulle ou vide.
     * 
     * @param key
     * @param fileName
     * @return
     */
    public static boolean formatApiKeyValid(final String key, final String fileName) {
	    if(key == null || key.isEmpty()) {
		Exception exception = new Exception("Clé API vide");
		LOGGER_ERR_TECH.error("La clé API est absente du fichier " + fileName, exception);
		return false;
	    }
	    return true;
    }
    
    /**
     * Methode qui permet de récupérer la clé API depuis un fichier.
     * 
     * @param fileName le nom du fichier
     * @return
     */
    public static String getApiKey(final String fileName) {
	   try {
	       InputStream is = TranslatorUtils.class.getClassLoader().getResourceAsStream(fileName);
	       InputStreamReader isr = new InputStreamReader(is);
	       BufferedReader reader = new BufferedReader(isr);
	       String line = reader.readLine();
	       reader.close();
	       return line;
	   } catch (IOException e) {
	       LOGGER_ERR_TECH.error("Erreur lecture fichier Clé API.", e);
	       return null;
	   }
    }
}
