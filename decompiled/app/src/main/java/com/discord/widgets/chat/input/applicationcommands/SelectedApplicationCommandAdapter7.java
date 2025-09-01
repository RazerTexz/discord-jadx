package com.discord.widgets.chat.input.applicationcommands;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter$scroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "", "getHorizontalSnapPreference", "()I", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter$scroller$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter7 extends LinearSmoothScroller {
    public final /* synthetic */ SelectedApplicationCommandAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedApplicationCommandAdapter7(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, Context context) {
        super(context);
        this.this$0 = selectedApplicationCommandAdapter;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int getHorizontalSnapPreference() {
        return -1;
    }
}
