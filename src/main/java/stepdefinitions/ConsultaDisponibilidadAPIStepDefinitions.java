package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.ResponseCode;
import tasks.GetCountryCoord;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsultaDisponibilidadAPIStepDefinitions {
    private  final String restAìUrl="http://api.geonames.org/timezoneJSON?";
    Actor Leonardo;

    @Given("Leonardo es un usuario que requiere consultar la api TimeZone")
    public void leonardo_es_un_usuario_que_requiere_consultar_la_api_time_zone() {
        Leonardo = Actor.named("Leonardo Administrador")
                .whoCan(CallAnApi.at(restAìUrl));
    }

    @When("el envìa los valores asociados a las coordenadas {string} y {string}")
    public void el_envìa_los_valores_asociados_a_las_coordenadas_y(String latitud, String longitud) {
       String user="qa_mobile_easy";

        Leonardo.attemptsTo(
                GetCountryCoord.fromcoord(latitud,longitud,user));
    }

    @Then("la api devuelve un codigo de respuesta de consumo exitoso")
    public void la_api_devuelve_un_codigo_de_respuesta_de_consumo_exitoso() {
        Leonardo.should(
                seeThat("El código de respuesta", ResponseCode.was(),equalTo(200)));
    }

    @Given("Leonardo es un usuario que requiere consultar la api TimeZone con coordenadas incorrectas")
    public void leonardo_es_un_usuario_que_requiere_consultar_la_api_time_zone_con_coordenadas_incorrectas() {

        Leonardo = Actor.named("Leonardo Administrador")
                .whoCan(CallAnApi.at(restAìUrl));
    }

    @When("el envìa los valores asociados a las coordenadas {string} y {string} incorrectas")
    public void el_envìa_los_valores_asociados_a_las_coordenadas_y_incorrectas(String latitudI, String longitudI) {
        String user="qa_mobile_easy";

        Leonardo.attemptsTo(
                GetCountryCoord.fromcoord(latitudI,longitudI,user));
    }

    @Then("la api devuelve un codigo de respuesta de consumo exitoso -  caso coordenadas incorrectas")
    public void la_api_devuelve_un_codigo_de_respuesta_de_consumo_exitoso_caso_coordenadas_incorrectas() {

        Leonardo.should(
                seeThat("El código de respuesta", ResponseCode.was(),equalTo(200)));
    }


}
