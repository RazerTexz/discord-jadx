package com.discord.api.sticker;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: Sticker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0005R\u0019\u0010$\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\bR\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 R\u0019\u0010,\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000bR\u0019\u0010/\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b0\u0010\bR\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/discord/api/sticker/Sticker;", "Ljava/io/Serializable;", "Lcom/discord/api/sticker/BaseSticker;", "", "d", "()J", "", "b", "()Ljava/lang/String;", "Lcom/discord/api/sticker/StickerFormatType;", "a", "()Lcom/discord/api/sticker/StickerFormatType;", "Lcom/discord/api/sticker/StickerPartial;", "c", "()Lcom/discord/api/sticker/StickerPartial;", "", "l", "()Z", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_TAGS, "Ljava/lang/String;", "j", "packId", "Ljava/lang/Long;", "i", "()Ljava/lang/Long;", ModelAuditLogEntry.CHANGE_KEY_ID, "J", "getId", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "f", ModelAuditLogEntry.CHANGE_KEY_AVAILABLE, "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "guildId", "g", "formatType", "Lcom/discord/api/sticker/StickerFormatType;", "getFormatType", ModelAuditLogEntry.CHANGE_KEY_NAME, "h", "Lcom/discord/api/sticker/StickerType;", "type", "Lcom/discord/api/sticker/StickerType;", "k", "()Lcom/discord/api/sticker/StickerType;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Sticker implements Serializable, BaseSticker {
    private final Boolean available;
    private final String description;
    private final StickerFormatType formatType;
    private final Long guildId;
    private final long id;
    private final String name;
    private final Long packId;
    private final String tags;
    private final StickerType type;

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

    public Sticker(long j, Long l, Long l2, String str, String str2, StickerFormatType stickerFormatType, String str3, StickerType stickerType, Boolean bool, int i) {
        int i2 = i & 256;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        Intrinsics3.checkNotNullParameter(stickerFormatType, "formatType");
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        Intrinsics3.checkNotNullParameter(stickerType, "type");
        this.id = j;
        this.packId = l;
        this.guildId = l2;
        this.name = str;
        this.description = str2;
        this.formatType = stickerFormatType;
        this.tags = str3;
        this.type = stickerType;
        this.available = null;
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
        return new StickerPartial(this.id, this.formatType, this.name);
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* renamed from: d, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) other;
        return this.id == sticker.id && Intrinsics3.areEqual(this.packId, sticker.packId) && Intrinsics3.areEqual(this.guildId, sticker.guildId) && Intrinsics3.areEqual(this.name, sticker.name) && Intrinsics3.areEqual(this.description, sticker.description) && Intrinsics3.areEqual(this.formatType, sticker.formatType) && Intrinsics3.areEqual(this.tags, sticker.tags) && Intrinsics3.areEqual(this.type, sticker.type) && Intrinsics3.areEqual(this.available, sticker.available);
    }

    /* renamed from: f, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: g, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.packId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        StickerFormatType stickerFormatType = this.formatType;
        int iHashCode5 = (iHashCode4 + (stickerFormatType != null ? stickerFormatType.hashCode() : 0)) * 31;
        String str3 = this.tags;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        StickerType stickerType = this.type;
        int iHashCode7 = (iHashCode6 + (stickerType != null ? stickerType.hashCode() : 0)) * 31;
        Boolean bool = this.available;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Long getPackId() {
        return this.packId;
    }

    /* renamed from: j, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    /* renamed from: k, reason: from getter */
    public final StickerType getType() {
        return this.type;
    }

    public final boolean l() {
        StickerFormatType stickerFormatType = this.formatType;
        return stickerFormatType == StickerFormatType.APNG || stickerFormatType == StickerFormatType.LOTTIE;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Sticker(id=");
        sbU.append(this.id);
        sbU.append(", packId=");
        sbU.append(this.packId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", formatType=");
        sbU.append(this.formatType);
        sbU.append(", tags=");
        sbU.append(this.tags);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", available=");
        return outline.D(sbU, this.available, ")");
    }
}
