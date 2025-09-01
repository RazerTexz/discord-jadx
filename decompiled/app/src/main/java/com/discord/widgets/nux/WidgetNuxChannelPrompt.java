package com.discord.widgets.nux;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppScreen2;
import b.a.d.o;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetNuxChannelPromptBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Func0;

/* compiled from: WidgetNuxChannelPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\u00020!8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/discord/widgets/nux/WidgetNuxChannelPrompt;", "Lcom/discord/app/AppFragment;", "Lcom/discord/models/guild/Guild;", "guild", "", "handleGuild", "(Lcom/discord/models/guild/Guild;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "handleSubmit", "(J)V", "finishActivity", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/utilities/error/Error;", "error", "handleError", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", "binding", "Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager$delegate", "Lkotlin/Lazy;", "getValidationManager", "()Lcom/discord/utilities/view/validators/ValidationManager;", "validationManager", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNuxChannelPrompt.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNuxChannelPromptBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/nux/WidgetNuxChannelPrompt$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetNuxChannelPrompt.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: WidgetNuxChannelPrompt.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/api/channel/Channel;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03021 extends Lambda implements Function1<Channel, TrackNetworkMetadata2> {
            public C03021() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Channel channel) {
                return invoke2(channel);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Channel channel) {
                List<PermissionOverwrite> listV;
                return new TrackNetworkActionChannelCreate((channel == null || (listV = channel.v()) == null) ? null : Boolean.valueOf(!listV.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(AnonymousClass1.this.$guildId));
            }
        }

        /* compiled from: WidgetNuxChannelPrompt.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, anonymousClass1.$guildId);
            }
        }

        /* compiled from: WidgetNuxChannelPrompt.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/utilities/error/Error;", "kotlin.jvm.PlatformType", "error", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$handleSubmit$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T> implements Action1<Error> {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Error error) {
                call2(error);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Error error) {
                WidgetNuxChannelPrompt widgetNuxChannelPrompt = WidgetNuxChannelPrompt.this;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                widgetNuxChannelPrompt.handleError(error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f2504b.setIsLoading(false);
                return;
            }
            TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(RestAPI.INSTANCE.getApi().createGuildChannel(this.$guildId, new RestAPIParams.CreateGuildChannel(0, null, textOrEmpty, Long.valueOf(channel.getParentId()), null, FormatUtils.k(WidgetNuxChannelPrompt.this, R.string.nuf_channel_prompt_channel_topic_template, new Object[]{textOrEmpty}, null, 4).toString())), new C03021()), false, 1, null), WidgetNuxChannelPrompt.this, null, 2, null).k(o.a.g(WidgetNuxChannelPrompt.this.requireContext(), new AnonymousClass2(), new AnonymousClass3()));
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "invoke", "(Lcom/discord/models/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            WidgetNuxChannelPrompt.access$handleGuild(WidgetNuxChannelPrompt.this, guild);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass3(long j) {
            this.$guildId = j;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetNuxChannelPrompt.access$finishActivity(WidgetNuxChannelPrompt.this, this.$guildId);
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass4(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNuxChannelPrompt.access$handleSubmit(WidgetNuxChannelPrompt.this, this.$guildId);
        }
    }

    /* compiled from: WidgetNuxChannelPrompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetNuxChannelPrompt.access$getBinding$p(WidgetNuxChannelPrompt.this).f2504b.performClick();
        }
    }

    public WidgetNuxChannelPrompt() {
        super(R.layout.widget_nux_channel_prompt);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNuxChannelPrompt2.INSTANCE, null, 2, null);
        this.validationManager = LazyJVM.lazy(new WidgetNuxChannelPrompt4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetNuxChannelPrompt3.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$finishActivity(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.finishActivity(j);
    }

    public static final /* synthetic */ WidgetNuxChannelPromptBinding access$getBinding$p(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        return widgetNuxChannelPrompt.getBinding();
    }

    public static final /* synthetic */ void access$handleGuild(WidgetNuxChannelPrompt widgetNuxChannelPrompt, Guild guild) {
        widgetNuxChannelPrompt.handleGuild(guild);
    }

    public static final /* synthetic */ void access$handleSubmit(WidgetNuxChannelPrompt widgetNuxChannelPrompt, long j) {
        widgetNuxChannelPrompt.handleSubmit(j);
    }

    private final void finishActivity(long guildId) {
        if (GuildInviteShareSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
            WidgetGuildInviteShareSheet.Companion.enqueueNoticeForHomeTab$default(WidgetGuildInviteShareSheet.INSTANCE, null, guildId, "Guild Create", 1, null);
            AppScreen2.c(requireContext(), false, null, 6);
        } else {
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, parentFragmentManager, guildId, null, true, null, null, "Guild Create", 96, null);
        }
        requireActivity().finish();
    }

    private final WidgetNuxChannelPromptBinding getBinding() {
        return (WidgetNuxChannelPromptBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void handleGuild(Guild guild) {
        if (guild == null) {
            return;
        }
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guild.getId()), guild.getIcon(), null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.avatar_size_large))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.nufChannelPromptGuildIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        } else {
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.nufChannelPromptGuildIconName");
            textView2.setVisibility(0);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.nufChannelPromptGuildIconName");
            textView3.setText(guild.getShortName());
            SimpleDraweeView simpleDraweeView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.nufChannelPromptGuildIcon");
            IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
        TextView textView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nufChannelPromptGuildName");
        textView4.setText(guild.getName());
    }

    private final void handleSubmit(long guildId) {
        getBinding().f2504b.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId), 0L, false, 3, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        getBinding().f2504b.setIsLoading(false);
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        if (response.getMessages().isEmpty()) {
            error.setShowErrorToasts(true);
            return;
        }
        ValidationManager validationManager = getValidationManager();
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        Intrinsics3.checkNotNullExpressionValue(response2.getMessages(), "error.response.messages");
        error.setShowErrorToasts(!validationManager.setErrors(r1).isEmpty());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getGuilds().observeGuild(longExtra), this, null, 2, null), WidgetNuxChannelPrompt.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().f.setOnClickListener(new AnonymousClass2(longExtra));
        AppFragment.setOnBackPressed$default(this, new AnonymousClass3(longExtra), 0, 2, null);
        getBinding().f2504b.setIsLoading(false);
        getBinding().f2504b.setOnClickListener(new AnonymousClass4(longExtra));
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        ViewExtensions.setOnImeActionDone(textInputLayout, true, new AnonymousClass5());
    }
}
