package joseph.review.collector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import joseph.review.collector.dto.ItemInfo;
import joseph.review.collector.dto.ItemResponse;
import joseph.review.collector.service.ReviewCollectorService;
import joseph.review.collector.util.ExcelUtil;
import joseph.review.collector.util.FileUtil;

public class App {

	private static final Logger LOGGER = Logger.getLogger( ReviewCollectorService.class.getName() );

	private static final String UPC_FILE_PATH = "src\\main\\resources\\upcNumbers";
	
	private ReviewCollectorService reviewCollectorService;
	private FileUtil fileUtil;
	private ExcelUtil excelUtil;

	public static void main(String[] args) throws Exception  {
		new App();
	}
	
	/**
	 * Sets up the reviewCollectorService and passes in the list of UPC numbers
	 * which we will try to look up the information
	 * 
	 * @throws Exception
	 */
	public App() throws Exception {
		
		LOGGER.log(Level.INFO, "Starting to collect reviews.");
		init();
		
		List<String> upcNumbers = fileUtil.parseStringList(UPC_FILE_PATH);
		
		List<ItemResponse> itemInfo = reviewCollectorService.collectMultipleReviews(upcNumbers);
		
		String[] columns = {"Name", "Review"};
		excelUtil.writeToExcel(columns, itemInfo);
		//printInfo(itemInfo);
	}
	
	private void init() {
		reviewCollectorService = new ReviewCollectorService();
		fileUtil = new FileUtil();
		excelUtil = new ExcelUtil();
	}
	
	private void printInfo(List<ItemResponse> itemInfos) {
		int count = 0;
		for(ItemResponse itemInfo : itemInfos) {
			for(ItemInfo info : itemInfo.getItems()) {
				count++;
				LOGGER.log(Level.INFO, "Item #" + count + "): ");
				LOGGER.log(Level.INFO, "Item name: " + info.getName());
				LOGGER.log(Level.INFO, "Review: " + info.getCustomerRating());
			}
		}
	}
	
	

}