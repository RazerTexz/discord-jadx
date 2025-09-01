package com.discord.api.sticker;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: StickerPartial.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\r¨\u0006\""}, d2 = {"Lcom/discord/api/sticker/StickerPartial;", "Ljava/io/Serializable;", "Lcom/discord/api/sticker/BaseSticker;", "", "d", "()J", "Lcom/discord/api/sticker/StickerFormatType;", "a", "()Lcom/discord/api/sticker/StickerFormatType;", "c", "()Lcom/discord/api/sticker/StickerPartial;", "", "b", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", "formatType", "Lcom/discord/api/sticker/StickerFormatType;", "getFormatType", ModelAuditLogEntry.CHANGE_KEY_NAME, "Ljava/lang/String;", "e", "<init>", "(JLcom/discord/api/sticker/StickerFormatType;Ljava/lang/String;)V", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class StickerPartial implements Serializable, BaseSticker {
    private final StickerFormatType formatType;
    private final long id;
    private final String name;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StickerFormatType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StickerFormatType.UNKNOWN.ordinal()] = 1;
            iArr[StickerFormatType.PNG.ordinal()] = 2;
            iArr[StickerFormatType.APNG.ordinal()] = 3;
            iArr[StickerFormatType.LOTTIE.ordinal()] = 4;
        }
    }

    public StickerPartial(long j, StickerFormatType stickerFormatType, String str) {
        Intrinsics3.checkNotNullParameter(stickerFormatType, "formatType");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.formatType = stickerFormatType;
        this.name = str;
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* renamed from: a, reason: from getter */
    public StickerFormatType getFormatType() {
        return this.formatType;
    }

    @Override // com.discord.api.sticker.BaseSticker
    public String b() {
        int iOrdinal = this.formatType.ordinal();
        if (iOrdinal == 0) {
            return "";
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            return ".png";
        }
        if (iOrdinal == 3) {
            return ".json";
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.api.sticker.BaseSticker
    public StickerPartial c() {
        return this;
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* renamed from: d, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPartial)) {
            return false;
        }
        StickerPartial stickerPartial = (StickerPartial) other;
        return this.id == stickerPartial.id && Intrinsics3.areEqual(this.formatType, stickerPartial.formatType) && Intrinsics3.areEqual(this.name, stickerPartial.name);
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        StickerFormatType stickerFormatType = this.formatType;
        int iHashCode = (i + (stickerFormatType != null ? stickerFormatType.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerPartial(id=");
        sbU.append(this.id);
        sbU.append(", formatType=");
        sbU.append(this.formatType);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
