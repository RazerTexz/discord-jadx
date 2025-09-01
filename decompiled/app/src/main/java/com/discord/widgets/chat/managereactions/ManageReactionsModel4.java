package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import d0.t.Maps6;
import j0.k.Func1;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ManageReactionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "it", "", "", "Lcom/discord/api/message/reaction/MessageReaction;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/message/Message;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel4<T, R> implements Func1<Message, Map<String, ? extends MessageReaction>> {
    public static final ManageReactionsModel4 INSTANCE = new ManageReactionsModel4();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Map<String, ? extends MessageReaction> call(Message message) {
        return call2(message);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<String, MessageReaction> call2(Message message) {
        Map<String, MessageReaction> reactionsMap;
        return (message == null || (reactionsMap = message.getReactionsMap()) == null) ? Maps6.emptyMap() : reactionsMap;
    }
}
