package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT =
      "Backstage passes to a TAFKAL80ETC concert";
  private static final int maxQuality = 50;
  private Item[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      Item item = items[i];
      boolean isAgedBrie = item.name.equals("Aged Brie");
      boolean isBackStage = item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT);
      boolean isSulfuras = item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
      if (item.quality < maxQuality) {
        item.quality = item.quality + 1;

        if (isBackStage) {
          if (!isAgedBrie && item.quality > 0) {
            decrementOne(i);
          }

          if (item.sellIn < 11) {
            incrementOne(i);
          }

          if (item.sellIn < 6) {
            incrementOne(i);
          }
        }
      }

      if (!isSulfuras) {
        item.sellIn = item.sellIn - 1;
      }

      if (item.sellIn < 0) {
        if (!isAgedBrie) {
          if (!isBackStage) {
            if (item.quality > 0) {
              decrementOne(i);
            }
          } else {
            item.quality = item.quality - item.quality;
          }
        } else {
          incrementOne(i);
        }
      }
    }

  }

  private void decrementOne(int i) {
    if (!items[i].name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
      items[i].quality = items[i].quality - 1;
    }
  }

  private void incrementOne(int i) {
    if (items[i].quality < maxQuality) {
      items[i].quality = items[i].quality + 1;
    }
  }
}


class Item {
  String name;
  int sellIn;
  int quality;
}
