package iuh.fit;

import iuh.fit.model.Country;
import iuh.fit.model.Name;
import iuh.fit.model.Translation;
import iuh.fit.util.JsonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Admin 4/5/2025
 * ${DESCRIPTION}
 **/
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Name
        Name name = new Name("Vietnam", "Socialist Republic of Vietnam");

        // Tạo đối tượng Translations
        Map<String, Translation> translations = new HashMap<>();
        translations.put("fra", new Translation("Viêt Nam", "République socialiste du Vietnam"));
        translations.put("ita", new Translation("Vietnam", "Repubblica socialista del Vietnam"));

        // Danh sách altSpellings
        List<String> altSpellings = Arrays.asList(
                "VN",
                "Socialist Republic of Vietnam",
                "Cộng hòa Xã hội chủ nghĩa Việt Nam",
                "Viet Nam"
        );

        // Danh sách biên giới
        List<String> borders = Arrays.asList("KHM", "CHN", "LAO");

        // Danh sách mã gọi điện
        List<String> callingCode = List.of("84");

        // Danh sách đơn vị tiền tệ
        List<String> currency = List.of("VND");

        // Vĩ độ và kinh độ
        List<String> latlng = Arrays.asList("16.16666666", "107.83333333");

        // Tạo đối tượng Country
        Country vietnam = new Country(
                "1",                 // id
                "331212",            // area
                "Hanoi",             // capital
                "VN",                // cca2
                "VIE",               // cioc
                "Vietnamese",        // demonym
                false,               // landLocked
                "South-Eastern Asia",// subregion
                altSpellings,        // altSpellings
                borders,             // borders
                callingCode,         // callingCode
                currency,            // currency
                latlng,              // latlng
                name,                // name
                translations         // translations
        );

        JsonUtils.writeToFile(vietnam, "json/vietnam.json");
    }
}