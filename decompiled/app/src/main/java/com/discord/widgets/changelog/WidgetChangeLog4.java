package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import b.f.g.c.BaseControllerListener;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetChangeLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J-\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/discord/widgets/changelog/WidgetChangeLog$thumbnailControllerListener$1", "Lb/f/g/c/c;", "", "", ModelAuditLogEntry.CHANGE_KEY_ID, "imageInfo", "Landroid/graphics/drawable/Animatable;", "animatable", "", "onFinalImageSet", "(Ljava/lang/String;Ljava/lang/Object;Landroid/graphics/drawable/Animatable;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.changelog.WidgetChangeLog$thumbnailControllerListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeLog4 extends BaseControllerListener<Object> {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog4(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id2, Object imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        try {
            SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0).i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
            int i = 0;
            if (!(animatable != null)) {
                i = 8;
            }
            simpleDraweeView.setVisibility(i);
            WidgetChangeLog.access$getBinding$p(this.this$0).i.setOnClickListener(new WidgetChangeLog5(this));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Failed to set changelog thumbnail image.", e, null, 4, null);
        }
    }
}
