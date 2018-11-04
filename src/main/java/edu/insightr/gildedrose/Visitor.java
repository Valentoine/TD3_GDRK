package edu.insightr.gildedrose;

public class Visitor {

    public Inventory getInv() {
        return Inv;
    }

    private Inventory Inv;

    public Visitor() {
        Inv = new Inventory();
    }

    public void updateQuality() {

        for(int i=0; i<Inv.getItems().length; i++)
        {
            //first the quality never be negative
            if(Inv.getItems()[i].getQuality()>=0 || Inv.getItems()[i].getQuality()<= 50)
            {
                //secondly the decision criter the most impact is if the quality increase or decrease
                if (Inv.getItems()[i].getName() == "+5 Dexterity Vest"
                        || Inv.getItems()[i].getName() == "Elixir of the Mongoose"
                        || Inv.getItems()[i].getName() == "Conjured Mana Cake")
                {
                    //thirdly we look at the sellin value and if is a legendary item
                    int low = 1;
                    if(Inv.getItems()[i].getName()== "Conjured Mana Cake")
                        low = 2;

                    if(Inv.getItems()[i].getSellIn()>0)
                        Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - low);
                    else
                        Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - 2 * low);

                }
                else if (Inv.getItems()[i].getName() == "Aged Brie" || Inv.getItems()[i].getName() == "Backstage passes to a TAFKAL80ETC concert")
                {
                    int plus = 1;
                    if((Inv.getItems()[i].getName()== "Backstage passes to a TAFKAL80ETC concert" && Inv.getItems()[i].getSellIn() < 11) || (Inv.getItems()[i].getName()== "Aged Brie" && Inv.getItems()[i].getSellIn() <= 0))
                        plus = 2;
                    else if(Inv.getItems()[i].getName()== "Backstage passes to a TAFKAL80ETC concert" && Inv.getItems()[i].getSellIn() < 6)
                        plus = 3;

                    Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() + plus);
                }
            }
            //we can have problems if quality is negative or under 50, so we correct here instead of adding all the conditions in the code at the top
            if(Inv.getItems()[i].getQuality() <0)
                Inv.getItems()[i].setQuality(0);
            else if(Inv.getItems()[i].getQuality()>50 && Inv.getItems()[i].getName() != "Sulfuras, Hand of Ragnaros")
                Inv.getItems()[i].setQuality(50);

            //and we decrease the sellin value even if it's Sulfuras because it's constant
            if (Inv.getItems()[i].getName() != "Sulfuras, Hand of Ragnaros")
            {
                Inv.getItems()[i].setSellIn(Inv.getItems()[i].getSellIn() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Visitor V = new Visitor();
        for (int i = 0; i < 10; i++) {
            V.updateQuality();
            V.Inv.printInventory();
        }
    }
}
