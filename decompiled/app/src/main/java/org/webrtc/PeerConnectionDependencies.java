package org.webrtc;

import androidx.annotation.Nullable;
import org.webrtc.PeerConnection;

/* loaded from: classes3.dex */
public final class PeerConnectionDependencies {
    private final PeerConnection.Observer observer;
    private final SSLCertificateVerifier sslCertificateVerifier;

    public static class Builder {
        private PeerConnection.Observer observer;
        private SSLCertificateVerifier sslCertificateVerifier;

        public /* synthetic */ Builder(PeerConnection.Observer observer, AnonymousClass1 anonymousClass1) {
            this(observer);
        }

        public PeerConnectionDependencies createPeerConnectionDependencies() {
            return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier, null);
        }

        public Builder setSSLCertificateVerifier(SSLCertificateVerifier sSLCertificateVerifier) {
            this.sslCertificateVerifier = sSLCertificateVerifier;
            return this;
        }

        private Builder(PeerConnection.Observer observer) {
            this.observer = observer;
        }
    }

    public /* synthetic */ PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier, AnonymousClass1 anonymousClass1) {
        this(observer, sSLCertificateVerifier);
    }

    public static Builder builder(PeerConnection.Observer observer) {
        return new Builder(observer, null);
    }

    public PeerConnection.Observer getObserver() {
        return this.observer;
    }

    @Nullable
    public SSLCertificateVerifier getSSLCertificateVerifier() {
        return this.sslCertificateVerifier;
    }

    private PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        this.observer = observer;
        this.sslCertificateVerifier = sSLCertificateVerifier;
    }
}
