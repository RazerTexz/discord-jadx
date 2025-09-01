package com.discord.widgets.changelog;

import b.a.d.AppToast;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChangeLogParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.changelog.ChangeLogParser$parse$renderContext$1$onLongPressUrl$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChangeLogParser3 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ ChangeLogParser2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeLogParser3(ChangeLogParser2 changeLogParser2) {
        super(1);
        this.this$0 = changeLogParser2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        AppToast.c(this.this$0.$context, str, 0, 4);
    }
}
