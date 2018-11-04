package edu.insightr.gildedrose;

public class Strategy {

    public Inventory getInv() {
        return Inv;
    }

    private Inventory Inv;

    public Strategy() {
        Inv = new Inventory();
    }

    public void updateVestElixir(int i)
    {
        if(Inv.getItems()[i].getSellIn()>0)
            Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - 1);
        else
            Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - 2);
    }

    public void updateConjured(int i)
    {
        if(Inv.getItems()[i].getSellIn()>0)
            Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - 2);
        else
            Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() - 4);
    }

    public void updateAgedBrie(int i)
    {
        int plus = 1;
        if(Inv.getItems()[i].getSellIn() <= 0)
            plus = 2;

        Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() + plus);
    }

    public void updateBackstage(int i)
    {
        int plus = 1;
        if(Inv.getItems()[i].getSellIn() < 11)
            plus = 2;
        else if(Inv.getItems()[i].getSellIn() < 6)
            plus = 3;

        Inv.getItems()[i].setQuality(Inv.getItems()[i].getQuality() + plus);
    }

    public void updateQuality()
    {
        for(int i=0; i<Inv.getItems().length; i++)
        {
            if(Inv.getItems()[i].getQuality()>=0 || Inv.getItems()[i].getQuality()<= 50)
            {
                if (Inv.getItems()[i].getName() == "+5 Dexterity Vest"
                        || Inv.getItems()[i].getName() == "Elixir of the Mongoose")
                    updateVestElixir(i);

                else if(Inv.getItems()[i].getName() == "Conjured Mana Cake")
                    updateConjured(i);

                else if(Inv.getItems()[i].getName() == "Aged Brie")
                    updateAgedBrie(i);

                else if(Inv.getItems()[i].getName() == "Backstage passes to a TAFKAL80ETC concert")
                    updateBackstage(i);
            }

            if(Inv.getItems()[i].getQuality() <0)
                Inv.getItems()[i].setQuality(0);
            else if(Inv.getItems()[i].getQuality()>50 && Inv.getItems()[i].getName() != "Sulfuras, Hand of Ragnaros")
                Inv.getItems()[i].setQuality(50);

            Inv.getItems()[i].setSellIn(Inv.getItems()[i].getSellIn() - 1);
        }
    }

    public static void main(String[] args) {
        Strategy S = new Strategy();
        for (int i = 0; i < 10; i++) {

            S.updateQuality();

            S.Inv.printInventory();
        }
    }

}
