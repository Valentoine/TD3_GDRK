package edu.insightr.gildedrose;

public class Inventory {

    public Item[] getItems() {
        return items;
    }

    private Item[] items;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {

        for(int i=0; i<items.length; i++)
        {
            //first the quality never be negative
            if(items[i].getQuality()>=0 || items[i].getQuality()<= 50)
            {
                //secondly the decision criter the most impact is if the quality increase or decrease
                if (items[i].getName() == "+5 Dexterity Vest"
                        || items[i].getName() == "Elixir of the Mongoose"
                        || items[i].getName() == "Conjured Mana Cake")
                {
                    //thirdly we look at the sellin value and if is a legendary item
                    int low = 1;
                    if(items[i].getName()== "Conjured Mana Cake")
                        low = 2;

                    if(items[i].getSellIn()>0)
                        items[i].setQuality(items[i].getQuality() - low);
                    else
                        items[i].setQuality(items[i].getQuality() - 2 * low);

                }
                else if (items[i].getName() == "Aged Brie" || items[i].getName() == "Backstage passes to a TAFKAL80ETC concert")
                {
                    int plus = 1;
                    if((items[i].getName()== "Backstage passes to a TAFKAL80ETC concert" && items[i].getSellIn() < 11) || (items[i].getName()== "Aged Brie" && items[i].getSellIn() <= 0))
                        plus = 2;
                    else if(items[i].getName()== "Backstage passes to a TAFKAL80ETC concert" && items[i].getSellIn() < 6)
                        plus = 3;

                    items[i].setQuality(items[i].getQuality() + plus);
                }
            }
            //we can have problems if quality is negative or under 50, so we correct here instead of adding all the conditions in the code at the top
            if(items[i].getQuality() <0)
                items[i].setQuality(0);
            else if(items[i].getQuality()>50 && items[i].getName() != "Sulfuras, Hand of Ragnaros")
                items[i].setQuality(50);

            //and we decrease the sellin value even if it's Sulfuras because it's constant
            if (items[i].getName() != "Sulfuras, Hand of Ragnaros")
            {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }
        }
    }



    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
