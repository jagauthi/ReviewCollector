package joseph.review.collector.dto;

import java.util.Arrays;

public class ItemInfo {
	
	int itemId;
	int parentItemId;
	int numReviews;
	
	int[] variants;
	
	double msrp;
	double salePrice;
	double standardShipRate;
	
	String name, upc, categoryPath, shortDescription, brandName, thumbnailImage, mediumImage;

	String largeImage;
	String productTrackingUrl;
	String size;
	String color;
	String modelNumber;
	String productUrl;
	String customerRating;
	String customerRatingImage;
	String categoryNode;
	String rhid;
	String stock;
	String gender;
	String addToCartUrl;
	String affiliateAddToCartUrl;
	String offerType;
	
	boolean ninetySevenCentShipping;
	boolean marketplace;
	boolean shipToStore;
	boolean freeShipToStore;
	boolean bundle;
	boolean clearance;
	boolean preOrder;
	
	boolean freeShippingOver35Dollars;
	boolean isTwoDayShippingEligible;
	boolean availableOnline;
	
	Attribute attributes;
	GiftOption giftOptions;
	ImageEntity[] imageEntities;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getCustomerRating() {
		return customerRating;
	}
	public void setCustomerRating(String customerRating) {
		this.customerRating = customerRating;
	}
	
	@Override
	public String toString() {
		return "ItemInfo [itemId=" + itemId + ", parentItemId=" + parentItemId + ", numReviews=" + numReviews
				+ ", variants=" + Arrays.toString(variants) + ", msrp=" + msrp + ", salePrice=" + salePrice
				+ ", standardShipRate=" + standardShipRate + ", name=" + name + ", upc=" + upc + ", categoryPath="
				+ categoryPath + ", shortDescription=" + shortDescription + ", brandName=" + brandName
				+ ", thumbnailImage=" + thumbnailImage + ", mediumImage=" + mediumImage + ", largeImage=" + largeImage
				+ ", productTrackingUrl=" + productTrackingUrl + ", size=" + size + ", color=" + color
				+ ", modelNumber=" + modelNumber + ", productUrl=" + productUrl + ", customerRating=" + customerRating
				+ ", customerRatingImage=" + customerRatingImage + ", categoryNode=" + categoryNode + ", rhid=" + rhid
				+ ", stock=" + stock + ", gender=" + gender + ", addToCartUrl=" + addToCartUrl
				+ ", affiliateAddToCartUrl=" + affiliateAddToCartUrl + ", offerType=" + offerType
				+ ", ninetySevenCentShipping=" + ninetySevenCentShipping + ", marketplace=" + marketplace
				+ ", shipToStore=" + shipToStore + ", freeShipToStore=" + freeShipToStore + ", bundle=" + bundle
				+ ", clearance=" + clearance + ", preOrder=" + preOrder + ", freeShippingOver35Dollars="
				+ freeShippingOver35Dollars + ", isTwoDayShippingEligible=" + isTwoDayShippingEligible
				+ ", availableOnline=" + availableOnline + ", attributes=" + attributes + ", giftOptions=" + giftOptions
				+ ", imageEntities=" + Arrays.toString(imageEntities) + "]";
	}
	
}
