package org.translator.main;

import org.translator.metier.impl.ITranslateServiceDeeplImpl;
import org.translator.metier.impl.ITranslateServiceGoogleImpl;

public class Main {
	
  public static void main(String[] args) {
	  
    String text = "Hello";
    String sourceLang = "en";
    String targetLang = "fr";
    
    ITranslateServiceGoogleImpl iTranslateServiceGoogleImpl = new ITranslateServiceGoogleImpl();
    String traductionGoogle = iTranslateServiceGoogleImpl.translate(text, sourceLang, "fr");
    
    ITranslateServiceDeeplImpl iTranslateServiceDeeplImpl = new ITranslateServiceDeeplImpl();
    String traductionDeepl = iTranslateServiceDeeplImpl.translate(text, sourceLang, "fr");
    
    System.out.println("Traduction Google : " + traductionGoogle);
    System.out.println("Traduction Deepl : " + traductionDeepl);
    
  }

}
