package com.discord.widgets.chat.list.actions;

import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/emoji/Emoji;", "it", "", "invoke", "(Lcom/discord/models/domain/emoji/Emoji;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter$onClickEmoji$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter5 extends Lambda implements Function1<Emoji, Unit> {
    public static final WidgetChatListActionsEmojisAdapter5 INSTANCE = new WidgetChatListActionsEmojisAdapter5();

    public WidgetChatListActionsEmojisAdapter5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
        invoke2(emoji);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "it");
    }
}
