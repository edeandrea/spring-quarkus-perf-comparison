package org.acme.dto;

import java.math.BigDecimal;

public record StoreFruitPriceDTO(StoreDTO store, BigDecimal price) {
  public StoreFruitPriceDTO {
    if (price == null) {
      throw new IllegalArgumentException("Price cannot be null");
    }

    if (price.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Price must be >= 0");
    }
  }

  private StoreFruitPriceDTO(Builder builder) {
    this(builder.store, builder.price);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {
    private StoreDTO store;
    private BigDecimal price;

    private Builder() {}

    private Builder(StoreFruitPriceDTO storeFruitPriceDTO) {
      this.store = storeFruitPriceDTO.store;
      this.price = storeFruitPriceDTO.price;
    }

    public Builder store(StoreDTO store) {
      this.store = store;
      return this;
    }

    public Builder price(BigDecimal price) {
      this.price = price;
      return this;
    }

    public StoreFruitPriceDTO build() {
      return new StoreFruitPriceDTO(this);
    }
  }
}
