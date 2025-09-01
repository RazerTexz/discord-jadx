package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: Persister.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\f\u001a\u00020\t\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\n¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<anonymous parameter 2>", "", "invoke", "(ILjava/lang/String;Ljava/lang/Exception;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.persister.Persister$Companion$logger$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Persister6 extends Lambda implements Function3<Integer, String, Exception, Unit> {
    public static final Persister6 INSTANCE = new Persister6();

    public Persister6() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Exception exc) {
        invoke(num.intValue(), str, exc);
        return Unit.a;
    }

    public final void invoke(int i, String str, Exception exc) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
    }
}
