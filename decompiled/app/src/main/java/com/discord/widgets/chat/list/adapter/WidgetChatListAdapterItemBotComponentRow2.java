package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.discord.models.botuikit.MessageComponent;
import com.discord.widgets.botuikit.views.ComponentView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: WidgetChatListAdapterItemBotComponentRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/ViewGroup;", "", "Lcom/discord/widgets/botuikit/views/ComponentView;", "Lcom/discord/models/botuikit/MessageComponent;", "views", "", "replaceViews", "(Landroid/view/ViewGroup;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBotComponentRowKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBotComponentRow2 {
    public static final void replaceViews(ViewGroup viewGroup, List<? extends ComponentView<? extends MessageComponent>> list) {
        Intrinsics3.checkNotNullParameter(viewGroup, "$this$replaceViews");
        Intrinsics3.checkNotNullParameter(list, "views");
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Object obj2 = (ComponentView) obj;
            if (i >= viewGroup.getChildCount()) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.view.View");
                viewGroup.addView((View) obj2, i);
            } else if (viewGroup.getChildAt(i) != obj2) {
                viewGroup.removeViewAt(i);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.view.View");
                viewGroup.addView((View) obj2, i);
            }
            i = i2;
        }
        if (list.size() < viewGroup.getChildCount()) {
            viewGroup.removeViews(list.size(), viewGroup.getChildCount() - list.size());
        }
    }
}
