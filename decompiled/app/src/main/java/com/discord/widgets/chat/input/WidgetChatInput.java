package com.discord.widgets.chat.input;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.ImageUploadFailedDialog;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetChatInputCommunicationDisabledGuardBinding;
import b.a.i.WidgetChatInputGuardBinding;
import b.a.i.WidgetChatInputMemberVerificationGuardBinding;
import b.a.k.FormatUtils;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.databinding.WidgetChatInputBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.models.member.GuildMember;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.discord.widgets.announcements.WidgetChannelFollowSheet;
import com.discord.widgets.chat.MessageContent;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.input.ChatInputViewModel;
import com.discord.widgets.chat.input.MessageDraftsRepo;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import com.lytefast.flexinput.FlexInputListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChatInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bj\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\n\u0010\u000f\u001a\u00060\u000bj\u0002`\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010\u001aJ%\u0010&\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0003¢\u0006\u0004\b*\u0010+J!\u00101\u001a\u0004\u0018\u0001002\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b1\u00102J!\u00104\u001a\u0004\u0018\u0001032\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b4\u00105J/\u0010:\u001a\u0002002\u0006\u0010-\u001a\u00020,2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0004H\u0016¢\u0006\u0004\b@\u0010\u0013R\u001d\u0010F\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020G8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001d\u0010Q\u001a\u00020M8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010C\u001a\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001d\u0010Y\u001a\u00020U8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010C\u001a\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020]8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001d\u0010\u0003\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lcom/discord/widgets/chat/input/WidgetChatInput;", "Lcom/discord/app/AppFragment;", "Lcom/discord/databinding/WidgetChatInputBinding;", "binding", "", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetChatInputBinding;)V", "", "shouldApplyWindowInsets", "setWindowInsetsListeners", "(Z)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "showFollowSheet", "(JJ)V", "populateDirectShareData", "()V", "Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;", "viewState", "configureUI", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", "Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState$Loaded;", "configureChatGuard", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState$Loaded;)V", "configureSendListeners", "configureContextBar", "configureContextBarEditing", "Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying;", "model", "configureContextBarReplying", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState$Loaded$PendingReplyState$Replying;)V", "configureInitialText", "configureText", "focused", "clearText", "clearInput", "(Ljava/lang/Boolean;Z)V", "Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;", "event", "handleEvent", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", "Landroid/content/Context;", "context", "Lcom/discord/api/guild/GuildVerificationLevel;", "verificationLevelTriggered", "", "getVerificationText", "(Landroid/content/Context;Lcom/discord/api/guild/GuildVerificationLevel;)Ljava/lang/CharSequence;", "", "getVerificationActionText", "(Landroid/content/Context;Lcom/discord/api/guild/GuildVerificationLevel;)Ljava/lang/String;", "Lcom/discord/api/channel/Channel;", "channel", "isBlocked", "hasSendMessagePermissions", "getHint", "(Landroid/content/Context;Lcom/discord/api/channel/Channel;ZZ)Ljava/lang/CharSequence;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "Lcom/discord/widgets/chat/input/ChatInputViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/chat/input/ChatInputViewModel;", "viewModel", "Lcom/discord/utilities/views/ViewVisibilityObserver;", "inlineVoiceVisibilityObserver", "Lcom/discord/utilities/views/ViewVisibilityObserver;", "Lcom/discord/widgets/chat/input/WidgetChatInputTruncatedHint;", "chatInputTruncatedHint", "Lcom/discord/widgets/chat/input/WidgetChatInputTruncatedHint;", "Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "flexInputFragment$delegate", "getFlexInputFragment", "()Lcom/lytefast/flexinput/fragment/FlexInputFragment;", "flexInputFragment", "Lcom/discord/widgets/chat/input/autocomplete/InputAutocomplete;", "autocomplete", "Lcom/discord/widgets/chat/input/autocomplete/InputAutocomplete;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel$delegate", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/WidgetChatInputAttachments;", "chatAttachments", "Lcom/discord/widgets/chat/input/WidgetChatInputAttachments;", "Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "messageDraftsRepo", "Lcom/discord/widgets/chat/input/MessageDraftsRepo;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChatInputBinding;", "Lcom/discord/widgets/chat/input/WidgetChatInputEditText;", "chatInputEditTextHolder", "Lcom/discord/widgets/chat/input/WidgetChatInputEditText;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatInput extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChatInput.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatInputBinding;", 0)};
    private InputAutocomplete autocomplete;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetChatInputAttachments chatAttachments;
    private WidgetChatInputEditText chatInputEditTextHolder;
    private WidgetChatInputTruncatedHint chatInputTruncatedHint;
    private final Clock clock;

    /* renamed from: flexInputFragment$delegate, reason: from kotlin metadata */
    private final Lazy flexInputFragment;

    /* renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;
    private final MessageDraftsRepo messageDraftsRepo;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 1;
            iArr[ApplicationStatus.PENDING.ordinal()] = 2;
            GuildVerificationLevel.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.LOW;
            iArr2[guildVerificationLevel.ordinal()] = 1;
            iArr2[GuildVerificationLevel.MEDIUM.ordinal()] = 2;
            iArr2[GuildVerificationLevel.HIGH.ordinal()] = 3;
            GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.HIGHEST;
            iArr2[guildVerificationLevel2.ordinal()] = 4;
            GuildVerificationLevel.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildVerificationLevel.ordinal()] = 1;
            iArr3[guildVerificationLevel2.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(ChatInputViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$showFollowSheet(WidgetChatInput.this, this.$viewState.getChannel().getId(), this.$viewState.getChannel().getGuildId());
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $viewState;

        public AnonymousClass2(ChatInputViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$showFollowSheet(WidgetChatInput.this, this.$viewState.getChannel().getId(), this.$viewState.getChannel().getGuildId());
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).lurkGuild(WidgetChatInput.this);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).lurkGuild(WidgetChatInput.this);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ String $guideUrl;

        public AnonymousClass5(String str) {
            this.$guideUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetChatInput.access$getBinding$p(WidgetChatInput.this).f2304s.f205b, "binding.guardCommunicati…nicationDisabledGuardText", "binding.guardCommunicati…DisabledGuardText.context"), this.$guideUrl, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetChatInput.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            }
        }

        public AnonymousClass6(ChatInputViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
            Context contextRequireContext = WidgetChatInput.this.requireContext();
            FragmentManager parentFragmentManager = WidgetChatInput.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, contextRequireContext, parentFragmentManager, this.$viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, null, null, AnonymousClass1.INSTANCE, 48, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetChatInput.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            }
        }

        public AnonymousClass7(ChatInputViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
            Context contextRequireContext = WidgetChatInput.this.requireContext();
            FragmentManager parentFragmentManager = WidgetChatInput.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            MemberVerificationUtils.maybeShowVerificationGate$default(memberVerificationUtils, contextRequireContext, parentFragmentManager, this.$viewState.getChannel().getGuildId(), Traits.Location.Page.GUILD_CHANNEL, null, null, AnonymousClass1.INSTANCE, 48, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureChatGuard$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChatInputViewModel chatInputViewModelAccess$getViewModel$p = WidgetChatInput.access$getViewModel$p(WidgetChatInput.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            chatInputViewModelAccess$getViewModel$p.verifyAccount(context);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarEditing$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.clearInput$default(WidgetChatInput.this, Boolean.FALSE, false, 2, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying replying) {
            super(1);
            this.$context = context;
            this.$model = replying;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(GuildMember.INSTANCE.getColor(this.$model.getRepliedAuthorGuildMember(), ColorCompat.getThemedColor(this.$context, R.attr.colorHeaderPrimary)));
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying $model;

        public AnonymousClass2(ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying replying) {
            this.$model = replying;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).jumpToMessageReference(this.$model.getMessageReference());
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).deletePendingReply();
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureContextBarReplying$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).togglePendingReplyShouldMention();
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\r\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "applicationCommandData", "", "Lcom/discord/models/commands/ApplicationCommandOption;", "Lcom/lytefast/flexinput/model/Attachment;", "attachments", "", "autocomplete", "Lkotlin/Function1;", "", "onValidationResult", "invoke", "(Lcom/discord/widgets/chat/input/models/ApplicationCommandData;Ljava/util/Map;ZLkotlin/jvm/functions/Function1;)V", "sendCommand"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function4<ApplicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>>, Boolean, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* compiled from: WidgetChatInput.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02521 extends Lambda implements Function1<Boolean, Unit> {
            public static final C02521 INSTANCE = new C02521();

            public C02521() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, MessageManager messageManager) {
            super(4);
            this.$context = context;
            this.$messageManager = messageManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void invoke$default(AnonymousClass1 anonymousClass1, ApplicationCommandData applicationCommandData, Map map, boolean z2, Function1 function1, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                function1 = C02521.INSTANCE;
            }
            anonymousClass1.invoke(applicationCommandData, (Map<ApplicationCommandOption, ? extends Attachment<?>>) map, z2, (Function1<? super Boolean, Unit>) function1);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, Boolean bool, Function1<? super Boolean, ? extends Unit> function1) {
            invoke(applicationCommandData, map, bool.booleanValue(), (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        public final void invoke(ApplicationCommandData applicationCommandData, Map<ApplicationCommandOption, ? extends Attachment<?>> map, boolean z2, Function1<? super Boolean, Unit> function1) {
            Intrinsics3.checkNotNullParameter(applicationCommandData, "applicationCommandData");
            Intrinsics3.checkNotNullParameter(map, "attachments");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).sendCommand(this.$context, this.$messageManager, applicationCommandData, map, z2, false, function1);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u00072\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/lytefast/flexinput/model/Attachment;", "attachmentsRaw", "Lcom/discord/widgets/chat/input/models/ApplicationCommandData;", "applicationCommandData", "Lkotlin/Function1;", "", "", "onValidationResult", "invoke", "(Ljava/util/List;Lcom/discord/widgets/chat/input/models/ApplicationCommandData;Lkotlin/jvm/functions/Function1;)V", "sendMessage"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function3<List<? extends Attachment<?>>, ApplicationCommandData, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ WidgetChatInputEditText $chatInput;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ MessageManager $messageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetChatInputEditText widgetChatInputEditText, Context context, MessageManager messageManager) {
            super(3);
            this.$chatInput = widgetChatInputEditText;
            this.$context = context;
            this.$messageManager = messageManager;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, applicationCommandData, (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, ApplicationCommandData applicationCommandData, Function1<? super Boolean, Unit> function1) {
            MessageContent messageContent;
            MessageContent messageContent2;
            ApplicationCommand applicationCommand;
            String strInvoke;
            Intrinsics3.checkNotNullParameter(list, "attachmentsRaw");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(WidgetChatInput.this);
            if (inputAutocompleteAccess$getAutocomplete$p == null || (messageContent = inputAutocompleteAccess$getAutocomplete$p.getInputContent()) == null) {
                messageContent = new MessageContent(this.$chatInput.getText(), Collections2.emptyList());
            }
            if (applicationCommandData == null || (applicationCommand = applicationCommandData.getApplicationCommand()) == null || !applicationCommand.getBuiltIn()) {
                messageContent2 = messageContent;
            } else {
                ApplicationCommand applicationCommand2 = applicationCommandData.getApplicationCommand();
                List<ApplicationCommandValue> values = applicationCommandData.getValues();
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(values, 10)), 16));
                for (Object obj : values) {
                    linkedHashMap.put(((ApplicationCommandValue) obj).getName(), obj);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    linkedHashMap2.put(entry.getKey(), ((ApplicationCommandValue) entry.getValue()).getValue());
                }
                WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).onCommandUsed(applicationCommandData);
                Function1<Map<String, ? extends Object>, String> execute = applicationCommand2.getExecute();
                if (execute == null || (strInvoke = execute.invoke(linkedHashMap2)) == null) {
                    strInvoke = "";
                }
                messageContent2 = new MessageContent(strInvoke, messageContent.getMentionedUsers());
            }
            ChatInputViewModel.sendMessage$default(WidgetChatInput.access$getViewModel$p(WidgetChatInput.this), this.$context, this.$messageManager, messageContent2, list, false, function1, 16, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u00052\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/lytefast/flexinput/model/Attachment;", "attachmentsRaw", "Lkotlin/Function1;", "", "", "onValidationResult", "invoke", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "trySend"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<List<? extends Attachment<?>>, Function1<? super Boolean, ? extends Unit>, Unit> {
        public final /* synthetic */ AnonymousClass1 $sendCommand$1;
        public final /* synthetic */ AnonymousClass2 $sendMessage$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2) {
            super(2);
            this.$sendCommand$1 = anonymousClass1;
            this.$sendMessage$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Attachment<?>> list, Function1<? super Boolean, ? extends Unit> function1) {
            invoke2(list, (Function1<? super Boolean, Unit>) function1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
            Intrinsics3.checkNotNullParameter(list, "attachmentsRaw");
            Intrinsics3.checkNotNullParameter(function1, "onValidationResult");
            InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(WidgetChatInput.this);
            ApplicationCommandData applicationCommandData$default = inputAutocompleteAccess$getAutocomplete$p != null ? InputAutocomplete.getApplicationCommandData$default(inputAutocompleteAccess$getAutocomplete$p, null, 1, null) : null;
            if (applicationCommandData$default != null && !applicationCommandData$default.getValidInputs()) {
                WidgetChatInput.access$getViewModel$p(WidgetChatInput.this).onCommandInputsInvalid();
                return;
            }
            if (applicationCommandData$default == null || applicationCommandData$default.getApplicationCommand().getBuiltIn()) {
                this.$sendMessage$2.invoke2(list, applicationCommandData$default, function1);
                return;
            }
            AnonymousClass1 anonymousClass1 = this.$sendCommand$1;
            InputAutocomplete inputAutocompleteAccess$getAutocomplete$p2 = WidgetChatInput.access$getAutocomplete$p(WidgetChatInput.this);
            Map<ApplicationCommandOption, Attachment<?>> commandAttachments = inputAutocompleteAccess$getAutocomplete$p2 != null ? inputAutocompleteAccess$getAutocomplete$p2.getCommandAttachments() : null;
            if (commandAttachments == null) {
                commandAttachments = Maps6.emptyMap();
            }
            anonymousClass1.invoke(applicationCommandData$default, (Map<ApplicationCommandOption, ? extends Attachment<?>>) commandAttachments, false, function1);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "errorStringResId", "", "invoke", "(I)Z", "sendMessageError"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Integer, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
            return Boolean.valueOf(invoke(num.intValue()));
        }

        public final boolean invoke(@StringRes int i) {
            AppToast.g(this.$context, i, 0, null, 12);
            return false;
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/commands/ApplicationCommandOption;", "it", "", "invoke", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<ApplicationCommandOption, Unit> {
        public final /* synthetic */ AnonymousClass1 $sendCommand$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$sendCommand$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandOption applicationCommandOption) {
            invoke2(applicationCommandOption);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ApplicationCommandOption applicationCommandOption) {
            Intrinsics3.checkNotNullParameter(applicationCommandOption, "it");
            InputAutocomplete inputAutocompleteAccess$getAutocomplete$p = WidgetChatInput.access$getAutocomplete$p(WidgetChatInput.this);
            ApplicationCommandData applicationCommandData = inputAutocompleteAccess$getAutocomplete$p != null ? inputAutocompleteAccess$getAutocomplete$p.getApplicationCommandData(applicationCommandOption) : null;
            if (applicationCommandData != null) {
                AnonymousClass1.invoke$default(this.$sendCommand$1, applicationCommandData, Maps6.emptyMap(), true, null, 8, null);
            }
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass3 $trySend$3;

        /* compiled from: WidgetChatInput.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "validationSucceeded", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    WidgetChatInput.clearInput$default(WidgetChatInput.this, null, false, 3, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(AnonymousClass3 anonymousClass3) {
            super(0);
            this.$trySend$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$trySend$3.invoke2(Collections2.emptyList(), (Function1<? super Boolean, Unit>) new AnonymousClass1());
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "<anonymous parameter 0>", "", "Lcom/lytefast/flexinput/model/Attachment;", "list", "Lkotlin/Function1;", "", "", "onSendResult", "onSend", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$7, reason: invalid class name */
    public static final class AnonymousClass7 implements FlexInputListener {
        public final /* synthetic */ AnonymousClass4 $sendMessageError$4;
        public final /* synthetic */ AnonymousClass3 $trySend$3;
        public final /* synthetic */ ChatInputViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetChatInput.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "validationSucceeded", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureSendListeners$7$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
            public final /* synthetic */ Function1 $onSendResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Function1 function1) {
                super(1);
                this.$onSendResult = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.a;
            }

            public final void invoke(boolean z2) {
                if (z2) {
                    WidgetChatInput.clearInput$default(WidgetChatInput.this, null, false, 3, null);
                }
                this.$onSendResult.invoke(Boolean.valueOf(z2));
            }
        }

        public AnonymousClass7(ChatInputViewModel.ViewState.Loaded loaded, AnonymousClass4 anonymousClass4, AnonymousClass3 anonymousClass3) {
            this.$viewState = loaded;
            this.$sendMessageError$4 = anonymousClass4;
            this.$trySend$3 = anonymousClass3;
        }

        @Override // com.lytefast.flexinput.FlexInputListener
        public final void onSend(String str, List<? extends Attachment<?>> list, Function1<? super Boolean, Unit> function1) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(function1, "onSendResult");
            if (this.$viewState.isOnCooldown() && !this.$viewState.isEditing() && this.$viewState.getSelectedThreadDraft() == null) {
                function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(R.string.channel_slowmode_desc_short)));
                return;
            }
            if (this.$viewState.isEditing() && (!list.isEmpty())) {
                function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(R.string.editing_with_attachment_error)));
            } else if (this.$viewState.getAbleToSendMessage()) {
                this.$trySend$3.invoke2(list, (Function1<? super Boolean, Unit>) new AnonymousClass1(function1));
            } else {
                function1.invoke(Boolean.valueOf(this.$sendMessageError$4.invoke(R.string.no_send_messages_permission_placeholder)));
            }
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatInputViewModel.ViewState viewState) {
            super(0);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatInputTruncatedHint widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p = WidgetChatInput.access$getChatInputTruncatedHint$p(WidgetChatInput.this);
            if (widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p != null) {
                WidgetChatInput widgetChatInput = WidgetChatInput.this;
                widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p.setHint(WidgetChatInput.access$getHint(widgetChatInput, widgetChatInput.requireContext(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).getChannel(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).isBlocked(), ((ChatInputViewModel.ViewState.Loaded) this.$viewState).getAbleToSendMessage()));
            }
            WidgetChatInput.access$configureSendListeners(WidgetChatInput.this, (ChatInputViewModel.ViewState.Loaded) this.$viewState);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$handleEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ChatInputViewModel.Event $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatInputViewModel.Event event) {
            super(0);
            this.$event = event;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0<Unit> onResendCompressed = ((ChatInputViewModel.Event.FilesTooLarge) this.$event).getOnResendCompressed();
            if (onResendCompressed != null) {
                onResendCompressed.invoke();
            }
            WidgetChatInput.clearInput$default(WidgetChatInput.this, null, true, 1, null);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBound$1, reason: invalid class name */
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
            FlexEditText flexEditTextL = WidgetChatInput.access$getFlexInputFragment$p(WidgetChatInput.this).l();
            WidgetChatInput widgetChatInput = WidgetChatInput.this;
            FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInput.access$getFlexInputFragment$p(widgetChatInput);
            AppFlexInputViewModel appFlexInputViewModelAccess$getFlexInputViewModel$p = WidgetChatInput.access$getFlexInputViewModel$p(WidgetChatInput.this);
            TextView textView = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).k;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputEmojiMatchingHeader");
            RecyclerView recyclerView = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).l;
            Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatInputMentionsRecycler");
            RecyclerView recyclerView2 = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).c;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatInputCategoriesRecycler");
            LinearLayout linearLayout = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).m;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputStickersContainer");
            RecyclerView recyclerView3 = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).o;
            Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickersRecycler");
            TextView textView2 = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).n;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatInputStickersMatchingHeader");
            WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).f2303b;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputApplicationCommandsBinding, "binding.applicationCommandsRoot");
            InputAutocomplete inputAutocomplete = new InputAutocomplete(widgetChatInput, flexInputFragmentAccess$getFlexInputFragment$p, appFlexInputViewModelAccess$getFlexInputViewModel$p, flexEditTextL, null, textView, recyclerView, recyclerView2, linearLayout, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
            WidgetChatInput.access$setAutocomplete$p(WidgetChatInput.this, inputAutocomplete);
            inputAutocomplete.onViewBoundOrOnResume();
            WidgetChatInput.access$setChatInputEditTextHolder$p(WidgetChatInput.this, new WidgetChatInputEditText(flexEditTextL, null, 2, null));
            WidgetChatInput.access$setChatInputTruncatedHint$p(WidgetChatInput.this, new WidgetChatInputTruncatedHint(flexEditTextL));
            WidgetChatInputTruncatedHint widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p = WidgetChatInput.access$getChatInputTruncatedHint$p(WidgetChatInput.this);
            if (widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p != null) {
                widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p.addBindedTextWatcher(WidgetChatInput.this);
            }
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ChatInputViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/ChatInputViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetChatInput.access$configureUI((WidgetChatInput) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ChatInputViewModel.Event, Unit> {
        public AnonymousClass2(WidgetChatInput widgetChatInput) {
            super(1, widgetChatInput, WidgetChatInput.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/ChatInputViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatInputViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChatInputViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetChatInput.access$handleEvent((WidgetChatInput) this.receiver, event);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "isInlineVoiceWidgetVisible", "", "invoke", "(Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetChatInput.access$setWindowInsetsListeners(WidgetChatInput.this, !z2);
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$setWindowInsetsListeners$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$setWindowInsetsListeners$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "view", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$setWindowInsetsListeners$3, reason: invalid class name */
    public static final class AnonymousClass3 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetChatInput.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "Landroidx/core/view/WindowInsetsCompat;", "insets", "kotlin.jvm.PlatformType", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.WidgetChatInput$setWindowInsetsListeners$4, reason: invalid class name */
    public static final class AnonymousClass4 implements OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean $shouldApplyWindowInsets;

        public AnonymousClass4(boolean z2) {
            this.$shouldApplyWindowInsets = z2;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.of(0, 0, 0, this.$shouldApplyWindowInsets ? windowInsetsCompat.getSystemWindowInsetBottom() : 0)).build();
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
            ViewCompat.dispatchApplyWindowInsets(WidgetChatInput.access$getBinding$p(WidgetChatInput.this).q, windowInsetsCompatBuild);
            WidgetChatInputGuardBinding widgetChatInputGuardBinding = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).r;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
            ViewCompat.dispatchApplyWindowInsets(widgetChatInputGuardBinding.a, windowInsetsCompatBuild);
            WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).t;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
            ViewCompat.dispatchApplyWindowInsets(widgetChatInputMemberVerificationGuardBinding.a, windowInsetsCompatBuild);
            WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = WidgetChatInput.access$getBinding$p(WidgetChatInput.this).f2304s;
            Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
            ViewCompat.dispatchApplyWindowInsets(widgetChatInputCommunicationDisabledGuardBinding.a, windowInsetsCompatBuild);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public WidgetChatInput() {
        super(R.layout.widget_chat_input);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetChatInput2.INSTANCE, new WidgetChatInput3(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
        this.messageDraftsRepo = MessageDraftsRepo.Provider.INSTANCE.get();
        this.clock = ClockFactory.get();
        this.flexInputFragment = LazyJVM.lazy(new WidgetChatInput4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChatInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetChatInput6.INSTANCE));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatInput$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetChatInput5(this)));
    }

    public static final /* synthetic */ void access$configureSendListeners(WidgetChatInput widgetChatInput, ChatInputViewModel.ViewState.Loaded loaded) {
        widgetChatInput.configureSendListeners(loaded);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatInput widgetChatInput, ChatInputViewModel.ViewState viewState) {
        widgetChatInput.configureUI(viewState);
    }

    public static final /* synthetic */ InputAutocomplete access$getAutocomplete$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.autocomplete;
    }

    public static final /* synthetic */ WidgetChatInputBinding access$getBinding$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getBinding();
    }

    public static final /* synthetic */ WidgetChatInputEditText access$getChatInputEditTextHolder$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.chatInputEditTextHolder;
    }

    public static final /* synthetic */ WidgetChatInputTruncatedHint access$getChatInputTruncatedHint$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.chatInputTruncatedHint;
    }

    public static final /* synthetic */ FlexInputFragment access$getFlexInputFragment$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getFlexInputFragment();
    }

    public static final /* synthetic */ AppFlexInputViewModel access$getFlexInputViewModel$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getFlexInputViewModel();
    }

    public static final /* synthetic */ CharSequence access$getHint(WidgetChatInput widgetChatInput, Context context, Channel channel, boolean z2, boolean z3) {
        return widgetChatInput.getHint(context, channel, z2, z3);
    }

    public static final /* synthetic */ ChatInputViewModel access$getViewModel$p(WidgetChatInput widgetChatInput) {
        return widgetChatInput.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChatInput widgetChatInput, ChatInputViewModel.Event event) {
        widgetChatInput.handleEvent(event);
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetChatInput widgetChatInput, WidgetChatInputBinding widgetChatInputBinding) {
        widgetChatInput.onViewBindingDestroy(widgetChatInputBinding);
    }

    public static final /* synthetic */ void access$setAutocomplete$p(WidgetChatInput widgetChatInput, InputAutocomplete inputAutocomplete) {
        widgetChatInput.autocomplete = inputAutocomplete;
    }

    public static final /* synthetic */ void access$setChatInputEditTextHolder$p(WidgetChatInput widgetChatInput, WidgetChatInputEditText widgetChatInputEditText) {
        widgetChatInput.chatInputEditTextHolder = widgetChatInputEditText;
    }

    public static final /* synthetic */ void access$setChatInputTruncatedHint$p(WidgetChatInput widgetChatInput, WidgetChatInputTruncatedHint widgetChatInputTruncatedHint) {
        widgetChatInput.chatInputTruncatedHint = widgetChatInputTruncatedHint;
    }

    public static final /* synthetic */ void access$setWindowInsetsListeners(WidgetChatInput widgetChatInput, boolean z2) {
        widgetChatInput.setWindowInsetsListeners(z2);
    }

    public static final /* synthetic */ void access$showFollowSheet(WidgetChatInput widgetChatInput, long j, long j2) {
        widgetChatInput.showFollowSheet(j, j2);
    }

    private final void clearInput(Boolean focused, boolean clearText) {
        WidgetChatInputEditText widgetChatInputEditText = this.chatInputEditTextHolder;
        if (widgetChatInputEditText != null) {
            if (clearText) {
                getFlexInputViewModel().onInputTextChanged("", focused);
            }
            getFlexInputViewModel().clean(clearText);
            widgetChatInputEditText.clearLastTypingEmission();
            getViewModel().deleteEditingMessage();
        }
    }

    public static /* synthetic */ void clearInput$default(WidgetChatInput widgetChatInput, Boolean bool, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        widgetChatInput.clearInput(bool, z2);
    }

    private final void configureChatGuard(ChatInputViewModel.ViewState.Loaded viewState) {
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        LinearLayout linearLayout = widgetChatInputGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guard.root");
        linearLayout.setVisibility(viewState.isLurking() || viewState.isVerificationLevelTriggered() || viewState.isSystemDM() || viewState.getShouldShowFollow() ? 0 : 8);
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = widgetChatInputMemberVerificationGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        WidgetChatInputGuardBinding widgetChatInputGuardBinding2 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding2, "binding.guard");
        LinearLayout linearLayout2 = widgetChatInputGuardBinding2.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.guard.root");
        relativeLayout.setVisibility(!(linearLayout2.getVisibility() == 0) && viewState.getShouldShowVerificationGate() ? 0 : 8);
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = widgetChatInputCommunicationDisabledGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        WidgetChatInputGuardBinding widgetChatInputGuardBinding3 = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding3, "binding.guard");
        LinearLayout linearLayout3 = widgetChatInputGuardBinding3.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        relativeLayout2.setVisibility(!(linearLayout3.getVisibility() == 0) && !viewState.getShouldShowVerificationGate() && viewState.isCommunicationDisabled() ? 0 : 8);
        if (viewState.isSystemDM()) {
            getBinding().r.e.setText(R.string.system_dm_channel_description);
            TextView textView = getBinding().r.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guard.chatInputGuardSubtext");
            ViewExtensions.setTextAndVisibilityBy(textView, getString(R.string.system_dm_channel_description_subtext));
            MaterialButton materialButton = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guard.chatInputGuardAction");
            materialButton.setVisibility(8);
            MaterialButton materialButton2 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guard.chatInputGuardActionSecondary");
            materialButton2.setVisibility(8);
            return;
        }
        if (viewState.getShouldShowFollow()) {
            getBinding().r.e.setText(R.string.follow_news_chat_input_message);
            MaterialButton materialButton3 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton3, getString(R.string.game_popout_follow));
            getBinding().r.f211b.setOnClickListener(new AnonymousClass1(viewState));
            MaterialButton materialButton4 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.guard.chatInputGuardActionSecondary");
            materialButton4.setVisibility(8);
            return;
        }
        if (viewState.isLurking()) {
            if (!viewState.getShouldShowFollow()) {
                getBinding().r.e.setText(R.string.lurker_mode_chat_input_message);
                MaterialButton materialButton5 = getBinding().r.f211b;
                Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.guard.chatInputGuardAction");
                ViewExtensions.setTextAndVisibilityBy(materialButton5, getString(R.string.lurker_mode_chat_input_button));
                getBinding().r.f211b.setOnClickListener(new AnonymousClass4());
                MaterialButton materialButton6 = getBinding().r.c;
                Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.guard.chatInputGuardActionSecondary");
                materialButton6.setVisibility(8);
                return;
            }
            getBinding().r.e.setText(R.string.follow_news_chat_input_message);
            MaterialButton materialButton7 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton7, "binding.guard.chatInputGuardAction");
            ViewExtensions.setTextAndVisibilityBy(materialButton7, getString(R.string.game_popout_follow));
            getBinding().r.f211b.setOnClickListener(new AnonymousClass2(viewState));
            MaterialButton materialButton8 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton8, "binding.guard.chatInputGuardActionSecondary");
            ViewExtensions.setTextAndVisibilityBy(materialButton8, getString(R.string.lurker_mode_chat_input_button));
            getBinding().r.c.setOnClickListener(new AnonymousClass3());
            return;
        }
        if (viewState.isCommunicationDisabled()) {
            String strA = AppHelpDesk.a.a(360045138571L, null);
            TextView textView2 = getBinding().f2304s.f205b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guardCommunicati…nicationDisabledGuardText");
            FormatUtils.n(textView2, R.string.guild_communication_disabled_chat_notice_description, new Object[]{strA}, null, 4);
            getBinding().f2304s.f205b.setOnClickListener(new AnonymousClass5(strA));
            TextView textView3 = getBinding().f2304s.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guardCommunicati…ionDisabledGuardTimerText");
            textView3.setText(DurationUtils.humanizeCountdownDuration(requireContext(), viewState.getTimeoutLeftMs()));
            return;
        }
        if (!viewState.getShouldShowVerificationGate()) {
            TextView textView4 = getBinding().r.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guard.chatInputGuardText");
            textView4.setText(getVerificationText(outline.I(getBinding().r.e, "binding.guard.chatInputGuardText", "binding.guard.chatInputGuardText.context"), viewState.getVerificationLevelTriggered()));
            MaterialButton materialButton9 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton9, "binding.guard.chatInputGuardAction");
            MaterialButton materialButton10 = getBinding().r.f211b;
            Intrinsics3.checkNotNullExpressionValue(materialButton10, "binding.guard.chatInputGuardAction");
            Context context = materialButton10.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.guard.chatInputGuardAction.context");
            ViewExtensions.setTextAndVisibilityBy(materialButton9, getVerificationActionText(context, viewState.getVerificationLevelTriggered()));
            getBinding().r.f211b.setOnClickListener(new AnonymousClass8());
            MaterialButton materialButton11 = getBinding().r.c;
            Intrinsics3.checkNotNullExpressionValue(materialButton11, "binding.guard.chatInputGuardActionSecondary");
            materialButton11.setVisibility(8);
            return;
        }
        getBinding().t.f218b.setOnClickListener(new AnonymousClass6(viewState));
        ApplicationStatus joinRequestStatus = viewState.getJoinRequestStatus();
        if (joinRequestStatus != null) {
            int iOrdinal = joinRequestStatus.ordinal();
            if (iOrdinal == 1) {
                ImageView imageView = getBinding().t.c;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView.setVisibility(8);
                MaterialButton materialButton12 = getBinding().t.d;
                Intrinsics3.checkNotNullExpressionValue(materialButton12, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton12.setVisibility(0);
                getBinding().t.f.setText(R.string.member_verification_application_confirmation_title);
                getBinding().t.e.setImageResource(R.drawable.img_member_verification_pending);
                getBinding().t.c.setImageResource(R.drawable.ic_close_circle_nova_grey_24dp);
                getBinding().t.d.setOnClickListener(new AnonymousClass7(viewState));
                return;
            }
            if (iOrdinal == 2) {
                MaterialButton materialButton13 = getBinding().t.d;
                Intrinsics3.checkNotNullExpressionValue(materialButton13, "binding.guardMemberVerif…erVerificationGuardButton");
                materialButton13.setVisibility(8);
                ImageView imageView2 = getBinding().t.c;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guardMemberVerif…erVerificationGuardAction");
                imageView2.setVisibility(0);
                getBinding().t.f.setText(R.string.member_verification_application_rejected_title);
                getBinding().t.e.setImageResource(R.drawable.img_member_verification_denied);
                getBinding().t.c.setImageResource(R.drawable.ic_arrow_right_24dp);
                return;
            }
        }
        MaterialButton materialButton14 = getBinding().t.d;
        Intrinsics3.checkNotNullExpressionValue(materialButton14, "binding.guardMemberVerif…erVerificationGuardButton");
        materialButton14.setVisibility(8);
        ImageView imageView3 = getBinding().t.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.guardMemberVerif…erVerificationGuardAction");
        imageView3.setVisibility(0);
        getBinding().t.f.setText(R.string.member_verification_chat_blocker_text);
        getBinding().t.e.setImageResource(R.drawable.img_member_verification_started);
        getBinding().t.c.setImageResource(R.drawable.ic_arrow_right_24dp);
    }

    private final void configureContextBar(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.isEditing()) {
            configureContextBarEditing();
        } else {
            if (viewState.getPendingReplyState() instanceof ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) {
                configureContextBarReplying((ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying) viewState.getPendingReplyState());
                return;
            }
            RelativeLayout relativeLayout = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
            relativeLayout.setVisibility(8);
        }
    }

    private final void configureContextBarEditing() {
        RelativeLayout relativeLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.chatInputContextBar");
        relativeLayout2.setClickable(false);
        getBinding().g.setText(R.string.editing_message);
        getBinding().f.setOnClickListener(new AnonymousClass1());
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(8);
    }

    private final void configureContextBarReplying(ChatInputViewModel.ViewState.Loaded.PendingReplyState.Replying model) {
        String username;
        Context contextRequireContext = requireContext();
        RelativeLayout relativeLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.chatInputContextBar");
        relativeLayout.setVisibility(0);
        GuildMember repliedAuthorGuildMember = model.getRepliedAuthorGuildMember();
        if (repliedAuthorGuildMember == null || (username = repliedAuthorGuildMember.getNick()) == null) {
            username = model.getRepliedAuthor().getUsername();
        }
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputContextDescription");
        FormatUtils.m(textView, R.string.mobile_replying_to, new Object[]{username}, new AnonymousClass1(contextRequireContext, model));
        getBinding().e.setOnClickListener(new AnonymousClass2(model));
        getBinding().f.setOnClickListener(new AnonymousClass3());
        LinearLayout linearLayout = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputContextReplyMentionButton");
        linearLayout.setVisibility(model.getShowMentionToggle() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass4());
        int themedColor = model.getShouldMention() ? ColorCompat.getThemedColor(contextRequireContext, R.attr.colorControlBrandForeground) : ColorCompat.getThemedColor(contextRequireContext, R.attr.colorTextMuted);
        ImageView imageView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatInputContextReplyMentionButtonImage");
        ColorCompat2.tintWithColor(imageView, themedColor);
        getBinding().j.setTextColor(themedColor);
        getBinding().j.setText(model.getShouldMention() ? R.string.reply_mention_on : R.string.reply_mention_off);
    }

    private final void configureInitialText(ChatInputViewModel.ViewState.Loaded viewState) {
        String string;
        getFlexInputViewModel().hideExpressionTray();
        if (viewState.isEditing() && viewState.getEditingMessage() != null) {
            getFlexInputViewModel().onInputTextChanged(viewState.getEditingMessage().getContent().toString(), Boolean.TRUE);
            return;
        }
        CharSequence textChannelInput = this.messageDraftsRepo.getTextChannelInput(viewState.getChannelId());
        AppFlexInputViewModel flexInputViewModel = getFlexInputViewModel();
        if (textChannelInput == null || (string = textChannelInput.toString()) == null) {
            string = "";
        }
        flexInputViewModel.onInputTextChanged(string, (viewState.isEditing() || viewState.isReplying()) ? Boolean.TRUE : null);
    }

    private final void configureSendListeners(ChatInputViewModel.ViewState.Loaded viewState) {
        WidgetChatInputEditText widgetChatInputEditText = this.chatInputEditTextHolder;
        if (widgetChatInputEditText != null) {
            Context contextRequireContext = requireContext();
            MessageManager messageManager = new MessageManager(contextRequireContext, null, null, null, null, null, null, null, null, 510, null);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(contextRequireContext, messageManager);
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(anonymousClass1, new AnonymousClass2(widgetChatInputEditText, contextRequireContext, messageManager));
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(contextRequireContext);
            boolean z2 = widgetChatInputEditText.getChannelId() != viewState.getChannelId();
            widgetChatInputEditText.setChannelId(viewState.getChannelId(), z2);
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.setOnPerformCommandAutocomplete(new AnonymousClass5(anonymousClass1));
            }
            widgetChatInputEditText.setOnSendListener(new AnonymousClass6(anonymousClass3));
            if (z2) {
                configureInitialText(viewState);
            }
            configureText(viewState);
            WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
            if (widgetChatInputAttachments == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
            }
            widgetChatInputAttachments.setInputListener(new AnonymousClass7(viewState, anonymousClass4, anonymousClass3));
        }
    }

    private final void configureText(ChatInputViewModel.ViewState.Loaded viewState) {
        if (viewState.getAbleToSendMessage()) {
            return;
        }
        f.P0(getFlexInputViewModel(), "", null, 2, null);
    }

    private final void configureUI(ChatInputViewModel.ViewState viewState) {
        if (!(viewState instanceof ChatInputViewModel.ViewState.Loading)) {
            if (viewState instanceof ChatInputViewModel.ViewState.Loaded) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
                }
                ChatInputViewModel.ViewState.Loaded loaded = (ChatInputViewModel.ViewState.Loaded) viewState;
                widgetChatInputAttachments.configureFlexInputContentPages(loaded.getShowCreateThreadOption());
                LinearLayout linearLayout = getBinding().q;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
                linearLayout.setVisibility(loaded.isInputShowing() ? 0 : 8);
                configureChatGuard(loaded);
                getFlexInputFragment().i(new AnonymousClass1(viewState));
                configureContextBar(loaded);
                getFlexInputViewModel().setShowExpressionTrayButtonBadge(loaded.getShouldBadgeChatInput());
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.chatInputWrap");
        linearLayout2.setVisibility(8);
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        RelativeLayout relativeLayout = widgetChatInputMemberVerificationGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.guardMemberVerification.root");
        relativeLayout.setVisibility(8);
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        RelativeLayout relativeLayout2 = widgetChatInputCommunicationDisabledGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.guardCommunicationDisabled.root");
        relativeLayout2.setVisibility(8);
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        LinearLayout linearLayout3 = widgetChatInputGuardBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.guard.root");
        linearLayout3.setVisibility(8);
    }

    private final WidgetChatInputBinding getBinding() {
        return (WidgetChatInputBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FlexInputFragment getFlexInputFragment() {
        return (FlexInputFragment) this.flexInputFragment.getValue();
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final CharSequence getHint(Context context, Channel channel, boolean isBlocked, boolean hasSendMessagePermissions) {
        if (isBlocked) {
            String string = context.getString(R.string.dm_verification_text_blocked);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…erification_text_blocked)");
            return string;
        }
        if (hasSendMessagePermissions) {
            return FormatUtils.h(context, R.string.textarea_placeholder, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
        }
        String string2 = context.getString(R.string.no_send_messages_permission_placeholder);
        Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…s_permission_placeholder)");
        return string2;
    }

    private final String getVerificationActionText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(R.string.verify_account);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(R.string.verify_phone);
    }

    private final CharSequence getVerificationText(Context context, GuildVerificationLevel verificationLevelTriggered) {
        int iOrdinal = verificationLevelTriggered.ordinal();
        if (iOrdinal == 1) {
            return context.getString(R.string.guild_verification_text_not_claimed);
        }
        if (iOrdinal == 2) {
            return FormatUtils.h(context, R.string.guild_verification_text_account_age, new Object[]{"5"}, null, 4);
        }
        if (iOrdinal == 3) {
            return FormatUtils.h(context, R.string.guild_verification_text_member_age, new Object[]{"10"}, null, 4);
        }
        if (iOrdinal != 4) {
            return null;
        }
        return context.getString(R.string.guild_verification_text_not_phone_verified);
    }

    private final ChatInputViewModel getViewModel() {
        return (ChatInputViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"StringFormatMatches"})
    private final void handleEvent(ChatInputViewModel.Event event) {
        Unit unit = null;
        if (event instanceof ChatInputViewModel.Event.FilesTooLarge) {
            getFlexInputViewModel().hideKeyboard();
            ImageUploadFailedDialog.Companion companion = ImageUploadFailedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            ChatInputViewModel.Event.FilesTooLarge filesTooLarge = (ChatInputViewModel.Event.FilesTooLarge) event;
            float currentFileSizeMB = filesTooLarge.getCurrentFileSizeMB();
            float maxAttachmentSizeMB = filesTooLarge.getMaxAttachmentSizeMB();
            companion.a(parentFragmentManager, filesTooLarge.isUserPremium(), filesTooLarge.getMaxFileSizeMB(), maxAttachmentSizeMB, currentFileSizeMB, new AnonymousClass1(event), filesTooLarge.getAttachments().size(), filesTooLarge.getHasImage(), filesTooLarge.getHasVideo(), filesTooLarge.getHasGif());
            clearInput$default(this, null, false, 1, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.MessageTooLong) {
            getFlexInputViewModel().hideKeyboard();
            NumberFormat numberInstance = NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext()));
            WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            ChatInputViewModel.Event.MessageTooLong messageTooLong = (ChatInputViewModel.Event.MessageTooLong) event;
            WidgetNoticeDialog.Companion.show$default(companion2, parentFragmentManager2, getString(R.string.message_too_long_header), FormatUtils.k(this, R.string.message_too_long_body_text, new Object[]{numberInstance.format(Integer.valueOf(messageTooLong.getCurrentCharacterCount())), numberInstance.format(Integer.valueOf(messageTooLong.getMaxCharacterCount()))}, null, 4), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.EmptyThreadName) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion3 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion3, parentFragmentManager3, null, FormatUtils.k(this, R.string.form_thread_name_required_error, new Object[0], null, 4), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16370, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.FailedDeliveryToRecipient) {
            getFlexInputViewModel().hideKeyboard();
            WidgetNoticeDialog.Companion companion4 = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager4 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion4, parentFragmentManager4, getString(R.string.error), FormatUtils.k(this, R.string.bot_dm_send_failed_with_help_link_mobile, new Object[]{AppHelpDesk.a.a(360060145013L, null)}, null, 4), getString(R.string.okay), null, null, null, null, null, null, null, null, 0, null, 16368, null);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.AppendChatText) {
            getFlexInputViewModel().onInputTextAppended(((ChatInputViewModel.Event.AppendChatText) event).getText());
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.SetChatText) {
            getFlexInputViewModel().hideExpressionTray();
            getFlexInputViewModel().onInputTextChanged(((ChatInputViewModel.Event.SetChatText) event).getText(), Boolean.TRUE);
            unit = Unit.a;
        } else if (event instanceof ChatInputViewModel.Event.CommandInputsInvalid) {
            InputAutocomplete inputAutocomplete = this.autocomplete;
            if (inputAutocomplete != null) {
                inputAutocomplete.onCommandInputsSendError();
                unit = Unit.a;
            }
        } else if (event instanceof ChatInputViewModel.Event.ShowPremiumUpsell) {
            MultiValuePropPremiumUpsellDialog.Companion companion5 = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager5 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager5, "parentFragmentManager");
            ChatInputViewModel.Event.ShowPremiumUpsell showPremiumUpsell = (ChatInputViewModel.Event.ShowPremiumUpsell) event;
            MultiValuePropPremiumUpsellDialog.Companion.a(companion5, parentFragmentManager5, showPremiumUpsell.getPage(), getString(showPremiumUpsell.getHeaderResId()), getString(showPremiumUpsell.getBodyResId()), null, null, null, null, showPremiumUpsell.getShowOtherPages(), showPremiumUpsell.getShowLearnMore(), 240);
            unit = Unit.a;
        } else {
            if (!(event instanceof ChatInputViewModel.Event.ThreadDraftClosed)) {
                throw new NoWhenBranchMatchedException();
            }
            getFlexInputViewModel().hideKeyboard();
            clearInput$default(this, null, false, 3, null);
            unit = Unit.a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final void onViewBindingDestroy(WidgetChatInputBinding binding) {
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        LinearLayout linearLayout = binding.q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        panelsChildGestureRegionObserverA.c(linearLayout);
    }

    private final void populateDirectShareData() {
        ContentResolver contentResolver;
        List<Uri> uris;
        Long directShareId = IntentUtils.INSTANCE.getDirectShareId(getMostRecentIntent());
        if (directShareId != null) {
            long jLongValue = directShareId.longValue();
            boolean z2 = true;
            ShareUtils.SharedContent sharedContent = ShareUtils.INSTANCE.getSharedContent(getMostRecentIntent(), true);
            CharSequence text = sharedContent.getText();
            if (text != null && !StringsJVM.isBlank(text)) {
                z2 = false;
            }
            if (!z2) {
                this.messageDraftsRepo.setTextChannelInput(jLongValue, sharedContent.getText().toString());
            }
            Context context = getContext();
            if (context == null || (contentResolver = context.getContentResolver()) == null || (uris = sharedContent.getUris()) == null) {
                return;
            }
            for (Uri uri : uris) {
                WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
                if (widgetChatInputAttachments == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
                }
                widgetChatInputAttachments.addExternalAttachment(Attachment.INSTANCE.b(uri, contentResolver));
            }
        }
    }

    private final void setWindowInsetsListeners(boolean shouldApplyWindowInsets) {
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        ViewExtensions.setForwardingWindowInsetsListener(linearLayout);
        FragmentContainerView fragmentContainerView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.chatInputWidget");
        ViewExtensions.setForwardingWindowInsetsListener(fragmentContainerView);
        WidgetChatInputGuardBinding widgetChatInputGuardBinding = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputGuardBinding, "binding.guard");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputGuardBinding.a, AnonymousClass1.INSTANCE);
        WidgetChatInputMemberVerificationGuardBinding widgetChatInputMemberVerificationGuardBinding = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputMemberVerificationGuardBinding, "binding.guardMemberVerification");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputMemberVerificationGuardBinding.a, AnonymousClass2.INSTANCE);
        WidgetChatInputCommunicationDisabledGuardBinding widgetChatInputCommunicationDisabledGuardBinding = getBinding().f2304s;
        Intrinsics3.checkNotNullExpressionValue(widgetChatInputCommunicationDisabledGuardBinding, "binding.guardCommunicationDisabled");
        ViewCompat.setOnApplyWindowInsetsListener(widgetChatInputCommunicationDisabledGuardBinding.a, AnonymousClass3.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().d, new AnonymousClass4(shouldApplyWindowInsets));
        getBinding().d.requestApplyInsets();
    }

    public static /* synthetic */ void setWindowInsetsListeners$default(WidgetChatInput widgetChatInput, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        widgetChatInput.setWindowInsetsListeners(z2);
    }

    private final void showFollowSheet(long channelId, long guildId) {
        WidgetChannelFollowSheet.Companion companion = WidgetChannelFollowSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId, guildId);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChatInputAttachments widgetChatInputAttachments = new WidgetChatInputAttachments(getFlexInputFragment());
        this.chatAttachments = widgetChatInputAttachments;
        if (widgetChatInputAttachments == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.configureFlexInputFragment(this);
        getFlexInputFragment().i(new AnonymousClass1());
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.chatInputWrap");
        panelsChildGestureRegionObserverA.b(linearLayout);
        setWindowInsetsListeners$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        populateDirectShareData();
        WidgetChatInputTruncatedHint widgetChatInputTruncatedHint = this.chatInputTruncatedHint;
        if (widgetChatInputTruncatedHint != null) {
            widgetChatInputTruncatedHint.addBindedTextWatcher(this);
        }
        Observable<ChatInputViewModel.ViewState> observableR = getViewModel().observeChatInputViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
        WidgetChatInputAttachments widgetChatInputAttachments = this.chatAttachments;
        if (widgetChatInputAttachments == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("chatAttachments");
        }
        widgetChatInputAttachments.setViewModel(getFlexInputViewModel());
        InputAutocomplete inputAutocomplete = this.autocomplete;
        if (inputAutocomplete != null) {
            inputAutocomplete.onViewBoundOrOnResume();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.inlineVoiceVisibilityObserver.observeIsVisible(), this, null, 2, null), WidgetChatInput.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
