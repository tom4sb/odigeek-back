package com.tom4sb.odigeek.infrastructure.domain.subscription;

import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.ContentFamily.DATA;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.ContentFamily.FIGURES;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.HUMANS;
import static com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption.SAIYANS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent.SubscriptionContentInfo;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle.SubscriptionTitleValue.SupplierOption;
import com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball.FeignDragonBallHttpClient;
import com.tom4sb.odigeek.infrastructure.http.feign.dragon_ball.response.DragonBallCharacter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class DragonBallSupplierDataLoader
    implements SupplierDataLoader {

  private static final Map<SupplierOption, String> characterRaceOptions = Map.of(
      HUMANS, "Human",
      SAIYANS, "Saiyan"
  );
  private final FeignDragonBallHttpClient httpClient;

  public DragonBallSupplierDataLoader(final FeignDragonBallHttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public SubscriptionContent load(final SubscriptionTitle title) {
    return parseToContent(httpClient.load(getCharacterRaceOption(title)));
  }

  public SubscriptionContent parseToContent(final List<DragonBallCharacter> characters) {
    return new SubscriptionContent(
        Map.of(
            DATA, buildDataContentInfo(characters),
            FIGURES, buildFiguresContentInfo()
        )
    );
  }

  private List<SubscriptionContentInfo> buildDataContentInfo(
      final List<DragonBallCharacter> characters
  ) {
    final var objectMapper = new ObjectMapper();
    return characters.stream()
        .map(character -> character.parseToContentInfo(objectMapper))
        .toList();
  }

  private List<SubscriptionContentInfo> buildFiguresContentInfo() {
    return Collections.emptyList(); // TODO maybe add some random data
  }

  private String getCharacterRaceOption(final SubscriptionTitle title) {
    return characterRaceOptions.get(title.getValue().getSupplierOption());
  }

}
