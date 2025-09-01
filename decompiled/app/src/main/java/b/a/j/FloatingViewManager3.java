package b.a.j;

import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* compiled from: FloatingViewManager.kt */
/* renamed from: b.a.j.e, reason: use source file name */
/* loaded from: classes.dex */
public final class FloatingViewManager3<T> implements Action1<Throwable> {
    public final /* synthetic */ FloatingViewManager j;

    public FloatingViewManager3(FloatingViewManager floatingViewManager) {
        this.j = floatingViewManager;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.c, "error while subscribing to componentPausedObservable for hiding floating view", th, null, 4, null);
    }
}
