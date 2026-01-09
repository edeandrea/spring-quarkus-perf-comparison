package org.acme.mapping;

import org.acme.domain.StoreFruitPrice;
import org.acme.dto.StoreFruitPriceDTO;

public final class StoreFruitPriceMapper {
  private StoreFruitPriceMapper() {}

  public static StoreFruitPriceDTO map(StoreFruitPrice storeFruitPrice) {
    if (storeFruitPrice == null) {
      return null;
    }

    return StoreFruitPriceDTO.builder()
        .store(StoreMapper.map(storeFruitPrice.getStore()))
        .price(storeFruitPrice.getPrice())
        .build();
  }
}
