package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.R;
import com.discord.databinding.ViewChatListActionsEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter2;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/actions/EmojiViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/chat/list/actions/WidgetChatListActionsEmojisAdapter;", "Lcom/discord/widgets/chat/list/actions/EmojiItem;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/widgets/chat/list/actions/EmojiItem;)V", "Lcom/discord/databinding/ViewChatListActionsEmojiItemBinding;", "binding", "Lcom/discord/databinding/ViewChatListActionsEmojiItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/chat/list/actions/WidgetChatListActionsEmojisAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.actions.EmojiViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter3 extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, WidgetChatListActionsEmojisAdapter2> {
    private final ViewChatListActionsEmojiItemBinding binding;

    /* compiled from: WidgetChatListActionsEmojisAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.actions.EmojiViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatListActionsEmojisAdapter2 $data;

        public AnonymousClass1(WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
            this.$data = widgetChatListActionsEmojisAdapter2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActionsEmojisAdapter3.access$getAdapter$p(WidgetChatListActionsEmojisAdapter3.this).getOnClickEmoji().invoke(((WidgetChatListActionsEmojisAdapter2.EmojiData) this.$data).getEmoji());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter3(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R.layout.view_chat_list_actions_emoji_item, widgetChatListActionsEmojisAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        ViewChatListActionsEmojiItemBinding viewChatListActionsEmojiItemBinding = new ViewChatListActionsEmojiItemBinding(simpleDraweeView, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(viewChatListActionsEmojiItemBinding, "ViewChatListActionsEmojiItemBinding.bind(itemView)");
        this.binding = viewChatListActionsEmojiItemBinding;
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(WidgetChatListActionsEmojisAdapter3 widgetChatListActionsEmojisAdapter3) {
        return (WidgetChatListActionsEmojisAdapter) widgetChatListActionsEmojisAdapter3.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
        onConfigure2(i, widgetChatListActionsEmojisAdapter2);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatListActionsEmojisAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        WidgetChatListActionsEmojisAdapter2.EmojiData emojiData = (WidgetChatListActionsEmojisAdapter2.EmojiData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f2178b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiIv");
        int i = simpleDraweeView.getLayoutParams().width;
        SimpleDraweeView simpleDraweeView2 = this.binding.f2178b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiIv");
        int paddingStart = i - simpleDraweeView2.getPaddingStart();
        SimpleDraweeView simpleDraweeView3 = this.binding.f2178b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiIv");
        int mediaProxySize = IconUtils.getMediaProxySize(DimenUtils.pixelsToDp(paddingStart - simpleDraweeView3.getPaddingEnd()) * 2);
        this.itemView.setOnClickListener(new AnonymousClass1(data));
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        view.setContentDescription(emojiData.getEmoji().getFirstName());
        SimpleDraweeView simpleDraweeView4 = this.binding.f2178b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiIv");
        Emoji emoji = emojiData.getEmoji();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        MGImages.setImage$default(simpleDraweeView4, emoji.getImageUri(true, mediaProxySize, view2.getContext()), 0, 0, false, null, null, 124, null);
    }
}
