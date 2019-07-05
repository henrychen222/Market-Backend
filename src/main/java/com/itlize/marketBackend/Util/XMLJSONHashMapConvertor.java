/* 4.16 https://dzone.com/articles/xml-json-hashmap */
package com.itlize.marketBackend.Util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class XMLJSONHashMapConvertor {

	public static Map<String, Object> jsonToMap(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = null;

		try {
			map = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
			});

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unused")
	public static Map<String, Object> jsonToMap2(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = null;
		List<Map<String, Object>> jsonInList = null;

		try {
			// jsonInList = mapper.readValue(jsonString, new TypeReference<List<Map<String,
			// Object>>>() {
			// });
			//
			// for (int i = 0; i < jsonInList.size(); i++) {
			// map = jsonInList.get(i);
			// // System.out.println(map);
			// }

			map = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
			});

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static String xmlStringtoJSON(String xml) throws IOException {
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xml);
		return json.toString(2);
	}

	// public static String xmltoJSON(String xmlFileName) throws IOException {
	// InputStream is = new FileInputStream(xmlFileName);
	// String xml = IOUtils.toString(is);
	// XMLSerializer xmlSerializer = new XMLSerializer();
	// JSON json = xmlSerializer.read(xml);
	//
	// return json.toString(2);
	// }

	public static void main(String[] args) throws Exception {

		String xml = "<Buyer BuyerID=\"1\" Username=\"cursus\" Password=\"a\"\n"
				+ "		Email=\"magnis.dis@idante.net\" FirstName=\"Nicholas\" LastName=\"Indira\">\n" + "	</Buyer>";

		final String xmlStr = "<employees>" + "   <employee id=\"101\">" + "        <name>Lokesh Gupta</name>"
				+ "       <title>Author</title>" + "   </employee>" + "   <employee id=\"102\">"
				+ "        <name>Brian Lara</name>" + "       <title>Cricketer</title>" + "   </employee>"
				+ "</employees>";

		final String xmlStr2 = "<Product>" + "   <power id=\"101\">" + "        <min>400</min>"
				+ "       <max>5700</max>" + "   </power>" + "</Product>";

		String jsonString = xmlStringtoJSON(xml);
		System.out.println("**************");
		System.out.println(jsonString);

		System.err.println(jsonToMap(jsonString));
	}

}
