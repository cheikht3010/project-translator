package org.translator.metier.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ITranslateServiceGoogleImplTest {

	private static final String BONJOUR = "Bonjour";
	
	private static final String HELLO = "Hello";
	
	private static final String EN = "en";
	
	private static final String FR = "fr";
	
	@Test
	public void testTextInferieurALimit() {
	    ITranslateServiceGoogleImpl impl = new ITranslateServiceGoogleImpl();
	    String traduction = impl.translate(HELLO, EN, FR);
	    Assert.assertEquals(traduction, BONJOUR);
	}
	
	@Test
	public void testTextSuperieurALimit() {
	    ITranslateServiceGoogleImpl impl = new ITranslateServiceGoogleImpl();
	    String text = genererTextSuperieurALimit();
	    String traduction = impl.translate(text, "en", "fr");
	    Assert.assertNull(traduction);
	}
	
	private String genererTextSuperieurALimit() {
	   String str = "";
	   for(int i = 0; i < 1700; i++) {
	       str += HELLO + " ";
	   }
	   return str;
	}

}
