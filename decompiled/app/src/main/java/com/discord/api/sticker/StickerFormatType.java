package com.discord.api.sticker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StickerFormatType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/api/sticker/StickerFormatType;", "", "", "apiValue", "I", "getApiValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "UNKNOWN", "PNG", "APNG", "LOTTIE", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum StickerFormatType {
    UNKNOWN(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* compiled from: StickerFormatType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/api/sticker/StickerFormatType$Companion;", "", "", "int", "Lcom/discord/api/sticker/StickerFormatType;", "a", "(I)Lcom/discord/api/sticker/StickerFormatType;", "<init>", "()V", "discord_api"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final StickerFormatType a(int i) {
            StickerFormatType stickerFormatType;
            StickerFormatType[] stickerFormatTypeArrValues = StickerFormatType.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    stickerFormatType = null;
                    break;
                }
                stickerFormatType = stickerFormatTypeArrValues[i2];
                if (stickerFormatType.getApiValue() == i) {
                    break;
                }
                i2++;
            }
            return stickerFormatType != null ? stickerFormatType : StickerFormatType.UNKNOWN;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerFormatType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
