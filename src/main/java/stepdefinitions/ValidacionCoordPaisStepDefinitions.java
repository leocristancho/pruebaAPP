package stepdefinitions;

import Models.country.CountryData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import questions.GetContryQ;
import tasks.GetCountryCoord;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;



public class ValidacionCoordPaisStepDefinitions {
    private  final String restAìUrl="http://api.geonames.org/timezoneJSON?";
    Actor Leonardo;

    @Given("Leonardo es un usuario que requiere consultar la api TimeZone con coordenadas asociadas a un pais")
    public void leonardo_es_un_usuario_que_requiere_consultar_la_api_time_zone_con_coordenadas_asociadas_a_un_pais() {
        Leonardo = Actor.named("Leonardo Administrador")
                .whoCan(CallAnApi.at(restAìUrl));
    }

    @When("el envia los valores asociados al pais a consultar segun las coordenadas {string} y {string}")
    public void el_envia_los_valores_asociados_al_pais_a_consultar_segun_las_coordenadas_y(String latitud, String longitud) {
        String user="qa_mobile_easy";

        Leonardo.attemptsTo(
                GetCountryCoord.fromcoord(latitud,longitud,user));
    }

    @Then("la api devuelve los resultados asociados al pais segun las coordenadas {string} {string}")
    public void la_api_devuelve_los_resultados_asociados_al_pais_segun_las_coordenadas(String  pais, String timezone) {


        CountryData country= new GetContryQ().answeredBy(Leonardo);

        Leonardo.should(seeThat("País asociado:", act
                -> country.getCountryName(),equalTo(pais)));

        Leonardo.should(seeThat("TimeZone:", act
                -> country.getTimezoneId(),equalTo(timezone)));
    }

}
