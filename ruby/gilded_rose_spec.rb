require File.join(File.dirname(__FILE__), 'gilded_rose')

describe GildedRose do

  describe "update_quality" do
    it "Normal item before sell date" do
      app = GildedRose.new("normal", 5, 10)
      app.update_quality()
      expect(app.quality).to eq 9
      expect(app.sell_in).to eq 4
    end

    it "Normal item on sell date" do
      app = GildedRose.new("normal", 0, 10)
      app.update_quality()
      expect(app.quality).to eq 8
      expect(app.sell_in).to eq -1
    end

    it "Normal item after sell date" do
      app = GildedRose.new("normal", -10, 10)
      app.update_quality()
      expect(app.quality).to eq 8
      expect(app.sell_in).to eq -11
    end

    it "Normal item of zero quality" do
      app = GildedRose.new("normal", 5, 0)
      app.update_quality()
      expect(app.quality).to eq 0
      expect(app.sell_in).to eq 4
    end

    it "Brie item before sell date" do
      app = GildedRose.new("Aged Brie", 5, 10)
      app.update_quality()
      expect(app.quality).to eq 11
      expect(app.sell_in).to eq 4
    end

    it "Brie item before sell date with max quality" do
      app = GildedRose.new("Aged Brie", 5, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq 4
    end

    it "Brie item on sell date" do
      app = GildedRose.new("Aged Brie", 0, 10)
      app.update_quality()
      expect(app.quality).to eq 12
      expect(app.sell_in).to eq -1
    end

    it "Brie item on sell date near max quality" do
      app = GildedRose.new("Aged Brie", 0, 49)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq -1
    end

    it "Brie item on sell date with max quality" do
      app = GildedRose.new("Aged Brie", 0, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq -1
    end

    it "Brie item after sell date" do
      app = GildedRose.new("Aged Brie", -10, 10)
      app.update_quality()
      expect(app.quality).to eq 12
      expect(app.sell_in).to eq -11
    end

    it "Sulfuras item before sell date" do
      app = GildedRose.new("Sulfuras, Hand of Ragnaros", 5, 80)
      app.update_quality()
      expect(app.quality).to eq 80
      expect(app.sell_in).to eq 5
    end

    it "Sulfuras item on sell date" do
      app = GildedRose.new("Sulfuras, Hand of Ragnaros", 0, 80)
      app.update_quality()
      expect(app.quality).to eq 80
      expect(app.sell_in).to eq 0
    end

    it "Sulfuras item after sell date" do
      app = GildedRose.new("Sulfuras, Hand of Ragnaros", -10, 80)
      app.update_quality()
      expect(app.quality).to eq 80
      expect(app.sell_in).to eq -10
    end

    it "Backstage pass long before sell date" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 11, 10)
      app.update_quality()
      expect(app.quality).to eq 11
      expect(app.sell_in).to eq 10
    end

    it "Backstage pass medium close to sell date upper bound" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 10, 10)
      app.update_quality()
      expect(app.quality).to eq 12
      expect(app.sell_in).to eq 9
    end

    it "Backstage pass medium close to sell date upper bound at max quality" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 10, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq 9
    end

    it "Backstage pass medium close to sell date lower bound" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 6, 10)
      app.update_quality()
      expect(app.quality).to eq 12
      expect(app.sell_in).to eq 5
    end

    it "Backstage pass medium close to sell date lower bound max quality" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 6, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq 5
    end

    it "Backstage pass very close to sell date upper bound" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 5, 10)
      app.update_quality()
      expect(app.quality).to eq 13
      expect(app.sell_in).to eq 4
    end

    it "Backstage pass very close to sell date upper bound at max quality" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 5, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq 4
    end

    it "Backstage pass very close to sell date lower bound" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 1, 10)
      app.update_quality()
      expect(app.quality).to eq 13
      expect(app.sell_in).to eq 0
    end

    it "Backstage pass very close to sell date lower bound at max quality" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 1, 50)
      app.update_quality()
      expect(app.quality).to eq 50
      expect(app.sell_in).to eq 0
    end

    it "Backstage pass on sell date" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", 0, 10)
      app.update_quality()
      expect(app.quality).to eq 0
      expect(app.sell_in).to eq -1
    end

    it "Backstage pass after sell date" do
      app = GildedRose.new("Backstage passes to a TAFKAL80ETC concert", -10, 10)
      app.update_quality()
      expect(app.quality).to eq 0
      expect(app.sell_in).to eq -11
    end

    # TODO: next test are skipped :( till someone write the functionality

    # it "Conjured item before sell date" do
    #   app = GildedRose.new("Conjured Mana Cake", 5, 10)
    #   app.update_quality()
    #   expect(app.quality).to eq 8
    #   expect(app.sell_in).to eq 4
    # end
    #
    # it "Conjured item at zero quality" do
    #   app = GildedRose.new("Conjured Mana Cake", 5, 0)
    #   app.update_quality()
    #   expect(app.quality).to eq 0
    #   expect(app.sell_in).to eq 4
    # end
    #
    # it "Conjured item on sell date" do
    #   app = GildedRose.new("Conjured Mana Cake", 0, 10)
    #   app.update_quality()
    #   expect(app.quality).to eq 6
    #   expect(app.sell_in).to eq -1
    # end
    #
    # it "Conjured item on sell date at zero quality" do
    #   app = GildedRose.new("Conjured Mana Cake", 0, 0)
    #   app.update_quality()
    #   expect(app.quality).to eq 0
    #   expect(app.sell_in).to eq -1
    # end
    #
    # it "Conjured item after sell date" do
    #   app = GildedRose.new("Conjured Mana Cake", -10, 10)
    #   app.update_quality()
    #   expect(app.quality).to eq 6
    #   expect(app.sell_in).to eq -11
    # end
    #
    # it "Conjured item after sell date at zero quality" do
    #   app = GildedRose.new("Conjured Mana Cake", -10, 0)
    #   app.update_quality()
    #   expect(app.quality).to eq 0
    #   expect(app.sell_in).to eq -11
    # end

  end

end
