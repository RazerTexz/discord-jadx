package com.discord.api.sticker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/api/sticker/StickerType;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "UNKNOWN", "STANDARD", "GUILD", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum StickerType {
    UNKNOWN(-1),
    STANDARD(1),
    GUILD(2);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: StickerType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/api/sticker/StickerType$Companion;", "", "", "int", "Lcom/discord/api/sticker/StickerType;", "a", "(I)Lcom/discord/api/sticker/StickerType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final StickerType a(int i) {
            StickerType stickerType;
            StickerType[] stickerTypeArrValues = StickerType.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    stickerType = null;
                    break;
                }
                stickerType = stickerTypeArrValues[i2];
                if (stickerType.getApiValue() == i) {
                    break;
                }
                i2++;
            }
            return stickerType != null ? stickerType : StickerType.UNKNOWN;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
