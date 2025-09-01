package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.GuildVideoAtCapacityDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.LayoutFullscreenCallPreviewEmptyBinding;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetCallPreviewFullscreenBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreenViewModel;
import com.discord.widgets.voice.sheet.CallParticipantsAdapter;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: WidgetCallPreviewFullscreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b?\u0010\u001bJ\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ#\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010\u001bR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001d\u00102\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010>\u001a\u0002098B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreen;", "Lcom/discord/app/AppFragment;", "", "Lcom/discord/primitives/ChannelId;", "getVoiceChannelId", "()J", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;", "viewState", "", "configureActionBar", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;)V", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;", "participantsList", "Lcom/discord/api/channel/Channel;", "channel", "configureParticipants", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ParticipantsList;Lcom/discord/api/channel/Channel;)V", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "onStreamPreviewClicked", "(Lcom/discord/utilities/streams/StreamContext;)V", "configureUI", "", "isHidden", "onNsfwToggle", "(Z)V", "onDenyNsfw", "()V", "transitionActivity", "selectTextChannel", "transition", "finishActivity", "(ZZ)V", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/home/WidgetHomePanelNsfw;", "panelNsfw", "Lcom/discord/widgets/home/WidgetHomePanelNsfw;", "Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel;", "viewModel", "Lrx/Subscription;", "viewModelEventSubscription", "Lrx/Subscription;", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter;", "participantsAdapter", "Lcom/discord/widgets/voice/sheet/CallParticipantsAdapter;", "Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen extends AppFragment {
    private static final String ANALYTICS_SOURCE = "Fullscreen Voice Channel Preview";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetHomePanelNsfw panelNsfw;
    private CallParticipantsAdapter participantsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private Subscription viewModelEventSubscription;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCallPreviewFullscreen.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCallPreviewFullscreenBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreen$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/app/AppTransitionActivity$Transition;", "transition", "", "launch", "(Landroid/content/Context;JLcom/discord/app/AppTransitionActivity$Transition;)V", "", "ANALYTICS_SOURCE", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, AppTransitionActivity.Transition transition, int i, Object obj) {
            if ((i & 4) != 0) {
                transition = null;
            }
            companion.launch(context, j, transition);
        }

        public final void launch(Context context, long channelId, AppTransitionActivity.Transition transition) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) WidgetCallFullscreen.class);
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("transition", transition);
            AppScreen2.d(context, WidgetCallPreviewFullscreen.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "context", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetCallPreviewFullscreenViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_invite) {
                return;
            }
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$viewState.getVoiceChannel(), WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/Menu;", "kotlin.jvm.PlatformType", "menu", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/Menu;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetCallPreviewFullscreenViewModel.ViewState $viewState;

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureActionBar$3$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCallPreviewFullscreen.access$transitionActivity(WidgetCallPreviewFullscreen.this);
                WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).onTextInVoiceTapped();
            }
        }

        public AnonymousClass3(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            boolean z2 = this.$viewState.isChannelNsfw() && (this.$viewState.isNsfwUnconsented() || this.$viewState.getNsfwAllowed() == NsfwAllowance.DISALLOWED);
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_text_in_voice);
            boolean z3 = this.$viewState.getTextInVoiceEnabled() && this.$viewState.isConnectEnabled() && !z2;
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "textInVoiceMenuItem");
            menuItemFindItem.setVisible(z3);
            if (z3) {
                View actionView = menuItemFindItem.getActionView();
                TextView textView = actionView != null ? (TextView) actionView.findViewById(R.id.text_in_voice_count) : null;
                View actionView2 = menuItemFindItem.getActionView();
                ImageView imageView = actionView2 != null ? (ImageView) actionView2.findViewById(R.id.text_in_voice_icon) : null;
                int channelMentionsCount = this.$viewState.getChannelMentionsCount();
                if (channelMentionsCount > 0) {
                    if (textView != null) {
                        ViewKt.setVisible(textView, true);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.ic_text_in_voice_cutout);
                    }
                    if (textView != null) {
                        textView.setBackground(ContextCompat.getDrawable(WidgetCallPreviewFullscreen.this.requireContext(), R.drawable.drawable_circle_red));
                    }
                    if (textView != null) {
                        textView.setText(String.valueOf(Math.min(99, channelMentionsCount)));
                    }
                    if (textView != null) {
                        textView.setTextColor(ContextCompat.getColor(WidgetCallPreviewFullscreen.this.requireContext(), R.color.white));
                    }
                } else {
                    if (textView != null) {
                        ViewKt.setVisible(textView, false);
                    }
                    if (imageView != null) {
                        imageView.setImageResource(R.drawable.ic_text_in_voice);
                    }
                }
                menuItemFindItem.getActionView().setOnClickListener(new AnonymousClass1());
            }
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_invite);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "inviteMenuItem");
            menuItemFindItem2.setVisible(!z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/streams/StreamContext;", "p1", "", "invoke", "(Lcom/discord/utilities/streams/StreamContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StreamContext, Unit> {
        public AnonymousClass1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
            invoke2(streamContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StreamContext streamContext) {
            Intrinsics3.checkNotNullParameter(streamContext, "p1");
            WidgetCallPreviewFullscreen.access$onStreamPreviewClicked((WidgetCallPreviewFullscreen) this.receiver, streamContext);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "clickedUser", "", "invoke", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$2, reason: invalid class name */
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
            FragmentManager childFragmentManager = WidgetCallPreviewFullscreen.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, childFragmentManager, Long.valueOf(this.$channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Channel channel) {
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
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetCallPreviewFullscreen.this, this.$channel, WidgetCallPreviewFullscreen.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureParticipants$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Context contextRequireContext = WidgetCallPreviewFullscreen.this.requireContext();
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(contextRequireContext, "context");
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            String string = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_title);
            String string2 = contextRequireContext.getString(R.string.embedded_activities_desktop_only_modal_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…p_only_modal_description)");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, contextRequireContext.getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03641 extends Lambda implements Function0<Unit> {
            public C03641() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetCallPreviewFullscreenViewModel.tryConnectToVoice$default(WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this), false, 1, null);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.S1(WidgetCallPreviewFullscreen.this, null, new C03641(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetCallPreviewFullscreen.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$2$1, reason: invalid class name */
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
                WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).tryConnectToVoice(true);
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.S1(WidgetCallPreviewFullscreen.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "p1", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public AnonymousClass3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetCallPreviewFullscreen.access$onNsfwToggle((WidgetCallPreviewFullscreen) this.receiver, z2);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$configureUI$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallPreviewFullscreen.access$onDenyNsfw((WidgetCallPreviewFullscreen) this.receiver);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onStreamPreviewClicked$1, reason: invalid class name */
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
            WidgetCallPreviewFullscreen.access$getViewModel$p(WidgetCallPreviewFullscreen.this).onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(insets.left);
            layoutParams2.setMarginEnd(insets.right);
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "view", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "windowView", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements OnApplyWindowInsetsListener {
        public AnonymousClass5() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "windowView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
            Resources resources = WidgetCallPreviewFullscreen.this.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            Resources resources2 = WidgetCallPreviewFullscreen.this.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = DimenUtils.dpToPixels(companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "", "invoke", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass6() {
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
            FragmentManager parentFragmentManager = WidgetCallPreviewFullscreen.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForGuild(parentFragmentManager, guildScheduledEvent.getId());
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "", "invoke", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public AnonymousClass7() {
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
            WidgetCallPreviewFullscreenBinding widgetCallPreviewFullscreenBindingAccess$getBinding$p = WidgetCallPreviewFullscreen.access$getBinding$p(WidgetCallPreviewFullscreen.this);
            Intrinsics3.checkNotNullExpressionValue(widgetCallPreviewFullscreenBindingAccess$getBinding$p, "binding");
            ConstraintLayout constraintLayout = widgetCallPreviewFullscreenBindingAccess$getBinding$p.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, context, GuildScheduledEventModel2.toModel(guildScheduledEvent), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(guildScheduledEvent.getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), null, false, 24, null);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;", "it", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetCallPreviewFullscreenViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetCallPreviewFullscreen.access$configureUI(WidgetCallPreviewFullscreen.this, viewState);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetCallPreviewFullscreenViewModel.Event, Unit> {
        public AnonymousClass2(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
            super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/fullscreen/WidgetCallPreviewFullscreenViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetCallPreviewFullscreenViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetCallPreviewFullscreenViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetCallPreviewFullscreen.access$handleEvent((WidgetCallPreviewFullscreen) this.receiver, event);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
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
            WidgetCallPreviewFullscreen.access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen.this, subscription);
        }
    }

    /* compiled from: WidgetCallPreviewFullscreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4<R> implements Func0<Boolean> {
        public AnonymousClass4() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetCallPreviewFullscreen.finishActivity$default(WidgetCallPreviewFullscreen.this, true, false, 2, null);
            return Boolean.TRUE;
        }
    }

    public WidgetCallPreviewFullscreen() {
        super(R.layout.widget_call_preview_fullscreen);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCallPreviewFullscreen2.INSTANCE, null, 2, null);
        WidgetCallPreviewFullscreen3 widgetCallPreviewFullscreen3 = new WidgetCallPreviewFullscreen3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetCallPreviewFullscreenViewModel.class), new WidgetCallPreviewFullscreen$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetCallPreviewFullscreen3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        widgetCallPreviewFullscreen.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenBinding access$getBinding$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getBinding();
    }

    public static final /* synthetic */ WidgetCallPreviewFullscreenViewModel access$getViewModel$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getViewModel();
    }

    public static final /* synthetic */ Subscription access$getViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.viewModelEventSubscription;
    }

    public static final /* synthetic */ long access$getVoiceChannelId(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        return widgetCallPreviewFullscreen.getVoiceChannelId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, WidgetCallPreviewFullscreenViewModel.Event event) {
        widgetCallPreviewFullscreen.handleEvent(event);
    }

    public static final /* synthetic */ void access$onDenyNsfw(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.onDenyNsfw();
    }

    public static final /* synthetic */ void access$onNsfwToggle(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2) {
        widgetCallPreviewFullscreen.onNsfwToggle(z2);
    }

    public static final /* synthetic */ void access$onStreamPreviewClicked(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, StreamContext streamContext) {
        widgetCallPreviewFullscreen.onStreamPreviewClicked(streamContext);
    }

    public static final /* synthetic */ void access$setViewModelEventSubscription$p(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, Subscription subscription) {
        widgetCallPreviewFullscreen.viewModelEventSubscription = subscription;
    }

    public static final /* synthetic */ void access$transitionActivity(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        widgetCallPreviewFullscreen.transitionActivity();
    }

    private final void configureActionBar(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        boolean z2 = viewState.getOtherChannelsMentionsCount() > 0;
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.callFullscreenMentions");
        textView.setText(String.valueOf(viewState.getOtherChannelsMentionsCount()));
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.callFullscreenMentions");
        textView2.setVisibility(z2 ? 0 : 8);
        Toolbar toolbar = getBinding().f2249b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext(), z2 ? R.drawable.ic_call_toolbar_stage_minimize_cutout : R.drawable.ic_call_toolbar_stage_minimize));
        getBinding().f2249b.setNavigationOnClickListener(new AnonymousClass1());
        setActionBarOptionsMenu(R.menu.menu_call_preview_fullscreen, new AnonymousClass2(viewState), new AnonymousClass3(viewState));
        int color = ColorCompat.getColor(this, R.color.transparent);
        String titleText = viewState.getTitleText();
        if (titleText == null) {
            titleText = "";
        }
        setActionBarTitle(titleText);
        setActionBarTitleColor(-1);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
    }

    private final void configureParticipants(WidgetCallPreviewFullscreenViewModel.ParticipantsList participantsList, Channel channel) {
        if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems)) {
            if (!(participantsList instanceof WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty)) {
                throw new NoWhenBranchMatchedException();
            }
            LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding = getBinding().l;
            Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding, "binding.empty");
            ConstraintLayout constraintLayout = layoutFullscreenCallPreviewEmptyBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.empty.root");
            constraintLayout.setVisibility(0);
            RecyclerView recyclerView = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
            WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty empty = (WidgetCallPreviewFullscreenViewModel.ParticipantsList.Empty) participantsList;
            recyclerView.setVisibility(empty.getItems().isEmpty() ^ true ? 0 : 8);
            CallParticipantsAdapter callParticipantsAdapter = this.participantsAdapter;
            if (callParticipantsAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
            }
            callParticipantsAdapter.setData(empty.getItems());
            return;
        }
        LayoutFullscreenCallPreviewEmptyBinding layoutFullscreenCallPreviewEmptyBinding2 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(layoutFullscreenCallPreviewEmptyBinding2, "binding.empty");
        ConstraintLayout constraintLayout2 = layoutFullscreenCallPreviewEmptyBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.empty.root");
        constraintLayout2.setVisibility(4);
        RecyclerView recyclerView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.callPreviewVoiceSheetRecycler");
        recyclerView2.setVisibility(0);
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setData(((WidgetCallPreviewFullscreenViewModel.ParticipantsList.ListItems) participantsList).getItems());
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
        callParticipantsAdapter5.setOnInviteFriendsClicked(new AnonymousClass3(channel));
        CallParticipantsAdapter callParticipantsAdapter6 = this.participantsAdapter;
        if (callParticipantsAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter6.setOnEmbeddedActivityClicked(new AnonymousClass4());
    }

    private final void configureUI(WidgetCallPreviewFullscreenViewModel.ViewState viewState) {
        configureActionBar(viewState);
        configureParticipants(viewState.getParticipantsList(), viewState.getVoiceChannel());
        if (viewState.isConnectEnabled()) {
            getBinding().i.setText(R.string.join_voice);
            getBinding().h.setText(R.string.join_muted);
            MaterialButton materialButton = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.callPreviewJoinVoice");
            materialButton.setEnabled(true);
            MaterialButton materialButton2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.callPreviewJoinMuted");
            materialButton2.setEnabled(true);
        } else {
            getBinding().i.setText(R.string.channel_locked_short);
            MaterialButton materialButton3 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.callPreviewJoinVoice");
            materialButton3.setEnabled(false);
            getBinding().h.setText(R.string.channel_locked_short);
            MaterialButton materialButton4 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.callPreviewJoinMuted");
            materialButton4.setEnabled(false);
        }
        getBinding().i.setOnClickListener(new AnonymousClass1());
        getBinding().h.setOnClickListener(new AnonymousClass2());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            widgetHomePanelNsfw.configureUI(viewState.getVoiceChannel().getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().j, new AnonymousClass3(this), new AnonymousClass4(this));
        }
    }

    private final void finishActivity(boolean selectTextChannel, boolean transition) {
        if (selectTextChannel) {
            getViewModel().selectTextChannelAfterFinish();
        }
        Subscription subscription = this.viewModelEventSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        requireAppActivity().finish();
        if (transition) {
            requireAppActivity().overridePendingTransition(0, R.anim.anim_slide_out_down);
        }
    }

    public static /* synthetic */ void finishActivity$default(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        widgetCallPreviewFullscreen.finishActivity(z2, z3);
    }

    private final WidgetCallPreviewFullscreenBinding getBinding() {
        return (WidgetCallPreviewFullscreenBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetCallPreviewFullscreenViewModel getViewModel() {
        return (WidgetCallPreviewFullscreenViewModel) this.viewModel.getValue();
    }

    private final long getVoiceChannelId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final void handleEvent(WidgetCallPreviewFullscreenViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowGuildVideoAtCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion companion = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.a(parentFragmentManager);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetCallPreviewFullscreenViewModel.Event.ShowOverlayNux.INSTANCE)) {
            WidgetNoticeNuxOverlay.INSTANCE.enqueue();
        } else {
            if (!(event instanceof WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall)) {
                throw new NoWhenBranchMatchedException();
            }
            finishActivity$default(this, false, false, 1, null);
            WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall launchVideoCall = (WidgetCallPreviewFullscreenViewModel.Event.LaunchVideoCall) event;
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), launchVideoCall.getChannelId(), false, launchVideoCall.getAutoTargetStreamKey(), null, 20, null);
        }
    }

    public static final void launch(Context context, long j, AppTransitionActivity.Transition transition) {
        INSTANCE.launch(context, j, transition);
    }

    private final void onDenyNsfw() {
        finishActivity$default(this, true, false, 2, null);
    }

    private final void onNsfwToggle(boolean isHidden) {
        ConstraintLayout constraintLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenBody");
        constraintLayout.setVisibility(isHidden ^ true ? 0 : 8);
    }

    private final void onStreamPreviewClicked(StreamContext streamContext) {
        AnimatableValueParser.S1(this, null, new AnonymousClass1(streamContext), 1, null);
    }

    private final void transitionActivity() {
        finishActivity$default(this, false, false, 3, null);
        requireAppActivity().overridePendingTransition(R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().g, AnonymousClass1.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().l.f183b, AnonymousClass2.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().k, AnonymousClass3.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().c, AnonymousClass4.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().e, new AnonymousClass5());
        ConstraintLayout constraintLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.callFullscreenParent");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.callPreviewVoiceSheetRecycler");
        CallParticipantsAdapter callParticipantsAdapter = (CallParticipantsAdapter) companion.configure(new CallParticipantsAdapter(recyclerView, true, true));
        this.participantsAdapter = callParticipantsAdapter;
        if (callParticipantsAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter.setOnEventClicked(new AnonymousClass6());
        CallParticipantsAdapter callParticipantsAdapter2 = this.participantsAdapter;
        if (callParticipantsAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("participantsAdapter");
        }
        callParticipantsAdapter2.setOnStartEventClicked(new AnonymousClass7());
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetCallPreviewFullscreen.class, (Context) null, new AnonymousClass3(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 58, (Object) null);
        AppFragment.setOnBackPressed$default(this, new AnonymousClass4(), 0, 2, null);
    }
}
