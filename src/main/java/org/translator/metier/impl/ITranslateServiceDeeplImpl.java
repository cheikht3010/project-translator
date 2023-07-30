package org.translator.metier.impl;

import org.apache.log4j.Logger;
import org.translator.metier.ITranslateService;
import org.translator.utils.TranslatorUtils;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;

public class ITranslateServiceDeeplImpl implements ITranslateService {

	private static final Logger LOGGER_ERR_TECH = Logger.getLogger("LOGGER_ERR_TECH");
	
	private static final String API_DEEPL_KEY_FILE = "api_deepl_key.txt"; 
	
	@Override
	public String translate(final String text, final String sourceLang, final String targetLang) {
	
	    String key = TranslatorUtils.getApiKey(API_DEEPL_KEY_FILE);
		    
	    if(!TranslatorUtils.formatTextValid(text) || !TranslatorUtils.formatApiKeyValid(key, API_DEEPL_KEY_FILE)) {
		return null;
	    }	
	
	    Translator translator = new Translator(key);
	    try {
		TextResult result = translator.translateText(text, sourceLang, targetLang);
		return result.getText();
	    } catch (DeepLException | InterruptedException e) {
		LOGGER_ERR_TECH.error("Erreur lors de traduction deepl.", e);
	    }
	    
	    return null;
	}

}
