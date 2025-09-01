package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.StringRes;
import b.a.d.AppToast;
import com.discord.R;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: JoinVoiceChannelButton.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\u00020\u0004*\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/discord/views/JoinVoiceChannelButton;", "Lcom/google/android/material/button/MaterialButton;", "", "toastMessage", "", "a", "(Lcom/google/android/material/button/MaterialButton;I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class JoinVoiceChannelButton extends MaterialButton {

    /* compiled from: JoinVoiceChannelButton.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MaterialButton j;
        public final /* synthetic */ int k;

        public a(MaterialButton materialButton, int i) {
            this.j = materialButton;
            this.k = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.g(this.j.getContext(), this.k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinVoiceChannelButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        setText(R.string.connect_to_voice);
    }

    public final void a(MaterialButton materialButton, @StringRes int i) {
        materialButton.setAlpha(0.3f);
        materialButton.setOnClickListener(new a(materialButton, i));
    }
}
