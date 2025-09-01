package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.premium.AccountCreditView;

/* compiled from: LayoutAccountCreditsListBinding.java */
/* renamed from: b.a.i.f0, reason: use source file name */
/* loaded from: classes.dex */
public final class LayoutAccountCreditsListBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final AccountCreditView f110b;

    @NonNull
    public final AccountCreditView c;

    @NonNull
    public final View d;

    public LayoutAccountCreditsListBinding(@NonNull CardView cardView, @NonNull AccountCreditView accountCreditView, @NonNull AccountCreditView accountCreditView2, @NonNull View view) {
        this.a = cardView;
        this.f110b = accountCreditView;
        this.c = accountCreditView2;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
