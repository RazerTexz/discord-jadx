package b.i.c.x;

import android.content.Context;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;

/* compiled from: LibraryVersionComponent.java */
/* renamed from: b.i.c.x.f, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class LibraryVersionComponent implements ComponentFactory {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final LibraryVersionComponent2 f1805b;

    public LibraryVersionComponent(String str, LibraryVersionComponent2 libraryVersionComponent2) {
        this.a = str;
        this.f1805b = libraryVersionComponent2;
    }

    @Override // b.i.c.l.ComponentFactory
    public Object a(ComponentContainer componentContainer) {
        return new AutoValue_LibraryVersion(this.a, this.f1805b.a((Context) componentContainer.a(Context.class)));
    }
}
