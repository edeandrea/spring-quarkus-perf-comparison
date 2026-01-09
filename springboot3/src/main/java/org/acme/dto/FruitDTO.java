package org.acme.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;

public record FruitDTO(Long id, @NotBlank(message = "Name is mandatory") String name, String description, List<StoreFruitPriceDTO> storePrices) {
  private FruitDTO(Builder builder) {
    this(builder.id, builder.name, builder.description, builder.storePrices);
  }

  public FruitDTO {
    if (name == null) {
      throw new IllegalArgumentException("Name is mandatory");
    }

    if (storePrices == null) {
      storePrices = new ArrayList<>();
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {
    private Long id;
    private String name;
    private String description;
    private List<StoreFruitPriceDTO> storePrices = new ArrayList<>();

    private Builder() {}

    private Builder(FruitDTO fruitDTO) {
      this.id = fruitDTO.id;
      this.name = fruitDTO.name;
      this.description = fruitDTO.description;
      this.storePrices.addAll(fruitDTO.storePrices);
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder storePrice(StoreFruitPriceDTO storePrice) {
      this.storePrices.add(storePrice);
      return this;
    }

    public Builder storePrices(List<StoreFruitPriceDTO> storePrices) {
      this.storePrices.clear();

      if (storePrices != null) {
        this.storePrices.addAll(storePrices);
      }

      return this;
    }

    public FruitDTO build() {
      return new FruitDTO(this);
    }
  }
}
