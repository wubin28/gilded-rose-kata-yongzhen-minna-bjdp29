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
    public void testQualityIncreaseForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 7) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality > 7);
    }

    @Test
    public void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulturas", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
}
