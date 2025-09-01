package com.discord.widgets.guilds.profile;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/profile/MoreEmojiViewHolder;", "Lcom/discord/widgets/guilds/profile/BaseEmojiViewHolder;", "Lcom/discord/widgets/guilds/profile/EmojiItem;", "data", "", "bind", "(Lcom/discord/widgets/guilds/profile/EmojiItem;)V", "Lcom/discord/databinding/WidgetGuildProfileEmojiExtraBinding;", "binding", "Lcom/discord/databinding/WidgetGuildProfileEmojiExtraBinding;", "<init>", "(Lcom/discord/databinding/WidgetGuildProfileEmojiExtraBinding;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.profile.MoreEmojiViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter5 extends WidgetGuildProfileSheetEmojisAdapter2 {
    private final WidgetGuildProfileEmojiExtraBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildProfileSheetEmojisAdapter5(WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildProfileEmojiExtraBinding, "binding");
        TextView textView = widgetGuildProfileEmojiExtraBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = widgetGuildProfileEmojiExtraBinding;
    }

    @Override // com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter2
    public void bind(WidgetGuildProfileSheetEmojisAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        TextView textView = this.binding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(FormatUtils.i(resources, R.string.extra_emoji_count, new Object[]{String.valueOf(((WidgetGuildProfileSheetEmojisAdapter3.MoreEmoji) data).getExtraEmojiCount())}, null, 4));
    }
}
