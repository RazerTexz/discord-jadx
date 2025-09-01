package com.discord.widgets.guilds.profile;

import android.view.View;
import com.discord.databinding.WidgetGuildProfileEmojiItemBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/profile/EmojiViewHolder;", "Lcom/discord/widgets/guilds/profile/BaseEmojiViewHolder;", "Lcom/discord/widgets/guilds/profile/EmojiItem;", "data", "", "bind", "(Lcom/discord/widgets/guilds/profile/EmojiItem;)V", "Lcom/discord/databinding/WidgetGuildProfileEmojiItemBinding;", "binding", "Lcom/discord/databinding/WidgetGuildProfileEmojiItemBinding;", "<init>", "(Lcom/discord/databinding/WidgetGuildProfileEmojiItemBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.EmojiViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter4 extends WidgetGuildProfileSheetEmojisAdapter2 {
    private final WidgetGuildProfileEmojiItemBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildProfileSheetEmojisAdapter4(WidgetGuildProfileEmojiItemBinding widgetGuildProfileEmojiItemBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildProfileEmojiItemBinding, "binding");
        SimpleDraweeView simpleDraweeView = widgetGuildProfileEmojiItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.root");
        super(simpleDraweeView);
        this.binding = widgetGuildProfileEmojiItemBinding;
    }

    @Override // com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter2
    public void bind(WidgetGuildProfileSheetEmojisAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        SimpleDraweeView simpleDraweeView = this.binding.f2430b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetEmojiImageview");
        int mediaProxySize = IconUtils.getMediaProxySize(simpleDraweeView.getLayoutParams().width);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2430b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetEmojiImageview");
        Emoji emoji = ((WidgetGuildProfileSheetEmojisAdapter3.EmojiData) data).getEmoji();
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        MGImages.setImage$default(simpleDraweeView2, emoji.getImageUri(true, mediaProxySize, view.getContext()), 0, 0, false, null, null, 124, null);
    }
}
