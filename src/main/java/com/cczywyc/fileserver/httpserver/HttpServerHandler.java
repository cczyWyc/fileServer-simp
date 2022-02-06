package com.cczywyc.fileserver.httpserver;

import com.cczywyc.fileserver.response.ResponseHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * Http server handler
 *
 * @author wangyc
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /** log object */
    private Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
        logger.info("get msg from the remote, the client address is:" + ctx.channel().remoteAddress());
        ResponseHandler handler = new ResponseHandler(msg);
        HttpResponse httpResponse = null;
        try {
            httpResponse = handler.handResponse();
        } catch (URISyntaxException e) {
            logger.error("URISyntax Error", e);
        }
        ctx.writeAndFlush(httpResponse);
    }
}
