package com.discord.utilities.stateful;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: StatefulViews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()Z", "com/discord/utilities/stateful/StatefulViews$setupUnsavedChangesConfirmation$onBackPressedHandler$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.stateful.StatefulViews$setupUnsavedChangesConfirmation$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StatefulViews5 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatefulViews5(StatefulViews statefulViews) {
        super(0);
        this.this$0 = statefulViews;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StatefulViews.access$hasAnythingChanged(this.this$0);
    }
}
