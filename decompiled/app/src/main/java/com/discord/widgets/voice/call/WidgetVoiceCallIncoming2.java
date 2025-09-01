package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.model.CallModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: WidgetVoiceCallIncoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005 \u0002*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "kotlin.jvm.PlatformType", "incomingCalls", "Lrx/Observable;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Set;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceCallIncoming2<T, R> implements Func1<Set<? extends Long>, Observable<? extends WidgetVoiceCallIncoming.Model>> {
    public static final WidgetVoiceCallIncoming2 INSTANCE = new WidgetVoiceCallIncoming2();

    /* compiled from: WidgetVoiceCallIncoming.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/model/CallModel;", "callModel", "Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/voice/model/CallModel;)Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<CallModel, WidgetVoiceCallIncoming.Model> {
        public final /* synthetic */ Set $incomingCalls;

        /* compiled from: WidgetVoiceCallIncoming.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "participant", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)Z", "shouldIncludeParticipant"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03601 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
            public final /* synthetic */ CallModel $callModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03601(CallModel callModel) {
                super(1);
                this.$callModel = callModel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                return Boolean.valueOf(invoke2(voiceUser));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                if (ChannelUtils.z(this.$callModel.getChannel())) {
                    if (voiceUser.isConnected() || voiceUser.isRinging()) {
                        return true;
                    }
                } else if (!voiceUser.isMe()) {
                    return true;
                }
                return false;
            }
        }

        public AnonymousClass1(Set set) {
            this.$incomingCalls = set;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetVoiceCallIncoming.Model call(CallModel callModel) {
            return call2(callModel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetVoiceCallIncoming.Model call2(CallModel callModel) {
            if (callModel == null) {
                return null;
            }
            C03601 c03601 = new C03601(callModel);
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callModel.getParticipants().values();
            ArrayList arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (c03601.invoke2((StoreVoiceParticipants.VoiceUser) t)) {
                    arrayList.add(t);
                }
            }
            return new WidgetVoiceCallIncoming.Model(callModel, arrayList, this.$incomingCalls.size());
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallIncoming.Model> call(Set<? extends Long> set) {
        return call2((Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallIncoming.Model> call2(Set<Long> set) {
        if (set.isEmpty()) {
            return new ScalarSynchronousObservable(null);
        }
        CallModel.Companion companion = CallModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(set, "incomingCalls");
        return companion.get(((Number) _Collections.first(set)).longValue()).G(new AnonymousClass1(set));
    }
}
