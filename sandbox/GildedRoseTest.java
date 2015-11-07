import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testQualityDegradeTwice() {
        Item[] items = new Item[] { new Item("foo", 0, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void testQualityWhen0() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testQualityIncreaseForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 7);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesBiggerThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
}

    @Test
    public void testBackstagePassesBetween5And10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesBetween0And5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesWhen0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
