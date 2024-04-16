package com.backend.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import javax.annotation.PostConstruct;

/**
 * @ClassDescription: RestTemplate请求调用工具类（同服务、跨服务）
 * 注：参数中的类型最好与被调用请求url的返回体类型一致
 * @Author：李白
 * @Date：2023/3/31 17:32
 */
@Component
public class RestTemplateUtil {
    private static final String HEADER_NAME = "Content-Type";
    private static final String HEADER_VALUE = "application/json";
    private static final String RESPONSE_BODY = "responseBody";
    @Autowired
    private RestTemplate restTemplate;
    private static RestTemplate rtl;
    @PostConstruct
    public void initTemplate(){
        rtl = restTemplate;
    }
    public static <T, R> R post(String url, T requestJson, Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> httpEntity = new HttpEntity<>(requestJson, headers);
        ResponseEntity<R> responseEntity = rtl.postForEntity(url, httpEntity, responseType);
        return responseEntity.getBody();
    }

    public static <T> T postMultipartFile(String url, MultiValueMap<String, Object> body, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_NAME, MediaType.MULTIPART_FORM_DATA_VALUE);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(body, headers);
        ResponseEntity<T> responseEntity = rtl.postForEntity(url, httpEntity, responseType);
        return responseEntity.getBody();
    }

    public static <T> T get(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<T> responseEntity = rtl.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), responseType);
        return responseEntity.getBody();
    }
    public static <T> T delete(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<T> responseEntity = rtl.exchange(url, HttpMethod.DELETE, new HttpEntity<>(headers), responseType);
        return responseEntity.getBody();
    }
    public static <T, R> R put(String url, T requestJson, Class<R> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T> httpEntity = new HttpEntity<>(requestJson, headers);
        ResponseEntity<R> responseEntity = rtl.exchange(url,HttpMethod.PUT,httpEntity, responseType);
        return responseEntity.getBody();
    }
}