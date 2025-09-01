package com.google.firebase.appindexing;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public class FirebaseAppIndexingTooManyArgumentsException extends FirebaseAppIndexingException {
    public FirebaseAppIndexingTooManyArgumentsException() {
        super("Too many Indexables provided. Try splitting them in batches.");
    }

    public FirebaseAppIndexingTooManyArgumentsException(@NonNull String str) {
        super(str);
    }
}
