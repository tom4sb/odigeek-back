package com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball.response.DragonBallCharacter;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    value = "dragonBallHttpClient",
    url = "https://dragonball-api.com/api" // TODO move to config file
)
public interface FeignDragonBallHttpClient {

  @GetMapping(
      value = "/characters",
      produces = APPLICATION_JSON_VALUE,
      consumes = APPLICATION_JSON_VALUE
  )
  List<DragonBallCharacter> load(@RequestParam(value = "race") String race);

}
