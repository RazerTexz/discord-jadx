package com.discord.widgets.guilds.join;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetGuildWelcomeChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildWelcomeSheetChannelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/guilds/join/BaseChannelViewHolder;", "", "Lcom/discord/widgets/guilds/join/ChannelItem;", "data", "", "setData", "(Ljava/util/List;)V", "", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guilds/join/BaseChannelViewHolder;", "holder", "onBindViewHolder", "(Lcom/discord/widgets/guilds/join/BaseChannelViewHolder;I)V", "Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetChannelAdapter extends RecyclerView.Adapter<WidgetGuildWelcomeSheetChannelAdapter2> {
    private List<? extends WidgetGuildWelcomeSheetChannelAdapter3> data = Collections2.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetGuildWelcomeSheetChannelAdapter2) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends WidgetGuildWelcomeSheetChannelAdapter3> data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(WidgetGuildWelcomeSheetChannelAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGuildWelcomeSheetChannelAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            throw new IllegalArgumentException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_welcome_channel, parent, false);
        CardView cardView = (CardView) viewInflate;
        int i = R.id.guild_welcome_channel_description;
        TextView textView = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_description);
        if (textView != null) {
            i = R.id.guild_welcome_channel_details;
            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_details);
            if (constraintLayout != null) {
                i = R.id.guild_welcome_channel_emoji;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.guild_welcome_channel_emoji);
                if (simpleDraweeView != null) {
                    i = R.id.guild_welcome_channel_hash;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guild_welcome_channel_hash);
                    if (imageView != null) {
                        i = R.id.guild_welcome_channel_icon;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_icon);
                        if (constraintLayout2 != null) {
                            i = R.id.guild_welcome_channel_name;
                            TextView textView2 = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_name);
                            if (textView2 != null) {
                                i = R.id.guild_welcome_channel_text;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) viewInflate.findViewById(R.id.guild_welcome_channel_text);
                                if (constraintLayout3 != null) {
                                    i = R.id.guild_welcome_channel_unicode_emoji;
                                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.guild_welcome_channel_unicode_emoji);
                                    if (textView3 != null) {
                                        WidgetGuildWelcomeChannelBinding widgetGuildWelcomeChannelBinding = new WidgetGuildWelcomeChannelBinding((CardView) viewInflate, cardView, textView, constraintLayout, simpleDraweeView, imageView, constraintLayout2, textView2, constraintLayout3, textView3);
                                        Intrinsics3.checkNotNullExpressionValue(widgetGuildWelcomeChannelBinding, "WidgetGuildWelcomeChanne….context), parent, false)");
                                        return new WidgetGuildWelcomeSheetChannelAdapter4(widgetGuildWelcomeChannelBinding);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
