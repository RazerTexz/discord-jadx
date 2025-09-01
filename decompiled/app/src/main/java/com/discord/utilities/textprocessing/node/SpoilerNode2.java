package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SpoilerNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "com/discord/utilities/textprocessing/node/SpoilerNode$createStyles$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.node.SpoilerNode$createStyles$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpoilerNode2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function1 $handler;
    public final /* synthetic */ SpoilerNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpoilerNode2(Function1 function1, SpoilerNode spoilerNode, Context context) {
        super(1);
        this.$handler = function1;
        this.this$0 = spoilerNode;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.$handler.invoke(this.this$0);
    }
}
