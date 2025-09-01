package com.discord.api.sticker;

import kotlin.Metadata;

/* compiled from: BaseSticker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/discord/api/sticker/BaseSticker;", "", "", "b", "()Ljava/lang/String;", "", "d", "()J", "Lcom/discord/api/sticker/StickerFormatType;", "a", "()Lcom/discord/api/sticker/StickerFormatType;", "Lcom/discord/api/sticker/StickerPartial;", "c", "()Lcom/discord/api/sticker/StickerPartial;", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface BaseSticker {
    /* renamed from: a */
    StickerFormatType getFormatType();

    String b();

    StickerPartial c();

    /* renamed from: d */
    long getId();
}
