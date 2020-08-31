package com.sign.configuration;

import com.sign.bean.User;
import com.sign.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

@Configuration
public class WebFluxConfiguration {

    @Bean
    public RouterFunction<ServerResponse> responseRouterFunctionUsers(UserRepository userRepository) {
        Collection<User> all = userRepository.findAll();
        Flux<User> users = Flux.fromIterable(all);
        return RouterFunctions.route(RequestPredicates.path("/users"), serverRequest -> ServerResponse.ok().body(users, User.class));
    }
}
