package questions;


import Models.country.CountryData;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetContryQ implements Question {


    @Override
    public CountryData answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CountryData.class);

    }
}
