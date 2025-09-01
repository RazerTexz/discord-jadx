package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemInviteBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guilds.ServerMemberCount;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.InviteEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00029:B\u000f\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(J\u0011\u0010*\u001a\u0004\u0018\u00010)H\u0014¢\u0006\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00104¨\u0006;"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInviteBase;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "model", "", "configureUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;)V", "configureLoadingUI", "()V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Resolved;", "configureResolvedUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Resolved;)V", "Lcom/discord/widgets/hubs/HubEmailArgs;", "args", "launchHubsEmail", "(Lcom/discord/widgets/hubs/HubEmailArgs;)V", "", "iconUrl", "updateIconUrlIfChanged", "(Ljava/lang/String;)V", "", "isGroupDM", "Lcom/discord/models/domain/ModelInvite;", "invite", "configureForTextChannel", "(ZLcom/discord/models/domain/ModelInvite;)V", "Lcom/discord/api/channel/Channel;", "channel", "Landroid/content/Context;", "context", "configureForVocalChannel", "(Lcom/discord/api/channel/Channel;Landroid/content/Context;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Invalid;", "configureInvalidUI", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Invalid;)V", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Lrx/Subscription;", "getSubscription", "()Lrx/Subscription;", "Lcom/discord/widgets/chat/list/entries/InviteEntry;", "item", "Lcom/discord/widgets/chat/list/entries/InviteEntry;", "Lcom/discord/databinding/WidgetChatListAdapterItemInviteBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemInviteBinding;", Traits.Payment.Type.SUBSCRIPTION, "Lrx/Subscription;", "Ljava/lang/String;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", ExifInterface.TAG_MODEL, "ModelProvider", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemInviteBinding binding;
    private String iconUrl;
    private InviteEntry item;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "", "<init>", "()V", "Invalid", "Loading", "Resolved", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Invalid;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Model {

        /* compiled from: WidgetChatListAdapterItemInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\f\b\u0002\u0010\r\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\r\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Invalid;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "Lcom/discord/api/channel/Channel;", "component3", "()Lcom/discord/api/channel/Channel;", "authorUser", "meId", "channel", "copy", "(Lcom/discord/models/user/User;JLcom/discord/api/channel/Channel;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Invalid;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getMeId", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/user/User;", "getAuthorUser", "<init>", "(Lcom/discord/models/user/User;JLcom/discord/api/channel/Channel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Invalid extends Model {
            private final User authorUser;
            private final Channel channel;
            private final long meId;

            public Invalid(User user, long j, Channel channel) {
                super(null);
                this.authorUser = user;
                this.meId = j;
                this.channel = channel;
            }

            public static /* synthetic */ Invalid copy$default(Invalid invalid, User user, long j, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = invalid.authorUser;
                }
                if ((i & 2) != 0) {
                    j = invalid.meId;
                }
                if ((i & 4) != 0) {
                    channel = invalid.channel;
                }
                return invalid.copy(user, j, channel);
            }

            /* renamed from: component1, reason: from getter */
            public final User getAuthorUser() {
                return this.authorUser;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            /* renamed from: component3, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Invalid copy(User authorUser, long meId, Channel channel) {
                return new Invalid(authorUser, meId, channel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invalid)) {
                    return false;
                }
                Invalid invalid = (Invalid) other;
                return Intrinsics3.areEqual(this.authorUser, invalid.authorUser) && this.meId == invalid.meId && Intrinsics3.areEqual(this.channel, invalid.channel);
            }

            public final User getAuthorUser() {
                return this.authorUser;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final long getMeId() {
                return this.meId;
            }

            public int hashCode() {
                User user = this.authorUser;
                int iA = (b.a(this.meId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
                Channel channel = this.channel;
                return iA + (channel != null ? channel.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invalid(authorUser=");
                sbU.append(this.authorUser);
                sbU.append(", meId=");
                sbU.append(this.meId);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetChatListAdapterItemInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Loading;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetChatListAdapterItemInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJT\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\f\b\u0002\u0010\u0014\u001a\u00060\u0005j\u0002`\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0019\u0010\u0018\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u000eR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0004R\u001d\u0010\u0014\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010\u000b¨\u00061"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Resolved;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "", "Lcom/discord/primitives/UserId;", "component2", "()J", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "", "component4", "()Z", "Lcom/discord/api/channel/Channel;", "component5", "()Lcom/discord/api/channel/Channel;", "component6", "invite", "meId", "authorUser", "isMemberOfGuild", "channel", "shouldAnimateGuildIcon", "copy", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/user/User;ZLcom/discord/api/channel/Channel;Z)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShouldAnimateGuildIcon", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "J", "getMeId", "Lcom/discord/models/user/User;", "getAuthorUser", "<init>", "(Lcom/discord/models/domain/ModelInvite;JLcom/discord/models/user/User;ZLcom/discord/api/channel/Channel;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends Model {
            private final User authorUser;
            private final Channel channel;
            private final ModelInvite invite;
            private final boolean isMemberOfGuild;
            private final long meId;
            private final boolean shouldAnimateGuildIcon;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.meId = j;
                this.authorUser = user;
                this.isMemberOfGuild = z2;
                this.channel = channel;
                this.shouldAnimateGuildIcon = z3;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = resolved.invite;
                }
                if ((i & 2) != 0) {
                    j = resolved.meId;
                }
                long j2 = j;
                if ((i & 4) != 0) {
                    user = resolved.authorUser;
                }
                User user2 = user;
                if ((i & 8) != 0) {
                    z2 = resolved.isMemberOfGuild;
                }
                boolean z4 = z2;
                if ((i & 16) != 0) {
                    channel = resolved.channel;
                }
                Channel channel2 = channel;
                if ((i & 32) != 0) {
                    z3 = resolved.shouldAnimateGuildIcon;
                }
                return resolved.copy(modelInvite, j2, user2, z4, channel2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMeId() {
                return this.meId;
            }

            /* renamed from: component3, reason: from getter */
            public final User getAuthorUser() {
                return this.authorUser;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsMemberOfGuild() {
                return this.isMemberOfGuild;
            }

            /* renamed from: component5, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getShouldAnimateGuildIcon() {
                return this.shouldAnimateGuildIcon;
            }

            public final Resolved copy(ModelInvite invite, long meId, User authorUser, boolean isMemberOfGuild, Channel channel, boolean shouldAnimateGuildIcon) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Resolved(invite, meId, authorUser, isMemberOfGuild, channel, shouldAnimateGuildIcon);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Resolved)) {
                    return false;
                }
                Resolved resolved = (Resolved) other;
                return Intrinsics3.areEqual(this.invite, resolved.invite) && this.meId == resolved.meId && Intrinsics3.areEqual(this.authorUser, resolved.authorUser) && this.isMemberOfGuild == resolved.isMemberOfGuild && Intrinsics3.areEqual(this.channel, resolved.channel) && this.shouldAnimateGuildIcon == resolved.shouldAnimateGuildIcon;
            }

            public final User getAuthorUser() {
                return this.authorUser;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final long getMeId() {
                return this.meId;
            }

            public final boolean getShouldAnimateGuildIcon() {
                return this.shouldAnimateGuildIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iA = (b.a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
                User user = this.authorUser;
                int iHashCode = (iA + (user != null ? user.hashCode() : 0)) * 31;
                boolean z2 = this.isMemberOfGuild;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Channel channel = this.channel;
                int iHashCode2 = (i2 + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z3 = this.shouldAnimateGuildIcon;
                return iHashCode2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isMemberOfGuild() {
                return this.isMemberOfGuild;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(invite=");
                sbU.append(this.invite);
                sbU.append(", meId=");
                sbU.append(this.meId);
                sbU.append(", authorUser=");
                sbU.append(this.authorUser);
                sbU.append(", isMemberOfGuild=");
                sbU.append(this.isMemberOfGuild);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", shouldAnimateGuildIcon=");
                return outline.O(sbU, this.shouldAnimateGuildIcon, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$ModelProvider;", "", "Lcom/discord/widgets/chat/list/entries/InviteEntry;", "item", "Lrx/Observable;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "getInvalidInvite", "(Lcom/discord/widgets/chat/list/entries/InviteEntry;)Lrx/Observable;", "Lcom/discord/models/domain/ModelInvite;", "invite", "observeModel", "(Lcom/discord/widgets/chat/list/entries/InviteEntry;Lcom/discord/models/domain/ModelInvite;)Lrx/Observable;", "get", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();

        private ModelProvider() {
        }

        public static final /* synthetic */ Observable access$getInvalidInvite(ModelProvider modelProvider, InviteEntry inviteEntry) {
            return modelProvider.getInvalidInvite(inviteEntry);
        }

        public static final /* synthetic */ Observable access$observeModel(ModelProvider modelProvider, InviteEntry inviteEntry, ModelInvite modelInvite) {
            return modelProvider.observeModel(inviteEntry, modelInvite);
        }

        private final Observable<Model> getInvalidInvite(InviteEntry item) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<Model> observableJ = Observable.j(companion.getUsers().observeMeId(), companion.getUsers().observeUser(item.getUserId()), WidgetChatListAdapterItemInvite3.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…authorUser, meId, null) }");
            return observableJ;
        }

        private final Observable<Model> observeModel(InviteEntry item, ModelInvite invite) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreUser users = companion.getUsers();
            StoreGuilds guilds = companion.getGuilds();
            StoreChannels channels = companion.getChannels();
            StoreAccessibility accessibility = companion.getAccessibility();
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{users, guilds, channels, accessibility}, false, null, null, new WidgetChatListAdapterItemInvite4(users, item, invite, guilds, channels, accessibility), 14, null);
        }

        public final Observable<Model> get(InviteEntry item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
            String inviteCode = item.getInviteCode();
            String eventId = item.getEventId();
            Observable observableY = instantInvites.observeInvite(ModelInvite.getInviteStoreKey(inviteCode, eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null)).Y(new WidgetChatListAdapterItemInvite2(item));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…tes\n          }\n        }");
            return observableY;
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureInvalidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $isInviter;
        public final /* synthetic */ Model.Invalid $model;

        public AnonymousClass1(boolean z2, Model.Invalid invalid, Context context) {
            this.$isInviter = z2;
            this.$model = invalid;
            this.$context = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Channel channel;
            if (!this.$isInviter) {
                StoreChat chat = StoreStream.INSTANCE.getChat();
                Model.Invalid invalid = this.$model;
                chat.appendMention(invalid != null ? invalid.getAuthorUser() : null, WidgetChatListAdapterItemInvite.access$getItem$p(WidgetChatListAdapterItemInvite.this).getGuildId());
                return;
            }
            Model.Invalid invalid2 = this.$model;
            if (invalid2 == null || (channel = invalid2.getChannel()) == null) {
                return;
            }
            long guildId = channel.getGuildId();
            WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
            Context context = this.$context;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            WidgetGuildInviteShare.Companion.launch$default(companion, context, WidgetChatListAdapterItemInvite.access$getAdapter$p(WidgetChatListAdapterItemInvite.this).getFragmentManager(), guildId, Long.valueOf(this.$model.getChannel().getId()), false, null, null, "Invite Button Embed", 112, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass2(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite = WidgetChatListAdapterItemInvite.this;
            WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemInvite, widgetChatListAdapterItemInvite.getClass(), this.$invite, null, null, 12, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass3(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite = WidgetChatListAdapterItemInvite.this;
            WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemInvite, widgetChatListAdapterItemInvite.getClass(), this.$invite, null, null, 12, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetChatListAdapterItemInvite.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$configureResolvedUI$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetChatListAdapterItemInvite.access$launchHubsEmail(WidgetChatListAdapterItemInvite.this, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
            }
        }

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
            super(1, widgetChatListAdapterItemInvite, WidgetChatListAdapterItemInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemInvite.access$configureUI((WidgetChatListAdapterItemInvite) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetChatListAdapterItemInvite.access$configureInvalidUI(WidgetChatListAdapterItemInvite.this, null);
        }
    }

    /* compiled from: WidgetChatListAdapterItemInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", "it", "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$onConfigure$3, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemInvite.access$setSubscription$p(WidgetChatListAdapterItemInvite.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.barrier_button;
        Barrier barrier = (Barrier) view.findViewById(R.id.barrier_button);
        if (barrier != null) {
            i = R.id.barrier_header;
            Barrier barrier2 = (Barrier) view.findViewById(R.id.barrier_header);
            if (barrier2 != null) {
                i = R.id.item_invite_button_layout;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.item_invite_button_layout);
                if (frameLayout != null) {
                    i = R.id.item_invite_channel_name;
                    TextView textView = (TextView) view.findViewById(R.id.item_invite_channel_name);
                    if (textView != null) {
                        i = R.id.item_invite_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.item_invite_header);
                        if (textView2 != null) {
                            i = R.id.item_invite_hub_layout;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.item_invite_hub_layout);
                            if (frameLayout2 != null) {
                                i = R.id.item_invite_hub_link;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.item_invite_hub_link);
                                if (linkifiedTextView != null) {
                                    i = R.id.item_invite_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_invite_image);
                                    if (simpleDraweeView != null) {
                                        i = R.id.item_invite_image_text;
                                        TextView textView3 = (TextView) view.findViewById(R.id.item_invite_image_text);
                                        if (textView3 != null) {
                                            i = R.id.item_invite_join_button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.item_invite_join_button);
                                            if (materialButton != null) {
                                                i = R.id.item_invite_joined_button;
                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.item_invite_joined_button);
                                                if (materialButton2 != null) {
                                                    i = R.id.item_invite_loading_button;
                                                    View viewFindViewById = view.findViewById(R.id.item_invite_loading_button);
                                                    if (viewFindViewById != null) {
                                                        i = R.id.item_invite_member_container;
                                                        ServerMemberCount serverMemberCount = (ServerMemberCount) view.findViewById(R.id.item_invite_member_container);
                                                        if (serverMemberCount != null) {
                                                            i = R.id.item_invite_mention_button;
                                                            MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.item_invite_mention_button);
                                                            if (materialButton3 != null) {
                                                                i = R.id.item_invite_name;
                                                                TextView textView4 = (TextView) view.findViewById(R.id.item_invite_name);
                                                                if (textView4 != null) {
                                                                    i = R.id.item_invite_splash;
                                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R.id.item_invite_splash);
                                                                    if (simpleDraweeView2 != null) {
                                                                        i = R.id.item_invite_splash_container;
                                                                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view.findViewById(R.id.item_invite_splash_container);
                                                                        if (roundedRelativeLayout != null) {
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                            WidgetChatListAdapterItemInviteBinding widgetChatListAdapterItemInviteBinding = new WidgetChatListAdapterItemInviteBinding(constraintLayout, barrier, barrier2, frameLayout, textView, textView2, frameLayout2, linkifiedTextView, simpleDraweeView, textView3, materialButton, materialButton2, viewFindViewById, serverMemberCount, materialButton3, textView4, simpleDraweeView2, roundedRelativeLayout, constraintLayout);
                                                                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                                                            this.binding = widgetChatListAdapterItemInviteBinding;
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, Model.Invalid invalid) {
        widgetChatListAdapterItemInvite.configureInvalidUI(invalid);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, Model model) {
        widgetChatListAdapterItemInvite.configureUI(model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemInvite.adapter;
    }

    public static final /* synthetic */ InviteEntry access$getItem$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        InviteEntry inviteEntry = widgetChatListAdapterItemInvite.item;
        if (inviteEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        return inviteEntry;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        return widgetChatListAdapterItemInvite.subscription;
    }

    public static final /* synthetic */ void access$launchHubsEmail(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, WidgetHubEmailViewModel2 widgetHubEmailViewModel2) {
        widgetChatListAdapterItemInvite.launchHubsEmail(widgetHubEmailViewModel2);
    }

    public static final /* synthetic */ void access$setItem$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, InviteEntry inviteEntry) {
        widgetChatListAdapterItemInvite.item = inviteEntry;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, Subscription subscription) {
        widgetChatListAdapterItemInvite.subscription = subscription;
    }

    private final void configureForTextChannel(boolean isGroupDM, ModelInvite invite) {
        ServerMemberCount serverMemberCount = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(invite.getChannel() != null ? 0 : 8);
        this.binding.k.setOnline(!isGroupDM ? Integer.valueOf(invite.getApproximatePresenceCount()) : null);
        this.binding.k.setMembers(Integer.valueOf(invite.getApproximateMemberCount()));
    }

    private final void configureForVocalChannel(Channel channel, Context context) {
        int themedDrawableRes$default;
        ServerMemberCount serverMemberCount = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.f2325b;
        int type = channel.getType();
        if (type != 2) {
            themedDrawableRes$default = type != 13 ? 0 : R.drawable.ic_channel_stage_24dp;
        } else {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, R.attr.ic_volume_up, 0, 2, (Object) null);
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
        ViewExtensions.setTextAndVisibilityBy(textView, ChannelUtils.d(channel, context, false));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureInvalidUI(Model.Invalid model) {
        CharSequence charSequenceH;
        Channel channel;
        User authorUser;
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Long lValueOf = null;
        boolean zAreEqual = Intrinsics3.areEqual((model == null || (authorUser = model.getAuthorUser()) == null) ? null : Long.valueOf(authorUser.getId()), model != null ? Long.valueOf(model.getMeId()) : null);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        FormatUtils.n(textView, zAreEqual ? R.string.invite_button_title_inviter_invalid : R.string.invite_button_title_invited_invalid, new Object[0], null, 4);
        TextView textView2 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        FormatUtils.n(textView2, R.string.invite_button_invalid, new Object[0], null, 4);
        this.binding.m.setTextColor(ColorCompat.getColor(context, R.color.status_red_500));
        this.binding.m.setBackgroundResource(0);
        this.binding.f.setActualImageResource(R.drawable.img_wump_trash_dark);
        TextView textView3 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
        textView3.setVisibility(8);
        boolean z2 = true;
        if (!zAreEqual) {
            if ((model != null ? model.getAuthorUser() : null) != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                charSequenceH = FormatUtils.h(context, R.string.instant_invite_ask_user_for_new_invite, new Object[]{model.getAuthorUser().getUsername()}, null, 4);
            }
        } else if (!zAreEqual) {
            if ((model != null ? model.getAuthorUser() : null) == null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                charSequenceH = FormatUtils.h(context, R.string.instant_invite_ask_for_new_invite, new Object[0], null, 4);
            }
        } else if (zAreEqual) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, R.string.invite_button_invalid_owner, new Object[0], null, 4);
        } else {
            charSequenceH = null;
        }
        TextView textView4 = this.binding.f2325b;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemInviteChannelName");
        textView4.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(0);
        this.binding.k.setInvalidText(charSequenceH);
        MaterialButton materialButton = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        FormatUtils.n(materialButton, zAreEqual ? R.string.create_instant_invite : R.string.mention, new Object[0], null, 4);
        MaterialButton materialButton2 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteMentionButton");
        if (zAreEqual) {
            if (model != null && (channel = model.getChannel()) != null) {
                lValueOf = Long.valueOf(channel.getGuildId());
            }
            if (lValueOf == null) {
                z2 = false;
            }
        }
        materialButton2.setVisibility(z2 ? 0 : 8);
        this.binding.l.setOnClickListener(new AnonymousClass1(zAreEqual, model, context));
        MaterialButton materialButton3 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinButton");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.itemInviteJoinedButton");
        materialButton4.setVisibility(8);
        View view2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(8);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        this.binding.c.setText(R.string.instant_invite_resolving);
        TextView textView = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteName");
        textView.setText((CharSequence) null);
        this.binding.m.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.m.setBackgroundResource(R.drawable.drawable_empty_text_placeholder_dark);
        this.binding.f.setImageResource(R.drawable.drawable_empty_text_placeholder_dark);
        TextView textView2 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteImageText");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f2325b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelName");
        textView3.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        MaterialButton materialButton = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(8);
        MaterialButton materialButton3 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinedButton");
        materialButton3.setVisibility(8);
        View view2 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureResolvedUI(Model.Resolved model) {
        Guild guild;
        CharSequence charSequenceH;
        String name;
        boolean z2;
        com.discord.api.guild.Guild guild2;
        String name2;
        String icon;
        List<GuildFeature> listM;
        ModelInvite invite = model.getInvite();
        long meId = model.getMeId();
        User authorUser = model.getAuthorUser();
        boolean isMemberOfGuild = model.getIsMemberOfGuild();
        Channel channel = model.getChannel();
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean z3 = authorUser != null && authorUser.getId() == meId;
        com.discord.api.guild.Guild guild3 = invite.guild;
        boolean z4 = (guild3 != null ? guild3.getMemberCount() : 0) < 200;
        Channel channel2 = invite.getChannel();
        boolean z5 = channel2 != null ? ChannelUtils.z(channel2) : false;
        com.discord.api.guild.Guild guild4 = invite.guild;
        boolean z6 = (guild4 == null || (listM = guild4.m()) == null || !listM.contains(GuildFeature.HUB)) ? false : true;
        boolean z7 = invite.getChannel() == null && invite.guild == null && invite.getInviter() != null;
        com.discord.api.guild.Guild guild5 = invite.guild;
        if (guild5 != null) {
            Intrinsics3.checkNotNullExpressionValue(guild5, "it");
            guild = new Guild(guild5);
        } else {
            guild = null;
        }
        SimpleDraweeView simpleDraweeView = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteSplash");
        IconUtils iconUtils = IconUtils.INSTANCE;
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        Resources resources = view2.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        IconUtils.setIcon$default(simpleDraweeView, iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        RoundedRelativeLayout roundedRelativeLayout = this.binding.o;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.itemInviteSplashContainer");
        roundedRelativeLayout.setVisibility((guild != null ? guild.getSplash() : null) != null ? 0 : 8);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        if (z5 && z3) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, R.string.invite_button_title_inviter_group_dm, new Object[0], null, 4);
        } else if (z3) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, R.string.invite_button_title_inviter, new Object[0], null, 4);
        } else if (z5 && !z3) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, R.string.invite_button_title_invited_group_dm, new Object[0], null, 4);
        } else if (z6) {
            charSequenceH = context.getString(R.string.invite_button_title_invited_hub);
        } else if (z7) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Object[] objArr = new Object[1];
            com.discord.api.user.User inviter = invite.getInviter();
            objArr[0] = inviter != null ? inviter.getUsername() : null;
            charSequenceH = FormatUtils.h(context, R.string.instant_invite_you_have_been_invited_to_chat, objArr, null, 4);
        } else if (!z4 || invite.getInviter() == null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            charSequenceH = FormatUtils.h(context, R.string.invite_button_title_invited, new Object[0], null, 4);
        } else {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Object[] objArr2 = new Object[1];
            com.discord.api.user.User inviter2 = invite.getInviter();
            objArr2[0] = inviter2 != null ? inviter2.getUsername() : null;
            charSequenceH = FormatUtils.h(context, R.string.instant_invite_you_have_been_invited_to_join_by_user, objArr2, null, 4);
        }
        textView.setText(charSequenceH);
        TextView textView2 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        if (!z5) {
            com.discord.api.guild.Guild guild6 = invite.guild;
            if (guild6 != null) {
                name = guild6.getName();
            }
        } else if (channel != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            name = ChannelUtils.e(channel, context, false, 2);
            if (name == null) {
                Channel channel3 = invite.getChannel();
                if (channel3 != null) {
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    name = ChannelUtils.e(channel3, context, false, 2);
                } else {
                    name = null;
                }
            }
        }
        textView2.setText(name);
        this.binding.m.setTextColor(ColorCompat.getThemedColor(context, R.attr.primary_100));
        this.binding.m.setBackgroundResource(0);
        if (z7) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemInviteImage");
            simpleDraweeView2.setVisibility(8);
        } else if (z5) {
            updateIconUrlIfChanged(IconUtils.getForChannel$default(invite.getChannel(), null, 2, null));
            TextView textView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
            textView3.setVisibility(8);
        } else {
            String strComputeShortName = null;
            com.discord.api.guild.Guild guild7 = invite.guild;
            Long lValueOf = guild7 != null ? Long.valueOf(guild7.getId()) : null;
            com.discord.api.guild.Guild guild8 = invite.guild;
            updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild8 != null ? guild8.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
            com.discord.api.guild.Guild guild9 = invite.guild;
            if (guild9 == null || (icon = guild9.getIcon()) == null) {
                z2 = false;
                TextView textView4 = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.itemInviteImageText");
                if (!z2 && (guild2 = invite.guild) != null && (name2 = guild2.getName()) != null) {
                    strComputeShortName = GuildUtils.computeShortName(name2);
                }
                ViewExtensions.setTextAndVisibilityBy(textView4, strComputeShortName);
            } else {
                if (icon.length() > 0) {
                    z2 = true;
                }
                TextView textView42 = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView42, "binding.itemInviteImageText");
                if (!z2) {
                    strComputeShortName = GuildUtils.computeShortName(name2);
                }
                ViewExtensions.setTextAndVisibilityBy(textView42, strComputeShortName);
            }
        }
        if (channel == null || !ChannelUtils.w(channel)) {
            configureForTextChannel(z5, invite);
        } else {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            configureForVocalChannel(channel, context);
        }
        if (z5) {
            isMemberOfGuild = channel != null;
        }
        boolean z8 = z6 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled();
        View view3 = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(view3, "binding.itemInviteLoadingButton");
        view3.setVisibility(8);
        MaterialButton materialButton = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemInviteJoinedButton");
        materialButton.setVisibility(isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(true ^ isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton3 = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.itemInviteMentionButton");
        materialButton3.setVisibility(8);
        this.binding.h.setOnClickListener(new AnonymousClass2(invite));
        this.binding.i.setOnClickListener(new AnonymousClass3(invite));
        FrameLayout frameLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.itemInviteHubLayout");
        frameLayout.setVisibility(z8 ? 0 : 8);
        if (z8) {
            LinkifiedTextView linkifiedTextView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.itemInviteHubLink");
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            linkifiedTextView.setText(FormatUtils.b(context, R.string.hub_invite_another_school_link, new Object[0], new AnonymousClass4()));
        }
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            configureLoadingUI();
        } else if (model instanceof Model.Resolved) {
            configureResolvedUI((Model.Resolved) model);
        } else {
            if (!(model instanceof Model.Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((Model.Invalid) model);
        }
    }

    private final void launchHubsEmail(WidgetHubEmailViewModel2 args) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
        AppScreen2.d(context, WidgetHubEmailFlow.class, args);
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!Intrinsics3.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.item = (InviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.INSTANCE.getInstantInvites();
        InviteEntry inviteEntry = this.item;
        if (inviteEntry == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        String inviteCode = inviteEntry.getInviteCode();
        InviteEntry inviteEntry2 = this.item;
        if (inviteEntry2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        String eventId = inviteEntry2.getEventId();
        StoreInstantInvites.fetchInviteIfNotLoaded$default(instantInvites, inviteCode, eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null, "Invite Button Embed", null, null, 24, null);
        ModelProvider modelProvider = ModelProvider.INSTANCE;
        InviteEntry inviteEntry3 = this.item;
        if (inviteEntry3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(modelProvider.get(inviteEntry3)), WidgetChatListAdapterItemInvite.class, (Context) null, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(this), 50, (Object) null);
    }
}
