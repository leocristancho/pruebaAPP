package Models.country;


import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CountryParameterFalse {

    private Status status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}