package b.a.a.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.PremiumUpgradeYearlyDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: UpgradePremiumYearlyDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\b\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lb/a/a/b/b;", "Lcom/discord/app/AppDialog;", "", "onStart", "()V", "onViewBoundOrOnResume", "Lkotlin/Function0;", "l", "Lkotlin/jvm/functions/Function0;", "getOnMonthlyClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnMonthlyClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onMonthlyClickListener", "Lb/a/i/f1;", "q", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "g", "()Lb/a/i/f1;", "binding", "", "o", "Ljava/lang/String;", "getUpgradePrice", "()Ljava/lang/String;", "setUpgradePrice", "(Ljava/lang/String;)V", "upgradePrice", "n", "getOnDismissCallback", "setOnDismissCallback", "onDismissCallback", "m", "getOnYearlyClickListener", "setOnYearlyClickListener", "onYearlyClickListener", "", "p", "Z", "getHasMonthlyPlan", "()Z", "setHasMonthlyPlan", "(Z)V", "hasMonthlyPlan", "<init>", "k", "b", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: b.a.a.b.b, reason: use source file name */
/* loaded from: classes.dex */
public final class UpgradePremiumYearlyDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(UpgradePremiumYearlyDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onMonthlyClickListener;

    /* renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onYearlyClickListener;

    /* renamed from: n, reason: from kotlin metadata */
    public Function0<Unit> onDismissCallback;

    /* renamed from: o, reason: from kotlin metadata */
    public String upgradePrice;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean hasMonthlyPlan;

    /* renamed from: q, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: java-style lambda group */
    /* renamed from: b.a.a.b.b$a */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                Function0<Unit> function0 = ((UpgradePremiumYearlyDialog) this.k).onMonthlyClickListener;
                if (function0 != null) {
                    function0.invoke();
                }
                ((UpgradePremiumYearlyDialog) this.k).dismiss();
                return;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> function02 = ((UpgradePremiumYearlyDialog) this.k).onYearlyClickListener;
            if (function02 != null) {
                function02.invoke();
            }
            ((UpgradePremiumYearlyDialog) this.k).dismiss();
        }
    }

    /* compiled from: UpgradePremiumYearlyDialog.kt */
    /* renamed from: b.a.a.b.b$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: UpgradePremiumYearlyDialog.kt */
    /* renamed from: b.a.a.b.b$c */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, PremiumUpgradeYearlyDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, PremiumUpgradeYearlyDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public PremiumUpgradeYearlyDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.premium_upsell_header;
            ImageView imageView = (ImageView) view2.findViewById(R.id.premium_upsell_header);
            if (imageView != null) {
                i = R.id.premium_upsell_yearly_description;
                TextView textView = (TextView) view2.findViewById(R.id.premium_upsell_yearly_description);
                if (textView != null) {
                    i = R.id.premium_upsell_yearly_title;
                    TextView textView2 = (TextView) view2.findViewById(R.id.premium_upsell_yearly_title);
                    if (textView2 != null) {
                        i = R.id.purchase_premium_monthly;
                        TextView textView3 = (TextView) view2.findViewById(R.id.purchase_premium_monthly);
                        if (textView3 != null) {
                            i = R.id.purchase_premium_yearly;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.purchase_premium_yearly);
                            if (materialButton != null) {
                                return new PremiumUpgradeYearlyDialogBinding((LinearLayout) view2, imageView, textView, textView2, textView3, materialButton);
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: UpgradePremiumYearlyDialog.kt */
    /* renamed from: b.a.a.b.b$d */
    public static final class d implements DialogInterface.OnCancelListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            Function0<Unit> function0 = UpgradePremiumYearlyDialog.this.onDismissCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    public UpgradePremiumYearlyDialog() {
        super(R.layout.premium_upgrade_yearly_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
    }

    public final PremiumUpgradeYearlyDialogBinding g() {
        return (PremiumUpgradeYearlyDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        if (this.onMonthlyClickListener == null || this.onYearlyClickListener == null) {
            dismiss();
        }
        requireDialog().setCanceledOnTouchOutside(true);
        requireDialog().setOnCancelListener(new d());
        boolean z2 = getArgumentsOrDefault().getBoolean("ARG_IS_TIER_1");
        CharSequence charSequenceK = FormatUtils.k(this, z2 ? R.string.premium_tier_1 : R.string.premium_tier_2, new Object[0], null, 4);
        TextView textView = g().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellYearlyTitle");
        FormatUtils.n(textView, R.string.premium_upsell_yearly_title, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f)), charSequenceK}, null, 4);
        TextView textView2 = g().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellYearlyDescription");
        FormatUtils.n(textView2, R.string.premium_upsell_yearly_description, new Object[]{NumberFormat.getPercentInstance().format(Float.valueOf(0.16f))}, null, 4);
        MaterialButton materialButton = g().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.purchasePremiumYearly");
        FormatUtils.n(materialButton, R.string.premium_upsell_yearly_cta, new Object[]{this.upgradePrice}, null, 4);
        g().f111b.setImageResource(z2 ? R.drawable.img_premium_guild_subscription_purchase_header_tier_1 : R.drawable.img_premium_guild_subscription_purchase_header_tier_2);
        TextView textView3 = g().e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.purchasePremiumMonthly");
        textView3.setVisibility(this.hasMonthlyPlan ^ true ? 0 : 8);
        g().e.setOnClickListener(new a(0, this));
        g().f.setOnClickListener(new a(1, this));
    }
}
