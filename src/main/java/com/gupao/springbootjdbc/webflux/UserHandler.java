package com.gupao.springbootjdbc.webflux;

import com.gupao.springbootjdbc.domain.MyUser;
import com.gupao.springbootjdbc.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        //在 spring web mvc 当中使用  @RequestBody
        //在 spring web flux 使用  ServletRequest
       //Mono<MyUser>  类似于  Optional<MyUser>
        Mono<MyUser>userMono = serverRequest.bodyToMono( MyUser.class );
        //map相当于转化工作
        Mono<Boolean>booleanMono = userMono.map( userRepository::save );
        return ServerResponse.ok().body( booleanMono,Boolean.class );

    }


}
