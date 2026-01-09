package org.acme.mapping;

import org.acme.domain.Address;
import org.acme.dto.AddressDTO;

public final class AddressMapper {
  private AddressMapper() {}

  public static AddressDTO map(Address address) {
    if (address == null) {
      return null;
    }

    return AddressDTO.builder()
        .address(address.address())
        .city(address.city())
        .country(address.country())
        .build();
  }

  public static Address map(AddressDTO addressDTO) {
    return (addressDTO != null) ?
        new Address(addressDTO.address(), addressDTO.city(), addressDTO.country()) :
        null;
  }
}
