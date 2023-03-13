package com.pivovaroff.esb.routes;

import com.datasonnet.Mapper;
import com.pivovaroff.esb.domain.ScriptDomain;
import com.pivovaroff.esb.repo.ScriptRepository;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.pivovaroff.esb.routes.EndpointRoute.ENDPOINT_ROUTE;

@Service
@RequiredArgsConstructor
public class StepRoute extends RouteBuilder {

    public static final String STEP_ROUTE = "stepRoute";
    private final ScriptRepository scriptRepository;
    private ScriptDomain scriptDomain;

    @PostConstruct
    public void init() {
        scriptDomain = scriptRepository.getByName("XML_TO_JSON");
    }

    @Override
    public void configure() {

        from("activemq:queue:" + STEP_ROUTE)
                .routeId("stepRouteId")
                .process(message -> {
                    Mapper mapper = new Mapper(scriptDomain.getBody());
                    String transformed = mapper.transform(message.getMessage().getBody(String.class));
                    message.getMessage().setBody(transformed);
                })
                .to("activemq:queue:" + ENDPOINT_ROUTE);

    }

}
