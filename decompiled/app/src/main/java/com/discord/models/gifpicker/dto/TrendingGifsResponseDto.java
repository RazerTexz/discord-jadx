package com.discord.models.gifpicker.dto;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: TrendingGifsResponseDto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J0\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0005R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/discord/models/gifpicker/dto/TrendingGifsResponseDto;", "", "", "Lcom/discord/models/gifpicker/dto/GifCategoryDto;", "component1", "()Ljava/util/List;", "Lcom/discord/models/gifpicker/dto/TrendingGifPreviewDto;", "component2", "categories", "gifs", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/discord/models/gifpicker/dto/TrendingGifsResponseDto;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCategories", "getGifs", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class TrendingGifsResponseDto {
    private final List<GifCategoryDto> categories;
    private final List<TrendingGifPreviewDto> gifs;

    public TrendingGifsResponseDto(List<GifCategoryDto> list, List<TrendingGifPreviewDto> list2) {
        Intrinsics3.checkNotNullParameter(list, "categories");
        Intrinsics3.checkNotNullParameter(list2, "gifs");
        this.categories = list;
        this.gifs = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrendingGifsResponseDto copy$default(TrendingGifsResponseDto trendingGifsResponseDto, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = trendingGifsResponseDto.categories;
        }
        if ((i & 2) != 0) {
            list2 = trendingGifsResponseDto.gifs;
        }
        return trendingGifsResponseDto.copy(list, list2);
    }

    public final List<GifCategoryDto> component1() {
        return this.categories;
    }

    public final List<TrendingGifPreviewDto> component2() {
        return this.gifs;
    }

    public final TrendingGifsResponseDto copy(List<GifCategoryDto> categories, List<TrendingGifPreviewDto> gifs) {
        Intrinsics3.checkNotNullParameter(categories, "categories");
        Intrinsics3.checkNotNullParameter(gifs, "gifs");
        return new TrendingGifsResponseDto(categories, gifs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrendingGifsResponseDto)) {
            return false;
        }
        TrendingGifsResponseDto trendingGifsResponseDto = (TrendingGifsResponseDto) other;
        return Intrinsics3.areEqual(this.categories, trendingGifsResponseDto.categories) && Intrinsics3.areEqual(this.gifs, trendingGifsResponseDto.gifs);
    }

    public final List<GifCategoryDto> getCategories() {
        return this.categories;
    }

    public final List<TrendingGifPreviewDto> getGifs() {
        return this.gifs;
    }

    public int hashCode() {
        List<GifCategoryDto> list = this.categories;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<TrendingGifPreviewDto> list2 = this.gifs;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrendingGifsResponseDto(categories=");
        sbU.append(this.categories);
        sbU.append(", gifs=");
        return outline.L(sbU, this.gifs, ")");
    }
}
