package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import b.a.i.ViewLoadingButtonBinding;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: LoadingButton.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\u00042\b\b\u0001\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/discord/views/LoadingButton;", "Landroid/widget/FrameLayout;", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "", "setProgressBarColor", "(I)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setText", "(Ljava/lang/CharSequence;)V", "", "isLoading", "setIsLoading", "(Z)V", "visible", "setIconVisibility", "enabled", "setEnabled", "colorInt", "setBackgroundColor", "Landroid/graphics/drawable/Drawable;", "m", "Landroid/graphics/drawable/Drawable;", "buttonIcon", "", "k", "F", "disabledAlpha", "Lb/a/i/n2;", "j", "Lb/a/i/n2;", "binding", "l", "Ljava/lang/CharSequence;", "buttonText", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class LoadingButton extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewLoadingButtonBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public float disabledAlpha;

    /* renamed from: l, reason: from kotlin metadata */
    public CharSequence buttonText;

    /* renamed from: m, reason: from kotlin metadata */
    public Drawable buttonIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132 A[Catch: all -> 0x014f, TryCatch #0 {all -> 0x014f, blocks: (B:9:0x0052, B:11:0x0063, B:12:0x0066, B:15:0x006e, B:16:0x0074, B:18:0x0081, B:19:0x0084, B:21:0x00d2, B:22:0x00d8, B:24:0x00e1, B:25:0x00e7, B:44:0x0125, B:46:0x0132, B:47:0x0135, B:51:0x0148, B:50:0x0146, B:28:0x00f2, B:29:0x00f6, B:31:0x00fa, B:34:0x0105, B:37:0x010f, B:40:0x011a), top: B:59:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146 A[Catch: all -> 0x014f, TryCatch #0 {all -> 0x014f, blocks: (B:9:0x0052, B:11:0x0063, B:12:0x0066, B:15:0x006e, B:16:0x0074, B:18:0x0081, B:19:0x0084, B:21:0x00d2, B:22:0x00d8, B:24:0x00e1, B:25:0x00e7, B:44:0x0125, B:46:0x0132, B:47:0x0135, B:51:0x0148, B:50:0x0146, B:28:0x00f2, B:29:0x00f6, B:31:0x00fa, B:34:0x0105, B:37:0x010f, B:40:0x011a), top: B:59:0x0052 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LoadingButton(Context context, AttributeSet attributeSet) {
        int color;
        super(context, attributeSet, 0);
        int i = 4;
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_loading_button, this);
        int i2 = R.id.loading_button_button;
        MaterialButton materialButton = (MaterialButton) findViewById(R.id.loading_button_button);
        if (materialButton != null) {
            i2 = R.id.loading_button_progress;
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading_button_progress);
            if (progressBar != null) {
                ViewLoadingButtonBinding viewLoadingButtonBinding = new ViewLoadingButtonBinding(this, materialButton, progressBar);
                Intrinsics3.checkNotNullExpressionValue(viewLoadingButtonBinding, "ViewLoadingButtonBinding…ater.from(context), this)");
                this.binding = viewLoadingButtonBinding;
                this.disabledAlpha = 0.2f;
                setClickable(true);
                setFocusable(true);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.LoadingButton, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.LoadingButton, 0, 0)");
                    try {
                        String string = typedArrayObtainStyledAttributes.getString(8);
                        setText(string);
                        this.buttonText = string;
                        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(9);
                        if (colorStateList != null) {
                            materialButton.setTextColor(colorStateList);
                        }
                        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(0);
                        if (colorStateList2 != null) {
                            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setBackgroundTintList(colorStateList2);
                        }
                        float dimension = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
                        if (dimension > 0) {
                            materialButton.setTextSize(0, dimension);
                        }
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, materialButton.getPaddingTop());
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingLeft = materialButton.getPaddingLeft();
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingRight = materialButton.getPaddingRight();
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        materialButton.setPadding(paddingLeft, dimensionPixelSize, paddingRight, materialButton.getPaddingBottom());
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, materialButton.getPaddingBottom());
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingLeft2 = materialButton.getPaddingLeft();
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        int paddingTop = materialButton.getPaddingTop();
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        materialButton.setPadding(paddingLeft2, paddingTop, materialButton.getPaddingRight(), dimensionPixelSize2);
                        if (typedArrayObtainStyledAttributes.getBoolean(1, false)) {
                            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setStateListAnimator(null);
                        }
                        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(3);
                        this.buttonIcon = drawable;
                        if (drawable != null) {
                            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                            materialButton.setIcon(drawable);
                        }
                        String string2 = typedArrayObtainStyledAttributes.getString(4);
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
                        if (string2 != null) {
                            switch (string2.hashCode()) {
                                case -1417863058:
                                    if (string2.equals("textEnd")) {
                                        break;
                                    }
                                    break;
                                case -1048657099:
                                    if (string2.equals("textStart")) {
                                        i = 2;
                                        break;
                                    }
                                    break;
                                case 100571:
                                    if (string2.equals("end")) {
                                        i = 3;
                                        break;
                                    }
                                    break;
                                case 109757538:
                                    if (string2.equals("start")) {
                                        i = 1;
                                        break;
                                    }
                                    break;
                            }
                            materialButton.setIconGravity(i);
                            color = typedArrayObtainStyledAttributes.getColor(7, Integer.MAX_VALUE);
                            if (color != Integer.MAX_VALUE) {
                                setProgressBarColor(color);
                            }
                            this.disabledAlpha = typedArrayObtainStyledAttributes.getFloat(2, this.disabledAlpha);
                            setAlpha(!isEnabled() ? 1.0f : this.disabledAlpha);
                            return;
                        }
                        i = 0;
                        materialButton.setIconGravity(i);
                        color = typedArrayObtainStyledAttributes.getColor(7, Integer.MAX_VALUE);
                        if (color != Integer.MAX_VALUE) {
                        }
                        this.disabledAlpha = typedArrayObtainStyledAttributes.getFloat(2, this.disabledAlpha);
                        setAlpha(!isEnabled() ? 1.0f : this.disabledAlpha);
                        return;
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }

    private final void setProgressBarColor(@ColorInt int color) {
        ProgressBar progressBar = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
        progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int colorInt) {
        MaterialButton materialButton = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(colorInt));
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        MaterialButton materialButton = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        materialButton.setEnabled(enabled);
        setAlpha(isEnabled() ? 1.0f : this.disabledAlpha);
    }

    public final void setIconVisibility(boolean visible) {
        if (visible) {
            MaterialButton materialButton = this.binding.f166b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
            materialButton.setIcon(this.buttonIcon);
        } else {
            MaterialButton materialButton2 = this.binding.f166b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.loadingButtonButton");
            materialButton2.setIcon(null);
        }
    }

    public final void setIsLoading(boolean isLoading) {
        if (!isLoading) {
            setClickable(true);
            MaterialButton materialButton = this.binding.f166b;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
            materialButton.setText(this.buttonText);
            MaterialButton materialButton2 = this.binding.f166b;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.loadingButtonButton");
            materialButton2.setIcon(this.buttonIcon);
            ProgressBar progressBar = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
            progressBar.setVisibility(8);
            return;
        }
        setClickable(false);
        MaterialButton materialButton3 = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.loadingButtonButton");
        this.buttonText = materialButton3.getText().toString();
        MaterialButton materialButton4 = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.loadingButtonButton");
        materialButton4.setText((CharSequence) null);
        MaterialButton materialButton5 = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.loadingButtonButton");
        materialButton5.setIcon(null);
        ProgressBar progressBar2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.loadingButtonProgress");
        progressBar2.setVisibility(0);
    }

    public final void setText(CharSequence text) {
        this.buttonText = text;
        MaterialButton materialButton = this.binding.f166b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.loadingButtonButton");
        ProgressBar progressBar = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingButtonProgress");
        if (progressBar.getVisibility() == 0) {
            text = null;
        }
        materialButton.setText(text);
    }
}
