function GildedRose(name, sell_in, quality) {
  this.name = name;
  this.sell_in = sell_in;
  this.quality = quality;

  this.decreaseQualityBy = function(num){
    this.quality = this.quality - num;
  }

  this.decreaseSellIn = function(num) {
    this.sell_in = this.sell_in - num;
  }

  this.increaseQualityBy = function(num){
    this.quality = this.quality + num;
  }

  this.update_quality = function() {
    if (this.name != 'Aged Brie' && this.name != 'Backstage passes to a TAFKAL80ETC concert') {
      if (this.quality > 0 && this.name != 'Sulfuras, Hand of Ragnaros') {
          this.decreaseQualityBy(1)
      }
    } else {
      if (this.quality < 50) {
        this.increaseQualityBy(1);
      }

      if (this.name == 'Backstage passes to a TAFKAL80ETC concert'
        && this.sell_in < 11
        && this.quality < 50) {
          this.increaseQualityBy(1);

      }
      if (this.name == 'Backstage passes to a TAFKAL80ETC concert'
        && this.sell_in < 6
        && this.quality < 50) {
          this.increaseQualityBy(1);
      }

    }
    if (this.name != 'Sulfuras, Hand of Ragnaros') {
      this.sell_in = this.sell_in - 1;
    }


    if (this.name != 'Aged Brie'
        && this.name != 'Backstage passes to a TAFKAL80ETC concert'
        && this.name != 'Sulfuras, Hand of Ragnaros'
        && this.quality > 0
        && this.sell_in < 0) {
      this.decreaseQualityBy(1);
    }



    else if (this.name == 'Backstage passes to a TAFKAL80ETC concert'
             && this.sell_in < 0) {
      this.quality = this.quality - this.quality
    }

    else if (this.quality < 50 && this.sell_in < 0) {
      this.increaseQualityBy(1);
    }

  }
}
