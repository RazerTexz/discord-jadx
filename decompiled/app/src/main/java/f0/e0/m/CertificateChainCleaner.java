package f0.e0.m;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificateChainCleaner.kt */
/* renamed from: f0.e0.m.c, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CertificateChainCleaner {
    public abstract List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException;
}
