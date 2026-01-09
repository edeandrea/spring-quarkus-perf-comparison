package org.acme.dto;

public record StoreDTO(Long id, String name, String currency, AddressDTO address) {
  private StoreDTO(Builder builder) {
    this(builder.id, builder.name, builder.currency, builder.address);
  }

  public StoreDTO {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Name is mandatory");
    }

    if (currency == null || currency.isBlank()) {
      throw new IllegalArgumentException("Currency is mandatory");
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
    private String currency;
    private AddressDTO address;

    private Builder() {}

    private Builder(StoreDTO storeDTO) {
      this.id = storeDTO.id;
      this.name = storeDTO.name;
      this.currency = storeDTO.currency;
      this.address = storeDTO.address;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public Builder address(AddressDTO address) {
      this.address = address;
      return this;
    }

    public StoreDTO build() {
      return new StoreDTO(this);
    }
  }
}
