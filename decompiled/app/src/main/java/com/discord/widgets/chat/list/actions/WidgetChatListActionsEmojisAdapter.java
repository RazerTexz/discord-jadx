package com.discord.widgets.chat.list.actions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/actions/WidgetChatListActionsEmojisAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/chat/list/actions/EmojiItem;", "", "Lcom/discord/models/domain/emoji/Emoji;", "emojis", "", "emojisToShow", "getEmojiItems", "(Ljava/util/List;I)Ljava/util/List;", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "", "setData", "(Ljava/util/List;I)V", "Lkotlin/Function0;", "onClickMoreEmojis", "Lkotlin/jvm/functions/Function0;", "getOnClickMoreEmojis", "()Lkotlin/jvm/functions/Function0;", "setOnClickMoreEmojis", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "onClickEmoji", "Lkotlin/jvm/functions/Function1;", "getOnClickEmoji", "()Lkotlin/jvm/functions/Function1;", "setOnClickEmoji", "(Lkotlin/jvm/functions/Function1;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter extends MGRecyclerAdapterSimple<WidgetChatListActionsEmojisAdapter2> {
    private Function1<? super Emoji, Unit> onClickEmoji;
    private Function0<Unit> onClickMoreEmojis;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickEmoji = WidgetChatListActionsEmojisAdapter5.INSTANCE;
        this.onClickMoreEmojis = WidgetChatListActionsEmojisAdapter6.INSTANCE;
    }

    private final List<WidgetChatListActionsEmojisAdapter2> getEmojiItems(List<? extends Emoji> emojis, int emojisToShow) {
        if (emojis.isEmpty() || emojisToShow <= 0) {
            return Collections2.emptyList();
        }
        List listTake = _Collections.take(emojis, emojisToShow - 1);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            arrayList.add(new WidgetChatListActionsEmojisAdapter2.EmojiData((Emoji) it.next()));
        }
        List<WidgetChatListActionsEmojisAdapter2> mutableList = _Collections.toMutableList((Collection) arrayList);
        mutableList.add(WidgetChatListActionsEmojisAdapter2.MoreEmoji.INSTANCE);
        return mutableList;
    }

    public final Function1<Emoji, Unit> getOnClickEmoji() {
        return this.onClickEmoji;
    }

    public final Function0<Unit> getOnClickMoreEmojis() {
        return this.onClickMoreEmojis;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends Emoji> emojis, int emojisToShow) {
        Intrinsics3.checkNotNullParameter(emojis, "emojis");
        setData(getEmojiItems(emojis, emojisToShow));
    }

    public final void setOnClickEmoji(Function1<? super Emoji, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClickEmoji = function1;
    }

    public final void setOnClickMoreEmojis(Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "<set-?>");
        this.onClickMoreEmojis = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, WidgetChatListActionsEmojisAdapter2> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetChatListActionsEmojisAdapter3(this);
        }
        if (viewType == 1) {
            return new WidgetChatListActionsEmojisAdapter4(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
