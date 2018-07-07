package joseph.review.collector.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import joseph.review.collector.dto.ItemResponse;
import joseph.review.collector.util.RestTemplate;

public class ReviewCollectorService {

	private static String url1 = "http://api.walmartlabs.com/v1/items?apiKey=ct9fe8358fa33q6w84vp9v73&upc=035000521019";
	
	private static final Logger LOGGER = Logger.getLogger( ReviewCollectorService.class.getName() );
	
	public ItemResponse collectReviews() throws Exception {

		ItemResponse itemResponse = new ItemResponse();
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			itemResponse = restTemplate.sendGet(url1, ItemResponse.class);
		} catch (Exception e) {
			String errorMsg = "Error getting itemRespose";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw e;
		}
		
		return itemResponse;
	}

}
