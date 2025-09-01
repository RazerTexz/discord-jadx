package com.discord.models.gifpicker.domain;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: ModelGifCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "categoryName", "gifPreviewUrl", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGifPreviewUrl", "getCategoryName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGifCategory implements Serializable {
    private final String categoryName;
    private final String gifPreviewUrl;

    public ModelGifCategory(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "categoryName");
        Intrinsics3.checkNotNullParameter(str2, "gifPreviewUrl");
        this.categoryName = str;
        this.gifPreviewUrl = str2;
    }

    public static /* synthetic */ ModelGifCategory copy$default(ModelGifCategory modelGifCategory, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelGifCategory.categoryName;
        }
        if ((i & 2) != 0) {
            str2 = modelGifCategory.gifPreviewUrl;
        }
        return modelGifCategory.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public final ModelGifCategory copy(String categoryName, String gifPreviewUrl) {
        Intrinsics3.checkNotNullParameter(categoryName, "categoryName");
        Intrinsics3.checkNotNullParameter(gifPreviewUrl, "gifPreviewUrl");
        return new ModelGifCategory(categoryName, gifPreviewUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGifCategory)) {
            return false;
        }
        ModelGifCategory modelGifCategory = (ModelGifCategory) other;
        return Intrinsics3.areEqual(this.categoryName, modelGifCategory.categoryName) && Intrinsics3.areEqual(this.gifPreviewUrl, modelGifCategory.gifPreviewUrl);
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public int hashCode() {
        String str = this.categoryName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.gifPreviewUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGifCategory(categoryName=");
        sbU.append(this.categoryName);
        sbU.append(", gifPreviewUrl=");
        return outline.J(sbU, this.gifPreviewUrl, ")");
    }
}
