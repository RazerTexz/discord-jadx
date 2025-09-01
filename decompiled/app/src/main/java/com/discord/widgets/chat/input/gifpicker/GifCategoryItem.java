package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.outline;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifCategoryItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\n\u000bB\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "Ljava/io/Serializable;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "()V", "Standard", "Trending", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Standard;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Trending;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GifCategoryItem implements DiffKeyProvider, Serializable {
    private final String key;

    /* compiled from: GifCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Standard;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "component1", "()Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "gifCategory", "copy", "(Lcom/discord/models/gifpicker/domain/ModelGifCategory;)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Standard;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/gifpicker/domain/ModelGifCategory;", "getGifCategory", "<init>", "(Lcom/discord/models/gifpicker/domain/ModelGifCategory;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Standard extends GifCategoryItem {
        private final ModelGifCategory gifCategory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Standard(ModelGifCategory modelGifCategory) {
            super(null);
            Intrinsics3.checkNotNullParameter(modelGifCategory, "gifCategory");
            this.gifCategory = modelGifCategory;
        }

        public static /* synthetic */ Standard copy$default(Standard standard, ModelGifCategory modelGifCategory, int i, Object obj) {
            if ((i & 1) != 0) {
                modelGifCategory = standard.gifCategory;
            }
            return standard.copy(modelGifCategory);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelGifCategory getGifCategory() {
            return this.gifCategory;
        }

        public final Standard copy(ModelGifCategory gifCategory) {
            Intrinsics3.checkNotNullParameter(gifCategory, "gifCategory");
            return new Standard(gifCategory);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Standard) && Intrinsics3.areEqual(this.gifCategory, ((Standard) other).gifCategory);
            }
            return true;
        }

        public final ModelGifCategory getGifCategory() {
            return this.gifCategory;
        }

        public int hashCode() {
            ModelGifCategory modelGifCategory = this.gifCategory;
            if (modelGifCategory != null) {
                return modelGifCategory.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Standard(gifCategory=");
            sbU.append(this.gifCategory);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: GifCategoryItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Trending;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "", "component1", "()Ljava/lang/String;", "gifPreviewUrl", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem$Trending;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGifPreviewUrl", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Trending extends GifCategoryItem {
        private final String gifPreviewUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Trending(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "gifPreviewUrl");
            this.gifPreviewUrl = str;
        }

        public static /* synthetic */ Trending copy$default(Trending trending, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trending.gifPreviewUrl;
            }
            return trending.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getGifPreviewUrl() {
            return this.gifPreviewUrl;
        }

        public final Trending copy(String gifPreviewUrl) {
            Intrinsics3.checkNotNullParameter(gifPreviewUrl, "gifPreviewUrl");
            return new Trending(gifPreviewUrl);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Trending) && Intrinsics3.areEqual(this.gifPreviewUrl, ((Trending) other).gifPreviewUrl);
            }
            return true;
        }

        public final String getGifPreviewUrl() {
            return this.gifPreviewUrl;
        }

        public int hashCode() {
            String str = this.gifPreviewUrl;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("Trending(gifPreviewUrl="), this.gifPreviewUrl, ")");
        }
    }

    private GifCategoryItem() {
        this.key = String.valueOf(hashCode());
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public /* synthetic */ GifCategoryItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
