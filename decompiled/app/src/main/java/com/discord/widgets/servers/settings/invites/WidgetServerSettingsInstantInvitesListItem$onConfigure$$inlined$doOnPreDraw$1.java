package com.discord.widgets.servers.settings.invites;

import android.view.View;
import com.discord.utilities.dimen.DimenUtils;
import kotlin.Metadata;

/* compiled from: View.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "<anonymous>", "()V", "androidx/core/view/ViewKt$doOnPreDraw$1"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1 implements Runnable {
    public final /* synthetic */ View $this_doOnPreDraw;

    public WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1(View view) {
        this.$this_doOnPreDraw = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.$this_doOnPreDraw;
        view.setMinimumWidth(DimenUtils.dpToPixels(4) + view.getWidth());
    }
}
