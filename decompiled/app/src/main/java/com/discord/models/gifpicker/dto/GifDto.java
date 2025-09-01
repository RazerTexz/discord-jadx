package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GifDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/discord/models/gifpicker/dto/GifDto;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "src", "url", "width", "height", "copy", "(Ljava/lang/String;Ljava/lang/String;II)Lcom/discord/models/gifpicker/dto/GifDto;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "Ljava/lang/String;", "getUrl", "getSrc", "getHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class GifDto {
    private final int height;
    private final String src;
    private final String url;
    private final int width;

    public GifDto(String str, String str2, int i, int i2) {
        Intrinsics3.checkNotNullParameter(str, "src");
        Intrinsics3.checkNotNullParameter(str2, "url");
        this.src = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ GifDto copy$default(GifDto gifDto, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = gifDto.src;
        }
        if ((i3 & 2) != 0) {
            str2 = gifDto.url;
        }
        if ((i3 & 4) != 0) {
            i = gifDto.width;
        }
        if ((i3 & 8) != 0) {
            i2 = gifDto.height;
        }
        return gifDto.copy(str, str2, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final GifDto copy(String src, String url, int width, int height) {
        Intrinsics3.checkNotNullParameter(src, "src");
        Intrinsics3.checkNotNullParameter(url, "url");
        return new GifDto(src, url, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifDto)) {
            return false;
        }
        GifDto gifDto = (GifDto) other;
        return Intrinsics3.areEqual(this.src, gifDto.src) && Intrinsics3.areEqual(this.url, gifDto.url) && this.width == gifDto.width && this.height == gifDto.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getSrc() {
        return this.src;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.src;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GifDto(src=");
        sbU.append(this.src);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return outline.B(sbU, this.height, ")");
    }
}
