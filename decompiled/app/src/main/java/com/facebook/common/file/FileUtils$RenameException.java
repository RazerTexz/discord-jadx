package com.facebook.common.file;

import java.io.IOException;

/* loaded from: classes.dex */
public class FileUtils$RenameException extends IOException {
    public FileUtils$RenameException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
