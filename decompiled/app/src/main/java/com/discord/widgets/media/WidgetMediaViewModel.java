package com.discord.widgets.media;

import b.a.d.AppViewModel;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: WidgetMediaViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/media/WidgetMediaViewModel;", "Lb/a/d/d0;", "", "", "isPlaying", "Z", "()Z", "setPlaying", "(Z)V", "showCoverFrame", "getShowCoverFrame", "setShowCoverFrame", "", "currentPlayerPositionMs", "J", "getCurrentPlayerPositionMs", "()J", "setCurrentPlayerPositionMs", "(J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMediaViewModel extends AppViewModel<Unit> {
    private long currentPlayerPositionMs;
    private boolean isPlaying;
    private boolean showCoverFrame;

    public WidgetMediaViewModel() {
        super(null, 1, null);
        this.isPlaying = true;
        this.showCoverFrame = true;
    }

    public final long getCurrentPlayerPositionMs() {
        return this.currentPlayerPositionMs;
    }

    public final boolean getShowCoverFrame() {
        return this.showCoverFrame;
    }

    /* renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void setCurrentPlayerPositionMs(long j) {
        this.currentPlayerPositionMs = j;
    }

    public final void setPlaying(boolean z2) {
        this.isPlaying = z2;
    }

    public final void setShowCoverFrame(boolean z2) {
        this.showCoverFrame = z2;
    }
}
