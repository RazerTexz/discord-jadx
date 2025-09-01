package org.webrtc;

/* loaded from: classes3.dex */
public final class CryptoOptions {
    private final SFrame sframe;
    private final Srtp srtp;

    public static class Builder {
        private boolean enableAes128Sha1_32CryptoCipher;
        private boolean enableEncryptedRtpHeaderExtensions;
        private boolean enableGcmCryptoSuites;
        private boolean requireFrameEncryption;

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public CryptoOptions createCryptoOptions() {
            return new CryptoOptions(this.enableGcmCryptoSuites, this.enableAes128Sha1_32CryptoCipher, this.enableEncryptedRtpHeaderExtensions, this.requireFrameEncryption, null);
        }

        public Builder setEnableAes128Sha1_32CryptoCipher(boolean z2) {
            this.enableAes128Sha1_32CryptoCipher = z2;
            return this;
        }

        public Builder setEnableEncryptedRtpHeaderExtensions(boolean z2) {
            this.enableEncryptedRtpHeaderExtensions = z2;
            return this;
        }

        public Builder setEnableGcmCryptoSuites(boolean z2) {
            this.enableGcmCryptoSuites = z2;
            return this;
        }

        public Builder setRequireFrameEncryption(boolean z2) {
            this.requireFrameEncryption = z2;
            return this;
        }

        private Builder() {
        }
    }

    public final class SFrame {
        private final boolean requireFrameEncryption;

        public /* synthetic */ SFrame(CryptoOptions cryptoOptions, boolean z2, AnonymousClass1 anonymousClass1) {
            this(z2);
        }

        @CalledByNative("SFrame")
        public boolean getRequireFrameEncryption() {
            return this.requireFrameEncryption;
        }

        private SFrame(boolean z2) {
            this.requireFrameEncryption = z2;
        }
    }

    public final class Srtp {
        private final boolean enableAes128Sha1_32CryptoCipher;
        private final boolean enableEncryptedRtpHeaderExtensions;
        private final boolean enableGcmCryptoSuites;

        public /* synthetic */ Srtp(CryptoOptions cryptoOptions, boolean z2, boolean z3, boolean z4, AnonymousClass1 anonymousClass1) {
            this(z2, z3, z4);
        }

        @CalledByNative("Srtp")
        public boolean getEnableAes128Sha1_32CryptoCipher() {
            return this.enableAes128Sha1_32CryptoCipher;
        }

        @CalledByNative("Srtp")
        public boolean getEnableEncryptedRtpHeaderExtensions() {
            return this.enableEncryptedRtpHeaderExtensions;
        }

        @CalledByNative("Srtp")
        public boolean getEnableGcmCryptoSuites() {
            return this.enableGcmCryptoSuites;
        }

        private Srtp(boolean z2, boolean z3, boolean z4) {
            this.enableGcmCryptoSuites = z2;
            this.enableAes128Sha1_32CryptoCipher = z3;
            this.enableEncryptedRtpHeaderExtensions = z4;
        }
    }

    public /* synthetic */ CryptoOptions(boolean z2, boolean z3, boolean z4, boolean z5, AnonymousClass1 anonymousClass1) {
        this(z2, z3, z4, z5);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    @CalledByNative
    public SFrame getSFrame() {
        return this.sframe;
    }

    @CalledByNative
    public Srtp getSrtp() {
        return this.srtp;
    }

    private CryptoOptions(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.srtp = new Srtp(this, z2, z3, z4, null);
        this.sframe = new SFrame(this, z5, null);
    }
}
