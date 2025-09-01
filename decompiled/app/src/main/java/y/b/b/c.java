package y.b.b;

import androidx.core.widget.ContentLoadingProgressBar;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar j;

    public /* synthetic */ c(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.j = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar = this.j;
        contentLoadingProgressBar.mPostedShow = false;
        if (contentLoadingProgressBar.mDismissed) {
            return;
        }
        contentLoadingProgressBar.mStartTime = System.currentTimeMillis();
        contentLoadingProgressBar.setVisibility(0);
    }
}
