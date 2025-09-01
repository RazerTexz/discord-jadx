package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u0014J\u0015\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "", "configureUI", "(Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;)V", "Lcom/discord/api/channel/Channel;", "", "canManageChannel", "", "getSettingsText", "(Lcom/discord/api/channel/Channel;Z)Ljava/lang/String;", "", "getContentViewResId", "()I", "Lrx/subscriptions/CompositeSubscription;", "compositeSubscription", "bindSubscriptions", "(Lrx/subscriptions/CompositeSubscription;)V", "onPause", "()V", "Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", "binding", "<init>", "Companion", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelsListItemChannelActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "show", "(Landroidx/fragment/app/FragmentManager;J)V", "", WidgetChannelsListItemChannelActions.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions = new WidgetChannelsListItemChannelActions();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChannelsListItemChannelActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            widgetChannelsListItemChannelActions.setArguments(bundle);
            widgetChannelsListItemChannelActions.show(fragmentManager, WidgetChannelsListItemChannelActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0082\b\u0018\u0000 32\u00020\u0001:\u00013B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b1\u00102J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010%\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0017R\u0019\u0010(\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\rR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010\u0010R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010.\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b.\u0010\u0017R!\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u0010\u0014¨\u00064"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "", "Landroid/content/Context;", "context", "Lcom/discord/api/channel/Channel;", "channel", "", "getMuteChannelText", "(Landroid/content/Context;Lcom/discord/api/channel/Channel;)Ljava/lang/CharSequence;", "", "getMuteIconResId", "(Landroid/content/Context;)I", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "", "Lcom/discord/api/permission/PermissionBit;", "component3", "()Ljava/lang/Long;", "", "component4", "()Z", "guild", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "isMuted", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "canManageChannel", "Z", "getCanManageChannel", "canCreateInstantInvite", "getCanCreateInstantInvite", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/guild/Guild;", "getGuild", "isDeveloper", "Ljava/lang/Long;", "getPermissions", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Ljava/lang/Long;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreateInstantInvite;
        private final boolean canManageChannel;
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final boolean isMuted;
        private final Long permissions;

        /* compiled from: WidgetChannelsListItemChannelActions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "get", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetChannelsListItemChannelActions$Model$Companion$get$1(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, Long l, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
            this.isMuted = z2;
            this.isDeveloper = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
            this.canManageChannel = PermissionUtils.can(16L, l) || ChannelUtils.z(channel);
            this.canCreateInstantInvite = PermissionUtils.can(1L, l);
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, Long l, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = model.channel;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                l = model.permissions;
            }
            if ((i & 8) != 0) {
                z2 = model.isMuted;
            }
            return model.copy(channel, guild, l, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        public final Model copy(Channel channel, Guild guild, Long permissions, boolean isMuted) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(channel, guild, permissions, isMuted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.permissions, model.permissions) && this.isMuted == model.isMuted;
        }

        public final boolean getCanCreateInstantInvite() {
            return this.canCreateInstantInvite;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final CharSequence getMuteChannelText(Context context, Channel channel) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return (this.isMuted && ChannelUtils.k(channel)) ? FormatUtils.h(context, R.string.unmute_category, new Object[0], null, 4) : (this.isMuted || !ChannelUtils.k(channel)) ? this.isMuted ? FormatUtils.h(context, R.string.unmute_channel_generic, new Object[0], null, 4) : FormatUtils.h(context, R.string.mute_channel_generic, new Object[0], null, 4) : FormatUtils.h(context, R.string.mute_category, new Object[0], null, 4);
        }

        public final int getMuteIconResId(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, this.isMuted ? R.attr.ic_channel_muted : R.attr.ic_channel_mute, 0, 2, (Object) null);
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z2 = this.isMuted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        /* renamed from: isDeveloper, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", isMuted=");
            return outline.O(sbU, this.isMuted, ")");
        }
    }

    /* compiled from: WidgetChannelsListItemChannelActions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;", "it", "", "invoke", "(Lcom/discord/widgets/channels/list/WidgetChannelsListItemChannelActions$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$bindSubscriptions$1, reason: invalid class name */
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
            WidgetChannelsListItemChannelActions.access$configureUI(WidgetChannelsListItemChannelActions.this, model);
        }
    }

    public WidgetChannelsListItemChannelActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelsListItemChannelActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions, Model model) {
        widgetChannelsListItemChannelActions.configureUI(model);
    }

    private final void configureUI(Model model) {
        Guild guild;
        if (model == null) {
            dismiss();
            return;
        }
        if (model.getGuild() != null) {
            SimpleDraweeView simpleDraweeView = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, model.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        } else {
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.channelsListItemTextActionsIcon");
            IconUtils.setIcon$default(simpleDraweeView2, model.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
        }
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelsListItemTextActionsTitle");
        Channel channel = model.getChannel();
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.e(channel, contextRequireContext, false, 2));
        User userA = ChannelUtils.a(model.getChannel());
        TextView textView2 = getBinding().i;
        boolean z2 = true;
        textView2.setVisibility(userA != null ? 0 : 8);
        textView2.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$1(this, userA));
        TextView textView3 = getBinding().e;
        textView3.setVisibility(model.getCanCreateInstantInvite() ? 0 : 8);
        setOnClickAndDismissListener(textView3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$2(textView3, this, model));
        TextView textView4 = getBinding().k;
        textView4.setVisibility(ChannelUtils.F(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        setOnClickAndDismissListener(textView4, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$3(textView4, this, model));
        Context context = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView4.setCompoundDrawablesWithIntrinsicBounds(model.getMuteIconResId(context), 0, 0, 0);
        Context context2 = textView4.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView4.setText(model.getMuteChannelText(context2, model.getChannel()));
        TextView textView5 = getBinding().l;
        textView5.setVisibility(ThreadUtils.INSTANCE.isThreadsEnabled(model.getChannel().getGuildId()) && ChannelUtils.I(model.getChannel()) && !ChannelUtils.q(model.getChannel()) && !model.getChannel().getNsfw() ? 0 : 8);
        setOnClickAndDismissListener(textView5, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$4(textView5, this, model));
        TextView textView6 = getBinding().c;
        textView6.setVisibility(model.getCanManageChannel() ? 0 : 8);
        setOnClickAndDismissListener(textView6, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$5(this, model));
        textView6.setText(getSettingsText(model.getChannel(), model.getCanManageChannel()));
        TextView textView7 = getBinding().f2283b;
        textView7.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || (ChannelUtils.D(model.getChannel()) && (guild = model.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY)) ? 0 : 8);
        textView7.setOnClickListener(new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(model));
        View view = getBinding().j;
        if (!ChannelUtils.F(model.getChannel()) && !ChannelUtils.k(model.getChannel())) {
            z2 = false;
        }
        view.setVisibility(z2 ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$7(this, model));
        View view2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.developerDivider");
        view2.setVisibility(model.getIsDeveloper() ? 0 : 8);
        View view3 = getBinding().d;
        view3.setVisibility(model.getIsDeveloper() ? 0 : 8);
        setOnClickAndDismissListener(view3, new WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$8(this, model));
    }

    private final WidgetChannelsListItemActionsBinding getBinding() {
        return (WidgetChannelsListItemActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSettingsText(Channel channel, boolean z2) {
        String string = getString(ChannelUtils.k(channel) ? R.string.edit_category : z2 ? R.string.edit_channel : !z2 ? R.string.channel_settings : R.string.sample_empty_string);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(\n      when {\n…_empty_string\n      }\n  )");
        return string;
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetChannelsListItemChannelActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channels_list_item_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
