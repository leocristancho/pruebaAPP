package stepdefinitions;

import Models.country.CountryData;
import Models.country.CountryParameterFalse;
import Models.country.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.GetContryQ;
import questions.GetStatusQ;
import tasks.GetCountryCoord;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidacionErrorCoordenadasStepDefinitions {
    private  final String restAìUrl="http://api.geonames.org/timezoneJSON?";
    Actor Leonardo;
    @Given("Leonardo es un usuario que requiere consultar la api TimeZone con parametros de coordenadas erroneas")
    public void leonardo_es_un_usuario_que_requiere_consultar_la_api_time_zone_con_parametros_de_coordenadas_erroneas() {
        Leonardo = Actor.named("Leonardo Administrador")
                .whoCan(CallAnApi.at(restAìUrl));
    }

    @When("el envìa los valores erroneos en las coordenadas {string} y {string}")
    public void el_envìa_los_valores_erroneos_en_las_coordenadas_y(String latitud, String longitud) {
        String user="qa_mobile_easy";

        Leonardo.attemptsTo(
                GetCountryCoord.fromcoord(latitud,longitud,user));
    }

    @Then("la api devuelve un codigo  de status  que indica  error en los parametros")
    public void la_api_devuelve_un_codigo_de_status_que_indica_error_en_los_parametros() {



        CountryParameterFalse statusValue =new GetStatusQ().answeredBy(Leonardo);


        Leonardo.should(seeThat("País asociado:", act
                -> statusValue.getStatus().getValue(),equalTo(14)));





    }
}
