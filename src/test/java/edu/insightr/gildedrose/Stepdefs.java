package edu.insightr.gildedrose;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Stepdefs {

    private Strategy S;
    private Item[] items;
    private Item vest;
    private Item conjured;
    private Item elixir;
    private Item agedbrie;
    private Item sulfuras;
    private Item backstage;


    @Given("^I have a new strategy$")
    public void iHaveANewVisitor() throws Throwable {
        S = new Strategy();
        items = S.getInv().getItems();
        vest = items[0];
        agedbrie = items[1];
        elixir = items[2];
        sulfuras = items[3];
        backstage = items[4];
        conjured = items[5];
    }

    @Then("^the quality of the conjured item is (\\d+)$")
    public void theQualityOfTheConjuredIs(int conjuredQuality) throws Throwable {
        assertThat(conjured.getQuality(), is(conjuredQuality));
    }

    @Then("^the quality of the vest item is (\\d+)$")
    public void theQualityOfTheVestIs(int conjuredQuality) throws Throwable {
        assertThat(vest.getQuality(), is(conjuredQuality));
    }

    @Then("^the quality of the agedbrie item is (\\d+)$")
    public void theQualityOfTheAgedBrieIs(int conjuredQuality) throws Throwable {
        assertThat(agedbrie.getQuality(), is(conjuredQuality));
    }

    @Then("^the quality of the elixir item is (\\d+)$")
    public void theQualityOfTheElixirIs(int conjuredQuality) throws Throwable {
        assertThat(elixir.getQuality(), is(conjuredQuality));
    }

    @Then("^the quality of the sulfuras item is (\\d+)$")
    public void theQualityOfTheSulfurasIs(int conjuredQuality) throws Throwable {
        assertThat(sulfuras.getQuality(), is(conjuredQuality));
    }

    @Then("^the quality of the backstage item is (\\d+)$")
    public void theQualityOfTheBackstageIs(int conjuredQuality) throws Throwable {
        assertThat(backstage.getQuality(), is(conjuredQuality));
    }

    @When("^I update the inventory$")
    public void iUpdateTheInventory() throws Throwable {
        S.updateQuality();
    }
}

