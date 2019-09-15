package com.cleancoder.myexpenses.db.entities;

import android.arch.persistence.room.Embedded;

public class RecordWithEntities {

    @Embedded
    public Record record;

    @Embedded(prefix = "acc")
    public Account account;

    @Embedded(prefix = "subcat")
    public SubCategory subCategory;
}
