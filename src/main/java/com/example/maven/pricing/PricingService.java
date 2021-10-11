package com.example.maven.pricing;

import java.math.BigDecimal;

public class PricingService {

  private final ProductVerifier productVerifier;
  private final PriceReporter priceReporter;

  public PricingService(ProductVerifier productVerifier, PriceReporter priceReporter) {
    this.productVerifier = productVerifier;
    this.priceReporter = priceReporter;
  }

  public BigDecimal calculatePrice(String productName) {
    if (productVerifier.isCurrentlyInStockOfCompetitor(productName)) {
      priceReporter.notify(productName);
      return new BigDecimal("99.99");
    }

    return new BigDecimal("149.99");
  }
}
