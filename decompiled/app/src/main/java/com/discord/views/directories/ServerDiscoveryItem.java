package com.discord.views.directories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewServerDiscoveryItemBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ServerDiscoveryItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/discord/views/directories/ServerDiscoveryItem;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "setDescription", "", "active", "setOnline", "(I)V", "members", "setMembers", "Landroid/view/View$OnClickListener;", "listener", "setJoinButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "setJoinedButtonOnClickListener", "", "joinedGuild", "setJoinedGuild", "(Z)V", "Lb/a/i/g3;", "j", "Lb/a/i/g3;", "binding", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerDiscoveryItem extends ConstraintLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewServerDiscoveryItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerDiscoveryItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_server_discovery_item, this);
        int i = R.id.button_barrier;
        Barrier barrier = (Barrier) findViewById(R.id.button_barrier);
        if (barrier != null) {
            i = R.id.server_discovery_item_barrier;
            Barrier barrier2 = (Barrier) findViewById(R.id.server_discovery_item_barrier);
            if (barrier2 != null) {
                i = R.id.server_discovery_item_button;
                MaterialButton materialButton = (MaterialButton) findViewById(R.id.server_discovery_item_button);
                if (materialButton != null) {
                    i = R.id.server_discovery_item_button_joined;
                    MaterialButton materialButton2 = (MaterialButton) findViewById(R.id.server_discovery_item_button_joined);
                    if (materialButton2 != null) {
                        i = R.id.server_discovery_item_count_container;
                        ServerMemberCount serverMemberCount = (ServerMemberCount) findViewById(R.id.server_discovery_item_count_container);
                        if (serverMemberCount != null) {
                            i = R.id.server_discovery_item_description;
                            TextView textView = (TextView) findViewById(R.id.server_discovery_item_description);
                            if (textView != null) {
                                i = R.id.server_discovery_item_image;
                                GuildView guildView = (GuildView) findViewById(R.id.server_discovery_item_image);
                                if (guildView != null) {
                                    i = R.id.server_discovery_item_title;
                                    TextView textView2 = (TextView) findViewById(R.id.server_discovery_item_title);
                                    if (textView2 != null) {
                                        ViewServerDiscoveryItemBinding viewServerDiscoveryItemBinding = new ViewServerDiscoveryItemBinding(this, barrier, barrier2, materialButton, materialButton2, serverMemberCount, textView, guildView, textView2);
                                        Intrinsics3.checkNotNullExpressionValue(viewServerDiscoveryItemBinding, "ViewServerDiscoveryItemB…ater.from(context), this)");
                                        this.binding = viewServerDiscoveryItemBinding;
                                        guildView.b();
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setDescription(CharSequence description) {
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryItemDescription");
        FormatUtils.a(textView, description);
    }

    public final void setJoinButtonOnClickListener(View.OnClickListener listener) {
        this.binding.f119b.setOnClickListener(listener);
    }

    public final void setJoinedButtonOnClickListener(View.OnClickListener listener) {
        this.binding.c.setOnClickListener(listener);
    }

    public final void setJoinedGuild(boolean joinedGuild) {
        MaterialButton materialButton = this.binding.f119b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverDiscoveryItemButton");
        materialButton.setVisibility(joinedGuild ^ true ? 0 : 8);
        MaterialButton materialButton2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.serverDiscoveryItemButtonJoined");
        materialButton2.setVisibility(joinedGuild ? 0 : 8);
    }

    public final void setMembers(int members) {
        this.binding.d.setMembers(Integer.valueOf(members));
    }

    public final void setOnline(int active) {
        this.binding.d.setOnline(Integer.valueOf(active));
    }

    public final void setTitle(CharSequence title) {
        TextView textView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverDiscoveryItemTitle");
        textView.setText(title);
    }
}
