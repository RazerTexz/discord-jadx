package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiPickerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "it", "Lcom/discord/models/guild/Guild;", "invoke", "(J)Lcom/discord/models/guild/Guild;", "com/discord/widgets/chat/input/emoji/EmojiPickerViewModel$Companion$buildGuildEmojiListItems$guildItems$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildGuildEmojiListItems$$inlined$let$lambda$1 extends Lambda implements Function1<Long, Guild> {
    public final /* synthetic */ boolean $allowEmojisToAnimate$inlined;
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $includeUnavailable$inlined;
    public final /* synthetic */ boolean $partition$inlined;
    public final /* synthetic */ String $searchInputLower$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildGuildEmojiListItems$$inlined$let$lambda$1(Guild guild, String str, boolean z2, boolean z3, boolean z4) {
        super(1);
        this.$guild$inlined = guild;
        this.$searchInputLower$inlined = str;
        this.$allowEmojisToAnimate$inlined = z2;
        this.$partition$inlined = z3;
        this.$includeUnavailable$inlined = z4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Guild invoke(long j) {
        return this.$guild$inlined;
    }
}
