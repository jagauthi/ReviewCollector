package joseph.review.collector.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import joseph.review.collector.service.ReviewCollectorService;

public class RestTemplate {

	private static final Logger LOGGER = Logger.getLogger(ReviewCollectorService.class.getName());

	/**
	 * Makes an HTTP Get call with the provided URL, and returns the object with the
	 * given class
	 * 
	 * @param url
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public <T> T sendGet(String url, Class<T> clazz) throws Exception {

		LOGGER.info("GET request received for url: " + url);
		T responseObject;

		URL urlConnection = null;
		HttpURLConnection conn = null;
		int responseCode = -1;
		try {
			urlConnection = new URL(url);
			conn = (HttpURLConnection) urlConnection.openConnection();
			conn.setRequestMethod("GET");
			responseCode = conn.getResponseCode();
		} catch (MalformedURLException e) {
			String errorMsg = "MalformedURLException in sendGet()";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		} catch (IOException e) {
			String errorMsg = "IOException in sendGet()";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		}

		if (HttpURLConnection.HTTP_OK == responseCode) {
			BufferedReader in = null;
			try {
				String inputLine;
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				Gson gson = new Gson();
				responseObject = gson.fromJson(response.toString(), clazz);
				return responseObject;
			} catch (IOException e) {
				String errorMsg = "IOException in parsing response()";
				LOGGER.log(Level.SEVERE, errorMsg, e);
				throw new Exception(errorMsg, e);
			}
			finally {
				in.close();
			}
		} else {
			String errorMsg = "Error, response code was not 200, it was: " + responseCode;
			LOGGER.log(Level.SEVERE, errorMsg);
			throw new Exception(errorMsg);
		}

	}
	
}
