package com.cczywyc.fileserver.response;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * response handler
 *
 * @author wangyc
 */
public class ResponseHandler {

    /** log object */
    private Logger logger = LoggerFactory.getLogger(ResponseHandler.class);
    /** http object */
    private HttpObject httpObject;

    public ResponseHandler(HttpObject httpObject) {
        this.httpObject = httpObject;
    }

    /**
     * structure response
     *
     * @return response
     * @throws URISyntaxException ex
     */
    public HttpResponse handResponse() throws URISyntaxException {
        DefaultFullHttpResponse httpResponse = null;
        if (httpObject instanceof HttpRequest httpRequest) {
            ByteBuf content = getContent(httpRequest);
            httpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            httpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

        }
        return httpResponse;
    }

    /**
     * get content
     *
     * @param httpRequest http request
     * @return ByteBuf content
     * @throws URISyntaxException ex
     */
    private ByteBuf getContent(HttpRequest httpRequest) throws URISyntaxException {
        URI uri = new URI(httpRequest.uri());
        return Unpooled.copiedBuffer("Hello, This is file list", CharsetUtil.UTF_8);
    }
}
