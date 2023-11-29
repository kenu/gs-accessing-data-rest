package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

    private Item[] items;

    public void updateQuality() {
	ItemMethod itemMethod = new ItemMethod();

	for (var i = 0; i < items.length; i++) {
	    Item item = items[i];
	    if (!itemMethod.isAgedBrie(item)
		    && itemMethod.isBackStage(item)) {
		if (item.quality > 0) {
		    itemMethod.decreaseRagnarosOne(item, i);
		}
	    } else {
		if (itemMethod.qualityUnder50(item, i)) {
		    itemMethod.increaseQualityOne(item, i);

		    if (itemMethod.isBackStage(item)) {
			if (item.sellIn < 11) {
			    if (itemMethod.qualityUnder50(item, i)) {
				itemMethod.increaseQualityOne(item, i);
			    }
			}

			if (item.sellIn < 6) {
			    if (itemMethod.qualityUnder50(item, i)) {
				itemMethod.increaseQualityOne(item, i);
			    }
			}
		    }
		}
	    }

	    if (!itemMethod.isSulfuras(item)) {
		item.sellIn = item.sellIn - 1;
	    }

	    if (item.sellIn < 0) {
		if (!itemMethod.isAgedBrie(item)) {
		    if (!itemMethod.isBackStage(item)) {
			if (item.quality > 0) {
			    itemMethod.decreaseRagnarosOne(item, i);
			}
		    } else {
			itemMethod.decreaseQualityZero(item, i);
		    }
		} else {
		    if (itemMethod.qualityUnder50(item, i)) {
			itemMethod.increaseQualityOne(item, i);
		    }
		}
	    }
	}
    }

}