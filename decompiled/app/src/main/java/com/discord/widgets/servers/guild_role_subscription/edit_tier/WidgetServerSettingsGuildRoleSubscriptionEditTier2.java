package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00060\u0012j\u0002`\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/edit_tier/ServerSettingsGuildRoleSubscriptionEditTierAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "pageSize", "", "setPageSize", "(I)V", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Landroidx/fragment/app/Fragment;", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "getTabStringResId", "(I)I", "", "isDetailsTab", "(I)Z", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "I", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;J)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier2 extends FragmentStateAdapter {
    private static final int TIER_BENEFITS_POSITION = 2;
    private static final int TIER_DESIGN_POSITION = 1;
    private static final int TIER_DETAILS_POSITION = 0;
    private final long guildId;
    private int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsGuildRoleSubscriptionEditTier2(Fragment fragment, long j) {
        super(fragment);
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        this.guildId = j;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        if (position == 0) {
            return WidgetGuildRoleSubscriptionTierDetails.INSTANCE.newInstance(true);
        }
        if (position == 1) {
            return WidgetGuildRoleSubscriptionTierDesign.INSTANCE.newInstance(true);
        }
        if (position == 2) {
            return WidgetGuildRoleSubscriptionTierBenefits.INSTANCE.newInstance(this.guildId, GuildRoleSubscriptionTierBenefitListType.ALL, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount, reason: from getter */
    public int getPageSize() {
        return this.pageSize;
    }

    public final int getTabStringResId(int position) {
        if (position == 0) {
            return R.string.guild_settings_role_subscription_tier_edit_details_title;
        }
        if (position == 1) {
            return R.string.guild_settings_role_subscription_tier_edit_design_title;
        }
        if (position == 2) {
            return R.string.guild_settings_role_subscription_tier_edit_benefits_title;
        }
        throw new IllegalArgumentException();
    }

    public final boolean isDetailsTab(int position) {
        return position == 0;
    }

    public final void setPageSize(int pageSize) {
        if (this.pageSize == pageSize) {
            return;
        }
        this.pageSize = pageSize;
        notifyDataSetChanged();
    }
}
