package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.GuildRoleChipBinding;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.google.android.material.chip.ChipGroup;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: RolesListView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/roles/RolesListView;", "Lcom/google/android/material/chip/ChipGroup;", "", "Lcom/discord/api/role/GuildRole;", "roles", "", "roleDefaultColor", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "updateView", "(Ljava/util/List;IJ)V", "Ljava/util/List;", "getRoles", "()Ljava/util/List;", "setRoles", "(Ljava/util/List;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class RolesListView extends ChipGroup {
    private List<GuildRole> roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.roles = Collections2.emptyList();
        int iDpToPixels = DimenUtils.dpToPixels(4);
        setChipSpacingVertical(iDpToPixels);
        setChipSpacingHorizontal(iDpToPixels);
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final void setRoles(List<GuildRole> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.roles = list;
    }

    public final void updateView(List<GuildRole> roles, int roleDefaultColor, long guildId) {
        Intrinsics3.checkNotNullParameter(roles, "roles");
        if (Intrinsics3.areEqual(roles, this.roles)) {
            return;
        }
        boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
        this.roles = roles;
        removeAllViews();
        for (GuildRole guildRole : roles) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.guild_role_chip, (ViewGroup) null, false);
            int i = R.id.role_chip_dot;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.role_chip_dot);
            if (imageView != null) {
                i = R.id.role_chip_icon;
                RoleIconView roleIconView = (RoleIconView) viewInflate.findViewById(R.id.role_chip_icon);
                if (roleIconView != null) {
                    i = R.id.role_chip_text;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.role_chip_text);
                    if (textView != null) {
                        CardView cardView = (CardView) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new GuildRoleChipBinding(cardView, imageView, roleIconView, textView), "GuildRoleChipBinding.inf…om(context), null, false)");
                        Intrinsics3.checkNotNullExpressionValue(textView, "binding.roleChipText");
                        textView.setText(guildRole.getName());
                        int opaqueColor = RoleUtils.isDefaultColor(guildRole) ? roleDefaultColor : RoleUtils.getOpaqueColor(guildRole);
                        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.roleChipDot");
                        ColorCompat2.tintWithColor(imageView, opaqueColor);
                        roleIconView.setRole(guildRole, Long.valueOf(guildId));
                        if (isDeveloperMode) {
                            cardView.setOnClickListener(new RolesListView2(guildRole, this, roleDefaultColor, guildId, isDeveloperMode));
                        }
                        addView(cardView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }
}
