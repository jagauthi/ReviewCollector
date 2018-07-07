package joseph.review.collector.dto;

import java.util.Arrays;

public class ItemResponse {
	
	private ItemInfo[] items;

	public ItemInfo[] getItems() {
		return items;
	}

	public void setItems(ItemInfo[] items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ItemResponse [items=" + Arrays.toString(items) + "]";
	}

}
