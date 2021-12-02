package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCountryCoord implements  Task {

    private final String lat;
    private final String lon;
    private final String user;

    public GetCountryCoord(String lat,String lon, String user){

        this.lat =lat;
        this.lon=lon;
        this.user=user;
    }

    public static Performable fromcoord(String lat,String lon, String user){

       return instrumented(GetCountryCoord.class,lat,lon,user);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource("?formatted=true&lat="+lat+"&lng="+lon+"&username="+user+"&style=full").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON).header("Latitud",lat).header("Longitud",lon).header("Usuario",user)));

    }
}
