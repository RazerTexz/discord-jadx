package com.discord.widgets.auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import com.discord.databinding.ViewAuthInviteInfoBinding;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AuthInviteInfoView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/auth/AuthInviteInfoView;", "Landroid/widget/RelativeLayout;", "Lcom/discord/models/domain/ModelInvite;", "", "getIntroText", "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/CharSequence;", "invite", "", "configureInvite", "(Lcom/discord/models/domain/ModelInvite;)V", "Lcom/discord/models/domain/ModelGuildTemplate;", "guildTemplate", "configureGuildTemplate", "(Lcom/discord/models/domain/ModelGuildTemplate;)V", "Lcom/discord/databinding/ViewAuthInviteInfoBinding;", "binding", "Lcom/discord/databinding/ViewAuthInviteInfoBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AuthInviteInfoView extends RelativeLayout {
    private final ViewAuthInviteInfoBinding binding;

    public AuthInviteInfoView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AuthInviteInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AuthInviteInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CharSequence getIntroText(ModelInvite modelInvite) {
        User inviter = modelInvite.getInviter();
        String username = inviter != null ? inviter.getUsername() : null;
        boolean z2 = username != null && (StringsJVM.isBlank(username) ^ true);
        if (modelInvite.getChannel() == null && modelInvite.guild == null && z2) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.h(context, R.string.instant_invite_you_have_been_invited_to_chat_with, new Object[0], null, 4);
        }
        Channel channel = modelInvite.getChannel();
        if (channel == null || !ChannelUtils.z(channel)) {
            if (modelInvite.getApproximateMemberCount() >= 200 || !z2) {
                Context context2 = getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "context");
                return FormatUtils.h(context2, R.string.instant_invite_you_have_been_invited_to_join, new Object[0], null, 4);
            }
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            return FormatUtils.h(context3, R.string.auth_message_invited_by, new Object[]{username}, null, 4);
        }
        Channel channel2 = modelInvite.getChannel();
        if (channel2 != null) {
            if (!(ChannelUtils.c(channel2).length() == 0)) {
            }
        } else if (z2) {
            Context context4 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context4, "context");
            Object[] objArr = new Object[1];
            User inviter2 = modelInvite.getInviter();
            objArr[0] = inviter2 != null ? inviter2.getUsername() : null;
            return FormatUtils.h(context4, R.string.auth_message_invited_by, objArr, null, 4);
        }
        Context context5 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context5, "context");
        return FormatUtils.h(context5, R.string.instant_invite_you_have_been_invited_to_join_group_dm, new Object[0], null, 4);
    }

    public final void configureGuildTemplate(ModelGuildTemplate guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        SimpleDraweeView simpleDraweeView = this.binding.f2174b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.authInviteInfoGuildAvatar");
        simpleDraweeView.setVisibility(8);
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.authInviteInfoTemplateIcon");
        imageView.setVisibility(0);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.authInviteInfoInvitedText");
        FormatUtils.n(textView, R.string.guild_template_modal_title, new Object[0], null, 4);
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.authInviteInfoGuildName");
        textView2.setText(guildTemplate.getName());
    }

    public final void configureInvite(ModelInvite invite) {
        String username;
        String discriminator;
        NullSerializable<String> nullSerializableA;
        String username2;
        Intrinsics3.checkNotNullParameter(invite, "invite");
        SimpleDraweeView simpleDraweeView = this.binding.f2174b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.authInviteInfoGuildAvatar");
        simpleDraweeView.setVisibility(0);
        ImageView imageView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.authInviteInfoTemplateIcon");
        imageView.setVisibility(8);
        Channel channel = invite.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 0) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == 13)))) {
            Guild guild = invite.guild;
            if (guild != null) {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2174b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.authInviteInfoGuildAvatar");
                Intrinsics3.checkNotNullExpressionValue(guild, "inviteGuild");
                IconUtils.setIcon$default(simpleDraweeView2, IconUtils.getForGuild$default(new com.discord.models.guild.Guild(guild), IconUtils.DEFAULT_ICON_BLURPLE, true, null, 8, null), R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.authInviteInfoInvitedText");
                textView.setText(FormatUtils.l(getIntroText(invite), new Object[0], null, 2));
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.authInviteInfoGuildName");
                textView2.setText(guild.getName());
                return;
            }
            return;
        }
        String strC = "";
        if (numValueOf != null && numValueOf.intValue() == 3) {
            User inviter = invite.getInviter();
            if (inviter != null && (username2 = inviter.getUsername()) != null) {
                strC = username2;
            }
            SimpleDraweeView simpleDraweeView3 = this.binding.f2174b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.authInviteInfoGuildAvatar");
            User inviter2 = invite.getInviter();
            IconUtils.setIcon$default(simpleDraweeView3, (inviter2 == null || (nullSerializableA = inviter2.a()) == null) ? null : nullSerializableA.a(), R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
            TextView textView3 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.authInviteInfoInvitedText");
            textView3.setText(FormatUtils.l(getIntroText(invite), new Object[0], null, 2));
            TextView textView4 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.authInviteInfoGuildName");
            Channel channel2 = invite.getChannel();
            if (channel2 != null) {
                if (ChannelUtils.c(channel2).length() > 0) {
                    Channel channel3 = invite.getChannel();
                    strC = channel3 != null ? ChannelUtils.c(channel3) : null;
                }
            }
            textView4.setText(strC);
            return;
        }
        if (numValueOf == null) {
            User inviter3 = invite.getInviter();
            if (inviter3 == null || (username = inviter3.getUsername()) == null) {
                username = "";
            }
            StringBuilder sbX = outline.X(username, "#");
            User inviter4 = invite.getInviter();
            if (inviter4 != null && (discriminator = inviter4.getDiscriminator()) != null) {
                strC = discriminator;
            }
            sbX.append(strC);
            String string = sbX.toString();
            SimpleDraweeView simpleDraweeView4 = this.binding.f2174b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.authInviteInfoGuildAvatar");
            User inviter5 = invite.getInviter();
            IconUtils.setIcon$default(simpleDraweeView4, inviter5 != null ? new CoreUser(inviter5) : null, R.dimen.avatar_size_large, null, null, null, 56, null);
            TextView textView5 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.authInviteInfoInvitedText");
            textView5.setText(FormatUtils.l(getIntroText(invite), new Object[0], null, 2));
            TextView textView6 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.authInviteInfoGuildName");
            textView6.setText(string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthInviteInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_auth_invite_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.auth_invite_info_content;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.auth_invite_info_content);
        if (linearLayout != null) {
            i2 = R.id.auth_invite_info_guild_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.auth_invite_info_guild_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.auth_invite_info_guild_name;
                TextView textView = (TextView) viewInflate.findViewById(R.id.auth_invite_info_guild_name);
                if (textView != null) {
                    i2 = R.id.auth_invite_info_invited_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.auth_invite_info_invited_text);
                    if (textView2 != null) {
                        i2 = R.id.auth_invite_info_template_icon;
                        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.auth_invite_info_template_icon);
                        if (imageView != null) {
                            ViewAuthInviteInfoBinding viewAuthInviteInfoBinding = new ViewAuthInviteInfoBinding((RelativeLayout) viewInflate, linearLayout, simpleDraweeView, textView, textView2, imageView);
                            Intrinsics3.checkNotNullExpressionValue(viewAuthInviteInfoBinding, "ViewAuthInviteInfoBindin…rom(context), this, true)");
                            this.binding = viewAuthInviteInfoBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
