package com.project.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass(){
        httpParser = new HttpParser();
    }

    @Test
    void parseHttpRequest(){
        httpParser.parseHttpRequest(
                generateTestCase()
        );
    }

    private InputStream generateTestCase(){
        String lineBreak = "\r\n";
        String rawData = "GET / HTTP/1.1" + lineBreak +
                "Host: localhost:8081" + lineBreak +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:152.0) Gecko/20100101 Firefox/152.0" + lineBreak +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + lineBreak +
                "Accept-Language: en-US,en;q=0.9" + lineBreak +
                "Accept-Encoding: gzip, deflate, br, zstd" + lineBreak +
                "Connection: keep-alive" + lineBreak +
                "Upgrade-Insecure-Requests: 1" + lineBreak +
                "Sec-Fetch-Dest: document" + lineBreak +
                "Sec-Fetch-Mode: navigate" + lineBreak +
                "Sec-Fetch-Site: none" + lineBreak +
                "Sec-Fetch-User: ?1" + lineBreak +
                "Priority: u=0, i" + lineBreak;
        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(
                        StandardCharsets.US_ASCII
                )
        );
        return inputStream;
    }
}