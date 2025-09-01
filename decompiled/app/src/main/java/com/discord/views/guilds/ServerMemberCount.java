package com.discord.views.guilds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.ViewServerMemberCountBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.resources.StringResourceUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ServerMemberCount.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\nR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/discord/views/guilds/ServerMemberCount;", "Landroid/widget/FrameLayout;", "", "charSequence", "", "setInvalidText", "(Ljava/lang/CharSequence;)V", "", "active", "setOnline", "(Ljava/lang/Integer;)V", "members", "setMembers", "Lb/a/i/i3;", "j", "Lb/a/i/i3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerMemberCount extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewServerMemberCountBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerMemberCount(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_server_member_count, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.item_invite_online_dot;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.item_invite_online_dot);
        if (imageView != null) {
            i = R.id.item_invite_online_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.item_invite_online_text);
            if (textView != null) {
                i = R.id.item_invite_total_member_dot;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.item_invite_total_member_dot);
                if (imageView2 != null) {
                    i = R.id.item_invite_total_member_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.item_invite_total_member_text);
                    if (textView2 != null) {
                        ViewServerMemberCountBinding viewServerMemberCountBinding = new ViewServerMemberCountBinding((LinearLayout) viewInflate, imageView, textView, imageView2, textView2);
                        Intrinsics3.checkNotNullExpressionValue(viewServerMemberCountBinding, "ViewServerMemberCountBin…rom(context), this, true)");
                        this.binding = viewServerMemberCountBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setInvalidText(CharSequence charSequence) {
        ImageView imageView = this.binding.f134b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(8);
        ImageView imageView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.itemInviteTotalMemberDot");
        imageView2.setVisibility(8);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        FormatUtils.a(textView, charSequence);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemInviteTotalMemberText");
        FormatUtils.a(textView2, null);
    }

    public final void setMembers(Integer members) {
        CharSequence i18nPluralString;
        ImageView imageView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteTotalMemberDot");
        imageView.setVisibility(members != null ? 0 : 8);
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteTotalMemberText");
        if (members != null) {
            members.intValue();
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.members_header_members, members.intValue(), members);
        } else {
            i18nPluralString = null;
        }
        FormatUtils.a(textView, i18nPluralString);
    }

    public final void setOnline(Integer active) {
        ImageView imageView = this.binding.f134b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.itemInviteOnlineDot");
        imageView.setVisibility(active != null ? 0 : 8);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemInviteOnlineText");
        CharSequence charSequenceJ = null;
        if (active != null) {
            active.intValue();
            charSequenceJ = FormatUtils.j(this, R.string.instant_invite_guild_members_online, new Object[]{active}, null, 4);
        }
        FormatUtils.a(textView, charSequenceJ);
    }
}
