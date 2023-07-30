package org.translator.metier.impl;

import org.translator.metier.ITranslateService;
import org.translator.utils.TranslatorUtils;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class ITranslateServiceGoogleImpl implements ITranslateService {
	
	private static final String API_GOOGLE_KEY_FILE = "api_google_key.txt"; 
	
	@Override
	public String translate(final String text, final String sourceLang, final String targetLang) {

	    String key = TranslatorUtils.getApiKey(API_GOOGLE_KEY_FILE);
	    
	    if(!TranslatorUtils.formatTextValid(text) || !TranslatorUtils.formatApiKeyValid(key, API_GOOGLE_KEY_FILE)) {
	      	return null;
	    }
	    
	    // Possibilité d'utiliser des crédentitials si fichier json à disposition (setApiKey deprecated)
	    Translate translate = TranslateOptions.newBuilder().setApiKey(key).build().getService();
	    Translation translation = translate.translate(text, 
		    TranslateOption.sourceLanguage(sourceLang),
		    TranslateOption.targetLanguage(targetLang));
	    return translation.getTranslatedText();
	}

}
