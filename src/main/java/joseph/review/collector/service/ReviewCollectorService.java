package joseph.review.collector.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import joseph.review.collector.dto.ItemResponse;
import joseph.review.collector.util.RestTemplate;

public class ReviewCollectorService {

	private static String url1 = "http://api.walmartlabs.com/v1/items?apiKey=ct9fe8358fa33q6w84vp9v73&upc=035000521019";
	private static String baseUrl = "http://api.walmartlabs.com/v1/items?apiKey=ct9fe8358fa33q6w84vp9v73&upc=";
	
	private static final Logger LOGGER = Logger.getLogger( ReviewCollectorService.class.getName() );
	
	public List<ItemResponse> collectMultipleReviews(List<String> upcNumbers) throws Exception {

		List<ItemResponse> itemResponseList = new ArrayList<ItemResponse>();
		try {
			for(String upcNumber : upcNumbers) {
				ItemResponse itemResponse = collectReviews(upcNumber);
				itemResponseList.add(itemResponse);
			}
		}
		catch(Exception e) {
			String errorMsg = "Error getting responses for all the items: " + upcNumbers;
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw e;
		}
		return itemResponseList;
	}
	
	public ItemResponse collectReviews(String upcNumber) throws Exception {

		ItemResponse itemResponse = new ItemResponse();
		RestTemplate restTemplate = new RestTemplate();
		
		String url = baseUrl + upcNumber;
		
		try {
			itemResponse = restTemplate.sendGet(url, ItemResponse.class);
		} catch (Exception e) {
			String errorMsg = "Error getting itemRespose";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw e;
		}
		
		return itemResponse;
	}

}
