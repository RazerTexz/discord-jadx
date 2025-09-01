package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.User;
import com.discord.databinding.WidgetGuildInviteInfoViewBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetInviteInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\nJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0015J#\u0010\u001f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetInviteInfo;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "", "parseAttributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/discord/models/domain/ModelInvite;", "model", "configureForDirectFriend", "(Lcom/discord/models/domain/ModelInvite;)V", "configureForGDM", "configureForGuild", "", "userName", "", "getIntroText", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "getInviteTitleForDirectFriend", "getInviteSubtitleForDirectFriend", "channelName", "getIntroTextForGroup", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;", "guildName", "getFormattedGuildName", "Lkotlin/Function0;", "onAcceptClick", "configureUI", "(Lcom/discord/models/domain/ModelInvite;Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/utilities/error/Error;", "e", "configureUIFailure", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/databinding/WidgetGuildInviteInfoViewBinding;", "binding", "Lcom/discord/databinding/WidgetGuildInviteInfoViewBinding;", "ctx", "attrSet", "attr", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetInviteInfo extends ConstraintLayout {
    private final WidgetGuildInviteInfoViewBinding binding;

    /* compiled from: WidgetInviteInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetInviteInfo$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onAcceptClick;

        public AnonymousClass1(Function0 function0) {
            this.$onAcceptClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onAcceptClick.invoke();
        }
    }

    /* compiled from: WidgetInviteInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetInviteInfo$parseAttributeSet$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $size;
        public final /* synthetic */ int $userSize;

        public AnonymousClass1(int i, int i2) {
            this.$size = i;
            this.$userSize = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.$size != 0) {
                GuildView guildView = WidgetInviteInfo.access$getBinding$p(WidgetInviteInfo.this).c;
                Intrinsics3.checkNotNullExpressionValue(guildView, "binding.inviteAvatar");
                ViewGroup.LayoutParams layoutParams = guildView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                int i = this.$size;
                layoutParams.height = i;
                layoutParams.width = i;
                guildView.setLayoutParams(layoutParams);
            }
            if (this.$userSize != 0) {
                SimpleDraweeView simpleDraweeView = WidgetInviteInfo.access$getBinding$p(WidgetInviteInfo.this).d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
                ViewGroup.LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
                Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                int i2 = this.$userSize;
                layoutParams2.height = i2;
                layoutParams2.width = i2;
                simpleDraweeView.setLayoutParams(layoutParams2);
            }
        }
    }

    public WidgetInviteInfo(Context context) {
        this(context, null, 0, 6, null);
    }

    public WidgetInviteInfo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WidgetInviteInfo(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ WidgetGuildInviteInfoViewBinding access$getBinding$p(WidgetInviteInfo widgetInviteInfo) {
        return widgetInviteInfo.binding;
    }

    private final void configureForDirectFriend(ModelInvite model) {
        GuildView guildView = this.binding.c;
        User inviter = model.getInviter();
        String forUser$default = IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null);
        int i = GuildView.j;
        guildView.a(forUser$default, null);
        User inviter2 = model.getInviter();
        String username = inviter2 != null ? inviter2.getUsername() : null;
        if (username == null) {
            username = "";
        }
        StringBuilder sb = new StringBuilder();
        User inviter3 = model.getInviter();
        String username2 = inviter3 != null ? inviter3.getUsername() : null;
        if (username2 == null) {
            username2 = "";
        }
        sb.append(username2);
        sb.append("#");
        User inviter4 = model.getInviter();
        String discriminator = inviter4 != null ? inviter4.getDiscriminator() : null;
        sb.append(discriminator != null ? discriminator : "");
        String string = sb.toString();
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
        simpleDraweeView.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteTitle");
        textView.setText(getInviteTitleForDirectFriend(username));
        this.binding.g.setTextSize(2, 26.0f);
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        textView2.setText(getInviteSubtitleForDirectFriend(string));
        this.binding.f.setTextSize(2, 18.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureForGDM(ModelInvite model) {
        String icon;
        Channel channel = model.getChannel();
        if (channel != null) {
            Intrinsics3.checkNotNullExpressionValue(channel, "model.channel ?: return");
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, inviter != null ? new CoreUser(inviter) : null, R.dimen.avatar_size_hero, null, null, null, 56, null);
            User inviter2 = model.getInviter();
            String username = inviter2 != null ? inviter2.getUsername() : null;
            if (username == null) {
                username = "";
            }
            boolean z2 = true;
            String strC = ChannelUtils.c(channel).length() > 0 ? ChannelUtils.c(channel) : username;
            if (!ChannelUtils.z(channel) || (icon = channel.getIcon()) == null) {
                z2 = false;
            } else {
                if (!(icon.length() > 0)) {
                }
            }
            this.binding.c.a(z2 ? IconUtils.getForChannel$default(channel, null, 2, null) : IconUtils.INSTANCE.getDefaultForGroupDM(channel.getId()), null);
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
            simpleDraweeView2.setVisibility(z2 ? 0 : 8);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteMessage");
            textView.setText(getFormattedGuildName(strC));
            TextView textView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteTitle");
            textView2.setText(getIntroTextForGroup(username, ChannelUtils.c(channel)));
            this.binding.e.setOnline(null);
            this.binding.e.setMembers(Integer.valueOf(model.getApproximateMemberCount()));
        }
    }

    private final void configureForGuild(ModelInvite model) {
        List<GuildFeature> listM;
        List<GuildFeature> listM2;
        boolean z2 = model.getInviter() != null && model.getApproximateMemberCount() < 200;
        Guild guild = model.guild;
        if (guild != null) {
            GuildView guildView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(guild, "it");
            guildView.a(IconUtils.getForGuild$default(new com.discord.models.guild.Guild(guild), null, true, null, 10, null), GuildUtils.computeShortName(guild.getName()));
        }
        if (z2) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null), R.dimen.avatar_size_medium, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }
        this.binding.e.setMembers(!z2 ? Integer.valueOf(model.getApproximateMemberCount()) : null);
        this.binding.e.setOnline(!z2 ? Integer.valueOf(model.getApproximatePresenceCount()) : null);
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteMessage");
        Guild guild2 = model.guild;
        String name = guild2 != null ? guild2.getName() : null;
        if (name == null) {
            name = "";
        }
        textView.setText(getFormattedGuildName(name));
        Guild guild3 = model.guild;
        if (guild3 == null || (listM2 = guild3.m()) == null || !listM2.contains(GuildFeature.VERIFIED)) {
            Guild guild4 = model.guild;
            if (guild4 != null && (listM = guild4.m()) != null && listM.contains(GuildFeature.PARTNERED)) {
                TextView textView2 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
                ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, R.drawable.ic_partnered_badge, 0, 0, 0, 14, null);
            }
        } else {
            TextView textView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.inviteMessage");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView3, R.drawable.ic_verified_badge, 0, 0, 0, 14, null);
        }
        TextView textView4 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.inviteTitle");
        User inviter2 = model.getInviter();
        textView4.setText(getIntroText(inviter2 != null ? inviter2.getUsername() : null));
    }

    private final CharSequence getFormattedGuildName(String guildName) {
        return FormatUtils.l(outline.y("**", guildName, "**"), new Object[0], null, 2);
    }

    private final CharSequence getIntroText(String userName) {
        return userName == null ? FormatUtils.j(this, R.string.instant_invite_you_have_been_invited_to_join, new Object[0], null, 4) : FormatUtils.j(this, R.string.auth_message_invited_by, new Object[]{userName}, null, 4);
    }

    private final CharSequence getIntroTextForGroup(String userName, String channelName) {
        return channelName.length() > 0 ? FormatUtils.j(this, R.string.auth_message_invited_by, new Object[]{userName}, null, 4) : FormatUtils.j(this, R.string.instant_invite_you_have_been_invited_to_join_group_dm, new Object[0], null, 4);
    }

    private final CharSequence getInviteSubtitleForDirectFriend(String userName) {
        return FormatUtils.j(this, R.string.instant_invite_direct_friend_description, new Object[]{userName}, null, 4);
    }

    private final CharSequence getInviteTitleForDirectFriend(String userName) {
        return FormatUtils.j(this, R.string.instant_invite_you_have_been_invited_to_chat, new Object[]{userName}, null, 4);
    }

    private final void parseAttributeSet(Context context, AttributeSet attributeSet, int defStyleAttr) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.WidgetInviteInfo, defStyleAttr, 0);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…iteInfo, defStyleAttr, 0)");
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        post(new AnonymousClass1(dimension, dimension2));
    }

    public final void configureUI(ModelInvite model, Function0<Unit> onAcceptClick) {
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(onAcceptClick, "onAcceptClick");
        this.binding.c.b();
        MaterialButton materialButton = this.binding.f2415b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(0);
        this.binding.f2415b.setOnClickListener(new AnonymousClass1(onAcceptClick));
        if (model.guild == null && model.getChannel() == null && model.getInviter() != null) {
            configureForDirectFriend(model);
        } else if (model.guild == null) {
            configureForGDM(model);
        } else {
            configureForGuild(model);
        }
    }

    public final void configureUIFailure(Error e) {
        this.binding.g.setText(R.string.instant_invite_expired);
        this.binding.f.setText(R.string.invite_button_expired);
        MaterialButton materialButton = this.binding.f2415b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(8);
        if (e != null) {
            Error.Response response = e.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "e.response");
            if (response.getCode() == 30001) {
                MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
                TextView textView = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteTitle");
                FormatUtils.m(textView, R.string.too_many_user_guilds_alert_description, new Object[0], new AnonymousClass1(meSnapshot));
                this.binding.f.setText(R.string.too_many_user_guilds_description);
                this.binding.f.setTextSize(0, getResources().getDimension(R.dimen.uikit_textsize_medium));
            }
        }
        TextView textView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, 0, 0, 15, null);
        ServerMemberCount serverMemberCount = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        GuildView guildView = this.binding.c;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int themedDrawableRes = DrawableCompat.getThemedDrawableRes(context, R.attr.img_poop, R.drawable.img_poop_dark);
        Objects.requireNonNull(guildView);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = guildView.binding.f146b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView, themedDrawableRes, (MGImages.ChangeDetector) null, 4, (Object) null);
        TextView textView3 = guildView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildText");
        textView3.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetInviteInfo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "ctx");
        LayoutInflater.from(getContext()).inflate(R.layout.widget_guild_invite_info_view, this);
        int i2 = R.id.guild_invite_accept;
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.guild_invite_accept);
        if (materialButton != null) {
            i2 = R.id.invite_avatar;
            GuildView guildView = (GuildView) findViewById(R.id.invite_avatar);
            if (guildView != null) {
                i2 = R.id.invite_avatar_small;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.invite_avatar_small);
                if (simpleDraweeView != null) {
                    i2 = R.id.invite_member_container_layout;
                    ServerMemberCount serverMemberCount = (ServerMemberCount) findViewById(R.id.invite_member_container_layout);
                    if (serverMemberCount != null) {
                        i2 = R.id.invite_message;
                        TextView textView = (TextView) findViewById(R.id.invite_message);
                        if (textView != null) {
                            i2 = R.id.invite_title;
                            TextView textView2 = (TextView) findViewById(R.id.invite_title);
                            if (textView2 != null) {
                                i2 = R.id.title_layout;
                                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.title_layout);
                                if (linearLayout != null) {
                                    WidgetGuildInviteInfoViewBinding widgetGuildInviteInfoViewBinding = new WidgetGuildInviteInfoViewBinding(this, materialButton, guildView, simpleDraweeView, serverMemberCount, textView, textView2, linearLayout);
                                    Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteInfoViewBinding, "WidgetGuildInviteInfoVie…ater.from(context), this)");
                                    this.binding = widgetGuildInviteInfoViewBinding;
                                    Context context2 = getContext();
                                    Intrinsics3.checkNotNullExpressionValue(context2, "context");
                                    parseAttributeSet(context2, attributeSet, i);
                                    setBackgroundResource(R.drawable.bg_guild_scheduled_event_list_item_primary);
                                    int iDpToPixels = DimenUtils.dpToPixels(24);
                                    setPadding(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }

    /* compiled from: WidgetInviteInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetInviteInfo$configureUIFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ MeUser $meUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MeUser meUser) {
            super(1);
            this.$meUser = meUser;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("quantity", String.valueOf(UserUtils.INSTANCE.isPremiumTier2(this.$meUser) ? 200 : 100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
