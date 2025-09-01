package b.i.a.c.b3.r;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.o.f;

/* compiled from: SsaDialogueFormat.java */
/* renamed from: b.i.a.c.b3.r.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class SsaDialogueFormat {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f875b;
    public final int c;
    public final int d;
    public final int e;

    public SsaDialogueFormat(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.f875b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SsaDialogueFormat a(String str) {
        char c;
        AnimatableValueParser.j(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String strU1 = f.u1(strArrSplit[i5].trim());
            strU1.hashCode();
            switch (strU1.hashCode()) {
                case 100571:
                    if (strU1.equals("end")) {
                        c = 0;
                        break;
                    } else {
                        c = 65535;
                        break;
                    }
                case 3556653:
                    if (strU1.equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                        c = 1;
                        break;
                    }
                    break;
                case 109757538:
                    if (strU1.equals("start")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109780401:
                    if (strU1.equals("style")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i2 = i5;
            } else if (c == 1) {
                i4 = i5;
            } else if (c == 2) {
                i = i5;
            } else if (c == 3) {
                i3 = i5;
            }
        }
        if (i == -1 || i2 == -1 || i4 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i, i2, i3, i4, strArrSplit.length);
    }
}
