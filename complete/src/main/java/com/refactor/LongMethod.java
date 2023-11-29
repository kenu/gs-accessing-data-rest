package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
private Item[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      Item item = items[i];
	boolean isAgedBrie = item.name.equals("Aged Brie");
	boolean isBackstage = item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT);
	boolean isSulfuras = item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
	if (!isAgedBrie
          && isBackstage) {
        if (item.quality > 0) {
          decreaseOne(item, isSulfuras);
        }
      } else {
        if (item.quality < 50) {
          itemQualityUnder50(item, isBackstage);
        }
      }

      if (!isSulfuras) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (!isAgedBrie) {
          checkWhenNotAgedBrie(item, isBackstage, isSulfuras);
        } else {
          increaseOne(item);
        }
      }
    }
  }

private void increaseOne(Item item) {
	if (item.quality < 50) {
	    item.quality = item.quality + 1;
	  }
}

private void checkWhenNotAgedBrie(Item item, boolean isBackstage, boolean isSulfuras) {
	if (!isBackstage) {
	    if (item.quality > 0) {
	      decreaseOne(item, isSulfuras);
	    }
	  } else {
	    item.quality = item.quality - item.quality;
	  }
}

private void decreaseOne(Item item, boolean isSulfuras) {
	if (!isSulfuras) {
	    item.quality = item.quality - 1;
	  }
}

private void itemQualityUnder50(Item item, boolean isBackstage) {
	item.quality = item.quality + 1;

	  if (isBackstage) {
	    if (item.sellIn < 11) {
	      increaseOne(item);
	    }

	    if (item.sellIn < 6) {
	      increaseOne(item);
	    }
	  }
}
}


class Item {
  String name;
  int sellIn;
  int quality;
}
