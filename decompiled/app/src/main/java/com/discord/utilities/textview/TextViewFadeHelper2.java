package com.discord.utilities.textview;

import android.view.View;
import kotlin.Metadata;

/* compiled from: TextViewFadeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "<anonymous parameter 4>", "<anonymous parameter 5>", "<anonymous parameter 6>", "<anonymous parameter 7>", "<anonymous parameter 8>", "", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "com/discord/utilities/textview/TextViewFadeHelper$registerFadeHelper$1$layoutListener$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.textview.TextViewFadeHelper$registerFadeHelper$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class TextViewFadeHelper2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ TextViewFadeHelper this$0;

    public TextViewFadeHelper2(TextViewFadeHelper textViewFadeHelper) {
        this.this$0 = textViewFadeHelper;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        TextViewFadeHelper.access$updateFade(this.this$0);
    }
}
