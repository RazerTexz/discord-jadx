package com.discord.widgets.chat.list.model;

import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.FunctionReferenceImpl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChatListModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a$\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "p1", "Ljava/util/ArrayList;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "kotlin.jvm.PlatformType", "p2", "Lkotlin/Pair;", "invoke", "(Ljava/lang/Void;Ljava/util/ArrayList;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel6 extends FunctionReferenceImpl implements Function2 {
    public static final WidgetChatListModel6 INSTANCE = new WidgetChatListModel6();

    public WidgetChatListModel6() {
        super(2, Tuples2.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Void) obj, (ArrayList<ChatListEntry>) obj2);
    }

    public final Tuples2 invoke(Void r2, ArrayList<ChatListEntry> arrayList) {
        return new Tuples2(r2, arrayList);
    }
}
