package com.app.broker.entities;

import com.app.broker.valueObject.AssetDetails;
import lombok.Getter;

public record TransactionAggregate(Transaction transaction, AssetDetails assetDetails) {

}
