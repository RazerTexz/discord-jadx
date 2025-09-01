package com.discord.widgets.chat.list.model;

import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.FunctionReferenceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a*\u0012\f\u0012\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00030\u00072\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/discord/models/message/Message;", "Lcom/discord/stores/ClientMessage;", "p1", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "kotlin.jvm.PlatformType", "p2", "Lkotlin/Pair;", "invoke", "(Lcom/discord/models/message/Message;Ljava/util/List;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel5 extends FunctionReferenceImpl implements Function2<Message, List<? extends ChatListEntry>, Tuples2<? extends Message, ? extends List<? extends ChatListEntry>>> {
    public static final WidgetChatListModel5 INSTANCE = new WidgetChatListModel5();

    public WidgetChatListModel5() {
        super(2, Tuples2.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Message, ? extends List<? extends ChatListEntry>> invoke(Message message, List<? extends ChatListEntry> list) {
        return invoke2(message, list);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Tuples2<Message, List<ChatListEntry>> invoke2(Message message, List<? extends ChatListEntry> list) {
        return new Tuples2<>(message, list);
    }
}
