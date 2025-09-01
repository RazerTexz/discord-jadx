package com.discord.widgets.channels.memberlist;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: PrivateChannelMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "p1", "p2", "", "invoke", "(Ljava/lang/String;Ljava/lang/String;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt$generateGroupDmMemberListItems$memberItems$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class PrivateChannelMemberListItemGenerator2 extends FunctionReferenceImpl implements Function2<String, String, Integer> {
    public static final PrivateChannelMemberListItemGenerator2 INSTANCE = new PrivateChannelMemberListItemGenerator2();

    public PrivateChannelMemberListItemGenerator2() {
        super(2, String.class, "compareTo", "compareTo(Ljava/lang/String;)I", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "p1");
        Intrinsics3.checkNotNullParameter(str2, "p2");
        return str.compareTo(str2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(String str, String str2) {
        return Integer.valueOf(invoke2(str, str2));
    }
}
