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

public class ConsultaAPICredencialInvalida {
    private  final String restAìUrl="http://api.geonames.org/timezoneJSON?";
    Actor Leonardo;

    @Given("Leonardo es un usuario que requiere consultar la api TimeZone con username invalido")
    public void leonardo_es_un_usuario_que_requiere_consultar_la_api_time_zone_con_username_invalido() {
        Leonardo = Actor.named("Leonardo Administrador")
                .whoCan(CallAnApi.at(restAìUrl));
    }

    @When("el envìa los valores asociados a las coordenadas {string} y {string}  con username {string} invalido")
    public void el_envìa_los_valores_asociados_a_las_coordenadas_y_con_username_invalido(String latitud, String longitud, String username) {

        Leonardo.attemptsTo(
                GetCountryCoord.fromcoord(latitud,longitud,username));
    }

    @Then("la api devuelve un codigo de respuesta que indica   que el username no existe o no es valido")
    public void la_api_devuelve_un_codigo_de_respuesta_que_indica_que_el_username_no_existe_o_no_es_valido() {

        Leonardo.should(
                seeThat("El código de respuesta", ResponseCode.was(),equalTo(401)));
    }

}
