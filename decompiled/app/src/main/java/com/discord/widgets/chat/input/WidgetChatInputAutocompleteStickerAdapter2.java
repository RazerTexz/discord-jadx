package com.discord.widgets.chat.input;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/widgets/chat/input/AutocompleteStickerItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/api/sticker/Sticker;", "component1", "()Lcom/discord/api/sticker/Sticker;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "sticker", "key", "type", "copy", "(Lcom/discord/api/sticker/Sticker;Ljava/lang/String;I)Lcom/discord/widgets/chat/input/AutocompleteStickerItem;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/sticker/Sticker;", "getSticker", "I", "getType", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/api/sticker/Sticker;Ljava/lang/String;I)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.AutocompleteStickerItem, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetChatInputAutocompleteStickerAdapter2 implements MGRecyclerDataPayload {
    public static final int TYPE = 0;
    private final String key;
    private final Sticker sticker;
    private final int type;

    public WidgetChatInputAutocompleteStickerAdapter2(Sticker sticker, String str, int i) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(str, "key");
        this.sticker = sticker;
        this.key = str;
        this.type = i;
    }

    public static /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2 copy$default(WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2, Sticker sticker, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sticker = widgetChatInputAutocompleteStickerAdapter2.sticker;
        }
        if ((i2 & 2) != 0) {
            str = widgetChatInputAutocompleteStickerAdapter2.getKey();
        }
        if ((i2 & 4) != 0) {
            i = widgetChatInputAutocompleteStickerAdapter2.getType();
        }
        return widgetChatInputAutocompleteStickerAdapter2.copy(sticker, str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    public final String component2() {
        return getKey();
    }

    public final int component3() {
        return getType();
    }

    public final WidgetChatInputAutocompleteStickerAdapter2 copy(Sticker sticker, String key, int type) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(key, "key");
        return new WidgetChatInputAutocompleteStickerAdapter2(sticker, key, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputAutocompleteStickerAdapter2)) {
            return false;
        }
        WidgetChatInputAutocompleteStickerAdapter2 widgetChatInputAutocompleteStickerAdapter2 = (WidgetChatInputAutocompleteStickerAdapter2) other;
        return Intrinsics3.areEqual(this.sticker, widgetChatInputAutocompleteStickerAdapter2.sticker) && Intrinsics3.areEqual(getKey(), widgetChatInputAutocompleteStickerAdapter2.getKey()) && getType() == widgetChatInputAutocompleteStickerAdapter2.getType();
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        String key = getKey();
        return getType() + ((iHashCode + (key != null ? key.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("AutocompleteStickerItem(sticker=");
        sbU.append(this.sticker);
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(", type=");
        sbU.append(getType());
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetChatInputAutocompleteStickerAdapter2(Sticker sticker, String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(sticker, (i2 & 2) != 0 ? String.valueOf(sticker.getId()) : str, (i2 & 4) != 0 ? 0 : i);
    }
}
