package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.ChatInputViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: ChatInputViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StorePendingReplies$PendingReply;", "pendingReply", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded$PendingReply;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StorePendingReplies$PendingReply;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$getPendingReplyStateObservable$1<T, R> implements Func1<StorePendingReplies.PendingReply, Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply>> {
    public static final ChatInputViewModel$Companion$getPendingReplyStateObservable$1 INSTANCE = new ChatInputViewModel$Companion$getPendingReplyStateObservable$1();

    /* compiled from: ChatInputViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/models/user/User;", "user", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "member", "Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded$PendingReply;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)Lcom/discord/widgets/chat/input/ChatInputViewModel$StoreState$Loaded$PendingReply;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.ChatInputViewModel$Companion$getPendingReplyStateObservable$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<User, GuildMember, ChatInputViewModel.StoreState.Loaded.PendingReply> {
        public final /* synthetic */ StorePendingReplies.PendingReply $pendingReply;

        public AnonymousClass1(StorePendingReplies.PendingReply pendingReply) {
            this.$pendingReply = pendingReply;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ChatInputViewModel.StoreState.Loaded.PendingReply call(User user, GuildMember guildMember) {
            return call2(user, guildMember);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChatInputViewModel.StoreState.Loaded.PendingReply call2(User user, GuildMember guildMember) {
            return new ChatInputViewModel.StoreState.Loaded.PendingReply(this.$pendingReply, user, guildMember);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply> call2(StorePendingReplies.PendingReply pendingReply) {
        Observable<R> scalarSynchronousObservable;
        if (pendingReply == null) {
            return new ScalarSynchronousObservable(null);
        }
        if (pendingReply.getOriginalMessage().isWebhook()) {
            com.discord.api.user.User author = pendingReply.getOriginalMessage().getAuthor();
            Intrinsics3.checkNotNull(author);
            return new ScalarSynchronousObservable(new ChatInputViewModel.StoreState.Loaded.PendingReply(pendingReply, new CoreUser(author), null));
        }
        com.discord.api.user.User author2 = pendingReply.getOriginalMessage().getAuthor();
        Intrinsics3.checkNotNull(author2);
        long id2 = author2.getId();
        Long guildId = pendingReply.getMessageReference().getGuildId();
        if (guildId != null) {
            scalarSynchronousObservable = StoreStream.INSTANCE.getGuilds().observeComputed(guildId.longValue()).G(new ChatInputViewModel$Companion$getPendingReplyStateObservable$1$$special$$inlined$let$lambda$1(id2)).r();
        } else {
            scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        }
        return Observable.j(StoreStream.INSTANCE.getUsers().observeUser(id2), scalarSynchronousObservable, new AnonymousClass1(pendingReply));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel.StoreState.Loaded.PendingReply> call(StorePendingReplies.PendingReply pendingReply) {
        return call2(pendingReply);
    }
}
