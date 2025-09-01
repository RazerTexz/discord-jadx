package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetChatInputEmojiAutocompleteUpsellItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.views.PileView;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiAutocompleteUpsellViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/input/autocomplete/adapter/EmojiAutocompleteUpsellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/discord/widgets/chat/input/autocomplete/EmojiUpsellPlaceholder;", "emojiUpsellPlaceholder", "", "bind", "(Lcom/discord/widgets/chat/input/autocomplete/EmojiUpsellPlaceholder;)V", "Lkotlin/Function1;", "Lcom/discord/widgets/chat/input/autocomplete/Autocompletable;", "onItemSelected", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/databinding/WidgetChatInputEmojiAutocompleteUpsellItemBinding;", "binding", "Lcom/discord/databinding/WidgetChatInputEmojiAutocompleteUpsellItemBinding;", "<init>", "(Lcom/discord/databinding/WidgetChatInputEmojiAutocompleteUpsellItemBinding;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder extends RecyclerView.ViewHolder {
    private final WidgetChatInputEmojiAutocompleteUpsellItemBinding binding;
    private final Function1<Autocompletable, Unit> onItemSelected;

    /* compiled from: EmojiAutocompleteUpsellViewHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.autocomplete.adapter.EmojiAutocompleteUpsellViewHolder$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder;

        public AnonymousClass1(EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
            this.$emojiUpsellPlaceholder = emojiUpsellPlaceholder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EmojiAutocompleteUpsellViewHolder.access$getOnItemSelected$p(EmojiAutocompleteUpsellViewHolder.this).invoke(this.$emojiUpsellPlaceholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiAutocompleteUpsellViewHolder(WidgetChatInputEmojiAutocompleteUpsellItemBinding widgetChatInputEmojiAutocompleteUpsellItemBinding, Function1<? super Autocompletable, Unit> function1) {
        super(widgetChatInputEmojiAutocompleteUpsellItemBinding.a);
        Intrinsics3.checkNotNullParameter(widgetChatInputEmojiAutocompleteUpsellItemBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onItemSelected");
        this.binding = widgetChatInputEmojiAutocompleteUpsellItemBinding;
        this.onItemSelected = function1;
    }

    public static final /* synthetic */ WidgetChatInputEmojiAutocompleteUpsellItemBinding access$getBinding$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.binding;
    }

    public static final /* synthetic */ Function1 access$getOnItemSelected$p(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder) {
        return emojiAutocompleteUpsellViewHolder.onItemSelected;
    }

    public final void bind(EmojiUpsellPlaceholder emojiUpsellPlaceholder) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(emojiUpsellPlaceholder, "emojiUpsellPlaceholder");
        int lockedTotal = emojiUpsellPlaceholder.getLockedTotal();
        LinearLayout linearLayout = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        Resources resources = linearLayout.getResources();
        String string = resources.getString(R.string.autocomplete_emoji_upsell);
        Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(R.st…utocomplete_emoji_upsell)");
        String quantityString = resources.getQuantityString(R.plurals.autocomplete_emoji_upsell_count, lockedTotal);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…moji_upsell_count, count)");
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatInputEmojiUpsellText");
        FormatUtils.o(textView, string, new Object[]{FormatUtils.l(quantityString, new Object[]{Integer.valueOf(lockedTotal)}, null, 2)}, null, 4);
        List<Emoji> lockedFirstThree = emojiUpsellPlaceholder.getLockedFirstThree();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(lockedFirstThree, 10));
        Iterator<T> it = lockedFirstThree.iterator();
        while (it.hasNext()) {
            arrayList.add(new PileView.c(new EmojiAutocompleteUpsellViewHolder2((Emoji) it.next(), this, emojiUpsellPlaceholder), null));
        }
        this.binding.f2306b.setItems(arrayList);
        this.binding.a.setOnClickListener(new AnonymousClass1(emojiUpsellPlaceholder));
    }
}
