package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilder;
import b.f.g.e.v;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DraweeSpanStringBuilderExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\u001aS\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "Landroid/content/Context;", "context", "", "avatarUrl", "", "animateAvatar", "", "avatarSizePx", "roundingOverlayColor", "", "spaceCharacter", "setAvatar", "(Lcom/facebook/drawee/span/DraweeSpanStringBuilder;Landroid/content/Context;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Character;)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class DraweeSpanStringBuilderExtensions {
    /* JADX WARN: Type inference failed for: r0v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public static final DraweeSpanStringBuilder setAvatar(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, @ColorInt Integer num2, Character ch) throws NumberFormatException {
        Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, "$this$setAvatar");
        Intrinsics3.checkNotNullParameter(context, "context");
        if (str != null) {
            int length = draweeSpanStringBuilder.length();
            draweeSpanStringBuilder.append("#");
            draweeSpanStringBuilder.append((CharSequence) String.valueOf(ch));
            int iIntValue = num != null ? num.intValue() : DimenUtils.dpToPixels(16);
            ?? A = MGImages.getImageRequest(str, IconUtils.getMediaProxySize(iIntValue), IconUtils.getMediaProxySize(iIntValue), true).a();
            PipelineDraweeControllerBuilder pipelineDraweeControllerBuilderA = Fresco.a();
            pipelineDraweeControllerBuilderA.h = A;
            pipelineDraweeControllerBuilderA.m = z2;
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.f523b = true;
            roundingParams.a = 1;
            if (num2 != null) {
                int iIntValue2 = num2.intValue();
                Intrinsics3.checkNotNullExpressionValue(roundingParams, "roundingParams");
                roundingParams.b(iIntValue2);
            }
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
            genericDraweeHierarchyBuilder.f = ContextCompat.getDrawable(context, R.drawable.asset_default_avatar_32dp);
            genericDraweeHierarchyBuilder.r = roundingParams;
            ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
            genericDraweeHierarchyBuilder.n = v.l;
            draweeSpanStringBuilder.c(context, genericDraweeHierarchyBuilder.a(), pipelineDraweeControllerBuilderA.a(), length, length, iIntValue, iIntValue, false, 2);
        }
        return draweeSpanStringBuilder;
    }

    public static /* synthetic */ DraweeSpanStringBuilder setAvatar$default(DraweeSpanStringBuilder draweeSpanStringBuilder, Context context, String str, boolean z2, Integer num, Integer num2, Character ch, int i, Object obj) {
        return setAvatar(draweeSpanStringBuilder, context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num, (i & 16) == 0 ? num2 : null, (i & 32) != 0 ? ' ' : ch);
    }
}
