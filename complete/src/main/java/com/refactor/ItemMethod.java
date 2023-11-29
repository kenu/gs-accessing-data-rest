package com.refactor;

public class ItemMethod {
    Item item;
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    
    
    public void increaseQualityOne(Item item, int i) {
	item.quality = item.quality + 1;
    }

    public void decreaseRagnarosOne(Item item, int i) {
	if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
	    item.quality = item.quality - 1;
	}
    }

    public boolean qualityUnder50(Item item, int i) {
	return item.quality < 50;
    }

    public void decreaseQualityZero(Item item, int i) {
	item.quality = item.quality - item.quality;
    }

    public boolean isSulfuras(Item item) {
	return item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    public boolean isBackStage(Item item) {
	return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT);
    }

    public boolean isAgedBrie(Item item) {
	return item.name.equals(AGED_BRIE);
    }
}
