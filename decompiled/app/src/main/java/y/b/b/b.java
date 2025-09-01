package y.b.b;

import androidx.core.widget.ContentLoadingProgressBar;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ContentLoadingProgressBar j;

    public /* synthetic */ b(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.j = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContentLoadingProgressBar.a(this.j);
    }
}
