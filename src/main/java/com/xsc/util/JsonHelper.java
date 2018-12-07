package com.xsc.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.xsc.exception.InvokeExceptionMapper;

public class JsonHelper {

	public static ObjectMapper objectMapper;

	/**
	 * function:Convert object to JSON string
	 * 
	 * @param object
	 *            instance
	 */
	public static String beanToJson(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		String jsonStr = "";

		try {
			jsonStr = objectMapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonStr;
	}

	/**
	 * function:Convert JSON string to Object
	 * 
	 * @param jsonStr
	 *            string
	 * @param use
	 *            entity instance.class
	 */
	public static <T> T jsonToBean(String jsonStr, Class<T> objClass) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(jsonStr, objClass);
		} catch (IOException e) {
			 e.printStackTrace();
			 return null;
			//throw new InvokeExceptionMapper(e);
		}
		
	}

	/**
	 * function:json数组转List
	 * 
	 * @param jsonStr
	 *            string
	 * @param use
	 *            new TypeReference<List<JavaBean>>(){}
	 */
	public static <T> T jsonToBean(String jsonStr, TypeReference<T> valueTypeRef) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(jsonStr, valueTypeRef);
		} catch (Exception e) {
			throw new InvokeExceptionMapper(e);
		}

	}

	/**
	 * function:json数组转List
	 * 
	 * @param jsonStr
	 *            string
	 * @param nodeName
	 *            节点名
	 * @param use
	 *            new TypeReference<List<JavaBean>>(){}
	 */
	public static <T> T jsonToBean(String jsonStr, String nodeName,
			TypeReference<T> valueTypeRef) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			JsonNode jsonNode = objectMapper.readTree(jsonStr);
			JsonNode jn = jsonNode.get(nodeName);
			String json = objectMapper.writeValueAsString(jn);
			return objectMapper.readValue(json, valueTypeRef);
		} catch (Exception e) {
			
			throw new InvokeExceptionMapper(e);
		}

	}

	/**
	 * function:获取单个Json节点片段
	 * 
	 * @param json
	 *            string
	 * @param example
	 *            :A:[{"CityId":18,B:[{"CityName":"西安"}]}],nodeName=A or B
	 */
	public static JsonNode getJsonNode(String json, String nodeName) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		JsonNode jn = null;
		try {
			JsonNode jsonNode = objectMapper.readTree(json);
			jn = jsonNode.get(nodeName);
		} catch (IOException e) {
			throw new InvokeExceptionMapper(e);
		}
		return jn;
	}
}
