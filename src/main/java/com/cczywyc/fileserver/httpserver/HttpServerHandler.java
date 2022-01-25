package com.cczywyc.fileserver.httpserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Http server handler
 *
 * @author wangyc
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /** log object */
    private Logger logger = LoggerFactory.getLogger(HttpServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

    }
}
