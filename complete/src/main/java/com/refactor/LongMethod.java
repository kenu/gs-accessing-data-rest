package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

	private Item[] items;

	public void updateQuality() {
		ItemMethod itemMethod = new ItemMethod();
		
		for (var i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (items[i].quality > 0) {
					itemMethod.decreaseRagnarosOne(items[i],i);
				}
			} else {
				if (itemMethod.qualityUnder50(items[i], i)) {
					itemMethod.increaseQualityOne(items[i],i);

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							if (itemMethod.qualityUnder50(items[i], i)) {
								itemMethod.increaseQualityOne(items[i],i);
							}
						}

						if (items[i].sellIn < 6) {
							if (itemMethod.qualityUnder50(items[i], i)) {
								itemMethod.increaseQualityOne(items[i],i);
							}
						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							itemMethod.decreaseRagnarosOne(items[i],i);
						}
					} else {
						itemMethod.decreaseQualityZero(items[i], i);
					}
				} else {
					if (itemMethod.qualityUnder50(items[i], i)) {
						itemMethod.increaseQualityOne(items[i],i);
					}
				}
			}
		}
	}

}