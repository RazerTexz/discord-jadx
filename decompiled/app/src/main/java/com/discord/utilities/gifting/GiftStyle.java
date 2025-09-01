package com.discord.utilities.gifting;

import androidx.annotation.DrawableRes;
import androidx.annotation.RawRes;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GiftStyle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB%\b\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006j\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/gifting/GiftStyle;", "", "", "animRes", "I", "getAnimRes", "()I", "staticRes", "getStaticRes", ModelAuditLogEntry.CHANGE_KEY_ID, "getId", "<init>", "(Ljava/lang/String;IIII)V", "Companion", "WumpusGlobe", "WumpusBox", "WumpusLatte", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum GiftStyle {
    WumpusGlobe(1, R.drawable.gift_wumpus_snowglobe, R.raw.anim_gift_wumpus_globe),
    WumpusBox(2, R.drawable.gift_wumpus_box, R.raw.anim_gift_wumpus_box),
    WumpusLatte(3, R.drawable.gift_wumpus_latte, R.raw.anim_gift_wumpus_latte);

    private final int animRes;
    private final int id;
    private final int staticRes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy values$delegate = LazyJVM.lazy(GiftStyle2.INSTANCE);

    /* compiled from: GiftStyle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/gifting/GiftStyle$Companion;", "", "Lcom/discord/models/domain/ModelGift;", "gift", "Lcom/discord/utilities/gifting/GiftStyle;", "from", "(Lcom/discord/models/domain/ModelGift;)Lcom/discord/utilities/gifting/GiftStyle;", "", "values$delegate", "Lkotlin/Lazy;", "getValues", "()[Lcom/discord/utilities/gifting/GiftStyle;", "values", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final GiftStyle[] getValues() {
            Lazy lazyAccess$getValues$cp = GiftStyle.access$getValues$cp();
            Companion companion = GiftStyle.INSTANCE;
            return (GiftStyle[]) lazyAccess$getValues$cp.getValue();
        }

        public final GiftStyle from(ModelGift gift) {
            Intrinsics3.checkNotNullParameter(gift, "gift");
            for (GiftStyle giftStyle : getValues()) {
                int id2 = giftStyle.getId();
                Integer giftStyle2 = gift.getGiftStyle();
                if (giftStyle2 != null && id2 == giftStyle2.intValue()) {
                    return giftStyle;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    GiftStyle(int i, @DrawableRes int i2, @RawRes int i3) {
        this.id = i;
        this.staticRes = i2;
        this.animRes = i3;
    }

    public static final /* synthetic */ Lazy access$getValues$cp() {
        return values$delegate;
    }

    public final int getAnimRes() {
        return this.animRes;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStaticRes() {
        return this.staticRes;
    }
}
