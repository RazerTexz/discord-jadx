package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.share.WidgetIncomingShare;
import d0.Tuples;
import j0.k.Func1;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: WidgetIncomingShare.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000 \u0001* \u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/messagesend/MessageResult;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "Lcom/discord/models/user/MeUser;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/messagesend/MessageResult;)Lkotlin/Pair;", "com/discord/widgets/share/WidgetIncomingShare$onSendClicked$2$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare4<T, R> implements Func1<MessageQueue4, Tuples2<? extends MeUser, ? extends MessageQueue4>> {
    public final /* synthetic */ MeUser $meUser$inlined;
    public final /* synthetic */ WidgetIncomingShare.AnonymousClass2 this$0;

    public WidgetIncomingShare4(WidgetIncomingShare.AnonymousClass2 anonymousClass2, MeUser meUser) {
        this.this$0 = anonymousClass2;
        this.$meUser$inlined = meUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends MessageQueue4> call(MessageQueue4 messageQueue4) {
        return call2(messageQueue4);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<MeUser, MessageQueue4> call2(MessageQueue4 messageQueue4) {
        return Tuples.to(this.$meUser$inlined, messageQueue4);
    }
}
