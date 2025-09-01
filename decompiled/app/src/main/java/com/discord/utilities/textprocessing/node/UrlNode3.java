package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.UrlNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: UrlNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/textprocessing/node/UrlNode$RenderContext;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textprocessing.node.UrlNode$render$style$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class UrlNode3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ UrlNode.RenderContext $renderContext;
    public final /* synthetic */ String $safeUrl;
    public final /* synthetic */ UrlNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode3(UrlNode urlNode, UrlNode.RenderContext renderContext, String str) {
        super(1);
        this.this$0 = urlNode;
        this.$renderContext = renderContext;
        this.$safeUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        Function3<Context, String, String, Unit> onClickUrl = this.$renderContext.getOnClickUrl();
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        onClickUrl.invoke(context, this.$safeUrl, UrlNode.access$getMask$p(this.this$0));
    }
}
