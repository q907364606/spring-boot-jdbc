package com.gupao.springbootjdbc.webflux;


import com.gupao.springbootjdbc.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


/**
 * webFlux的配置
 */
@Configuration
public class WebFluxConfiguration {


    //UserRepository userRepository
    @Bean
    public RouterFunction<ServerResponse> saveUser( UserHandler userHandler ) {

        return route( POST("/web/flux/user/save"),userHandler::save  );
        //return route( POST("/web/flux/user/save",userHandler::save ) );

    }

}
