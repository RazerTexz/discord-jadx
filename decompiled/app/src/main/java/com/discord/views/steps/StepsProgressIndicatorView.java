package com.discord.views.steps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: StepsProgressIndicatorView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/discord/views/steps/StepsProgressIndicatorView;", "Landroid/widget/LinearLayout;", "", "totalStepCount", "", "setTotalStepCount", "(I)V", "currentStepIndex", "setCurrentStepIndex", "a", "()V", "j", "I", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StepsProgressIndicatorView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public int totalStepCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepsProgressIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        setOrientation(0);
    }

    public final void a() {
        removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i = this.totalStepCount;
        for (int i2 = 0; i2 < i; i2++) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.steps_progress_indicator_dot_view, (ViewGroup) this, false);
            addView(viewInflate);
            Objects.requireNonNull(viewInflate, "rootView");
        }
    }

    public final void setCurrentStepIndex(int currentStepIndex) {
        if (currentStepIndex >= this.totalStepCount) {
            Logger.d$default(AppLog.g, "Current step cannot be greater than the total step count", null, 2, null);
            return;
        }
        if (getChildCount() != this.totalStepCount) {
            a();
        }
        int i = this.totalStepCount;
        int i2 = 0;
        while (i2 < i) {
            View childAt = getChildAt(i2);
            if (!(childAt instanceof TextView)) {
                childAt = null;
            }
            TextView textView = (TextView) childAt;
            if (textView != null) {
                textView.setEnabled(i2 <= currentStepIndex);
                if (i2 == currentStepIndex) {
                    textView.setTextSize(12.0f);
                    textView.setText(String.valueOf(currentStepIndex + 1));
                    textView.setSelected(true);
                } else {
                    textView.setTextSize(0.0f);
                    textView.setText((CharSequence) null);
                    textView.setSelected(false);
                }
            }
            i2++;
        }
    }

    public final void setTotalStepCount(int totalStepCount) {
        this.totalStepCount = totalStepCount;
        a();
        setCurrentStepIndex(0);
    }
}
