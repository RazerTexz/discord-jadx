package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import d0.t._Collections;
import j0.k.Func1;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ManageReactionsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00050\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/api/message/reaction/MessageReaction;", "kotlin.jvm.PlatformType", "reactions", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel5<T, R> implements Func1<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>> {
    public static final ManageReactionsModel5 INSTANCE = new ManageReactionsModel5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
        return call2((Map<String, MessageReaction>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
        return _Collections.sortedWith(map.values(), new ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1());
    }
}
