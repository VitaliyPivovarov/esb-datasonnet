package com.pivovaroff.esb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import static com.pivovaroff.esb.routes.StepRoute.STEP_ROUTE;

@Service
public class InputRoute extends RouteBuilder {

    public static final String INPUT_ROUTE = "inputRoute";

    @Override
    public void configure() {

        from("activemq:queue:" + INPUT_ROUTE)
                .routeId("inputRouteId")
                .to("activemq:queue:" + STEP_ROUTE);

    }

}
