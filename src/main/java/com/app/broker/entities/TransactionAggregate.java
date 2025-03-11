package com.app.broker.entities;

import com.app.broker.valueObject.AssetDetails;

public record TransactionAggregate(Transaction transaction, AssetDetails assetDetails) {

}
