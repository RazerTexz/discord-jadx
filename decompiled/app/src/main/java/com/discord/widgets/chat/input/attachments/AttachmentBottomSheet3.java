package com.discord.widgets.chat.input.attachments;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: AttachmentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J#\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/discord/widgets/chat/input/attachments/AttachmentBottomSheet$draweeControllerListener$1", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "", ModelAuditLogEntry.CHANGE_KEY_ID, "", "callerContext", "", "onSubmit", "(Ljava/lang/String;Ljava/lang/Object;)V", "imageInfo", "Landroid/graphics/drawable/Animatable;", "animatable", "onFinalImageSet", "(Ljava/lang/String;Lcom/facebook/imagepipeline/image/ImageInfo;Landroid/graphics/drawable/Animatable;)V", "onIntermediateImageSet", "(Ljava/lang/String;Lcom/facebook/imagepipeline/image/ImageInfo;)V", "", "throwable", "onIntermediateImageFailed", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "onFailure", "onRelease", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.attachments.AttachmentBottomSheet$draweeControllerListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class AttachmentBottomSheet3 implements ControllerListener<ImageInfo> {
    public final /* synthetic */ AttachmentBottomSheet this$0;

    public AttachmentBottomSheet3(AttachmentBottomSheet attachmentBottomSheet) {
        this.this$0 = attachmentBottomSheet;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(String id2, Throwable throwable) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
        onFinalImageSet2(str, imageInfo, animatable);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(String id2, Throwable throwable) {
    }

    /* renamed from: onIntermediateImageSet, reason: avoid collision after fix types in other method */
    public void onIntermediateImageSet2(String id2, ImageInfo imageInfo) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onIntermediateImageSet(String str, ImageInfo imageInfo) {
        onIntermediateImageSet2(str, imageInfo);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(String id2) {
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(String id2, Object callerContext) {
    }

    /* renamed from: onFinalImageSet, reason: avoid collision after fix types in other method */
    public void onFinalImageSet2(String id2, ImageInfo imageInfo, Animatable animatable) {
        String string;
        this.this$0.setAttachmentImageInfo(imageInfo);
        SimpleDraweeView simpleDraweeView = AttachmentBottomSheet.access$getBinding$p(this.this$0).f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.attachmentPreview");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if ((imageInfo != null ? imageInfo.getWidth() : 0) > (imageInfo != null ? imageInfo.getHeight() : 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getWidth()) : null);
            sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
            sb.append(imageInfo != null ? Integer.valueOf(imageInfo.getHeight()) : null);
            string = sb.toString();
        } else {
            string = "1";
        }
        layoutParams2.dimensionRatio = string;
        simpleDraweeView.setLayoutParams(layoutParams2);
        this.this$0.updateSpoilerViewSize();
    }
}
