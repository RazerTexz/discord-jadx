package com.discord.widgets.voice.call;

import android.content.Context;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetVoiceCallInline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\bR\u001d\u0010\u0003\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline;", "Lcom/discord/app/AppFragment;", "Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", "binding", "", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetVoiceCallInlineBinding;)V", "setWindowInsetsListeners", "()V", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "data", "configureUI", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", "Lcom/discord/utilities/views/ViewVisibilityObserver;", "inlineVoiceVisibilityObserver", "Lcom/discord/utilities/views/ViewVisibilityObserver;", "<init>", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "component1", "()Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "voiceConnected", "copy", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;)Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "getVoiceConnected", "<init>", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;)V", "Companion", "VoiceConnected", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VoiceConnected voiceConnected;

        /* compiled from: WidgetVoiceCallInline.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableG = VoiceConnected.INSTANCE.get().G(WidgetVoiceCallInline2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "VoiceConnected\n         …eConnected)\n            }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetVoiceCallInline.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\n¨\u0006#"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "component2", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "Lcom/discord/utilities/streams/StreamContext;", "component3", "()Lcom/discord/utilities/streams/StreamContext;", "selectedVoiceChannel", "inputMode", "streamContext", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getSelectedVoiceChannel", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getInputMode", "Lcom/discord/utilities/streams/StreamContext;", "getStreamContext", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class VoiceConnected {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final MediaEngineConnection.InputMode inputMode;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* compiled from: WidgetVoiceCallInline.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected$Companion;", "", "Lrx/Observable;", "Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model$VoiceConnected;", "get", "()Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public final Observable<VoiceConnected> get() {
                    Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().Y(WidgetVoiceCallInline3.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                    return ObservableExtensionsKt.computationLatest(observableY);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public VoiceConnected(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                this.selectedVoiceChannel = channel;
                this.inputMode = inputMode;
                this.streamContext = streamContext;
            }

            public static /* synthetic */ VoiceConnected copy$default(VoiceConnected voiceConnected, Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = voiceConnected.selectedVoiceChannel;
                }
                if ((i & 2) != 0) {
                    inputMode = voiceConnected.inputMode;
                }
                if ((i & 4) != 0) {
                    streamContext = voiceConnected.streamContext;
                }
                return voiceConnected.copy(channel, inputMode, streamContext);
            }

            /* renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* renamed from: component2, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* renamed from: component3, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final VoiceConnected copy(Channel selectedVoiceChannel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                return new VoiceConnected(selectedVoiceChannel, inputMode, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VoiceConnected)) {
                    return false;
                }
                VoiceConnected voiceConnected = (VoiceConnected) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, voiceConnected.selectedVoiceChannel) && Intrinsics3.areEqual(this.inputMode, voiceConnected.inputMode) && Intrinsics3.areEqual(this.streamContext, voiceConnected.streamContext);
            }

            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                MediaEngineConnection.InputMode inputMode = this.inputMode;
                int iHashCode2 = (iHashCode + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                return iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("VoiceConnected(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", inputMode=");
                sbU.append(this.inputMode);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(")");
                return sbU.toString();
            }
        }

        public Model(VoiceConnected voiceConnected) {
            this.voiceConnected = voiceConnected;
        }

        public static /* synthetic */ Model copy$default(Model model, VoiceConnected voiceConnected, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceConnected = model.voiceConnected;
            }
            return model.copy(voiceConnected);
        }

        /* renamed from: component1, reason: from getter */
        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public final Model copy(VoiceConnected voiceConnected) {
            return new Model(voiceConnected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.voiceConnected, ((Model) other).voiceConnected);
            }
            return true;
        }

        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public int hashCode() {
            VoiceConnected voiceConnected = this.voiceConnected;
            if (voiceConnected != null) {
                return voiceConnected.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(voiceConnected=");
            sbU.append(this.voiceConnected);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "pressed", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreStream.INSTANCE.getMediaEngine().setPttActive(z2);
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;", "it", "", "invoke", "(Lcom/discord/widgets/voice/call/WidgetVoiceCallInline$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetVoiceCallInline.access$configureUI(WidgetVoiceCallInline.this, model);
        }
    }

    /* compiled from: WidgetVoiceCallInline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetVoiceCallInline() {
        super(R.layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetVoiceCallInline4.INSTANCE, new WidgetVoiceCallInline5(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceCallInline widgetVoiceCallInline, Model model) {
        widgetVoiceCallInline.configureUI(model);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetVoiceCallInline widgetVoiceCallInline, WidgetVoiceCallInlineBinding widgetVoiceCallInlineBinding) {
        widgetVoiceCallInline.onViewBindingDestroy(widgetVoiceCallInlineBinding);
    }

    private final void configureUI(Model data) {
        Model.VoiceConnected voiceConnected;
        boolean z2 = ((data == null || (voiceConnected = data.getVoiceConnected()) == null) ? null : voiceConnected.getInputMode()) == MediaEngineConnection.InputMode.PUSH_TO_TALK;
        View view = getView();
        if (view != null) {
            ViewKt.setVisible(view, z2);
        }
        this.inlineVoiceVisibilityObserver.updateVisibility(z2);
        if (data == null) {
        }
    }

    private final WidgetVoiceCallInlineBinding getBinding() {
        return (WidgetVoiceCallInlineBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetVoiceCallInlineBinding binding) {
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        MaterialButton materialButton = binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverA.c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2701b, AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().c.setOnTouchListener(new OnPressListener(AnonymousClass2.INSTANCE));
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverA.b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetVoiceCallInline.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
