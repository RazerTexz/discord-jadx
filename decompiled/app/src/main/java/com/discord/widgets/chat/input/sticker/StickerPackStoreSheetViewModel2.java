package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerPackStoreSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetAnalytics;", "", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;", "component2", "()Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;", "", "component3", "()Ljava/lang/String;", "component4", "sticker", "type", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "section", "copy", "(Lcom/discord/api/sticker/Sticker;Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetAnalytics;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;", "getType", "Ljava/lang/String;", "getLocation", "getSection", "Lcom/discord/api/sticker/Sticker;", "getSticker", "<init>", "(Lcom/discord/api/sticker/Sticker;Lcom/discord/widgets/chat/input/sticker/StickerPackStoreSheetViewType;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetAnalytics, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StickerPackStoreSheetViewModel2 {
    private final String location;
    private final String section;
    private final Sticker sticker;
    private final WidgetStickerPackStoreSheet2 type;

    public StickerPackStoreSheetViewModel2(Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, String str2) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(widgetStickerPackStoreSheet2, "type");
        Intrinsics3.checkNotNullParameter(str2, "section");
        this.sticker = sticker;
        this.type = widgetStickerPackStoreSheet2;
        this.location = str;
        this.section = str2;
    }

    public static /* synthetic */ StickerPackStoreSheetViewModel2 copy$default(StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = stickerPackStoreSheetViewModel2.sticker;
        }
        if ((i & 2) != 0) {
            widgetStickerPackStoreSheet2 = stickerPackStoreSheetViewModel2.type;
        }
        if ((i & 4) != 0) {
            str = stickerPackStoreSheetViewModel2.location;
        }
        if ((i & 8) != 0) {
            str2 = stickerPackStoreSheetViewModel2.section;
        }
        return stickerPackStoreSheetViewModel2.copy(sticker, widgetStickerPackStoreSheet2, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* renamed from: component2, reason: from getter */
    public final WidgetStickerPackStoreSheet2 getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSection() {
        return this.section;
    }

    public final StickerPackStoreSheetViewModel2 copy(Sticker sticker, WidgetStickerPackStoreSheet2 type, String location, String section) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(section, "section");
        return new StickerPackStoreSheetViewModel2(sticker, type, location, section);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPackStoreSheetViewModel2)) {
            return false;
        }
        StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2 = (StickerPackStoreSheetViewModel2) other;
        return Intrinsics3.areEqual(this.sticker, stickerPackStoreSheetViewModel2.sticker) && Intrinsics3.areEqual(this.type, stickerPackStoreSheetViewModel2.type) && Intrinsics3.areEqual(this.location, stickerPackStoreSheetViewModel2.location) && Intrinsics3.areEqual(this.section, stickerPackStoreSheetViewModel2.section);
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getSection() {
        return this.section;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public final WidgetStickerPackStoreSheet2 getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2 = this.type;
        int iHashCode2 = (iHashCode + (widgetStickerPackStoreSheet2 != null ? widgetStickerPackStoreSheet2.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.section;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerPackStoreSheetAnalytics(sticker=");
        sbU.append(this.sticker);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", section=");
        return outline.J(sbU, this.section, ")");
    }
}
