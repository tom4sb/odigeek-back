package com.tom4sb.odigeek.application.subscription.command.create;

import com.tom4sb.odigeek.application.offer.command.create.CreateOfferHandler;
import com.tom4sb.odigeek.application.shared.messaging.CommandHandler;
import com.tom4sb.odigeek.domain.shared.model.SubscriptionCategoryValue;
import com.tom4sb.odigeek.domain.subscription.exception.SubscriptionTitleAlreadyExistWithinCategory;
import com.tom4sb.odigeek.domain.subscription.model.Subscription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionCategories;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionContent;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDataLoader;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionDescription;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionId;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionPrice;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionStatus;
import com.tom4sb.odigeek.domain.subscription.model.SubscriptionTitle;
import com.tom4sb.odigeek.domain.subscription.model.Subscriptions;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public final class CreateSubscriptionHandler
    implements CommandHandler<CreateSubscription> {

  private static final Logger log = LoggerFactory.getLogger(CreateSubscriptionHandler.class);
  private final SubscriptionDataLoader subscriptionDataLoader;
  private final Subscriptions subscriptions;

  public CreateSubscriptionHandler(
      final SubscriptionDataLoader subscriptionDataLoader,
      final Subscriptions subscriptions
  ) {
    this.subscriptionDataLoader = subscriptionDataLoader;
    this.subscriptions = subscriptions;
  }

  @Override
  public void handle(final CreateSubscription command) {
    validateTitleWithinCategory(command);

    final var id = new SubscriptionId(command.getId());
    final var title = new SubscriptionTitle(command.getTitle());
    final var categories = new SubscriptionCategories(command.getCategories());
    final var price = new SubscriptionPrice(command.getPriceAmount(), command.getPriceCurrency());
    final var description = new SubscriptionDescription(command.getDescription());
    final var status = new SubscriptionStatus(command.getActive());
    final var content = buildContent(title);

    final var subscription = Subscription.create(
        id,
        title,
        categories,
        price,
        description,
        content,
        status
    );

    subscriptions.save(subscription);

    log.info("Subscription saved! {}", subscription.toStringForLog());
  }

  private void validateTitleWithinCategory(final CreateSubscription command) {
    if (command.getCategories().stream()
        .map(SubscriptionCategoryValue::valueOf)
        .flatMap(category -> subscriptions.findByCategory(category).stream())
        .anyMatch(subscription -> subscription.getTitle().getValue().name().equals(command.getTitle()))) {
      throw new SubscriptionTitleAlreadyExistWithinCategory();
    }
  }

  private SubscriptionContent buildContent(final SubscriptionTitle title) {
    final var apiTurnedOffDays = List.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
    final var isApiWorking = !apiTurnedOffDays.contains(LocalDate.now().getDayOfWeek());
    if (isApiWorking) {
      return subscriptionDataLoader.load(title);
    }

    return subscriptions.findByTitle(title)
        .map(Subscription::getContent)
        .orElseThrow(() -> new IllegalArgumentException("Subscription unavailable"));
  }

}
