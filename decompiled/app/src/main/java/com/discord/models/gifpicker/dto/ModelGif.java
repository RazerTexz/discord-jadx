package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelGif.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001b\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/discord/models/gifpicker/dto/ModelGif;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "gifImageUrl", "tenorGifUrl", "width", "height", "copy", "(Ljava/lang/String;Ljava/lang/String;II)Lcom/discord/models/gifpicker/dto/ModelGif;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGifImageUrl", "I", "getHeight", "getTenorGifUrl", "getWidth", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "Companion", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class ModelGif {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String gifImageUrl;
    private final int height;
    private final String tenorGifUrl;
    private final int width;

    /* compiled from: ModelGif.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/gifpicker/dto/ModelGif$Companion;", "", "Lcom/discord/models/gifpicker/dto/GifDto;", "gifDto", "Lcom/discord/models/gifpicker/dto/ModelGif;", "createFromGifDto", "(Lcom/discord/models/gifpicker/dto/GifDto;)Lcom/discord/models/gifpicker/dto/ModelGif;", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ModelGif createFromGifDto(GifDto gifDto) {
            Intrinsics3.checkNotNullParameter(gifDto, "gifDto");
            return new ModelGif(gifDto.getSrc(), gifDto.getUrl(), gifDto.getWidth(), gifDto.getHeight());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelGif(String str, String str2, int i, int i2) {
        Intrinsics3.checkNotNullParameter(str, "gifImageUrl");
        Intrinsics3.checkNotNullParameter(str2, "tenorGifUrl");
        this.gifImageUrl = str;
        this.tenorGifUrl = str2;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ ModelGif copy$default(ModelGif modelGif, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = modelGif.gifImageUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = modelGif.tenorGifUrl;
        }
        if ((i3 & 4) != 0) {
            i = modelGif.width;
        }
        if ((i3 & 8) != 0) {
            i2 = modelGif.height;
        }
        return modelGif.copy(str, str2, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGifImageUrl() {
        return this.gifImageUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTenorGifUrl() {
        return this.tenorGifUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final ModelGif copy(String gifImageUrl, String tenorGifUrl, int width, int height) {
        Intrinsics3.checkNotNullParameter(gifImageUrl, "gifImageUrl");
        Intrinsics3.checkNotNullParameter(tenorGifUrl, "tenorGifUrl");
        return new ModelGif(gifImageUrl, tenorGifUrl, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGif)) {
            return false;
        }
        ModelGif modelGif = (ModelGif) other;
        return Intrinsics3.areEqual(this.gifImageUrl, modelGif.gifImageUrl) && Intrinsics3.areEqual(this.tenorGifUrl, modelGif.tenorGifUrl) && this.width == modelGif.width && this.height == modelGif.height;
    }

    public final String getGifImageUrl() {
        return this.gifImageUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTenorGifUrl() {
        return this.tenorGifUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.gifImageUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tenorGifUrl;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGif(gifImageUrl=");
        sbU.append(this.gifImageUrl);
        sbU.append(", tenorGifUrl=");
        sbU.append(this.tenorGifUrl);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.B(sbU, this.height, ")");
    }
}
