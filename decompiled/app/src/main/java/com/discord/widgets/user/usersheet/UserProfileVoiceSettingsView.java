package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.UserProfileVoiceSettingsViewBinding;
import com.discord.views.calls.VolumeSliderView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: UserProfileVoiceSettingsView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0010\u001a\u00020\u00042\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/user/usersheet/UserProfileVoiceSettingsView;", "Landroid/widget/LinearLayout;", "Lcom/discord/widgets/user/usersheet/UserProfileVoiceSettingsView$ViewState;", "viewState", "", "updateView", "(Lcom/discord/widgets/user/usersheet/UserProfileVoiceSettingsView$ViewState;)V", "Lkotlin/Function1;", "", "onChecked", "setOnMuteChecked", "(Lkotlin/jvm/functions/Function1;)V", "setOnDeafenChecked", "Lkotlin/Function2;", "", "onProgressChanged", "setOnVolumeChange", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/discord/databinding/UserProfileVoiceSettingsViewBinding;", "binding", "Lcom/discord/databinding/UserProfileVoiceSettingsViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class UserProfileVoiceSettingsView extends LinearLayout {
    private final UserProfileVoiceSettingsViewBinding binding;

    /* compiled from: UserProfileVoiceSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\n\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u000b\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/user/usersheet/UserProfileVoiceSettingsView$ViewState;", "", "", "component1", "()Z", "component2", "()Ljava/lang/Boolean;", "", "component3", "()Ljava/lang/Float;", "isMuted", "isDeafened", "outputVolume", "copy", "(ZLjava/lang/Boolean;Ljava/lang/Float;)Lcom/discord/widgets/user/usersheet/UserProfileVoiceSettingsView$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Float;", "getOutputVolume", "Ljava/lang/Boolean;", "<init>", "(ZLjava/lang/Boolean;Ljava/lang/Float;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final Boolean isDeafened;
        private final boolean isMuted;
        private final Float outputVolume;

        public ViewState(boolean z2, Boolean bool, Float f) {
            this.isMuted = z2;
            this.isDeafened = bool;
            this.outputVolume = f;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Boolean bool, Float f, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isMuted;
            }
            if ((i & 2) != 0) {
                bool = viewState.isDeafened;
            }
            if ((i & 4) != 0) {
                f = viewState.outputVolume;
            }
            return viewState.copy(z2, bool, f);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMuted() {
            return this.isMuted;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsDeafened() {
            return this.isDeafened;
        }

        /* renamed from: component3, reason: from getter */
        public final Float getOutputVolume() {
            return this.outputVolume;
        }

        public final ViewState copy(boolean isMuted, Boolean isDeafened, Float outputVolume) {
            return new ViewState(isMuted, isDeafened, outputVolume);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isMuted == viewState.isMuted && Intrinsics3.areEqual(this.isDeafened, viewState.isDeafened) && Intrinsics3.areEqual(this.outputVolume, viewState.outputVolume);
        }

        public final Float getOutputVolume() {
            return this.outputVolume;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z2 = this.isMuted;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Boolean bool = this.isDeafened;
            int iHashCode = (i + (bool != null ? bool.hashCode() : 0)) * 31;
            Float f = this.outputVolume;
            return iHashCode + (f != null ? f.hashCode() : 0);
        }

        public final Boolean isDeafened() {
            return this.isDeafened;
        }

        public final boolean isMuted() {
            return this.isMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isMuted=");
            sbU.append(this.isMuted);
            sbU.append(", isDeafened=");
            sbU.append(this.isDeafened);
            sbU.append(", outputVolume=");
            sbU.append(this.outputVolume);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: UserProfileVoiceSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView$setOnDeafenChecked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ Function1 $onChecked;

        public AnonymousClass1(Function1 function1) {
            this.$onChecked = function1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            this.$onChecked.invoke(Boolean.valueOf(z2));
        }
    }

    /* compiled from: UserProfileVoiceSettingsView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "checked", "", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.usersheet.UserProfileVoiceSettingsView$setOnMuteChecked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ Function1 $onChecked;

        public AnonymousClass1(Function1 function1) {
            this.$onChecked = function1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            this.$onChecked.invoke(Boolean.valueOf(z2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileVoiceSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_profile_voice_settings_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_sheet_deafen;
        SwitchMaterial switchMaterial = (SwitchMaterial) viewInflate.findViewById(R.id.user_sheet_deafen);
        if (switchMaterial != null) {
            i = R.id.user_sheet_muted;
            SwitchMaterial switchMaterial2 = (SwitchMaterial) viewInflate.findViewById(R.id.user_sheet_muted);
            if (switchMaterial2 != null) {
                i = R.id.user_sheet_volume_label;
                TextView textView = (TextView) viewInflate.findViewById(R.id.user_sheet_volume_label);
                if (textView != null) {
                    i = R.id.user_sheet_volume_slider;
                    VolumeSliderView volumeSliderView = (VolumeSliderView) viewInflate.findViewById(R.id.user_sheet_volume_slider);
                    if (volumeSliderView != null) {
                        UserProfileVoiceSettingsViewBinding userProfileVoiceSettingsViewBinding = new UserProfileVoiceSettingsViewBinding((LinearLayout) viewInflate, switchMaterial, switchMaterial2, textView, volumeSliderView);
                        Intrinsics3.checkNotNullExpressionValue(userProfileVoiceSettingsViewBinding, "UserProfileVoiceSettings…rom(context), this, true)");
                        this.binding = userProfileVoiceSettingsViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setOnDeafenChecked(Function1<? super Boolean, Unit> onChecked) {
        Intrinsics3.checkNotNullParameter(onChecked, "onChecked");
        this.binding.f2168b.setOnCheckedChangeListener(new AnonymousClass1(onChecked));
    }

    public final void setOnMuteChecked(Function1<? super Boolean, Unit> onChecked) {
        Intrinsics3.checkNotNullParameter(onChecked, "onChecked");
        this.binding.c.setOnCheckedChangeListener(new AnonymousClass1(onChecked));
    }

    public final void setOnVolumeChange(Function2<? super Float, ? super Boolean, Unit> onProgressChanged) {
        Intrinsics3.checkNotNullParameter(onProgressChanged, "onProgressChanged");
        this.binding.e.setOnVolumeChange(onProgressChanged);
    }

    public final void updateView(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        VolumeSliderView volumeSliderView = this.binding.e;
        Float outputVolume = viewState.getOutputVolume();
        int iRoundToInt = outputVolume != null ? MathJVM.roundToInt(outputVolume.floatValue()) : 0;
        SeekBar seekBar = volumeSliderView.binding.d;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        VolumeSliderView volumeSliderView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(volumeSliderView2, "binding.userSheetVolumeSlider");
        volumeSliderView2.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userSheetVolumeLabel");
        textView.setVisibility(viewState.getOutputVolume() != null ? 0 : 8);
        SwitchMaterial switchMaterial = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.userSheetMuted");
        switchMaterial.setChecked(viewState.isMuted());
        SwitchMaterial switchMaterial2 = this.binding.f2168b;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.userSheetDeafen");
        switchMaterial2.setVisibility(viewState.isDeafened() != null ? 0 : 8);
        SwitchMaterial switchMaterial3 = this.binding.f2168b;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.userSheetDeafen");
        Boolean boolIsDeafened = viewState.isDeafened();
        switchMaterial3.setChecked(boolIsDeafened != null ? boolIsDeafened.booleanValue() : false);
    }
}
