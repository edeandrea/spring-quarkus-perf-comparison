package org.acme.mapping;

import org.acme.domain.Store;
import org.acme.dto.StoreDTO;

public final class StoreMapper {
  private StoreMapper() {}

  public static StoreDTO map(Store store) {
    if (store == null) {
      return null;
    }

    return StoreDTO.builder()
        .address(AddressMapper.map(store.getAddress()))
        .id(store.getId())
        .name(store.getName())
        .currency(store.getCurrency())
        .build();
  }

  public static Store map(StoreDTO storeDTO) {
    return (storeDTO != null) ?
        new Store(null, storeDTO.name(), AddressMapper.map(storeDTO.address()), storeDTO.currency()) :
        null;
  }
}
