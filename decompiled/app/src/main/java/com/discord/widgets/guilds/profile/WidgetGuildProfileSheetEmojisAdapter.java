package com.discord.widgets.guilds.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%J+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\f\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/discord/widgets/guilds/profile/WidgetGuildProfileSheetEmojisAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/discord/widgets/guilds/profile/BaseEmojiViewHolder;", "", "Lcom/discord/models/domain/emoji/Emoji;", "emojis", "", "maxEmojisToShow", "Lcom/discord/widgets/guilds/profile/EmojiItem;", "getEmojiItems", "(Ljava/util/List;I)Ljava/util/List;", "", "setData", "(Ljava/util/List;I)V", "getItemCount", "()I", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/widgets/guilds/profile/BaseEmojiViewHolder;", "holder", "onBindViewHolder", "(Lcom/discord/widgets/guilds/profile/BaseEmojiViewHolder;I)V", "data", "Ljava/util/List;", "Lkotlin/Function0;", "onClickEmoji", "Lkotlin/jvm/functions/Function0;", "getOnClickEmoji", "()Lkotlin/jvm/functions/Function0;", "setOnClickEmoji", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter extends RecyclerView.Adapter<WidgetGuildProfileSheetEmojisAdapter2> {
    private List<? extends WidgetGuildProfileSheetEmojisAdapter3> data = Collections2.emptyList();
    private Function0<Unit> onClickEmoji = WidgetGuildProfileSheetEmojisAdapter6.INSTANCE;

    /* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter$onBindViewHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildProfileSheetEmojisAdapter.this.getOnClickEmoji().invoke();
        }
    }

    private final List<WidgetGuildProfileSheetEmojisAdapter3> getEmojiItems(List<? extends Emoji> emojis, int maxEmojisToShow) {
        List listTake = _Collections.take(emojis, maxEmojisToShow);
        ArrayList arrayList = new ArrayList();
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetGuildProfileSheetEmojisAdapter3.EmojiData((Emoji) it.next()));
        }
        int size = emojis.size() - arrayList.size();
        if (size > 0) {
            if (arrayList.size() == maxEmojisToShow) {
                arrayList.remove(Collections2.getLastIndex(arrayList));
                size++;
            }
            arrayList.add(new WidgetGuildProfileSheetEmojisAdapter3.MoreEmoji(Math.min(size, 99)));
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.data.get(position).getType();
    }

    public final Function0<Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetGuildProfileSheetEmojisAdapter2) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends Emoji> emojis, int maxEmojisToShow) {
        Intrinsics3.checkNotNullParameter(emojis, "emojis");
        this.data = getEmojiItems(emojis, maxEmojisToShow);
        notifyDataSetChanged();
    }

    public final void setOnClickEmoji(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickEmoji = function0;
    }

    public void onBindViewHolder(WidgetGuildProfileSheetEmojisAdapter2 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.data.get(position));
        holder.itemView.setOnClickListener(new AnonymousClass1());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGuildProfileSheetEmojisAdapter2 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_profile_emoji_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
            WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding = new WidgetGuildProfileEmojiItemBinding(simpleDraweeView, simpleDraweeView);
            Intrinsics3.checkNotNullExpressionValue(widgetGuildProfileEmojiItemBinding, "WidgetGuildProfileEmojiI….context), parent, false)");
            return new WidgetGuildProfileSheetEmojisAdapter4(widgetGuildProfileEmojiItemBinding);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException(outline.q("invalid view type: ", viewType));
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_guild_profile_emoji_extra, parent, false);
        Objects.requireNonNull(viewInflate2, "rootView");
        WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding = new WidgetGuildProfileEmojiExtraBinding((TextView) viewInflate2);
        Intrinsics3.checkNotNullExpressionValue(widgetGuildProfileEmojiExtraBinding, "WidgetGuildProfileEmojiE….context), parent, false)");
        return new WidgetGuildProfileSheetEmojisAdapter5(widgetGuildProfileEmojiExtraBinding);
    }
}
