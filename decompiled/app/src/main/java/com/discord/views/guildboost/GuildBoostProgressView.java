package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.i.ViewPremiumGuildProgressBinding;
import com.discord.R;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.premium.GuildBoostUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: GuildBoostProgressView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\t\u001a\u00020\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/discord/views/guildboost/GuildBoostProgressView;", "Landroid/widget/FrameLayout;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "premiumTier", "premiumSubscriptionCount", "", "a", "(JII)V", "Lb/a/i/x2;", "j", "Lb/a/i/x2;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildBoostProgressView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewPremiumGuildProgressBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_premium_guild_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.progress_gem_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.progress_gem_icon);
        if (imageView != null) {
            i = R.id.progress_level_text;
            TextView textView = (TextView) viewInflate.findViewById(R.id.progress_level_text);
            if (textView != null) {
                i = R.id.progress_progress;
                ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progress_progress);
                if (progressBar != null) {
                    ViewPremiumGuildProgressBinding viewPremiumGuildProgressBinding = new ViewPremiumGuildProgressBinding((FrameLayout) viewInflate, imageView, textView, progressBar);
                    Intrinsics3.checkNotNullExpressionValue(viewPremiumGuildProgressBinding, "ViewPremiumGuildProgress…rom(context), this, true)");
                    this.binding = viewPremiumGuildProgressBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(long guildId, int premiumTier, int premiumSubscriptionCount) {
        ImageView imageView = this.binding.f228b;
        int themedDrawableRes$default = 0;
        if (premiumTier == 0) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.boosted_guild_tier_0, 0, 2, (Object) null);
        } else if (premiumTier == 1) {
            themedDrawableRes$default = R.drawable.ic_boosted_guild_tier_1;
        } else if (premiumTier == 2) {
            themedDrawableRes$default = R.drawable.ic_boosted_guild_tier_2;
        } else if (premiumTier == 3) {
            themedDrawableRes$default = R.drawable.ic_boosted_guild_tier_3;
        }
        imageView.setImageResource(themedDrawableRes$default);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.progressLevelText");
        textView.setText(premiumTier != 0 ? premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? "" : getContext().getString(R.string.premium_guild_tier_3) : getContext().getString(R.string.premium_guild_tier_2) : getContext().getString(R.string.premium_guild_tier_1) : getContext().getString(R.string.premium_guild_header_badge_no_tier));
        ProgressBar progressBar = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.progressProgress");
        progressBar.setProgress(GuildBoostUtils.calculatePercentToNextTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, premiumSubscriptionCount, null, null, 24, null));
    }
}
