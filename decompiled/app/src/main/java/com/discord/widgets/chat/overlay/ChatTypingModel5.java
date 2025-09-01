package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.widgets.chat.overlay.ChatTypingModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: ChatTypingModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "kotlin.jvm.PlatformType", "cooldownSecs", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/ChatTypingModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Integer;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForDraft$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel5<T, R> implements Func1<Integer, Observable<? extends ChatTypingModel>> {
    public final /* synthetic */ Channel $parentChannel;

    public ChatTypingModel5(Channel channel) {
        this.$parentChannel = channel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ChatTypingModel> call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatTypingModel> call2(Integer num) {
        List listEmptyList = Collections2.emptyList();
        int rateLimitPerUser = this.$parentChannel.getRateLimitPerUser();
        Intrinsics3.checkNotNullExpressionValue(num, "cooldownSecs");
        return new ScalarSynchronousObservable(new ChatTypingModel.Typing(listEmptyList, rateLimitPerUser, num.intValue()));
    }
}
