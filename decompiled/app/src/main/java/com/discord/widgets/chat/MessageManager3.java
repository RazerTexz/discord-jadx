package com.discord.widgets.chat;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.utilities.messagesend.MessageQueue4;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: MessageManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "cooldownSeconds", "Lrx/Observable;", "Lcom/discord/utilities/messagesend/MessageResult;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$messageResultObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageManager3<T, R> implements Func1<Integer, Observable<? extends MessageQueue4>> {
    public final /* synthetic */ MessageAllowedMentions $allowedMentions;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ String $content;
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ List $mentions;
    public final /* synthetic */ long $nonNullChannelId;
    public final /* synthetic */ StorePendingReplies.PendingReply $pendingReply;
    public final /* synthetic */ List $stickers;
    public final /* synthetic */ MessageManager this$0;

    public MessageManager3(MessageManager messageManager, StorePendingReplies.PendingReply pendingReply, long j, MeUser meUser, String str, List list, List list2, List list3, MessageAllowedMentions messageAllowedMentions) {
        this.this$0 = messageManager;
        this.$pendingReply = pendingReply;
        this.$nonNullChannelId = j;
        this.$me = meUser;
        this.$content = str;
        this.$mentions = list;
        this.$attachments = list2;
        this.$stickers = list3;
        this.$allowedMentions = messageAllowedMentions;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends MessageQueue4> call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MessageQueue4> call2(Integer num) {
        if (num.intValue() > 0) {
            return new ScalarSynchronousObservable(new MessageQueue4.Slowmode(num.intValue() * 1000));
        }
        if (this.$pendingReply != null) {
            MessageManager.access$getStorePendingReplies$p(this.this$0).onDeletePendingReply(this.$nonNullChannelId);
        }
        StoreMessages storeMessagesAccess$getStoreMessages$p = MessageManager.access$getStoreMessages$p(this.this$0);
        long j = this.$nonNullChannelId;
        MeUser meUser = this.$me;
        String str = this.$content;
        List list = this.$mentions;
        List list2 = this.$attachments;
        List list3 = this.$stickers;
        StorePendingReplies.PendingReply pendingReply = this.$pendingReply;
        return StoreMessages.sendMessage$default(storeMessagesAccess$getStoreMessages$p, j, meUser, str, list, list2, list3, pendingReply != null ? pendingReply.getMessageReference() : null, this.$allowedMentions, null, null, null, null, null, null, null, 32512, null);
    }
}
