package b.f.j.e;

import b.f.d.e.FLog;
import b.f.j.g.NoOpCloseableReferenceLeakTracker;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/* compiled from: CloseableReferenceFactory.java */
/* renamed from: b.f.j.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class CloseableReferenceFactory {
    public final CloseableReference.c a;

    /* compiled from: CloseableReferenceFactory.java */
    /* renamed from: b.f.j.e.a$a */
    public class a implements CloseableReference.c {
        public final /* synthetic */ NoOpCloseableReferenceLeakTracker a;

        public a(CloseableReferenceFactory closeableReferenceFactory, NoOpCloseableReferenceLeakTracker noOpCloseableReferenceLeakTracker) {
            this.a = noOpCloseableReferenceLeakTracker;
        }

        @Override // com.facebook.common.references.CloseableReference.c
        public void a(SharedReference<Object> sharedReference, Throwable th) {
            String string;
            Objects.requireNonNull(this.a);
            Object objC = sharedReference.c();
            String name = objC != null ? objC.getClass().getName() : "<value is null>";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = name;
            if (th == null) {
                string = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            }
            objArr[3] = string;
            FLog.o("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.c
        public boolean b() {
            Objects.requireNonNull(this.a);
            return false;
        }
    }

    public CloseableReferenceFactory(NoOpCloseableReferenceLeakTracker noOpCloseableReferenceLeakTracker) {
        this.a = new a(this, noOpCloseableReferenceLeakTracker);
    }
}
