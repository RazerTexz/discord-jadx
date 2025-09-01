package com.discord.widgets.chat.input.applicationcommands;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.discord.models.commands.ApplicationCommandOption;
import kotlin.Metadata;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "run", "()V", "com/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter$highlightOption$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedApplicationCommandAdapter$highlightOption$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter6 implements Runnable {
    public final /* synthetic */ ApplicationCommandOption $commandOption$inlined;
    public final /* synthetic */ int $position;
    public final /* synthetic */ SelectedApplicationCommandAdapter this$0;

    public SelectedApplicationCommandAdapter6(int i, SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, ApplicationCommandOption applicationCommandOption) {
        this.$position = i;
        this.this$0 = selectedApplicationCommandAdapter;
        this.$commandOption$inlined = applicationCommandOption;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$position;
        if (i == 1) {
            i = 0;
        }
        SelectedApplicationCommandAdapter.access$getScroller$p(this.this$0).setTargetPosition(i);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.this$0.getRecycler().getLayoutManager();
        if (linearLayoutManager != null) {
            linearLayoutManager.startSmoothScroll(SelectedApplicationCommandAdapter.access$getScroller$p(this.this$0));
        }
    }
}
