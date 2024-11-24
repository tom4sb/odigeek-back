package com.tom4sb.odigeek.infrastructure.config;

import com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball.FeignDragonBallHttpClient;
import com.tom4sb.odigeek.infrastructure.http.feign.star_wars.FeignStarWarsHttpClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(
    clients = {
        FeignDragonBallHttpClient.class,
        FeignStarWarsHttpClient.class
    }
)
@Configuration
public class OdiGeekInfrastructureConfiguration {

}
