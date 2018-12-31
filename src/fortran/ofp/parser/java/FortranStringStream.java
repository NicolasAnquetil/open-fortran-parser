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

public class FortranStringStream extends AbstractFortranStream implements IFortranStream
{
	protected String filepath;

	public FortranStringStream(String content)
	{
		this(content, AbstractFortranStream.FREE_FORM);
	}

	public FortranStringStream(String fortranSource, int type) {
		super(fortranSource);
		this.sourceForm = type;
		filepath = "<unknown>";
	}

	@Override
	public String getFileName() {
		return super.getSourceName();
	}

	@Override
	public String getAbsolutePath() {
		return filepath;
	}

	// provide a way to set fake "file identity" to the stream

	public void setFileName(String name) {
		super.name = name;
	}

	public void setAbsolutePath(String path) {
		filepath = path;
	}
	
} // end class FortranStream
