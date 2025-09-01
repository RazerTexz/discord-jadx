package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* compiled from: WidgetHomePanelCenterBinding.java */
/* renamed from: b.a.i.i5, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetHomePanelCenterBinding implements ViewBinding {

    @NonNull
    public final RoundedRelativeLayout a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FragmentContainerView f136b;

    @NonNull
    public final WidgetHomePanelCenterChatBinding c;

    @NonNull
    public final FragmentContainerView d;

    public WidgetHomePanelCenterBinding(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding, @NonNull FragmentContainerView fragmentContainerView2) {
        this.a = roundedRelativeLayout;
        this.f136b = fragmentContainerView;
        this.c = widgetHomePanelCenterChatBinding;
        this.d = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
