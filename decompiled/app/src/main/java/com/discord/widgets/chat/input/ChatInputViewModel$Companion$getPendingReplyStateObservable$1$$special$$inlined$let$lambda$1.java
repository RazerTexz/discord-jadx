package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "it", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/member/GuildMember;", "com/discord/widgets/chat/input/ChatInputViewModel$Companion$getPendingReplyStateObservable$1$guildMemberObservable$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ long $originalAuthorId$inlined;

    public ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1(long j) {
        this.$originalAuthorId$inlined = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, GuildMember> map) {
        return map.get(Long.valueOf(this.$originalAuthorId$inlined));
    }
}
