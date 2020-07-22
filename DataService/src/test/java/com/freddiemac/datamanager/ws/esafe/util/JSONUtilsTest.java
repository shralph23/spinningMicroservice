package com.freddiemac.datamanager.ws.esafe.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.freddiemac.datamanager.ws.model.ResponseType;

public class JSONUtilsTest {

	@Test
   public void testJSONUtilsTest1()
	{
		String testName = "testJSONUtilsTest1";

		try {

			JsonSchema jsonSchema = JSONUtils.convertObjectToJSONSchemaUsingJackson(ResponseType.class);
			String requestString = JSONUtils.convertObjectToJSONStringUsingJackson(jsonSchema, Boolean.TRUE);
			System.out.println("In test:'" + testName + "' JSON Schema :'" + requestString + "'");

		} catch (Exception e) {
			System.out.println("In test:'" + testName + "' received exception:" + e.toString());
			assertTrue(Boolean.FALSE);
		}

		System.out.println("Successful test:'" + testName + "'");

	}

}
