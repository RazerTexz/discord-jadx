package com.google.zxing;

/* loaded from: classes3.dex */
public final class ChecksumException extends ReaderException {
    public static final ChecksumException l;

    static {
        ChecksumException checksumException = new ChecksumException();
        l = checksumException;
        checksumException.setStackTrace(ReaderException.k);
    }

    private ChecksumException() {
    }

    public static ChecksumException a() {
        return ReaderException.j ? new ChecksumException() : l;
    }
}
