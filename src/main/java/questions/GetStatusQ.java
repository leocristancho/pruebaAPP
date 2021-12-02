package questions;

import Models.country.CountryParameterFalse;
import Models.country.Status;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetStatusQ implements Question {


    @Override
    public CountryParameterFalse answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(CountryParameterFalse.class);

    }
}
