package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/
public class LongMethod {

  private Item[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      Item item = items[i];
      boolean BackstagePass = item.name.equals("Backstage passes to a TAFKAL80ETC concert");
      boolean NameIsAgedBrie = item.name.equals("Aged Brie");
      boolean isSulfuras = !item.name.equals("Sulfuras, Hand of Ragnaros");

      if (!NameIsAgedBrie && BackstagePass && item.quality > 0) {
        decrementOne(i);
      } else {
        if (item.quality < 50) {
          item.quality += 1;
        }
        if (BackstagePass && (item.sellIn < 11 || item.sellIn < 6)) {
          incrementOne(i);
        }
      }

      if (isSulfuras) {
        item.sellIn -= 1;
      }

      if (item.sellIn < 0) {
        if (!NameIsAgedBrie) {
          checkWhenNotAgedBrie(i, BackstagePass);
        } else {
          incrementOne(i);
        }
      }
    }
  }

  private void checkWhenNotAgedBrie(int i, boolean BackstagePass) {
    if (!BackstagePass && items[i].quality > 0) {
      decrementOne(i);
    } else {
      items[i].quality = 0;
    }
  }

  private void decrementOne(int i) {
    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      items[i].quality -= -1;
    }
  }

  private void incrementOne(int i) {
    if (items[i].quality < 50) {
      items[i].quality += 1;
    }
  }
}


class Item {
  String name;
  int sellIn;
  int quality;
}
