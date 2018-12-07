package com.xsc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * http请求工具类
 * @author xusc
 *
 */
public class HttpUtils {

	private static final Logger logger = Logger.getLogger(HttpUtils.class);
	/*
	 * 是否使用代理
	 */
	private static boolean isProxy = false;
	
	/**
	 * post请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String post(String url,Map<String, String> paramMap) throws IOException{
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		post.setConfig(config);
		if (paramMap!=null) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				params.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		}
		CloseableHttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	
	/**
	 * post请求
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */
	public static String post(String url,String body) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		post.setConfig(config);
		if (body!=null) {
		    post.setEntity(new StringEntity(body,StandardCharsets.UTF_8));  
		}
		CloseableHttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	/**
	 * get请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String get(String url,Map<String, String> paramMap) throws IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String queryStr = "";
		if (paramMap!=null) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				params.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		}
		HttpGet get = new HttpGet(url+(StringUtils.isBlank(queryStr)?"":("?"+ queryStr)));
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		get.setConfig(config);
		CloseableHttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		EntityUtils.consume(entity);
		return content;
	}
	
	/**
	 * 文件上传
	 * 
	 * @param url
	 * @param paramMap
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String uploadFile(String url,Map<String, String> paramMap,String partName,File file) throws IOException{
		logger.info(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
		post.setConfig(config);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		if (paramMap!=null) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				StringBody param = new StringBody(paramMap.get(key), ContentType.create("text/plain", StandardCharsets.UTF_8));
	            builder.addPart(key, param);
			}
		}
		FileBody fileBody = new FileBody(file, ContentType.create("multipart/form-data", StandardCharsets.UTF_8));
		builder.addPart(partName, fileBody);
		post.setEntity(builder.build());
		CloseableHttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		//logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	/**
	 * 下载
	 * 
	 * @param url
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String download(String url,String filePath) throws IOException{
		logger.info(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response;
		response = httpclient.execute(get);
		Header header = response.getFirstHeader("Content-disposition");
		HttpEntity entity = response.getEntity();
		if (header==null) {
			String content = EntityUtils.toString(entity);
		}else {
			
			String fileName=getName(header);
			File file = new File(filePath+fileName);  
            FileOutputStream outputStream = new FileOutputStream(file);  
              
            InputStream inputStream = entity.getContent();  
              
            byte buff[] = new byte[4096];  
            int counts = 0;  
            while ((counts = inputStream.read(buff)) != -1) {  
                outputStream.write(buff, 0, counts);  
            }  
            outputStream.flush();  
            outputStream.close(); 
            return fileName;
		}
		EntityUtils.consume(entity);
		return null;
	}
	
	
	public static String download135(String url,String filePath) throws IOException{
		logger.info(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response;
		response = httpclient.execute(get);
		HttpEntity entity = response.getEntity();
		String fileName="";
		fileName=getName(url);
		if (fileName.length()>24) {
			fileName=getName1();
		}
		File file = new File(filePath+fileName);  
        FileOutputStream outputStream = new FileOutputStream(file);  
          
        InputStream inputStream = entity.getContent();  
          
        byte buff[] = new byte[4096];  
        int counts = 0;  
        while ((counts = inputStream.read(buff)) != -1) {  
            outputStream.write(buff, 0, counts);  
        }  
        outputStream.flush();  
        outputStream.close(); 
        EntityUtils.consume(entity);
        return fileName;
	}
	
	
	/**
	 * 依据原始文件名生成新文件名
	 * @return
	 */
	private static String getName(Header header) {
		
		String value = header.getValue();
		String ext = value.substring(value.lastIndexOf("."), value.length());
		Random random = new Random();
		return "" + random.nextInt(10000) + System.currentTimeMillis() + ext;
	}
	
	private static String getName(String url) {
		
		String ext = url.substring(url.lastIndexOf("."), url.length());
		Random random = new Random();
		return "" + random.nextInt(10000) + System.currentTimeMillis() + ext;
	}
	private static String getName1() {
		
		Random random = new Random();
		return "" + random.nextInt(10000) + System.currentTimeMillis() + ".jpg";
	}
	
	/**
	 * 依据原始文件名生成新文件名
	 * @return
	 */
	private static String getName1(Header header) {
		
		String value = header.getValue();
		String ext = value.substring(value.lastIndexOf("."), value.length()-1);
		Random random = new Random();
		return "" + random.nextInt(10000) + System.currentTimeMillis() + ext;
	}
	
	
	/**
	 * get请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	public static String getProxy(String url,Map<String, String> paramMap) throws IOException{
		//logger.info(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String queryStr = "";
		if (paramMap!=null) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				params.add(new BasicNameValuePair(key, paramMap.get(key)));
			}
			queryStr = EntityUtils.toString(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		}
		HttpGet get = new HttpGet(url+(StringUtils.isBlank(queryStr)?"":("?"+ queryStr)));
		
		if (isProxy) {
			Properties pro = new Properties();
			InputStream input = HttpUtils.class.getClassLoader().getResourceAsStream("proxy.properties");
			pro.load(input);
			input.close();
			HttpHost proxy=new HttpHost(pro.getProperty("proxyHost"), Integer.parseInt(pro.getProperty("proxyPort")));
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).setProxy(proxy).build();
			get.setConfig(config);
		}else {
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
			get.setConfig(config);
		}
		CloseableHttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		//logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	/**
	 * post请求
	 * 
	 * @param url
	 * @param body
	 * @return
	 * @throws IOException
	 */
	public static String postProxy(String url,String body) throws IOException{
		//logger.info(url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		if (isProxy) {
			Properties pro = new Properties();
			InputStream input = HttpUtils.class.getClassLoader().getResourceAsStream("proxy.properties");
			pro.load(input);
			input.close();
			HttpHost proxy=new HttpHost(pro.getProperty("proxyHost"), Integer.parseInt(pro.getProperty("proxyPort")));
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).setProxy(proxy).build();
			post.setConfig(config);
		}else {
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
			post.setConfig(config);
		}
		
		if (body!=null) {
		    post.setEntity(new StringEntity(body,StandardCharsets.UTF_8));  
		}
		CloseableHttpResponse response = httpClient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		//logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	
	/**
	 * 文件上传
	 * 
	 * @param url
	 * @param paramMap
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String uploadFileProxy(String url,Map<String, String> paramMap,String partName,File file) throws IOException{
		logger.info(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		if (isProxy) {
			Properties pro = new Properties();
			InputStream input = HttpUtils.class.getClassLoader().getResourceAsStream("proxy.properties");
			pro.load(input);
			input.close();
			HttpHost proxy=new HttpHost(pro.getProperty("proxyHost"), Integer.parseInt(pro.getProperty("proxyPort")));
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).setProxy(proxy).build();
			post.setConfig(config);
		}else {
			RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(30000).setConnectTimeout(30000).setSocketTimeout(30000).build();
			post.setConfig(config);
		}
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		//others param for request
		if (paramMap!=null) {
			Set<String> keySet = paramMap.keySet();
			for (String key : keySet) {
				StringBody param = new StringBody(paramMap.get(key), ContentType.create("text/plain", StandardCharsets.UTF_8));
	            builder.addPart(key, param);
			}
		}
		FileBody fileBody = new FileBody(file, ContentType.create("multipart/form-data", StandardCharsets.UTF_8));
		builder.addPart(partName, fileBody);
		post.setEntity(builder.build());
		CloseableHttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity,StandardCharsets.UTF_8);
		//logger.info("content:" + content);
		EntityUtils.consume(entity);
		return content;
	}
	
	
	/**
	 * 下载
	 * 
	 * @param url
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String downloadProxy(String url,String filePath) throws IOException{
		logger.info(url);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		File dir = new File(filePath);
		logger.info(filePath+"路径");
		judeDirExists(dir);
		
		if (isProxy) {
			Properties pro = new Properties();
			InputStream input = HttpUtils.class.getClassLoader().getResourceAsStream("proxy.properties");
			pro.load(input);
			input.close();
			HttpHost proxy=new HttpHost(pro.getProperty("proxyHost"), Integer.parseInt(pro.getProperty("proxyPort")));
			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			get.setConfig(config);
		}
		logger.info("通过代理");
		CloseableHttpResponse response;
		response = httpclient.execute(get);
		Header header = response.getFirstHeader("Content-disposition");
		HttpEntity entity = response.getEntity();
		if (header==null) {
			String content = EntityUtils.toString(entity);
			logger.info("未找到headercontent:" + content);
		}else {
			String fileName=getName1(header);
			File file = new File(filePath+fileName);  
            FileOutputStream outputStream = new FileOutputStream(file);  
            logger.info("insertfile"); 
            InputStream inputStream = entity.getContent();  
            byte buff[] = new byte[4096];  
            int counts = 0;  
            while ((counts = inputStream.read(buff)) != -1) {  
                outputStream.write(buff, 0, counts);  
            }  
            outputStream.flush();  
            outputStream.close(); 
            return fileName;
		}
		EntityUtils.consume(entity);
		return null;
	}
	
	 public static void judeDirExists(File file) {
        if (file.exists()) {
              logger.info("存在");
         }else {
        	  logger.info("dir not exists, create it ...");
              file.mkdir();
          }
  
      }
}
