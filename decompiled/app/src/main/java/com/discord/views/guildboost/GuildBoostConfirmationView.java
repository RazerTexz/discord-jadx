package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import b.a.i.ViewGuildBoostConfirmationBinding;
import com.discord.R;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.GuildBoostUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildBoostConfirmationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/discord/views/guildboost/GuildBoostConfirmationView;", "Landroidx/cardview/widget/CardView;", "Lcom/discord/models/guild/Guild;", "guild", "", "netNewSubscriptions", "", "b", "(Lcom/discord/models/guild/Guild;I)V", "boostTier", "c", "(I)I", "", "d", "(I)Ljava/lang/String;", "Lb/a/i/l2;", "j", "Lb/a/i/l2;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostConfirmationView extends CardView {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewGuildBoostConfirmationBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostConfirmationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_guild_boost_confirmation, this);
        int i = R.id.guild_boost_confirmation_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.guild_boost_confirmation_avatar);
        if (simpleDraweeView != null) {
            i = R.id.guild_boost_confirmation_guild_name;
            TextView textView = (TextView) findViewById(R.id.guild_boost_confirmation_guild_name);
            if (textView != null) {
                i = R.id.guild_boost_confirmation_level_info_previous;
                Chip chip = (Chip) findViewById(R.id.guild_boost_confirmation_level_info_previous);
                if (chip != null) {
                    i = R.id.guild_boost_confirmation_level_info_upgrade;
                    Chip chip2 = (Chip) findViewById(R.id.guild_boost_confirmation_level_info_upgrade);
                    if (chip2 != null) {
                        i = R.id.guild_boost_confirmation_upgrade_arrow;
                        ImageView imageView = (ImageView) findViewById(R.id.guild_boost_confirmation_upgrade_arrow);
                        if (imageView != null) {
                            ViewGuildBoostConfirmationBinding viewGuildBoostConfirmationBinding = new ViewGuildBoostConfirmationBinding(this, simpleDraweeView, textView, chip, chip2, imageView);
                            Intrinsics3.checkNotNullExpressionValue(viewGuildBoostConfirmationBinding, "ViewGuildBoostConfirmati…ater.from(context), this)");
                            this.binding = viewGuildBoostConfirmationBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void b(Guild guild, int netNewSubscriptions) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        int boostTier$default = GuildBoostUtils.getBoostTier$default(GuildBoostUtils.INSTANCE, guild.getId(), guild.getPremiumSubscriptionCount() + netNewSubscriptions, null, null, 12, null);
        char c = boostTier$default > guild.getPremiumTier() ? (char) 1 : boostTier$default < guild.getPremiumTier() ? (char) 2 : (char) 3;
        SimpleDraweeView simpleDraweeView = this.binding.f152b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildBoostConfirmationAvatar");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostConfirmationGuildName");
        textView.setText(guild.getName());
        Chip chip = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip.setChipIcon(ContextCompat.getDrawable(getContext(), c(guild.getPremiumTier())));
        Chip chip2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(chip2, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip2.setText(d(guild.getPremiumTier()));
        ImageView imageView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildBoostConfirmationUpgradeArrow");
        imageView.setVisibility(c != 3 ? 0 : 8);
        Chip chip3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(chip3, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip3.setVisibility(c != 3 ? 0 : 8);
        if (c == 3) {
            return;
        }
        int i = c == 2 ? R.color.status_red_500 : R.color.status_green_600;
        ImageView imageView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildBoostConfirmationUpgradeArrow");
        ColorCompat2.tintWithColorResource(imageView2, i);
        Chip chip4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(chip4, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip4.setChipIcon(ContextCompat.getDrawable(getContext(), c(boostTier$default)));
        Chip chip5 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(chip5, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip5.setText(d(boostTier$default));
    }

    public final int c(int boostTier) {
        if (boostTier == 0) {
            return R.drawable.ic_guild_nitro_progress_banner;
        }
        if (boostTier == 1) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, R.attr.guild_boost_badge_tier_1, 0, 2, (Object) null);
        }
        if (boostTier == 2) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return DrawableCompat.getThemedDrawableRes$default(context2, R.attr.guild_boost_badge_tier_2, 0, 2, (Object) null);
        }
        if (boostTier != 3) {
            return 0;
        }
        Context context3 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context3, "context");
        return DrawableCompat.getThemedDrawableRes$default(context3, R.attr.guild_boost_badge_tier_3, 0, 2, (Object) null);
    }

    public final String d(int boostTier) {
        String string = boostTier != 0 ? boostTier != 1 ? boostTier != 2 ? boostTier != 3 ? "" : getContext().getString(R.string.premium_guild_tier_3) : getContext().getString(R.string.premium_guild_tier_2) : getContext().getString(R.string.premium_guild_tier_1) : getContext().getString(R.string.premium_guild_header_badge_no_tier);
        Intrinsics3.checkNotNullExpressionValue(string, "when (boostTier) {\n     …       else -> \"\"\n      }");
        return string;
    }
}
