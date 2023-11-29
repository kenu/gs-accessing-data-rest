package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

	private Item[] items;

	public void updateQuality() {
		for (var i = 0; i < items.length; i++) {
			if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				decrementQuality(i);
			} else {
				incrementQuality(i);
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					decrementQuality(i);
				} else {
					incrementQuality(i);
				}
			}
		}
	}

	private void incrementQuality(int i) {
		if (items[i].quality < 50) {
			items[i].quality = items[i].quality + 1;
		}
	}

	private void decrementQuality(int i) {
		if (items[i].quality > 0) {
			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].quality = items[i].quality - 1;
			}
		}
	}
}

class Item {
	String name;
	int sellIn;
	int quality;
}