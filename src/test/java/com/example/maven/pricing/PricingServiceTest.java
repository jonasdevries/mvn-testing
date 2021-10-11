package com.example.maven.pricing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class PricingServiceTest {

    @Mock
    ProductVerifier productVerifier;

    @Mock
    PriceReporter priceReporter;

    @Test
    public void given_when_then() {

        // given
        PricingService cut = new PricingService(productVerifier, priceReporter);

        // when
        Mockito.when(productVerifier.isCurrentlyInStockOfCompetitor("melk")).thenReturn(true);
        BigDecimal price = cut.calculatePrice("melk");

        // then
        Assertions.assertEquals(BigDecimal.valueOf(99.99), price);
        Mockito.verify(priceReporter).notify("melk");
    }

}
