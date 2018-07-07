package joseph.review.collector;

import java.util.logging.Level;
import java.util.logging.Logger;

import joseph.review.collector.dto.ItemInfo;
import joseph.review.collector.dto.ItemResponse;
import joseph.review.collector.service.ReviewCollectorService;

public class App {

	private static final Logger LOGGER = Logger.getLogger( ReviewCollectorService.class.getName() );
	
	private ReviewCollectorService reviewCollectorService;

	public static void main(String[] args) throws Exception  {
		new App();
	}
	
	public App() throws Exception {
		
		LOGGER.log(Level.INFO, "Starting to collect reviews.");
		
		reviewCollectorService = new ReviewCollectorService();
		
		ItemResponse itemInfo = reviewCollectorService.collectReviews();
		
		printInfo(itemInfo);
	}
	
	private void printInfo(ItemResponse itemInfo) {
		for(ItemInfo info : itemInfo.getItems()) {
			LOGGER.log(Level.INFO, "Item name: " + info.getName());
			LOGGER.log(Level.INFO, "Review: " + info.getCustomerRating());
		}
	}

}