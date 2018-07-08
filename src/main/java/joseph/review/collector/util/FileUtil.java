package joseph.review.collector.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import joseph.review.collector.service.ReviewCollectorService;

public class FileUtil {
	
	private static final Logger LOGGER = Logger.getLogger(FileUtil.class.getName());

	public BufferedReader readTextFile(String fileName) throws Exception {

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			return bufferedReader;
		} catch (FileNotFoundException e) {
			String errorMsg = "FileNotFoundException when trying to read file " + fileName;
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		}
	}
	
	public List<String> parseStringList(String fileName) throws Exception {
		List<String> response = new ArrayList<String>();		
		BufferedReader bufferedReader;
		bufferedReader = readTextFile(fileName);
		String line = "";
		try {
			
			while ( null != (line = bufferedReader.readLine()) ) {
				response.add(line.trim());
			}
			
			bufferedReader.close();
		} catch (IOException e) {
			String errorMsg = "IOException when trying parse through " + fileName;
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		}

		return response;
	}

}
