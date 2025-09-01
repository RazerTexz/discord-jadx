package com.discord.widgets.stickers;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerPurchaseLocation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/stickers/StickerPurchaseLocation;", "", "", "analyticsValue", "Ljava/lang/String;", "getAnalyticsValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "EXPRESSION_PICKER", "STICKER_POPOUT", "STICKER_UPSELL_POPOUT", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum StickerPurchaseLocation {
    EXPRESSION_PICKER(Traits.Location.Section.EXPRESSION_PICKER),
    STICKER_POPOUT(Traits.Location.Section.STICKER_POPOUT),
    STICKER_UPSELL_POPOUT("Sticker Upsell Popout");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String analyticsValue;

    /* compiled from: StickerPurchaseLocation.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/stickers/StickerPurchaseLocation$Companion;", "", "Lcom/discord/widgets/stickers/StickerPurchaseLocation;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "getSimplifiedLocation", "(Lcom/discord/widgets/stickers/StickerPurchaseLocation;)Lcom/discord/widgets/stickers/StickerPurchaseLocation;", "", "canStickerPackBePurchased", "getPopoutPurchaseLocation", "(Z)Lcom/discord/widgets/stickers/StickerPurchaseLocation;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                StickerPurchaseLocation.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[StickerPurchaseLocation.STICKER_POPOUT.ordinal()] = 1;
                iArr[StickerPurchaseLocation.STICKER_UPSELL_POPOUT.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public final StickerPurchaseLocation getPopoutPurchaseLocation(boolean canStickerPackBePurchased) {
            return canStickerPackBePurchased ? StickerPurchaseLocation.STICKER_UPSELL_POPOUT : StickerPurchaseLocation.STICKER_POPOUT;
        }

        public final StickerPurchaseLocation getSimplifiedLocation(StickerPurchaseLocation location) {
            if (location == null) {
                return location;
            }
            int iOrdinal = location.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2) ? StickerPurchaseLocation.STICKER_POPOUT : location;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    StickerPurchaseLocation(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
