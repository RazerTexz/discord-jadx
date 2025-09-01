package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessages2;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreForumPostMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/forum/ForumPostFirstMessage;", "it", "Lcom/discord/api/message/Message;", "invoke", "(Lcom/discord/api/forum/ForumPostFirstMessage;)Lcom/discord/api/message/Message;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreForumPostMessages2 extends Lambda implements Function1<ForumPostFirstMessages2, Message> {
    public static final StoreForumPostMessages2 INSTANCE = new StoreForumPostMessages2();

    public StoreForumPostMessages2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Message invoke(ForumPostFirstMessages2 forumPostFirstMessages2) {
        return invoke2(forumPostFirstMessages2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Message invoke2(ForumPostFirstMessages2 forumPostFirstMessages2) {
        Intrinsics3.checkNotNullParameter(forumPostFirstMessages2, "it");
        return forumPostFirstMessages2.getFirstMessage();
    }
}
