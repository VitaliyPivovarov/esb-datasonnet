package com.pivovaroff.esb.routes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EndpointRoute extends RouteBuilder {

    public static final String ENDPOINT_ROUTE = "endpointRoute";

    @Override
    @Transactional
    public void configure() {

        from("activemq:queue:" + ENDPOINT_ROUTE)
                .routeId("endpointRouteId")
                .process(value -> {
                    log.info(value.getMessage().getBody().toString());
                    //some process
                })
                .end();
    }


}
