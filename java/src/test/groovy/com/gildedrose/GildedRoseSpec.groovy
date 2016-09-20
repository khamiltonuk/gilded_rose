package com.gildedrose

import spock.lang.Specification

/**
 * Spock unit tests.
 * NOTE: :( this is not the conventional use of SPOCK
 *       but I hope it is good enough for this exercise :)
 */
class GildedRoseSpec extends Specification {

    def "Normal item before sell date"() {
        given: " a normal item before sell date"
        GildedRose app = new GildedRose("normal", 10, 5);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 4
        app.sellIn == 9
    }

    def "Normal item after sell date"() {
        given: "a normal after on sell date"
        GildedRose app = new GildedRose("normal", -10, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 8
        app.sellIn == -11
    }

    def "Normal item of zero quality"() {
        given: "a Normal item of zero quality"
        GildedRose app = new GildedRose("normal", 5, 0);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == 4
    }

    def "Brie item before sell date"() {
        given: "a Brie item before sell date"
        GildedRose app = new GildedRose("Aged Brie", 5, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 11
        app.sellIn == 4
    }

    def "Brie item before sell date with max quality"() {
        given: "a Brie item before sell date with max quality"
        GildedRose app = new GildedRose("Aged Brie", 5, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == 4
    }

    def "Brie item on sell date"() {
        given: "a Brie item on sell date"
        GildedRose app = new GildedRose("Aged Brie", 0, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 12
        app.sellIn == -1
    }

    def "Brie item on sell date near max quality"() {
        given: "a Brie item on sell date near max quality"
        GildedRose app = new GildedRose("Aged Brie", 0, 49);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == -1
    }

    def "Brie item on sell date with max quality"() {
        given: "a Brie item on sell date with max quality"
        GildedRose app = new GildedRose("Aged Brie", 0, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == -1
    }

    def "Brie item after sell date"() {
        given: "a Brie item after sell date"
        GildedRose app = new GildedRose("Aged Brie", -10, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 12
        app.sellIn == -11
    }

    def "Sulfuras item before sell date"() {
        given: "a Sulfuras item before sell date"
        GildedRose app = new GildedRose("Sulfuras, Hand of Ragnaros", 5, 80);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 80
        app.sellIn == 5
    }

    def "Sulfuras item on sell date"() {
        given: "a Sulfuras item on sell date"
        GildedRose app = new GildedRose("Sulfuras, Hand of Ragnaros", 0, 80);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 80
        app.sellIn == 0
    }

    def "Sulfuras item after sell date"() {
        given: "a Sulfuras item after sell date"
        GildedRose app = new GildedRose("Sulfuras, Hand of Ragnaros", -10, 80);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 80
        app.sellIn == -10
    }

    def "Backstage pass long before sell date"() {
        given: "a Backstage pass long before sell date"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 11, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 11
        app.sellIn == 10
    }

    def "Backstage pass medium close to sell date upper bound"() {
        given: "a Backstage pass medium close to sell date upper bound"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 12
        app.sellIn == 9
    }

    def "Backstage pass medium close to sell date upper bound at max quality"() {
        given: "a Backstage pass medium close to sell date upper bound at max quality"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 10, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == 9
    }

    def "Backstage pass medium close to sell date lower bound"() {
        given: "a Backstage pass medium close to sell date lower bound"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 6, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 12
        app.sellIn == 5
    }

    def "Backstage pass medium close to sell date lower bound max quality"() {
        given: "a Backstage pass medium close to sell date lower bound max quality"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 6, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == 5
    }

    def "Backstage pass very close to sell date upper bound"() {
        given: "a Backstage pass very close to sell date upper bound"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 13
        app.sellIn == 4
    }

    def "Backstage pass very close to sell date upper bound at max quality"() {
        given: "a Backstage pass very close to sell date upper bound at max quality"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 5, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == 4
    }

    def "Backstage pass very close to sell date lower bound"() {
        given: "a Backstage pass very close to sell date lower bound"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 1, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 13
        app.sellIn == 0
    }

    def "Backstage pass very close to sell date lower bound at max quality"() {
        given: "a Backstage pass very close to sell date lower bound at max quality"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 1, 50);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 50
        app.sellIn == 0
    }

    def "Backstage pass on sell date"() {
        given: "a Backstage pass on sell date"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", 0, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == -1
    }

    def "Backstage pass after sell date"() {
        given: "a Backstage pass after sell date"
        GildedRose app = new GildedRose("Backstage passes to a TAFKAL80ETC concert", -10, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == -11
    }

    // TODO: next test are skipped till someone write the functionality :)
    /*
    def "Conjured item before sell date"() {
        given: "a Conjured item before sell date"
        GildedRose app = new GildedRose("Conjured Mana Cake", 5, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == 4
    }

    def "Conjured item at zero quality"() {
        given: "a Conjured item at zero quality"
        GildedRose app = new GildedRose("Conjured Mana Cake", 5, 0);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 8
        app.sellIn == 4
    }

    def "Conjured item on sell date"() {
        given: "a Conjured item on sell date"
        GildedRose app = new GildedRose("Conjured Mana Cake", 5, 0);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 6
        app.sellIn == -1
    }

    def "Conjured item on sell date at zero quality"() {
        given: "a Conjured item on sell date at zero quality"
        GildedRose app = new GildedRose("Conjured Mana Cake", 0, 0);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == -1
    }

    def "Conjured item after sell date"() {
        given: "a Conjured item after sell date"
        GildedRose app = new GildedRose("Conjured Mana Cake", -10, 10);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 6
        app.sellIn == -11
    }

    def "Conjured item after sell date at zero quality"() {
        given: "a Conjured item after sell date at zero quality"
        GildedRose app = new GildedRose("Conjured Mana Cake", -10, 0);

        when: "updating quality"
        app.updateQuality();

        then: "the quality and days remaining are correct"
        app.quality == 0
        app.sellIn == -11
    }
    */
}
