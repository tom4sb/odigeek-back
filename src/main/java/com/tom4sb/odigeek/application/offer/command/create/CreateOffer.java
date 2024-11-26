package com.tom4sb.odigeek.application.offer.command.create;

import com.tom4sb.odigeek.domain.shared.messaging.Command;

public final class CreateOffer
    extends Command {

  private final String title;
  private final String description;
  private final Double ruleMultiplier;
  private final String ruleCurrency;
  private final String scope;
  private final String scopeTitle;
  private final String scopeCategory;
  private final String periodStart;
  private final String periodEnd;

  public CreateOffer(
      final String title,
      final String description,
      final Double ruleMultiplier,
      final String ruleCurrency,
      final String scope,
      final String scopeTitle,
      final String scopeCategory,
      final String periodStart,
      final String periodEnd
  ) {
    this.title = title;
    this.description = description;
    this.ruleMultiplier = ruleMultiplier;
    this.ruleCurrency = ruleCurrency;
    this.scope = scope;
    this.scopeTitle = scopeTitle;
    this.scopeCategory = scopeCategory;
    this.periodStart = periodStart;
    this.periodEnd = periodEnd;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public Double getRuleMultiplier() {
    return ruleMultiplier;
  }

  public String getRuleCurrency() {
    return ruleCurrency;
  }

  public String getScope() {
    return scope;
  }

  public String getScopeTitle() {
    return scopeTitle;
  }

  public String getScopeCategory() {
    return scopeCategory;
  }

  public String getPeriodStart() {
    return periodStart;
  }

  public String getPeriodEnd() {
    return periodEnd;
  }

}
