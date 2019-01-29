/*******************************************************************************
 * Copyright (c) 2005, 2006 Los Alamos National Security, LLC.
 * This material was produced under U.S. Government contract DE-AC52-06NA25396
 * for Los Alamos National Laboratory (LANL), which is operated by the Los Alamos
 * National Security, LLC (LANS) for the U.S. Department of Energy. The U.S. Government has
 * rights to use, reproduce, and distribute this software. NEITHER THE
 * GOVERNMENT NOR LANS MAKES ANY WARRANTY, EXPRESS OR IMPLIED, OR
 * ASSUMES ANY LIABILITY FOR THE USE OF THIS SOFTWARE. If software is modified
 * to produce derivative works, such modified software should be clearly marked,
 * so as not to confuse it with the version available from LANL.
 *
 * Additionally, this program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package fortran.ofp.parser.java;

import java.io.*;
import java.util.Arrays;

public class FortranFileStream extends AbstractFortranStream implements IFortranStream
{
	protected String filepath;

	public FortranFileStream(String filename) throws IOException
	{
		this.name = filename;
		File file = new File(name);
		this.filepath = file.getAbsolutePath();
		this.sourceForm = determineSourceForm(name);

		loadFile(file);
	}

	public FortranFileStream(String filename, String path, int sourceForm) throws IOException
	{
		super();

		this.name = path+"/"+filename;
		File file = new File(name);
		this.filepath = path;
		this.sourceForm = sourceForm;
		
		loadFile(file);
	}

	protected void loadFile(File file) throws IOException {
		data = readFile(file, null);
		this.n = data.length;

		convertInputBuffer();
	}

	public String getFileName() {
		return name;
	}

	public String getAbsolutePath() {
		return filepath;
	}

	/**
	 * Copied from ANTLR Utils.readFile
	 */
	public static char[] readFile(File file, String encoding) throws IOException {
		int size = (int)file.length();
		InputStreamReader isr;
		FileInputStream fis = new FileInputStream(file);
		if ( encoding!=null ) {
			isr = new InputStreamReader(fis, encoding);
		}
		else {
			isr = new InputStreamReader(fis);
		}
		char[] data = null;
		try {
			data = new char[size];
			int n = isr.read(data);
			if (n < data.length) {
				data = Arrays.copyOf(data, n);
			}
		}
		finally {
			isr.close();
		}
		return data;
	}

} // end class FortranStream
