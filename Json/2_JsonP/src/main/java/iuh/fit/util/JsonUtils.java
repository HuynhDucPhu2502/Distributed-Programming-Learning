package iuh.fit.util;

import iuh.fit.model.Country;
import jakarta.json.*;
import jakarta.json.stream.JsonGenerator;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin 4/5/2025
 **/
public class JsonUtils {

    public static void writeToFile(Country country, String fileName) {
        Map<String, Object> config = new HashMap<>();
        config.put(JsonGenerator.PRETTY_PRINTING, true);
        JsonWriterFactory jsonWriterFactory = Json.createWriterFactory(config);

        try (JsonWriter writer = jsonWriterFactory.createWriter(new FileWriter(fileName))) {
            JsonObjectBuilder countryObject = Json.createObjectBuilder()
                    .add("id", country.getId())
                    .add("area", country.getArea())
                    .add("capital", country.getCapital())
                    .add("cca2", country.getCca2())
                    .add("cioc", country.getCioc())
                    .add("demonym", country.getDemonym())
                    .add("landLocked", country.isLandLocked())
                    .add("subregion", country.getSubregion());

            JsonArrayBuilder altSpellingsJsonArray = Json.createArrayBuilder();
            country.getAltSpellings().forEach(x -> {
                altSpellingsJsonArray.add(x);
            });
            countryObject.add("altSpellings", altSpellingsJsonArray);

            JsonArrayBuilder bordersJsonArray = Json.createArrayBuilder();
            country.getBorders().forEach(x -> {
                bordersJsonArray.add(x);
            });
            countryObject.add("borders", bordersJsonArray);

            JsonArrayBuilder callingCodeJsonArray = Json.createArrayBuilder();
            country.getCallingCode().forEach(x -> {
                callingCodeJsonArray.add(x);
            });
            countryObject.add("callingCode", callingCodeJsonArray);

            JsonArrayBuilder currencyJsonArray = Json.createArrayBuilder();
            country.getCurrency().forEach(x -> {
                currencyJsonArray.add(x);
            });
            countryObject.add("currency", currencyJsonArray);

            JsonArrayBuilder latlngJsonArray = Json.createArrayBuilder();
            country.getLatlng().forEach(x -> {
                latlngJsonArray.add(x);
            });
            countryObject.add("latlng", latlngJsonArray);

            JsonObjectBuilder nameObject = Json.createObjectBuilder()
                    .add("common", country.getName().getCommon())
                    .add("official", country.getName().getOfficial());
            countryObject.add("name", nameObject);

            JsonObjectBuilder translationsObject = Json.createObjectBuilder();

            country.getTranslations().forEach((key, value) -> {
                JsonObjectBuilder translationObject = Json.createObjectBuilder()
                        .add("common", value.getCommon())
                        .add("official", value.getOfficial());
                translationsObject.add(key, translationObject);
            });
            countryObject.add("translations", translationsObject);

            writer.write(countryObject.build());
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
