package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* compiled from: ViewServerSettingsNotificationsBinding.java */
/* renamed from: b.a.i.k3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerSettingsNotificationsBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckedSetting f147b;

    @NonNull
    public final CheckedSetting c;

    public ViewServerSettingsNotificationsBinding(@NonNull LinearLayout linearLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2) {
        this.a = linearLayout;
        this.f147b = checkedSetting;
        this.c = checkedSetting2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
