package com.discord.utilities.images;

import android.graphics.Bitmap;
import b.f.j.o.RoundAsCirclePostprocessor2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: RoundAsCirclePostProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/utilities/images/RoundAsCirclePostprocessor;", "Lb/f/j/o/a;", "Landroid/graphics/Bitmap;", "bitmap", "", "process", "(Landroid/graphics/Bitmap;)V", "", "imageUri", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.images.RoundAsCirclePostprocessor, reason: use source file name */
/* loaded from: classes2.dex */
public final class RoundAsCirclePostProcessor2 extends RoundAsCirclePostprocessor2 {
    private final String imageUri;

    public RoundAsCirclePostProcessor2(String str) {
        Intrinsics3.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
    }

    @Override // b.f.j.o.RoundAsCirclePostprocessor2, b.f.j.q.BasePostprocessor
    public void process(Bitmap bitmap) {
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (width < 2 || height < 2) {
            return;
        }
        super.process(bitmap);
    }
}
