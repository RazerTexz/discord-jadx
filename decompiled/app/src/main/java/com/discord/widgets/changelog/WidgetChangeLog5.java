package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChangeLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.changelog.WidgetChangeLog$thumbnailControllerListener$1$onFinalImageSet$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeLog5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeLog4 this$0;

    public WidgetChangeLog5(WidgetChangeLog4 widgetChangeLog4) {
        this.this$0 = widgetChangeLog4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Animatable animatableC;
        WidgetChangeLog.access$hideVideoOverlay(this.this$0.this$0);
        SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0.this$0).f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogThumbnail");
        DraweeController controller = simpleDraweeView.getController();
        if (controller == null || (animatableC = controller.c()) == null) {
            return;
        }
        animatableC.start();
    }
}
