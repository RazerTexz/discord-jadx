package y.a.b;

import androidx.browser.trusted.ConnectionHolder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ConnectionHolder a;

    public /* synthetic */ a(ConnectionHolder connectionHolder) {
        this.a = connectionHolder;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.a.a(completer);
    }
}
