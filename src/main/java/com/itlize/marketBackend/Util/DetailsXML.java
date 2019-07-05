//package com.itlize.marketBackend.Util;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//public class DetailsXML {
//
//	public static void main(String[] args) throws JAXBException, FileNotFoundException {
//		System.out.println("Output from our XML File: ");
//		JAXBContext context = JAXBContext.newInstance(BuyerTest.class);
//		Unmarshaller um = context.createUnmarshaller();
//		BuyerTest test = (BuyerTest) um.unmarshal(new FileReader("Buyers.xml"));
//		List<String> BuyerID = test.getBuyerID();
//		List<String> Password = test.getPassword();
//		List<String> Username = test.getUsername();
//		List<String> Email = test.getEmail();
//		List<String> FirstName = test.getFirstName();
//		List<String> LastName = test.getLastName();
//
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("BuyerID", BuyerID.toArray(new String[BuyerID.size()]));
//		map.put("Username", Username.toArray(new String[Username.size()]));
//		map.put("Password", Password.toArray(new String[Password.size()]));
//		map.put("Email", Email.toArray(new String[Email.size()]));
//		map.put("FirstName", FirstName.toArray(new String[FirstName.size()]));
//		map.put("LastName", LastName.toArray(new String[LastName.size()]));
//
//		for (Map.Entry<String, String[]> entry : map.entrySet()) {
//			System.out.print("Key \"" + entry.getKey() + "\" value={");
//			for (int i = 0; i < entry.getValue().length; i++) {
//				if (i != entry.getValue().length - 1) {
//					System.out.print("\"" + entry.getValue()[i] + "\",");
//				} else {
//					System.out.print("\"" + entry.getValue()[i] + "\"}");
//				}
//			}
//			System.out.println();
//		}
//
//	}
//
//}
