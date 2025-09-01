package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\b\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00050\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/models/domain/emoji/EmojiSet;", "kotlin.jvm.PlatformType", "emojiSet", "", "Lcom/discord/models/domain/emoji/Emoji;", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/emoji/EmojiSet;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel3<T, R> implements Func1<EmojiSet, List<Emoji>> {
    public final /* synthetic */ long $guildId;

    public WidgetGuildProfileSheetViewModel3(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<Emoji> call(EmojiSet emojiSet) {
        return call2(emojiSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Emoji> call2(EmojiSet emojiSet) {
        return emojiSet.customEmojis.get(Long.valueOf(this.$guildId));
    }
}
