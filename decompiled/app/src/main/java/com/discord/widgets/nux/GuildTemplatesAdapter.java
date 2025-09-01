package com.discord.widgets.nux;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.NuxGuildTemplateCardViewHolderBinding;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.nux.GuildTemplatesAdapter2;
import com.google.android.material.card.MaterialCardView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: GuildTemplatesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R6\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "", "Lcom/discord/widgets/nux/GuildTemplateViewType;", "value", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "callbacks", "Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "getCallbacks", "()Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "<init>", "(Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;)V", "Callbacks", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildTemplatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Callbacks callbacks;
    private List<? extends GuildTemplatesAdapter2> items;

    /* compiled from: GuildTemplatesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "", "Lcom/discord/widgets/nux/GuildTemplate;", "guildTemplate", "", "onTemplateClick", "(Lcom/discord/widgets/nux/GuildTemplate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Callbacks {
        void onTemplateClick(GuildTemplates guildTemplate);
    }

    public GuildTemplatesAdapter(Callbacks callbacks) {
        Intrinsics3.checkNotNullParameter(callbacks, "callbacks");
        this.callbacks = callbacks;
        this.items = Collections2.emptyList();
    }

    public final Callbacks getCallbacks() {
        return this.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getViewType();
    }

    public final List<GuildTemplatesAdapter2> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        GuildTemplatesAdapter2 guildTemplatesAdapter2 = this.items.get(position);
        if (guildTemplatesAdapter2 instanceof GuildTemplatesAdapter2.Template) {
            if (!(holder instanceof GuildTemplateViewHolders)) {
                holder = null;
            }
            GuildTemplateViewHolders guildTemplateViewHolders = (GuildTemplateViewHolders) holder;
            if (guildTemplateViewHolders != null) {
                guildTemplateViewHolders.bind(((GuildTemplatesAdapter2.Template) guildTemplatesAdapter2).getGuildTemplate());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        GuildTemplatesAdapter2.Companion companion = GuildTemplatesAdapter2.INSTANCE;
        if (viewType == companion.getTEXT()) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.nux_guild_template_text_view_holder, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding = new NuxGuildTemplateTextViewHolderBinding((TextView) viewInflate);
            Intrinsics3.checkNotNullExpressionValue(nuxGuildTemplateTextViewHolderBinding, "NuxGuildTemplateTextView…          false\n        )");
            return new GuildTemplateViewHolders2(nuxGuildTemplateTextViewHolderBinding);
        }
        if (viewType != companion.getTEMPLATE()) {
            throw new IllegalStateException(outline.q("Missing view type for ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.nux_guild_template_card_view_holder, parent, false);
        MaterialCardView materialCardView = (MaterialCardView) viewInflate2;
        TextView textView = (TextView) viewInflate2.findViewById(R.id.nux_guild_template_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.nux_guild_template_text)));
        }
        NuxGuildTemplateCardViewHolderBinding nuxGuildTemplateCardViewHolderBinding = new NuxGuildTemplateCardViewHolderBinding((MaterialCardView) viewInflate2, materialCardView, textView);
        Intrinsics3.checkNotNullExpressionValue(nuxGuildTemplateCardViewHolderBinding, "NuxGuildTemplateCardView…          false\n        )");
        return new GuildTemplateViewHolders(nuxGuildTemplateCardViewHolderBinding, this.callbacks);
    }

    public final void setItems(List<? extends GuildTemplatesAdapter2> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.items = _Collections.plus((Collection) Collections2.listOf((Object[]) new GuildTemplatesAdapter2[]{new GuildTemplatesAdapter2.Template(GuildTemplates.CreateMyOwn), GuildTemplatesAdapter2.Text.INSTANCE}), (Iterable) list);
        notifyDataSetChanged();
    }
}
