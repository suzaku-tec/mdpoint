package com.mdpoint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextException;

import com.mdpoint.data.PresentationViewData;

@SpringBootApplication
public class MdpointApplication {

	/**
	 * default separator string
	 */
	private static final String DEFAULT_SEPARATOR = "---";
	
	/**
	 * count of max parameter 
	 */
	private static final int MAX_ARG_SIZE = 2;
	
	/**
	 * presentation data of this application
	 */
	private static PresentationViewData PRESEN_DATA;
	
    /**
     * application start main method
     * @param args application parameter
     * @throws IOException markdown file read error
     * 
     */
    public static void main(String[] args) throws IOException {
    	
    	// application initialization
    	validate(args);
    	initPresentationData(args);
    	
    	// server run
    	SpringApplication.run(MdpointApplication.class);
        
    }

	/**
	 * presentation data getter
	 * @return
	 */
	public static PresentationViewData getPresenData() {
		return PRESEN_DATA;
	}

	/**
	 * application parameter validate method
	 * this method check the following contents
	 * ・the existence check parameters
	 * ・the maximum check parameters
	 * ・exists check of markdown file
	 * 
	 * @param args application parameter
	 * @throws FileNotFoundException
	 */
	private static void validate(String[] args) throws FileNotFoundException {
		
		if(args.length == 0) {
			throw new ApplicationContextException("Because there are no arguments, you can not the application is running");
		}
	
		if(MAX_ARG_SIZE < args.length) {
			throw new ApplicationContextException("Too many arguments. 1:markdownPath 2:html lang 3:markdown page separator");
		}
	
		if(!(new File(args[0]).exists())) {
			throw new FileNotFoundException();
		}
	}

	/**
	 * presentation data initialization
	 * 
	 * @param args application parameter
	 * @throws IOException
	 */
	private static void initPresentationData(String[] args) throws IOException {
		
		// create presentation data
		PresentationViewData presentation = new PresentationViewData();
		presentation.setMarkdown(readMarkdownFile(args[0]));
		presentation.setSeparator(DEFAULT_SEPARATOR);

		// The separator is set when I is designated
		if(2 <= args.length) {
			presentation.setSeparator(args[1]);
		}

		PRESEN_DATA = presentation;
	}

	/**
	 * read markdown Files.
	 * It reads the contents of the specified markdown files, and returns a string.
	 * 
	 * @param markdownPath markdown file path
	 * @return The contents of Markdown files
	 * @throws IOException
	 */
	private static String readMarkdownFile(String markdownPath) throws IOException {
		
		File markdown = new File(markdownPath);
		
		// returns a string reads the file
		StringBuilder sb = new StringBuilder();
		try(Stream<String> a = Files.lines(markdown.toPath())) {
			// windows OS newline do not know! 
			a.forEach(str -> sb.append(str).append("\n"));
		}

		return sb.toString();
	}

}
