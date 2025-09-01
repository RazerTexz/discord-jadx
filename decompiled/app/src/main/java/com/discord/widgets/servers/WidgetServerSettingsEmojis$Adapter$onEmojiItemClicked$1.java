package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsEmojis.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "Lcom/discord/models/domain/emoji/ModelEmojiGuild;", "<anonymous parameter 1>", "", "invoke", "(Landroid/view/View;Lcom/discord/models/domain/emoji/ModelEmojiGuild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 extends Lambda implements Function2<View, ModelEmojiGuild, Unit> {
    public static final WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1 INSTANCE = new WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1();

    public WidgetServerSettingsEmojis$Adapter$onEmojiItemClicked$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ModelEmojiGuild modelEmojiGuild) {
        invoke2(view, modelEmojiGuild);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, ModelEmojiGuild modelEmojiGuild) {
        Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(modelEmojiGuild, "<anonymous parameter 1>");
    }
}
