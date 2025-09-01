package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.CameraCapacityDialog;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.a.f.a.AudioOutputSelectionDialog;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.LayoutVoiceBottomSheetEmptyBinding;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceBottomSheetBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.controls.AnchoredVoiceControlsView;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetNavigator;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheetViewModel;
import com.discord.widgets.voice.stream.StreamNavigator;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* compiled from: WidgetVoiceBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Z2\u00020\u0001:\u0005[\\Z]^B\u0007¢\u0006\u0004\bY\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J!\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J)\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u001aR\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00108\u001a\u0002038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R!\u0010>\u001a\u000609j\u0002`:8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u00105\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u00020?8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u00105\u001a\u0004\bA\u0010BR\u001d\u0010I\u001a\u00020D8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001d\u0010N\u001a\u00020J8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00105\u001a\u0004\bL\u0010MR.\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006_"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "event", "", "handleEvent", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;)V", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "centerContent", "Lcom/discord/api/channel/Channel;", "channel", "configureCenterContent", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;Lcom/discord/api/channel/Channel;)V", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "onStreamPreviewClicked", "(Lcom/discord/utilities/streams/StreamContext;)V", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "bottomContent", "configureBottomContent", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;Lcom/discord/api/channel/Channel;)V", "showSuppressedDialog", "()V", "showServerMutedDialog", "showServerDeafenedDialog", "showNoVideoPermissionDialog", "showNoVideoDevicesToast", "showNoScreenSharePermissionDialog", "", "getContentViewResId", "()I", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "onActivityResult", "(IILandroid/content/Intent;)V", "onResume", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter;", "participantsAdapter", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "featureContext$delegate", "Lkotlin/Lazy;", "getFeatureContext", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "featureContext", "", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "getChannelId", "()J", "channelId", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel;", "viewModel", "Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", "binding", "", "forwardToFullscreenIfVideoActivated$delegate", "getForwardToFullscreenIfVideoActivated", "()Z", "forwardToFullscreenIfVideoActivated", "Lkotlin/Function1;", "onStreamPreviewClickedListener", "Lkotlin/jvm/functions/Function1;", "getOnStreamPreviewClickedListener", "()Lkotlin/jvm/functions/Function1;", "setOnStreamPreviewClickedListener", "(Lkotlin/jvm/functions/Function1;)V", "Lrx/Subscription;", "viewModelEventSubscription", "Lrx/Subscription;", "<init>", "Companion", "BottomContent", "CenterContent", "FeatureContext", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetVoiceBottomSheet extends AppBottomSheet {
    private static final String ANALYTICS_SOURCE = "Voice Channel Bottom Sheet";
    private static final String ARG_FEATURE_CONTEXT = "ARG_FEATURE_CONTEXT";
    private static final String ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED = "ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED";
    private static final String END_EVENT_REQUEST_KEY = "END_EVENT_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: featureContext$delegate, reason: from kotlin metadata */
    private final Lazy featureContext;

    /* renamed from: forwardToFullscreenIfVideoActivated$delegate, reason: from kotlin metadata */
    private final Lazy forwardToFullscreenIfVideoActivated;
    private Function1<? super StreamContext, Unit> onStreamPreviewClickedListener;
    private CallParticipantsAdapter participantsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "", "<init>", "()V", "Connect", "Controls", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Controls;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Connect;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class BottomContent {

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Connect;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "", "component1", "()Z", "isConnectEnabled", "copy", "(Z)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Connect;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "<init>", "(Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Connect extends BottomContent {
            private final boolean isConnectEnabled;

            public Connect(boolean z2) {
                super(null);
                this.isConnectEnabled = z2;
            }

            public static /* synthetic */ Connect copy$default(Connect connect, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = connect.isConnectEnabled;
                }
                return connect.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsConnectEnabled() {
                return this.isConnectEnabled;
            }

            public final Connect copy(boolean isConnectEnabled) {
                return new Connect(isConnectEnabled);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connect) && this.isConnectEnabled == ((Connect) other).isConnectEnabled;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isConnectEnabled;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isConnectEnabled() {
                return this.isConnectEnabled;
            }

            public String toString() {
                return outline.O(outline.U("Connect(isConnectEnabled="), this.isConnectEnabled, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u000f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\nJL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b\u0012\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010\rR\u0019\u0010\u0015\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b\u0015\u0010\n¨\u0006,"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Controls;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "component1", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "Lcom/discord/stores/StoreAudioManagerV2$State;", "component2", "()Lcom/discord/stores/StoreAudioManagerV2$State;", "", "component3", "()Z", "Lcom/discord/widgets/voice/model/CameraState;", "component4", "()Lcom/discord/widgets/voice/model/CameraState;", "component5", "component6", "inputMode", "audioManagerState", "isMuted", "cameraState", "showScreenShareSparkle", "isScreensharing", "copy", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/stores/StoreAudioManagerV2$State;ZLcom/discord/widgets/voice/model/CameraState;ZZ)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent$Controls;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowScreenShareSparkle", "Lcom/discord/stores/StoreAudioManagerV2$State;", "getAudioManagerState", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "getInputMode", "Lcom/discord/widgets/voice/model/CameraState;", "getCameraState", "<init>", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/stores/StoreAudioManagerV2$State;ZLcom/discord/widgets/voice/model/CameraState;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Controls extends BottomContent {
            private final StoreAudioManagerV2.State audioManagerState;
            private final CameraState cameraState;
            private final MediaEngineConnection.InputMode inputMode;
            private final boolean isMuted;
            private final boolean isScreensharing;
            private final boolean showScreenShareSparkle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Controls(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State state, boolean z2, CameraState cameraState, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                Intrinsics3.checkNotNullParameter(state, "audioManagerState");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                this.inputMode = inputMode;
                this.audioManagerState = state;
                this.isMuted = z2;
                this.cameraState = cameraState;
                this.showScreenShareSparkle = z3;
                this.isScreensharing = z4;
            }

            public static /* synthetic */ Controls copy$default(Controls controls, MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State state, boolean z2, CameraState cameraState, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputMode = controls.inputMode;
                }
                if ((i & 2) != 0) {
                    state = controls.audioManagerState;
                }
                StoreAudioManagerV2.State state2 = state;
                if ((i & 4) != 0) {
                    z2 = controls.isMuted;
                }
                boolean z5 = z2;
                if ((i & 8) != 0) {
                    cameraState = controls.cameraState;
                }
                CameraState cameraState2 = cameraState;
                if ((i & 16) != 0) {
                    z3 = controls.showScreenShareSparkle;
                }
                boolean z6 = z3;
                if ((i & 32) != 0) {
                    z4 = controls.isScreensharing;
                }
                return controls.copy(inputMode, state2, z5, cameraState2, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* renamed from: component2, reason: from getter */
            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            /* renamed from: component4, reason: from getter */
            public final CameraState getCameraState() {
                return this.cameraState;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getShowScreenShareSparkle() {
                return this.showScreenShareSparkle;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsScreensharing() {
                return this.isScreensharing;
            }

            public final Controls copy(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, CameraState cameraState, boolean showScreenShareSparkle, boolean isScreensharing) {
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
                Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
                return new Controls(inputMode, audioManagerState, isMuted, cameraState, showScreenShareSparkle, isScreensharing);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Controls)) {
                    return false;
                }
                Controls controls = (Controls) other;
                return Intrinsics3.areEqual(this.inputMode, controls.inputMode) && Intrinsics3.areEqual(this.audioManagerState, controls.audioManagerState) && this.isMuted == controls.isMuted && Intrinsics3.areEqual(this.cameraState, controls.cameraState) && this.showScreenShareSparkle == controls.showScreenShareSparkle && this.isScreensharing == controls.isScreensharing;
            }

            public final StoreAudioManagerV2.State getAudioManagerState() {
                return this.audioManagerState;
            }

            public final CameraState getCameraState() {
                return this.cameraState;
            }

            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            public final boolean getShowScreenShareSparkle() {
                return this.showScreenShareSparkle;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MediaEngineConnection.InputMode inputMode = this.inputMode;
                int iHashCode = (inputMode != null ? inputMode.hashCode() : 0) * 31;
                StoreAudioManagerV2.State state = this.audioManagerState;
                int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
                boolean z2 = this.isMuted;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                CameraState cameraState = this.cameraState;
                int iHashCode3 = (i2 + (cameraState != null ? cameraState.hashCode() : 0)) * 31;
                boolean z3 = this.showScreenShareSparkle;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode3 + i3) * 31;
                boolean z4 = this.isScreensharing;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public final boolean isScreensharing() {
                return this.isScreensharing;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Controls(inputMode=");
                sbU.append(this.inputMode);
                sbU.append(", audioManagerState=");
                sbU.append(this.audioManagerState);
                sbU.append(", isMuted=");
                sbU.append(this.isMuted);
                sbU.append(", cameraState=");
                sbU.append(this.cameraState);
                sbU.append(", showScreenShareSparkle=");
                sbU.append(this.showScreenShareSparkle);
                sbU.append(", isScreensharing=");
                return outline.O(sbU, this.isScreensharing, ")");
            }
        }

        private BottomContent() {
        }

        public /* synthetic */ BottomContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "", "<init>", "()V", "Empty", "ListItems", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$ListItems;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$Empty;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class CenterContent {

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$Empty;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter$ListItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Empty extends CenterContent {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Empty(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Empty copy$default(Empty empty, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = empty.items;
                }
                return empty.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final Empty copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Empty(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics3.areEqual(this.items, ((Empty) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Empty(items="), this.items, ")");
            }
        }

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$ListItems;", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter$ListItem;", "component1", "()Ljava/util/List;", "items", "copy", "(Ljava/util/List;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent$ListItems;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getItems", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ListItems extends CenterContent {
            private final List<CallParticipantsAdapter.ListItem> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ListItems(List<? extends CallParticipantsAdapter.ListItem> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ListItems copy$default(ListItems listItems, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = listItems.items;
                }
                return listItems.copy(list);
            }

            public final List<CallParticipantsAdapter.ListItem> component1() {
                return this.items;
            }

            public final ListItems copy(List<? extends CallParticipantsAdapter.ListItem> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new ListItems(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ListItems) && Intrinsics3.areEqual(this.items, ((ListItems) other).items);
                }
                return true;
            }

            public final List<CallParticipantsAdapter.ListItem> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<CallParticipantsAdapter.ListItem> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("ListItems(items="), this.items, ")");
            }
        }

        private CenterContent() {
        }

        public /* synthetic */ CenterContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "forwardToFullscreenIfVideoActivated", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "featureContext", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet;", "show", "(Landroidx/fragment/app/FragmentManager;JZLcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;)Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet;", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", WidgetVoiceBottomSheet.ARG_FEATURE_CONTEXT, WidgetVoiceBottomSheet.ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED, WidgetVoiceBottomSheet.END_EVENT_REQUEST_KEY, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final WidgetVoiceBottomSheet show(FragmentManager fragmentManager, long channelId, boolean forwardToFullscreenIfVideoActivated, FeatureContext featureContext) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
            WidgetVoiceBottomSheet widgetVoiceBottomSheet = new WidgetVoiceBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            bundle.putSerializable(WidgetVoiceBottomSheet.ARG_FEATURE_CONTEXT, featureContext);
            bundle.putBoolean(WidgetVoiceBottomSheet.ARG_FORWARD_TO_FULLSCREEN_IF_VIDEO_ACTIVATED, forwardToFullscreenIfVideoActivated);
            widgetVoiceBottomSheet.setArguments(bundle);
            widgetVoiceBottomSheet.show(fragmentManager, WidgetVoiceBottomSheet.class.getSimpleName());
            return widgetVoiceBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$FeatureContext;", "", "<init>", "(Ljava/lang/String;I)V", "HOME", "FULLSCREEN_CALL", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum FeatureContext {
        HOME,
        FULLSCREEN_CALL
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$ViewState;", "", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "getCenterContent", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$CenterContent;", "centerContent", "", "getTitle", "()Ljava/lang/String;", "title", "", "getShowInviteOption", "()Z", "showInviteOption", "isDeafened", "Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "getBottomContent", "()Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheet$BottomContent;", "bottomContent", "getSubtitle", "subtitle", "isNoiseCancellationActive", "()Ljava/lang/Boolean;", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "channel", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface ViewState {
        BottomContent getBottomContent();

        CenterContent getCenterContent();

        Channel getChannel();

        boolean getShowInviteOption();

        String getSubtitle();

        String getTitle();

        /* renamed from: isDeafened */
        boolean getIsDeafened();

        /* renamed from: isNoiseCancellationActive */
        Boolean getIsNoiseCancellationActive();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FeatureContext.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[FeatureContext.HOME.ordinal()] = 1;
            iArr[FeatureContext.FULLSCREEN_CALL.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onMutePressed", "onMutePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onMutePressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onScreenSharePressed", "onScreenSharePressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onScreenSharePressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AudioOutputSelectionDialog.Companion companion = AudioOutputSelectionDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            new AudioOutputSelectionDialog().show(parentFragmentManager, AudioOutputSelectionDialog.class.getName());
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onCameraButtonPressed", "onCameraButtonPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onCameraButtonPressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass5(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnectPressed", "onDisconnectPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnectPressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).tryConnectToVoice(false);
            }
        }

        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.S1(WidgetVoiceBottomSheet.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {

        /* compiled from: WidgetVoiceBottomSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureBottomContent$8$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).tryConnectToVoice(true);
            }
        }

        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceBottomSheet.this.requestVideoCallPermissions(new AnonymousClass1());
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/streams/StreamContext;", "p1", "", "invoke", "(Lcom/discord/utilities/streams/StreamContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StreamContext, Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(streamContext, "p1");
            WidgetVoiceBottomSheet.access$onStreamPreviewClicked((WidgetVoiceBottomSheet) this.receiver, streamContext);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "clickedUser", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "clickedUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(this.$channel.getId());
            FragmentManager childFragmentManager = WidgetVoiceBottomSheet.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceUser", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).onToggleRingingPressed(voiceUser);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Channel channel) {
            super(1);
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetVoiceBottomSheet.this, this.$channel, WidgetVoiceBottomSheet.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureCenterContent$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public AnonymousClass5() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).onDeafenPressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetVoiceBottomSheetViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetVoiceBottomSheet.this, this.$viewState.getChannel(), WidgetVoiceBottomSheet.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
            Context contextRequireContext = WidgetVoiceBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsVoice.Companion.launch$default(companion, contextRequireContext, null, false, 6, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).onNoiseCancellationPressed();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).onCameraPermissionsGranted();
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/Intent;", "it", "", "invoke", "(Landroid/content/Intent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onActivityResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Intent, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
            invoke2(intent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "it");
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).startStream(intent);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "", "invoke", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "", "invoke", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            WidgetVoiceBottomSheetBinding widgetVoiceBottomSheetBindingAccess$getBinding$p = WidgetVoiceBottomSheet.access$getBinding$p(WidgetVoiceBottomSheet.this);
            Intrinsics3.checkNotNullExpressionValue(widgetVoiceBottomSheetBindingAccess$getBinding$p, "binding");
            CoordinatorLayout coordinatorLayout = widgetVoiceBottomSheetBindingAccess$getBinding$p.a;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, context, GuildScheduledEventModel2.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetVoiceBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceBottomSheet.access$configureUI(WidgetVoiceBottomSheet.this, viewState);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<WidgetVoiceBottomSheetViewModel.Event, Unit> {
        public AnonymousClass4(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
            super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetVoiceBottomSheet.access$handleEvent((WidgetVoiceBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onResume$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetVoiceBottomSheet.access$setViewModelEventSubscription$p(WidgetVoiceBottomSheet.this, subscription);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onStreamPreviewClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StreamContext $streamContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StreamContext streamContext) {
            super(0);
            this.$streamContext = streamContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetVoiceBottomSheet.access$getViewModel$p(WidgetVoiceBottomSheet.this).onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(1, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onPttPressed", "onPttPressed(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onPttPressed(z2);
        }
    }

    /* compiled from: WidgetVoiceBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass2(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
            super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnect", "onDisconnect()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnect();
        }
    }

    public WidgetVoiceBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetVoiceBottomSheet3(this));
        this.forwardToFullscreenIfVideoActivated = LazyJVM.lazy(new WidgetVoiceBottomSheet5(this));
        WidgetVoiceBottomSheet7 widgetVoiceBottomSheet7 = new WidgetVoiceBottomSheet7(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetVoiceBottomSheetViewModel.class), new WidgetVoiceBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetVoiceBottomSheet7));
        this.featureContext = LazyJVM.lazy(new WidgetVoiceBottomSheet4(this));
        this.onStreamPreviewClickedListener = WidgetVoiceBottomSheet6.INSTANCE;
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceBottomSheet widgetVoiceBottomSheet, WidgetVoiceBottomSheetViewModel.ViewState viewState) {
        widgetVoiceBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetVoiceBottomSheetBinding access$getBinding$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getChannelId();
    }

    public static final /* synthetic */ boolean access$getForwardToFullscreenIfVideoActivated$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getForwardToFullscreenIfVideoActivated();
    }

    public static final /* synthetic */ WidgetVoiceBottomSheetViewModel access$getViewModel$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.getViewModel();
    }

    public static final /* synthetic */ Subscription access$getViewModelEventSubscription$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        return widgetVoiceBottomSheet.viewModelEventSubscription;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetVoiceBottomSheet widgetVoiceBottomSheet, WidgetVoiceBottomSheetViewModel.Event event) {
        widgetVoiceBottomSheet.handleEvent(event);
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetVoiceBottomSheet widgetVoiceBottomSheet, StreamContext streamContext) {
        widgetVoiceBottomSheet.onStreamPreviewClicked(streamContext);
    }

    public static final /* synthetic */ void access$setViewModelEventSubscription$p(WidgetVoiceBottomSheet widgetVoiceBottomSheet, Subscription subscription) {
        widgetVoiceBottomSheet.viewModelEventSubscription = subscription;
    }

    private final void configureBottomContent(BottomContent bottomContent, Channel channel) {
        if (bottomContent == null) {
            AnchoredVoiceControlsView anchoredVoiceControlsView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView.setVisibility(8);
            RelativeLayout relativeLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.voiceBottomSheetConnectContainer");
            relativeLayout.setVisibility(8);
            CoordinatorLayout coordinatorLayout = getBinding().i;
            CoordinatorLayout coordinatorLayout2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout2, "binding.voiceBottomSheetRoot");
            coordinatorLayout.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout2, R.attr.colorBackgroundPrimary));
            return;
        }
        if (bottomContent instanceof BottomContent.Controls) {
            AnchoredVoiceControlsView anchoredVoiceControlsView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView2, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView2.setVisibility(0);
            RelativeLayout relativeLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.voiceBottomSheetConnectContainer");
            relativeLayout2.setVisibility(8);
            AnchoredVoiceControlsView anchoredVoiceControlsView3 = getBinding().f;
            BottomContent.Controls controls = (BottomContent.Controls) bottomContent;
            MediaEngineConnection.InputMode inputMode = controls.getInputMode();
            boolean zIsMuted = controls.isMuted();
            boolean zIsScreensharing = controls.isScreensharing();
            CameraState cameraState = controls.getCameraState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(getViewModel());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(getViewModel());
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(getViewModel());
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(getViewModel());
            boolean showScreenShareSparkle = controls.getShowScreenShareSparkle();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            anchoredVoiceControlsView3.configureUI(inputMode, controls.getAudioManagerState(), zIsMuted, zIsScreensharing, showScreenShareSparkle, cameraState, anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5, this, parentFragmentManager, new AnonymousClass6(), getChannelId(), channel.getGuildId(), getForwardToFullscreenIfVideoActivated(), getFeatureContext());
            CoordinatorLayout coordinatorLayout3 = getBinding().i;
            CoordinatorLayout coordinatorLayout4 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout4, "binding.voiceBottomSheetRoot");
            coordinatorLayout3.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout4, R.attr.colorBackgroundSecondary));
        } else if (bottomContent instanceof BottomContent.Connect) {
            AnchoredVoiceControlsView anchoredVoiceControlsView4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsView4, "binding.voiceBottomSheetControls");
            anchoredVoiceControlsView4.setVisibility(4);
            getBinding().f.hidePtt();
            RelativeLayout relativeLayout3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout3, "binding.voiceBottomSheetConnectContainer");
            relativeLayout3.setVisibility(0);
            BottomContent.Connect connect = (BottomContent.Connect) bottomContent;
            if (connect.isConnectEnabled()) {
                getBinding().d.setText(R.string.join_voice_channel_cta);
                MaterialButton materialButton = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceBottomSheetConnect");
                materialButton.setEnabled(true);
            } else {
                getBinding().d.setText(R.string.channel_locked_short);
                MaterialButton materialButton2 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.voiceBottomSheetConnect");
                materialButton2.setEnabled(false);
            }
            getBinding().d.setOnClickListener(new AnonymousClass7());
            MaterialButton materialButton3 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.voiceBottomSheetJoinVideo");
            materialButton3.setEnabled(connect.isConnectEnabled());
            getBinding().g.setOnClickListener(new AnonymousClass8());
            CoordinatorLayout coordinatorLayout5 = getBinding().i;
            CoordinatorLayout coordinatorLayout6 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout6, "binding.voiceBottomSheetRoot");
            coordinatorLayout5.setBackgroundColor(ColorCompat.getThemedColor(coordinatorLayout6, R.attr.colorBackgroundPrimary));
        }
    }

    private final void configureCenterContent(CenterContent centerContent, Channel channel) {
        if (!(centerContent instanceof CenterContent.ListItems)) {
            if (!(centerContent instanceof CenterContent.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding = getBinding().f2699b;
            Intrinsics3.checkNotNullExpressionValue(layoutVoiceBottomSheetEmptyBinding, "binding.empty");
            LinearLayout linearLayout = layoutVoiceBottomSheetEmptyBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.empty.root");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
            CenterContent.Empty empty = (CenterContent.Empty) centerContent;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        LayoutVoiceBottomSheetEmptyBinding layoutVoiceBottomSheetEmptyBinding2 = getBinding().f2699b;
        Intrinsics3.checkNotNullExpressionValue(layoutVoiceBottomSheetEmptyBinding2, "binding.empty");
        LinearLayout linearLayout2 = layoutVoiceBottomSheetEmptyBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.empty.root");
        linearLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.voiceBottomSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((CenterContent.ListItems) centerContent).getItems());
        CallParticipantsAdapter callParticipantsAdapter3 = this.participantsAdapter;
        if (callParticipantsAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter3.setOnStreamPreviewClicked(new AnonymousClass1(this));
        CallParticipantsAdapter callParticipantsAdapter4 = this.participantsAdapter;
        if (callParticipantsAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter4.setOnVoiceUserClicked(new AnonymousClass2(channel));
        CallParticipantsAdapter callParticipantsAdapter5 = this.participantsAdapter;
        if (callParticipantsAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter5.setOnToggleRingingClicked(new AnonymousClass3());
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnInviteFriendsClicked(new AnonymousClass4(channel));
        CallParticipantsAdapter callParticipantsAdapter7 = this.participantsAdapter;
        if (callParticipantsAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter7.setOnEmbeddedActivityClicked(new AnonymousClass5());
    }

    private final void configureUI(WidgetVoiceBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().c.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.header.voiceBottomSheetHeaderTitle");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.header.voiceBottomSheetHeaderSubtitle");
        ViewExtensions.setTextAndVisibilityBy(textView2, viewState.getSubtitle());
        ImageView imageView = getBinding().c.f208b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView.setActivated(viewState.getIsDeafened());
        ImageView imageView2 = getBinding().c.f208b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.header.voiceBottomSheetHeaderDeafen");
        imageView2.setContentDescription(viewState.getIsDeafened() ? getString(R.string.undeafen) : getString(R.string.deafen));
        getBinding().c.f208b.setOnClickListener(new AnonymousClass1());
        ImageView imageView3 = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.header.voiceBottomSheetHeaderInvite");
        imageView3.setVisibility(viewState.getShowInviteOption() ? 0 : 8);
        getBinding().c.c.setOnClickListener(new AnonymousClass2(viewState));
        getBinding().c.e.setOnClickListener(new AnonymousClass3());
        getBinding().c.d.setOnClickListener(new AnonymousClass4());
        if (viewState.getIsNoiseCancellationActive() != null) {
            if (Intrinsics3.areEqual(viewState.getIsNoiseCancellationActive(), Boolean.TRUE)) {
                getBinding().c.d.setImageResource(R.drawable.ic_noise_cancellation_active_24dp);
            } else {
                getBinding().c.d.setImageResource(R.drawable.ic_noise_cancellation_disabled_24dp);
            }
            ImageView imageView4 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView4.setVisibility(0);
        } else {
            ImageView imageView5 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.header.voiceBott…etHeaderNoiseCancellation");
            imageView5.setVisibility(8);
        }
        configureCenterContent(viewState.getCenterContent(), viewState.getChannel());
        configureBottomContent(viewState.getBottomContent(), viewState.getChannel());
    }

    private final WidgetVoiceBottomSheetBinding getBinding() {
        return (WidgetVoiceBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final FeatureContext getFeatureContext() {
        return (FeatureContext) this.featureContext.getValue();
    }

    private final boolean getForwardToFullscreenIfVideoActivated() {
        return ((Boolean) this.forwardToFullscreenIfVideoActivated.getValue()).booleanValue();
    }

    private final WidgetVoiceBottomSheetViewModel getViewModel() {
        return (WidgetVoiceBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetVoiceBottomSheetViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowSuppressedDialog.INSTANCE)) {
            showSuppressedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerMutedDialog.INSTANCE)) {
            showServerMutedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowServerDeafenedDialog.INSTANCE)) {
            showServerDeafenedDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoPermissionDialog.INSTANCE)) {
            showNoVideoPermissionDialog();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowNoVideoDevicesAvailableToast.INSTANCE)) {
            showNoVideoDevicesToast();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowRequestCameraPermissionsDialog.INSTANCE)) {
            requestVideoCallPermissions(new AnonymousClass1());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) {
            CameraCapacityDialog.Companion aVar = CameraCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager, ((WidgetVoiceBottomSheetViewModel.Event.ShowCameraCapacityDialog) event).getGuildMaxVideoChannelUsers());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowNoiseCancellationBottomSheet) {
            WidgetNoiseCancellationBottomSheet.INSTANCE.show(this);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall) {
            Subscription subscription = this.viewModelEventSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall launchVideoCall = (WidgetVoiceBottomSheetViewModel.Event.LaunchVideoCall) event;
            WidgetCallFullscreen.Companion.launch$default(companion, contextRequireContext, launchVideoCall.getChannelId(), false, launchVideoCall.getAutoTargetStreamKey(), null, 20, null);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.LaunchStageChannel) {
            Subscription subscription2 = this.viewModelEventSubscription;
            if (subscription2 != null) {
                subscription2.unsubscribe();
            }
            dismiss();
            WidgetCallFullscreen.Companion companion2 = WidgetCallFullscreen.INSTANCE;
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            WidgetCallFullscreen.Companion.launch$default(companion2, contextRequireContext2, ((WidgetVoiceBottomSheetViewModel.Event.LaunchStageChannel) event).getChannelId(), false, null, null, 28, null);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion aVar2 = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            aVar2.a(parentFragmentManager2);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowToast) {
            AppToast.g(requireContext(), ((WidgetVoiceBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) {
            WidgetEndGuildScheduledEventBottomSheet.Companion companion3 = WidgetEndGuildScheduledEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd showEventEnd = (WidgetVoiceBottomSheetViewModel.Event.ShowEventEnd) event;
            companion3.show(parentFragmentManager3, END_EVENT_REQUEST_KEY, showEventEnd.getGuildScheduledEvent().getGuildId(), showEventEnd.getGuildScheduledEvent().getId());
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) {
            WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet enqueueCallFeedbackSheet = (WidgetVoiceBottomSheetViewModel.Event.EnqueueCallFeedbackSheet) event;
            CallFeedbackSheetNavigator.INSTANCE.enqueueNotice(enqueueCallFeedbackSheet.getChannelId(), enqueueCallFeedbackSheet.getRtcConnectionId(), enqueueCallFeedbackSheet.getMediaSessionId(), Long.valueOf(enqueueCallFeedbackSheet.getCallDuration()), enqueueCallFeedbackSheet.getTriggerRateDenominator());
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Context contextRequireContext3 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            String string = getString(((WidgetVoiceBottomSheetViewModel.Event.AccessibilityAnnouncement) event).getMessageResId());
            Intrinsics3.checkNotNullExpressionValue(string, "getString(event.messageResId)");
            accessibilityUtils.sendAnnouncement(contextRequireContext3, string);
            return;
        }
        if (event instanceof WidgetVoiceBottomSheetViewModel.Event.ShowNoScreenSharePermissionDialog) {
            showNoScreenSharePermissionDialog();
        } else if (Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.RequestStartStream.INSTANCE)) {
            StreamNavigator.requestStartStream(this);
        } else {
            if (!Intrinsics3.areEqual(event, WidgetVoiceBottomSheetViewModel.Event.ExpandSheet.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            setBottomSheetState(3);
        }
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        int iOrdinal = getFeatureContext().ordinal();
        if (iOrdinal == 0) {
            AnimatableValueParser.S1(this, null, new AnonymousClass1(streamContext), 1, null);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            this.onStreamPreviewClickedListener.invoke(streamContext);
        }
    }

    private final void showNoScreenSharePermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(R.string.no_screenshare_permission_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…e_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showNoVideoDevicesToast() {
        AppToast.i(this, R.string.no_video_devices, 0, 4);
    }

    private final void showNoVideoPermissionDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.no_video_permission_dialog_title);
        String string2 = contextRequireContext.getString(R.string.no_video_permission_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…o_permission_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerDeafenedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.server_deafened_dialog_title);
        String string2 = contextRequireContext.getString(R.string.server_deafened_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ver_deafened_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showServerMutedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.server_muted_dialog_title);
        String string2 = contextRequireContext.getString(R.string.server_muted_dialog_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…server_muted_dialog_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showSuppressedDialog() {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        String string = contextRequireContext.getString(R.string.suppressed);
        String string2 = contextRequireContext.getString(R.string.suppressed_permission_body);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…ppressed_permission_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_bottom_sheet;
    }

    public final Function1<StreamContext, Unit> getOnStreamPreviewClickedListener() {
        return this.onStreamPreviewClickedListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        StreamNavigator.handleActivityResult(requestCode, resultCode, intent, new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.voiceBottomSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, false, true, 2, null));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new AnonymousClass1());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new AnonymousClass2());
        getBinding().h.setHasFixedSize(false);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetVoiceBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetVoiceBottomSheet.class, (Context) null, new AnonymousClass5(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(this), 58, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
        getBinding().f.setOnPttPressedListener(new AnonymousClass1(getViewModel()));
        WidgetEndGuildScheduledEventBottomSheet.INSTANCE.registerForResult(this, END_EVENT_REQUEST_KEY, new AnonymousClass2(getViewModel()));
    }

    public final void setOnStreamPreviewClickedListener(Function1<? super StreamContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onStreamPreviewClickedListener = function1;
    }
}
