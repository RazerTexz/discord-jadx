package com.google.firebase.messaging;

import java.util.Locale;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* loaded from: classes3.dex */
public final class SendException extends Exception {
    private final int errorCode;

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SendException(String str) {
        super(str);
        int i = 1;
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            lowerCase.hashCode();
            switch (lowerCase) {
                case "service_not_available":
                    i = 3;
                    break;
                case "toomanymessages":
                    i = 4;
                    break;
                case "messagetoobig":
                    i = 2;
                    break;
            }
        } else {
            i = 0;
        }
        this.errorCode = i;
    }
}
