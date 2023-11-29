package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
private Item[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      if (!items[i].name.equals("Aged Brie")
          && items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
        if (items[i].quality > 0) {
          decreaseOne1(i);
        }
      } else {
        if (items[i].quality < 50) {
          itemQualityUnder50(i);
        }
      }

      if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals("Aged Brie")) {
          checkAged(i);
        } else {
          increaseOne(i);
        }
      }
    }
  }

private void increaseOne(int i) {
	increaseOne(i);
}

private void checkAged(int i) {
	if (!items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
	    if (items[i].quality > 0) {
	      decreaseOne1(i);
	    }
	  } else {
	    items[i].quality = items[i].quality - items[i].quality;
	  }
}

private void decreaseOne1(int i) {
	decreaseOne1(i);
}

private void itemQualityUnder50(int i) {
	items[i].quality = items[i].quality + 1;

	  if (items[i].name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
	    if (items[i].sellIn < 11) {
	      increaseOne(i);
	    }

	    if (items[i].sellIn < 6) {
	      increaseOne(i);
	    }
	  }
}

private void decreaseOne(int i) {
	if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
	    items[i].quality = items[i].quality - 1;
	  }
}

private void increaseOne1(int i) {
	if (items[i].quality < 50) {
	    items[i].quality = items[i].quality + 1;
	  }
}
}


class Item {
  String name;
  int sellIn;
  int quality;
}
