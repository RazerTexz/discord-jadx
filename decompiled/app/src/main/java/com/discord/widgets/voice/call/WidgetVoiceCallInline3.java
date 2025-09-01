package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetVoiceCallInline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lrx/Observable;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline3<T, R> implements Func1<Channel, Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected>> {
    public static final WidgetVoiceCallInline3 INSTANCE = new WidgetVoiceCallInline3();

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/discord/api/channel/Channel;", "p1", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "p2", "Lcom/discord/utilities/streams/StreamContext;", "p3", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "invoke", "(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3, WidgetVoiceCallInline.Model.VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ WidgetVoiceCallInline.Model.VoiceConnected invoke(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            return invoke2(channel, inputMode, streamContext);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetVoiceCallInline.Model.VoiceConnected invoke2(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            Intrinsics3.checkNotNullParameter(inputMode, "p2");
            return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
        Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
        Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Object widgetVoiceCallInline6 = anonymousClass1;
        if (anonymousClass1 != null) {
            widgetVoiceCallInline6 = new WidgetVoiceCallInline6(anonymousClass1);
        }
        return Observable.i(scalarSynchronousObservable, inputMode, forActiveStream, (Func3) widgetVoiceCallInline6);
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
        return call2(channel);
    }
}
