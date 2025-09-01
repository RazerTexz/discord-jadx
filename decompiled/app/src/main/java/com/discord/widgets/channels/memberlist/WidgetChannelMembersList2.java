package com.discord.widgets.channels.memberlist;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelMembersList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "invoke", "()Landroidx/recyclerview/widget/RecyclerView;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$recycler$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersList2 extends Lambda implements Function0<RecyclerView> {
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList2(WidgetChannelMembersList widgetChannelMembersList) {
        super(0);
        this.this$0 = widgetChannelMembersList;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RecyclerView invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RecyclerView invoke() {
        View view = this.this$0.getView();
        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return (RecyclerView) view;
    }
}
