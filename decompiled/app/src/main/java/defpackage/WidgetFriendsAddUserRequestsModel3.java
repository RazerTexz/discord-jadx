package defpackage;

import kotlin.jvm.functions.Function2;
import rx.functions.Func2;

/* compiled from: WidgetFriendsAddUserRequestsModel.kt */
/* renamed from: w, reason: use source file name */
/* loaded from: classes3.dex */
public final class WidgetFriendsAddUserRequestsModel3 implements Func2 {
    public final /* synthetic */ Function2 j;

    public WidgetFriendsAddUserRequestsModel3(Function2 function2) {
        this.j = function2;
    }

    @Override // rx.functions.Func2
    public final /* synthetic */ Object call(Object obj, Object obj2) {
        return this.j.invoke(obj, obj2);
    }
}
