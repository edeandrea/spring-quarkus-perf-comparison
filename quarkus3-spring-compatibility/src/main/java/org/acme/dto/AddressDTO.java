package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
    @NotBlank(message = "Address is mandatory")
    String address,

    @NotBlank(message = "City is mandatory")
    String city,

    @NotBlank(message = "Country is mandatory")
    String country
) {
  public AddressDTO {
    if ((address == null) || address.isBlank()) {
      throw new IllegalArgumentException("Address is mandatory");
    }

    if ((city == null) || city.isBlank()) {
      throw new IllegalArgumentException("City is mandatory");
    }

    if ((country == null) || country.isBlank()) {
      throw new IllegalArgumentException("Country is mandatory");
    }
  }

  private AddressDTO(Builder builder) {
    this(builder.address, builder.city, builder.country);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {
    private String address;
    private String city;
    private String country;

    private Builder() {}

    public Builder(AddressDTO addressDTO) {
      this.address = addressDTO.address;
      this.city = addressDTO.city;
      this.country = addressDTO.country;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public AddressDTO build() {
      return new AddressDTO(this);
    }
  }
}
