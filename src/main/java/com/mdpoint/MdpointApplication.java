package com.mdpoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextException;

import com.mdpoint.data.PresentationViewData;

@SpringBootApplication
public class MdpointApplication {

	private static final String DEFUALT_SEPARATOR = "---";
	
	private static final int MAX_ARG_SIZE = 2;
	
	private static PresentationViewData PRESEN_DATA;
	
    /**
     * アプリケーション開始メインメソッド
     * @param args
     * @throws IOException 
     * 
     */
    public static void main(String[] args) throws IOException {
    	
    	validate(args);
    	initPresentationData(args);
    	
    	SpringApplication.run(MdpointApplication.class);
        
    }

	public static PresentationViewData getPresenData() {
		return PRESEN_DATA;
	}

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

	private static void initPresentationData(String[] args) throws IOException {
		
		PresentationViewData presentation = new PresentationViewData();
		presentation.setMarkdown(readMarkdownFile(args[0]));
		presentation.setSeparator(DEFUALT_SEPARATOR);

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
		
		StringBuilder sb = new StringBuilder();
		try(Stream<String> a = Files.lines(markdown.toPath())) {
			a.forEach(str -> sb.append(str).append("\n"));
		}

		return sb.toString();
	}

}
