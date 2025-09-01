package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.overlay.WidgetChatOverlay;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;

/* compiled from: WidgetChatOverlay.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "kotlin.jvm.PlatformType", "selectedChannelId", "Lrx/Observable;", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay3<T, R> implements Func1<Long, Observable<? extends WidgetChatOverlay.OldMessageModel>> {
    public static final WidgetChatOverlay3 INSTANCE = new WidgetChatOverlay3();

    /* compiled from: WidgetChatOverlay.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "isViewingOldMessages", "Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Boolean;)Lcom/discord/widgets/chat/overlay/WidgetChatOverlay$OldMessageModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Boolean, WidgetChatOverlay.OldMessageModel> {
        public final /* synthetic */ Long $selectedChannelId;

        public AnonymousClass1(Long l) {
            this.$selectedChannelId = l;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChatOverlay.OldMessageModel call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatOverlay.OldMessageModel call2(Boolean bool) {
            Long l = this.$selectedChannelId;
            Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
            long jLongValue = l.longValue();
            Intrinsics3.checkNotNullExpressionValue(bool, "isViewingOldMessages");
            return new WidgetChatOverlay.OldMessageModel(jLongValue, bool.booleanValue());
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatOverlay.OldMessageModel> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatOverlay.OldMessageModel> call2(Long l) {
        Observable observableJ;
        if (l.longValue() <= 0) {
            observableJ = new ScalarSynchronousObservable(Boolean.FALSE);
        } else {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
            observableJ = Observable.j(messages.observeIsDetached(l.longValue()), companion.getChat().observeInteractionState().y(new WidgetChatOverlay4(l)).p(200L, TimeUnit.MILLISECONDS), WidgetChatOverlay5.INSTANCE);
        }
        return Observable.m(new ScalarSynchronousObservable(Boolean.FALSE), observableJ).r().G(new AnonymousClass1(l));
    }
}
