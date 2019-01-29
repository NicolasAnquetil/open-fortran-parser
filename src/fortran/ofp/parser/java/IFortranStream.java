package fortran.ofp.parser.java;

import org.antlr.runtime.CharStream;

public interface IFortranStream extends CharStream {

	int determineSourceForm(String fileName); // end determineSourceForm()

	int getSourceForm();

	String getFileName();
	String getAbsolutePath();

	/**
	    * Convert characters to upper case.  This is only for look ahead
	    * used in building tokens, in particular key words, the actually
	    * character buffer is unchanged so id tokens have original case. 
	    */
	int LA(int i); // end LA()

}