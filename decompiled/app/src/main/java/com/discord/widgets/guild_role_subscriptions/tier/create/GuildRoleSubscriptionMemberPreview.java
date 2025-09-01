package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetChatListAdapterItemTextBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildRoleSubscriptionMemberPreview.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001d\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B'\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u001bJ1\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guild_role_subscriptions/tier/create/GuildRoleSubscriptionMemberPreview;", "Landroid/widget/FrameLayout;", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "", "icon", "Lcom/discord/api/role/GuildRole;", "guildRole", "", "setMemberDesign", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/discord/api/role/GuildRole;)V", "defaultColor$delegate", "Lkotlin/Lazy;", "getDefaultColor", "()I", "defaultColor", "Lcom/discord/databinding/WidgetChatListAdapterItemTextBinding;", "binding", "Lcom/discord/databinding/WidgetChatListAdapterItemTextBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionMemberPreview extends FrameLayout {
    private final WidgetChatListAdapterItemTextBinding binding;

    /* renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = LazyJVM.lazy(new GuildRoleSubscriptionMemberPreview2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(R.string.wumpus);
        widgetChatListAdapterItemTextBindingB.g.setText(R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(R.string.guild_role_subscription_tier_design_member_preview_placeholder_message);
        setBackgroundColor(ColorCompat.getThemedColor(this, R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    private final int getDefaultColor() {
        return ((Number) this.defaultColor.getValue()).intValue();
    }

    public static /* synthetic */ void setMemberDesign$default(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, Integer num, String str, GuildRole guildRole, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            guildRole = null;
        }
        guildRoleSubscriptionMemberPreview.setMemberDesign(num, str, guildRole);
    }

    public final void setMemberDesign(@ColorInt Integer color, String icon, GuildRole guildRole) {
        this.binding.d.setTextColor(color != null ? color.intValue() : getDefaultColor());
        if (icon == null || StringsJVM.isBlank(icon)) {
            this.binding.e.setRoleIconPreview(guildRole);
        } else {
            this.binding.e.setRoleIconPreview(icon);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = LazyJVM.lazy(new GuildRoleSubscriptionMemberPreview2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(R.string.wumpus);
        widgetChatListAdapterItemTextBindingB.g.setText(R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(R.string.guild_role_subscription_tier_design_member_preview_placeholder_message);
        setBackgroundColor(ColorCompat.getThemedColor(this, R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBindingB = WidgetChatListAdapterItemTextBinding.b(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextBindingB, "WidgetChatListAdapterIte…rom(context), this, true)");
        this.binding = widgetChatListAdapterItemTextBindingB;
        this.defaultColor = LazyJVM.lazy(new GuildRoleSubscriptionMemberPreview2(this));
        if (isInEditMode()) {
            widgetChatListAdapterItemTextBindingB.c.setImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        } else {
            widgetChatListAdapterItemTextBindingB.c.setActualImageResource(R.drawable.img_guild_role_subscription_default_avatar_40dp);
        }
        TextView textView = widgetChatListAdapterItemTextBindingB.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextTag");
        textView.setVisibility(8);
        widgetChatListAdapterItemTextBindingB.d.setText(R.string.wumpus);
        widgetChatListAdapterItemTextBindingB.g.setText(R.string.sample_time_pm);
        widgetChatListAdapterItemTextBindingB.f2338b.setText(R.string.guild_role_subscription_tier_design_member_preview_placeholder_message);
        setBackgroundColor(ColorCompat.getThemedColor(this, R.attr.colorBackgroundPrimary));
        widgetChatListAdapterItemTextBindingB.h.setPadding(0, 0, 0, 0);
        widgetChatListAdapterItemTextBindingB.e.setRole((GuildRole) null, (Long) null);
    }

    public /* synthetic */ GuildRoleSubscriptionMemberPreview(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
