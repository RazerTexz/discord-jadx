package com.discord.widgets.chat.input.expression;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExpressionDetailPage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;", "", "<init>", "()V", "GifCategoryPage", "Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage$GifCategoryPage;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ExpressionDetailPage {

    /* compiled from: ExpressionDetailPage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage$GifCategoryPage;", "Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "component1", "()Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "gifCategoryItem", "copy", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage$GifCategoryPage;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "getGifCategoryItem", "<init>", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GifCategoryPage extends ExpressionDetailPage {
        private final GifCategoryItem gifCategoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifCategoryPage(GifCategoryItem gifCategoryItem) {
            super(null);
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
            this.gifCategoryItem = gifCategoryItem;
        }

        public static /* synthetic */ GifCategoryPage copy$default(GifCategoryPage gifCategoryPage, GifCategoryItem gifCategoryItem, int i, Object obj) {
            if ((i & 1) != 0) {
                gifCategoryItem = gifCategoryPage.gifCategoryItem;
            }
            return gifCategoryPage.copy(gifCategoryItem);
        }

        /* renamed from: component1, reason: from getter */
        public final GifCategoryItem getGifCategoryItem() {
            return this.gifCategoryItem;
        }

        public final GifCategoryPage copy(GifCategoryItem gifCategoryItem) {
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
            return new GifCategoryPage(gifCategoryItem);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GifCategoryPage) && Intrinsics3.areEqual(this.gifCategoryItem, ((GifCategoryPage) other).gifCategoryItem);
            }
            return true;
        }

        public final GifCategoryItem getGifCategoryItem() {
            return this.gifCategoryItem;
        }

        public int hashCode() {
            GifCategoryItem gifCategoryItem = this.gifCategoryItem;
            if (gifCategoryItem != null) {
                return gifCategoryItem.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("GifCategoryPage(gifCategoryItem=");
            sbU.append(this.gifCategoryItem);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private ExpressionDetailPage() {
    }

    public /* synthetic */ ExpressionDetailPage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
