package com.mdpoint.data;

/**
 * presentaion data object
 * 
 * @author suzaku380
 *
 */
public class PresentationViewData {

	/**
	 * markdown file content
	 */
	private String markdown;
	
	/**
	 * markdown file page separator
	 */
	private String separator;

	public String getMarkdown() {
		return markdown;
	}

	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
