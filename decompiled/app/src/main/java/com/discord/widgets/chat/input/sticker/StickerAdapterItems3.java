package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: StickerAdapterItems.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ8\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010!\u001a\u00020\u00058\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0016R\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\nR\u0019\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\r¨\u0006-"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "", "component2", "()I", "Lcom/discord/widgets/chat/input/sticker/StickerItem$Mode;", "component3", "()Lcom/discord/widgets/chat/input/sticker/StickerItem$Mode;", "Lcom/discord/utilities/stickers/StickerUtils$StickerSendability;", "component4", "()Lcom/discord/utilities/stickers/StickerUtils$StickerSendability;", "sticker", "stickerAnimationSettings", "mode", "sendability", "copy", "(Lcom/discord/api/sticker/Sticker;ILcom/discord/widgets/chat/input/sticker/StickerItem$Mode;Lcom/discord/utilities/stickers/StickerUtils$StickerSendability;)Lcom/discord/widgets/chat/input/sticker/StickerItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStickerAnimationSettings", "Lcom/discord/api/sticker/Sticker;", "getSticker", "type", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/widgets/chat/input/sticker/StickerItem$Mode;", "getMode", "Lcom/discord/utilities/stickers/StickerUtils$StickerSendability;", "getSendability", "<init>", "(Lcom/discord/api/sticker/Sticker;ILcom/discord/widgets/chat/input/sticker/StickerItem$Mode;Lcom/discord/utilities/stickers/StickerUtils$StickerSendability;)V", "Mode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class StickerAdapterItems3 implements MGRecyclerDataPayload {
    private final String key;
    private final Mode mode;
    private final StickerUtils.StickerSendability sendability;
    private final Sticker sticker;
    private final int stickerAnimationSettings;
    private final int type;

    /* compiled from: StickerAdapterItems.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/chat/input/sticker/StickerItem$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "OWNED", "STORE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.sticker.StickerItem$Mode */
    public enum Mode {
        OWNED,
        STORE
    }

    public StickerAdapterItems3(Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(stickerSendability, "sendability");
        this.sticker = sticker;
        this.stickerAnimationSettings = i;
        this.mode = mode;
        this.sendability = stickerSendability;
        this.type = 1;
        StringBuilder sbU = outline.U("sticker:");
        sbU.append(sticker.getId());
        this.key = sbU.toString();
    }

    public static /* synthetic */ StickerAdapterItems3 copy$default(StickerAdapterItems3 stickerAdapterItems3, Sticker sticker, int i, Mode mode, StickerUtils.StickerSendability stickerSendability, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = stickerAdapterItems3.sticker;
        }
        if ((i2 & 2) != 0) {
            i = stickerAdapterItems3.stickerAnimationSettings;
        }
        if ((i2 & 4) != 0) {
            mode = stickerAdapterItems3.mode;
        }
        if ((i2 & 8) != 0) {
            stickerSendability = stickerAdapterItems3.sendability;
        }
        return stickerAdapterItems3.copy(sticker, i, mode, stickerSendability);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    /* renamed from: component3, reason: from getter */
    public final Mode getMode() {
        return this.mode;
    }

    /* renamed from: component4, reason: from getter */
    public final StickerUtils.StickerSendability getSendability() {
        return this.sendability;
    }

    public final StickerAdapterItems3 copy(Sticker sticker, int stickerAnimationSettings, Mode mode, StickerUtils.StickerSendability sendability) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(sendability, "sendability");
        return new StickerAdapterItems3(sticker, stickerAnimationSettings, mode, sendability);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerAdapterItems3)) {
            return false;
        }
        StickerAdapterItems3 stickerAdapterItems3 = (StickerAdapterItems3) other;
        return Intrinsics3.areEqual(this.sticker, stickerAdapterItems3.sticker) && this.stickerAnimationSettings == stickerAdapterItems3.stickerAnimationSettings && Intrinsics3.areEqual(this.mode, stickerAdapterItems3.mode) && Intrinsics3.areEqual(this.sendability, stickerAdapterItems3.sendability);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final StickerUtils.StickerSendability getSendability() {
        return this.sendability;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public final int getStickerAnimationSettings() {
        return this.stickerAnimationSettings;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (((sticker != null ? sticker.hashCode() : 0) * 31) + this.stickerAnimationSettings) * 31;
        Mode mode = this.mode;
        int iHashCode2 = (iHashCode + (mode != null ? mode.hashCode() : 0)) * 31;
        StickerUtils.StickerSendability stickerSendability = this.sendability;
        return iHashCode2 + (stickerSendability != null ? stickerSendability.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerItem(sticker=");
        sbU.append(this.sticker);
        sbU.append(", stickerAnimationSettings=");
        sbU.append(this.stickerAnimationSettings);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", sendability=");
        sbU.append(this.sendability);
        sbU.append(")");
        return sbU.toString();
    }
}
