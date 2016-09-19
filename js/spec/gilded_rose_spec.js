describe("Gilded Rose", function() {
  it("Normal item before sell date", function() {
    items = [ new Item("normal", 10, 5) ];
    update_quality();
    expect(items[0].quality).toBe(4);
  });

  it("Normal item before sell date", function() {
    items = [ new Item("normal", 5, 10) ];
    update_quality();
    expect(items[0].quality).toBe(9);
    expect(items[0].sell_in).toBe(4);
  });

  it("Normal item on sell date", function() {
    items = [ new Item("normal", 0, 10) ];
    update_quality();
    expect(items[0].quality).toBe(8);
    expect(items[0].sell_in).toBe(-1);
  });

  it("Normal item after sell date", function() {
    items = [ new Item("normal", -10, 10) ];
    update_quality();
    expect(items[0].quality).toBe(8);
    expect(items[0].sell_in).toBe(-11);
  });

  it("Normal item of zero quality", function() {
    items = [ new Item("normal", 5, 0) ];
    update_quality();
    expect(items[0].quality).toBe(0);
    expect(items[0].sell_in).toBe(4);
  });

  it("Brie item before sell date", function() {
    items = [ new Item("Aged Brie", 5, 10) ];
    update_quality();
    expect(items[0].quality).toBe(11);
    expect(items[0].sell_in).toBe(4);
  });

  it("Brie item before sell date with max quality", function() {
    items = [ new Item("Aged Brie", 5, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(4);
  });

  it("Brie item on sell date", function() {
    items = [ new Item("Aged Brie", 0, 10) ];
    update_quality();
    expect(items[0].quality).toBe(12);
    expect(items[0].sell_in).toBe(-1);
  });

  it("Brie item on sell date near max quality", function() {
    items = [ new Item("Aged Brie", 0, 49) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(-1);
  });

  it("Brie item on sell date with max quality", function() {
    items = [ new Item("Aged Brie", 0, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(-1);
  });

  it("Brie item after sell date", function() {
    items = [ new Item("Aged Brie", -10, 10) ];
    update_quality();
    expect(items[0].quality).toBe(12);
    expect(items[0].sell_in).toBe(-11);
  });

  it("Sulfuras item before sell date", function() {
    items = [ new Item("Sulfuras, Hand of Ragnaros", 5, 80) ];
    update_quality();
    expect(items[0].quality).toBe(80);
    expect(items[0].sell_in).toBe(5);
  });

  it("Sulfuras item on sell date", function() {
    items = [ new Item("Sulfuras, Hand of Ragnaros", 0, 80) ];
    update_quality();
    expect(items[0].quality).toBe(80);
    expect(items[0].sell_in).toBe(0);
  });

  it("Sulfuras item after sell date", function() {
    items = [ new Item("Sulfuras, Hand of Ragnaros", -10, 80) ];
    update_quality();
    expect(items[0].quality).toBe(80);
    expect(items[0].sell_in).toBe(-10);
  });

  it("Backstage pass long before sell date", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) ];
    update_quality();
    expect(items[0].quality).toBe(11);
    expect(items[0].sell_in).toBe(10);
  });

  it("Backstage pass medium close to sell date upper bound", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) ];
    update_quality();
    expect(items[0].quality).toBe(12);
    expect(items[0].sell_in).toBe(9);
  });

  it("Backstage pass medium close to sell date upper bound at max quality", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(9);
  });

  it("Backstage pass medium close to sell date lower bound", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10) ];
    update_quality();
    expect(items[0].quality).toBe(12);
    expect(items[0].sell_in).toBe(5);
  });

  it("Backstage pass medium close to sell date lower bound max quality", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(5);
  });

  it("Backstage pass very close to sell date upper bound", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) ];
    update_quality();
    expect(items[0].quality).toBe(13);
    expect(items[0].sell_in).toBe(4);
  });

  it("Backstage pass very close to sell date upper bound at max quality", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(4);
  });

  it("Backstage pass very close to sell date lower bound", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10) ];
    update_quality();
    expect(items[0].quality).toBe(13);
    expect(items[0].sell_in).toBe(0);
  });

  it("Backstage pass very close to sell date lower bound at max quality", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) ];
    update_quality();
    expect(items[0].quality).toBe(50);
    expect(items[0].sell_in).toBe(0);
  });

  it("Backstage pass on sell date", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) ];
    update_quality();
    expect(items[0].quality).toBe(0);
    expect(items[0].sell_in).toBe(-1);
  });

  it("Backstage pass after sell date", function() {
    items = [ new Item("Backstage passes to a TAFKAL80ETC concert", -10, 10) ];
    update_quality();
    expect(items[0].quality).toBe(0);
    expect(items[0].sell_in).toBe(-11);
  });

  // TODO: next test are skipped :( till someone write the functionality

  // it("Conjured item before sell date", function() {
  //   items = [ new Item("Conjured Mana Cake", 5, 10) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(8);
  //   expect(items[0].sell_in).toBe(4);
  // });
  //
  // it("Conjured item at zero quality", function() {
  //   items = [ new Item("Conjured Mana Cake", 5, 0) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(0);
  //   expect(items[0].sell_in).toBe(4);
  // });
  //
  // it("Conjured item on sell date", function() {
  //   items = [ new Item("Conjured Mana Cake", 0, 10) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(6);
  //   expect(items[0].sell_in).toBe(-1);
  // });
  //
  // it("Conjured item on sell date at zero quality", function() {
  //   items = [ new Item("Conjured Mana Cake", 0, 0) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(0);
  //   expect(items[0].sell_in).toBe(-1);
  // });
  //
  // it("Conjured item after sell date", function() {
  //   items = [ new Item("Conjured Mana Cake", -10, 10) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(6);
  //   expect(items[0].sell_in).toBe(-11);
  // });
  //
  // it("Conjured item after sell date at zero quality", function() {
  //   items = [ new Item("Conjured Mana Cake", -10, 0) ];
  //   update_quality();
  //   expect(items[0].quality).toBe(0);
  //   expect(items[0].sell_in).toBe(-11);
  // });
});
