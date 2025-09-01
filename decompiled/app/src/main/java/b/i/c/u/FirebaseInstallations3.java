package b.i.c.u;

import b.i.c.FirebaseApp2;
import b.i.c.u.o.AutoValue_PersistedInstallationEntry;
import b.i.c.u.o.PersistedInstallation;
import b.i.c.u.o.PersistedInstallationEntry;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.IOException;
import java.util.Objects;

/* compiled from: FirebaseInstallations.java */
/* renamed from: b.i.c.u.e, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class FirebaseInstallations3 implements Runnable {
    public final FirebaseInstallations4 j;
    public final boolean k;

    public FirebaseInstallations3(FirebaseInstallations4 firebaseInstallations4, boolean z2) {
        this.j = firebaseInstallations4;
        this.k = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        CrossProcessLock crossProcessLockA;
        PersistedInstallationEntry persistedInstallationEntryB;
        PersistedInstallationEntry persistedInstallationEntryJ;
        FirebaseInstallations4 firebaseInstallations4 = this.j;
        boolean z2 = this.k;
        Object obj = FirebaseInstallations4.a;
        Objects.requireNonNull(firebaseInstallations4);
        Object obj2 = FirebaseInstallations4.a;
        synchronized (obj2) {
            FirebaseApp2 firebaseApp2 = firebaseInstallations4.c;
            firebaseApp2.a();
            crossProcessLockA = CrossProcessLock.a(firebaseApp2.d, "generatefid.lock");
            try {
                persistedInstallationEntryB = firebaseInstallations4.e.b();
            } finally {
                if (crossProcessLockA != null) {
                    crossProcessLockA.b();
                }
            }
        }
        try {
            if (persistedInstallationEntryB.h()) {
                persistedInstallationEntryJ = firebaseInstallations4.j(persistedInstallationEntryB);
            } else {
                if (persistedInstallationEntryB.f() == PersistedInstallation.a.UNREGISTERED) {
                    persistedInstallationEntryJ = firebaseInstallations4.j(persistedInstallationEntryB);
                } else if (!z2 && !firebaseInstallations4.f.d(persistedInstallationEntryB)) {
                    return;
                } else {
                    persistedInstallationEntryJ = firebaseInstallations4.c(persistedInstallationEntryB);
                }
            }
            synchronized (obj2) {
                FirebaseApp2 firebaseApp22 = firebaseInstallations4.c;
                firebaseApp22.a();
                crossProcessLockA = CrossProcessLock.a(firebaseApp22.d, "generatefid.lock");
                try {
                    firebaseInstallations4.e.a(persistedInstallationEntryJ);
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                } finally {
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                }
            }
            if (persistedInstallationEntryJ.j()) {
                String str = ((AutoValue_PersistedInstallationEntry) persistedInstallationEntryJ).f1784b;
                synchronized (firebaseInstallations4) {
                    firebaseInstallations4.l = str;
                }
            }
            if (persistedInstallationEntryJ.h()) {
                firebaseInstallations4.k(new FirebaseInstallationsException(FirebaseInstallationsException.a.BAD_CONFIG));
            } else if (persistedInstallationEntryJ.i()) {
                firebaseInstallations4.k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                firebaseInstallations4.l(persistedInstallationEntryJ);
            }
        } catch (FirebaseInstallationsException e) {
            firebaseInstallations4.k(e);
        }
    }
}
