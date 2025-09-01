package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import b.a.i.VolumeSliderViewBinding;
import b.a.y.OnSeekBarChangeListenerAdapter;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: VolumeSliderView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/discord/views/calls/VolumeSliderView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function2;", "", "", "", "onVolumeChanged", "setOnVolumeChange", "(Lkotlin/jvm/functions/Function2;)V", "Lb/a/i/l4;", "j", "Lb/a/i/l4;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VolumeSliderView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final VolumeSliderViewBinding binding;

    /* compiled from: VolumeSliderView.kt */
    public static final class a extends OnSeekBarChangeListenerAdapter {
        public final /* synthetic */ Function2 a;

        public a(Function2 function2) {
            this.a = function2;
        }

        @Override // b.a.y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            this.a.invoke(Float.valueOf(i), Boolean.valueOf(z2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VolumeSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.volume_slider_view, this);
        int i = R.id.volume_slider_max_vol;
        ImageView imageView = (ImageView) findViewById(R.id.volume_slider_max_vol);
        if (imageView != null) {
            i = R.id.volume_slider_min_vol;
            ImageView imageView2 = (ImageView) findViewById(R.id.volume_slider_min_vol);
            if (imageView2 != null) {
                i = R.id.volume_slider_seek_bar;
                SeekBar seekBar = (SeekBar) findViewById(R.id.volume_slider_seek_bar);
                if (seekBar != null) {
                    VolumeSliderViewBinding volumeSliderViewBinding = new VolumeSliderViewBinding(this, imageView, imageView2, seekBar);
                    Intrinsics3.checkNotNullExpressionValue(volumeSliderViewBinding, "VolumeSliderViewBinding.…ater.from(context), this)");
                    this.binding = volumeSliderViewBinding;
                    if (attributeSet != null) {
                        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.VolumeSliderView, 0, 0);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.VolumeSliderView, 0, 0)");
                        int i2 = typedArrayObtainStyledAttributes.getInt(1, 100);
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
                        if (resourceId != -1) {
                            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.volumeSliderMinVol");
                            ColorCompat2.tintWithColor(imageView2, ColorCompat.getColor(getContext(), resourceId));
                            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.volumeSliderMaxVol");
                            ColorCompat2.tintWithColor(imageView, ColorCompat.getColor(getContext(), resourceId));
                        }
                        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
                        seekBar.setMax(i2);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onVolumeChanged) {
        Intrinsics3.checkNotNullParameter(onVolumeChanged, "onVolumeChanged");
        this.binding.d.setOnSeekBarChangeListener(new a(onVolumeChanged));
    }
}
