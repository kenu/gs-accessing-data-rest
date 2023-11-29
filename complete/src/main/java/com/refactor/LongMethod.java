package com.refactor;

// code from: https://makolyte.com/refactoring-the-long-method-code-smell/

public class LongMethod {

  private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT =
      "Backstage passes to a TAFKAL80ETC concert";
  private static final String AGED_BRIE = "Aged Brie";
  private ItemData[] items;

  public void updateQuality() {
    for (var i = 0; i < items.length; i++) {
      ItemData item = items[i];

      boolean isAgedBrie = item.getName().equals(AGED_BRIE);
      boolean isBackStage = item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT);
      boolean isSulFuras = item.getName().equals(SULFURAS_HAND_OF_RAGNAROS);
      boolean qualityUnder50 = isQualityUnder50(item);
      
      if (!isAgedBrie && isBackStage) {
        if (item.getQuality() > 0) {
          decreseQualityOne(i);
        }
      } else {
        if (qualityUnder50) {
          itemQualityUnder50(i, item, isBackStage);
        }
      }

      if (!isSulFuras) {
        decreaseSellInOne(i);
      }

      if (item.getSellIn() < 0) {
        if (!isAgedBrie) {
          isNotAgedBrie(i, item, isBackStage);
        } else {
          if (qualityUnder50) {
            increaseQualityOne(i);
          }
        }
      }
    }
  }

  private boolean isQualityUnder50(ItemData item) {
    return item.getQuality() < 50;
  }

  private void isNotAgedBrie(int i, ItemData item, boolean isBackStage) {
    if (!isBackStage) {
      if (item.getQuality() > 0) {
        decreseQualityOne(i);
      }
    } else {
      item.setQuality(item.getQuality() - item.getQuality());
    }
  }

  private void itemQualityUnder50(int i, ItemData item, boolean isBackStage) {
    increaseQualityOne(i);

    boolean qualityUnder50 = isQualityUnder50(item);
    
    if (isBackStage) {
      if (item.getSellIn() < 11) {
        if (qualityUnder50) {
          increaseQualityOne(i);
        }
      }

      if (item.getSellIn() < 6) {
        if (qualityUnder50) {
          increaseQualityOne(i);
        }
      }
    }
  }

  private void decreaseSellInOne(int i) {
    items[i].setSellIn(items[i].getSellIn() - 1);
  }

  private void decreseQualityOne(int i) {
    if (!items[i].getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
      items[i].setQuality(items[i].getQuality() - 1);
    }
  }

  private void increaseQualityOne(int i) {
    items[i].setQuality(items[i].getQuality() + 1);
  }

}

